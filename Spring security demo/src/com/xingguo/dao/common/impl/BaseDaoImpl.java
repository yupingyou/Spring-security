package com.xingguo.dao.common.impl;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.jdbc.Work;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.xingguo.dao.common.BaseDao;
import com.xingguo.entity.common.PaginationSupport;
import com.xingguo.utils.ReflectionTool;
/**
 * 基础模型层 数据操作类
 * @author yyp
 * @version 1.1
 * @param <T>
 */
@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {
	protected static final Logger log =Logger.getLogger(BaseDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public void add(T entity) {
		getSession().save(entity);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T loadEntityById(String clazz, Serializable id) {
		return (T) getSession().get(clazz, id);
	}

	@Override
	public T loadEntityByHQLWithCondition(final String hql,
			final Map<String, Object> map) {
		Session session=getSession();
		Query query=session.createQuery(hql);
		if(map!=null&&map.size()>0){
			query.setProperties(map);
		}
		List<T> list= query.list();
		
		return list!=null&&list.size()>0?(T) list.get(0):null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findListByHql(final String hql) {
		Session session=getSession();
		Query query=session.createQuery(hql);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findListByHqlWithCondition(final String hql,
			final Map<String, Object> conditionMap) {
		log.info(hql);
		Session session=getSession();
		Query query=session.createQuery(hql);
		if(conditionMap!=null&&conditionMap.size()>0){
			query.setProperties(conditionMap);
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findListByPage(final String hql, final int pageSize, final int pageIndex) {
		Session session=getSession();
		Query query=session.createQuery(hql);
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	@Override
	public int getCountByHql(final String hql, final Map<String, Object> map) {
		Session session=getSession();
		String countHql="select count(*) "+removeFromPrefix(hql);
		Query query=session.createQuery(countHql);
		if(map!=null && map.size()>0) query.setProperties(map);
		return ((Long)query.uniqueResult()).intValue();
	}
	public int getCountByHql(final String hql,final List<Object> params){
		Session session=getSession();
		String countHql="select count(*) "+removeFromPrefix(hql);
		Query query=session.createQuery(countHql);
		if(params!=null && params.size()>0){
			for(int i=0;i<params.size();i++){
				query.setParameter(i, params.get(i));
			}
		}
		return ((Long)query.uniqueResult()).intValue();
	}
	
	@Override
	public int getCountBySQL(final String sql, final List<Object> params) throws Exception {
		Session session=getSession();
		String countHql="select count(*) "+removeFromPrefix(sql);
		SQLQuery query=session.createSQLQuery(countHql);
		if(params!=null && params.size()>0){
			for(int i=0;i<params.size();i++){
				query.setParameter(i, params.get(i));
			}
		}
		return ((BigDecimal)query.uniqueResult()).intValue();
	}

	private String removeFromPrefix(String hql) {
		String result=hql;
		int index=result.indexOf("from");
		if(index!=-1){
			result=result.substring(index);
		}
		return result;
	}

	@Override
	public PaginationSupport<T> findListByPageWithCondition(final String hql, final int pageSize,
			final int pageIndex, final Map<String, Object> map) {
		PaginationSupport<T> page=new PaginationSupport<T>();
		page.setPageSize(pageSize);
		page.setTotalCount(getCountByHql(hql, map));
		page.setStartIndex((pageIndex-1)*pageSize);
		if(page.getTotalCount()>0){
			Session session=getSession();
			Query query=session.createQuery(hql);
			if(map!=null && map.size()>0) 
				query.setProperties(map);
			query.setFirstResult((pageIndex-1)*pageSize);
			query.setMaxResults(pageSize);
			List<T> list = query.list();
			page.setItems(list);
		}
		return page;
	}
	
	public List<T> findListByPageWithCondition(final String hql,final int pageSize,final int pageIndex,final List<Object> params){
		Session session=getSession();
		Query query=session.createQuery(hql);
		if(params!=null && params.size()>0){
			for(int i=0;i<params.size();i++){
				query.setParameter(i, params.get(i));
			}
		}
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		List<T> list = query.list();
		return list;
	}

	@Override
	public List<T> findListBySQL(final String sql, final Map<String, Object> conditionMap) {
		Session session=getSession();
		Query query=session.createSQLQuery(sql);
		if(conditionMap!=null&&conditionMap.size()>0){
			query.setProperties(conditionMap);
		}
		return query.list();
	}

	@Override
	public List<T> findListPageBySQL(final String sql, final int pageSize, final int pageIndex,
			final Map<String, Object> map) {
		Session session=getSession();
		Query query=session.createSQLQuery(sql);
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		if(map!=null&&map.size()>0){
			query.setProperties(map);
		}
		return query.list();
	}
	
	//********************************SQL查询，返回非泛型类型的结果 ：行记录以Map存储，行记录结果集以List<Map<String,Object>存储*************************/
	
	
	@Override
	public Map<String, Object> findResultMapBySQL(final String sql, final Object param) throws Exception {
		final Map<String, Object> map=new HashMap<String, Object>();
		jdbcTemplate.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps=conn.prepareStatement(sql);
				if(param!=null){
					ps.setObject(1, param);
				}
				return ps;
			}
			},
			new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				try {
					map.putAll(getColumnMap(rs));
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return map;
		
	}

	@Override
	public Map<String, Object> findResultMapBySQLWithCondition(String sql,
			Map<String, Object> conditionMap) throws Exception {
		final Map<String, Object> result=new HashMap<String, Object>();
		final Object[] values=new Object[conditionMap.size()];
		if(conditionMap!=null&&conditionMap.size()>0){
			sql=removeOrderByStr(sql);
			sql=isNeedWhereStatament(sql);
			Set<String> keySet = conditionMap.keySet();
			int index=0;
			for (String key:keySet) {
				sql+=" and "+key+" = ? ";
				values[index]=conditionMap.get(key);
				index++;
			}
		}
		final String finalSql=sql;
		log.info(sql);
		jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps=connection.prepareStatement(finalSql);
				for (int i = 0; i < values.length; i++) {
					ps.setObject(i+1, values[i]);
				}
				return ps;
			}
		}, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet resultset) throws SQLException {
				try {
					result.putAll(getColumnMap(resultset));
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return result;
	}
	
	@Override
	public Map<String, Object> findResultMapBySQLWithCondition(final String sql,
			final List<Object> params) throws Exception {
		final Map<String, Object> result=new HashMap<String, Object>();
		jdbcTemplate.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps=connection.prepareStatement(sql);
				if(params!=null&&params.size()>0){
					for (int i = 0; i < params.size(); i++) {
						ps.setObject(i+1, params.get(i));
					}
				}
				return ps;
			}
		}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet resultset) throws SQLException {
				try {
					result.putAll(getColumnMap(resultset));
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		
		return result;
		
	}
	
	@Override
	public List<Map<String, Object>> findBySQL(final String sql, final Object param) throws Exception {
		final List<Map<String, Object>> result=new ArrayList<Map<String,Object>>();
		jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps=connection.prepareStatement(sql);
				if(param!=null){
					ps.setObject(1, param);
				}
				return ps;
			}
		}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet resultset) throws SQLException {
				try {
					result.add(getColumnMap(resultset));//rs已打开，先读取第一个
					while(resultset.next()){
						result.add(getColumnMap(resultset));
					}
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		
		return result;
	}

	@Override
	public List<Map<String, Object>> findBySQLWithCondition(String sql,
			Map<String, Object> condition) throws Exception {
		final List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		final Object[] values=new Object[condition.size()];
		if(condition!=null&&condition.size()>0){
			sql=removeOrderByStr(sql);
			sql=isNeedWhereStatament(sql);
			Set<String> keySet = condition.keySet();
			int index=0;
			for (String key:keySet) {
				sql+=" and "+key+" = ? ";
				values[index]=condition.get(key);
			}
		}
		final String finalSql=sql; 
		jdbcTemplate.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps=connection.prepareStatement(finalSql);
				for (int i = 0; i < values.length; i++) {
					ps.setObject(i+1, values[i]);
				}
				return ps;
			}
		}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet resultset) throws SQLException {
				try {
					list.add(getColumnMap(resultset));//rs已打开，先读取第一个
					while(resultset.next()){
						list.add(getColumnMap(resultset));
					}
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return list;
	}
	
	@Override
	public List<Map<String, Object>> findBySQLWithCondition(final String sql,
			final List<Object> params) throws Exception {
		final List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		jdbcTemplate.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps=connection.prepareStatement(sql);
				if(params!=null&&params.size()>0){
					for (int i = 0; i < params.size(); i++) {
						ps.setObject(i+1, params.get(i));
					}
				}
				return ps;
			}
		}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet resultset) throws SQLException {
				while(resultset.next()){
					try {
						list.add(getColumnMap(resultset));//rs已打开，先读取第一个
						while(resultset.next()){
							list.add(getColumnMap(resultset));
						}
					} catch (Exception e) {
						log.error("", e);
					}
				}
			}
		});
		return list;
	}
	

	@Override
	public int excuteDMLSql(String sql) throws Exception {
		return jdbcTemplate.update(sql);
	}
	
	@Override
	public int excuteDMLSql(String sql,Object[] params) throws Exception {
		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int[] excuteBatchSQL(String[] sqls) throws Exception {
		return jdbcTemplate.batchUpdate(sqls);
	}
	@Override
	public List<Map<String, Object>> findPageBySQLWithCondition(String sql,
			final List<Object> list, int pageIndex, int pageSize) throws Exception {
		int startRow=(pageIndex-1)*pageSize+1;
		int endRow=pageIndex*pageSize;
		sql="select * from (select row_.*,rownum rn from ("+sql+") row_) where rn>="+startRow+" and rn<="+endRow;
		log.info(sql);
		final List<Map<String, Object>> result=new ArrayList<Map<String,Object>>();
		final String finalSql=sql;
		jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps=connection.prepareStatement(finalSql);
				if(list!=null&&list.size()>0){
					for(int i=0;i<list.size();i++){
						ps.setObject(i+1, list.get(i));
					}
				}
				return ps;
			}
		}, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet resultset) throws SQLException {
				try {
					result.add(getColumnMap(resultset));//rs已打开，先读取第一个
					while (resultset.next()) {
						result.add(getColumnMap(resultset));
					}
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return result;
	}
	
	
	/****************************************************************************************
	 *************************************大数据类型操作*****************************************
	 *****************************************************************************************/
	 /**
     * 删除Oracle Blob
     *
     * @param table 表名
     * @param primaryKeyColumn 主键字段名
     * @param blobColumn blob字段名
     * @param primaryKey 主键值
     * @return
     */
    protected boolean deleteBlob(final String table,
                               final String primaryKeyColumn,
                               final String blobColumn,
                               final String primaryKey) {
    	Session session=getSession();
    	 Boolean success = Boolean.FALSE;

         DeleteBlobWork work = new DeleteBlobWork(table, primaryKeyColumn, blobColumn, primaryKey);
         session.doWork(work);
         success = work.getResult();
         return success;
    }

    private class DeleteBlobWork implements Work {

        private String table;
        private String primaryKeyColumn;
        private String blobColumn;
        private String primaryKey;
        private Boolean result;

        DeleteBlobWork(String table, String primaryKeyColumn, String blobColumn, String primaryKey) {
            this.result = Boolean.FALSE;
            this.table = table;
            this.primaryKeyColumn = primaryKeyColumn;
            this.blobColumn = blobColumn;
            this.primaryKey = primaryKey;
        }

        public Boolean getResult() {
            return this.result;
        }

        public void execute(java.sql.Connection connection) throws SQLException {
            final String sql = "update " + table + " set " + blobColumn + " = empty_blob() where " + primaryKeyColumn + " = ?";

            if (log.isDebugEnabled()) {
                log.debug("========> sql: " + sql);
                log.debug("========> primaryKey: " + this.primaryKey);
            }

            PreparedStatement ps = null;
            try {
                ps = connection.prepareStatement(sql);
                ps.setString(1, primaryKey);
                ps.executeUpdate();
                ps.close();
                ps = null;

                this.result = Boolean.TRUE;
            } catch (SQLException e ) {
                log.error(e.getMessage(), e);
                throw e;
            } finally {
                closeQuietly(ps);
            }
        }
    }

    /**
     * 读Oracle Blob
     *
     * @param table 表名
     * @param primaryKeyColumn 主键字段名
     * @param blobColumn blob字段名
     * @param primaryKey 主键值
     * @param out 输出数据流
     * @return
     */
    protected boolean findBlob(final String table,
                               final String primaryKeyColumn,
                               final String blobColumn,
                               final String primaryKey,
                               final OutputStream out) {
    	Session session=getSession();
    	 Boolean success = Boolean.FALSE;

         ReadBlobWork work = new ReadBlobWork(table, primaryKeyColumn, blobColumn, primaryKey, out);
         session.doWork(work);
         success = work.getResult();

         return success;
    }


    private class ReadBlobWork implements Work {

        private OutputStream out;
        private String table;
        private String primaryKeyColumn;
        private String blobColumn;
        private String primaryKey;
        private Boolean result;

        ReadBlobWork(String table, String primaryKeyColumn, String blobColumn, String primaryKey,OutputStream out) {
            this.result = Boolean.FALSE;
            this.out = out;
            this.table = table;
            this.primaryKeyColumn = primaryKeyColumn;
            this.blobColumn = blobColumn;
            this.primaryKey = primaryKey;
        }

        public Boolean getResult() {
            return this.result;
        }

        public void execute(java.sql.Connection connection) throws SQLException {
            this.result = Boolean.FALSE;

            final String sql = "select " +blobColumn+ " from " + table + " where "+primaryKeyColumn+"= ? and " + blobColumn + " is not null" ;

            if (log.isDebugEnabled()) {
                log.debug("========> sql: " + sql);
                log.debug("========> primaryKey: " + this.primaryKey);
            }

            PreparedStatement ps = null;
            ResultSet rs = null;
            InputStream in = null;
            try {
                ps = connection.prepareStatement(sql);
                ps.setString(1, primaryKey);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Blob blob = rs.getBlob (1);
                    in = new BufferedInputStream(blob.getBinaryStream());

                    byte[] data = new byte[1024 * 4];
                    int count = 0;
                    while ((count = in.read(data)) != -1) {
                        this.out.write(data, 0, count);
                        this.out.flush();
                    }
                    in.close();
                    in = null;

                    this.result = Boolean.TRUE;                    
                }
                rs.close();
                rs = null;

                ps.close();
                ps = null;
            } catch (SQLException e ) {
                log.error(e.getMessage(), e);
                throw e;
            } catch (IOException e) {
                log.error(e.getMessage(), e);
                throw new RuntimeException(e.getMessage(), e);
            } finally {
                IOUtils.closeQuietly(in);

                closeQuietly(rs);

                closeQuietly(ps);
            }
        }
    }

    /**
     * 写Oracle Blob
     *
     * @param table 表名
     * @param primaryKeyColumn 主键字段名
     * @param blobColumn blob字段名
     * @param primaryKey 主键值
     * @param in 输入数据流
     * @return
     */
    protected boolean saveBlob(final String table,
                               final String primaryKeyColumn,
                               final String blobColumn,
                               final String primaryKey,
                               final InputStream in) {
    	 Session session=getSession();
    	 Boolean success = Boolean.FALSE;
         WriteBlobWork work = new WriteBlobWork(table, primaryKeyColumn, blobColumn, primaryKey, in);
         session.doWork(work);
         success = work.getResult();

         return success;
    }

    private class WriteBlobWork implements Work {

        private InputStream in;
        private String table;
        private String primaryKeyColumn;
        private String blobColumn;
        private String primaryKey;
        private Boolean result;

        WriteBlobWork(String table, String primaryKeyColumn, String blobColumn, String primaryKey,InputStream in) {
            this.result = Boolean.FALSE;
            this.in = in;
            this.table = table;
            this.primaryKeyColumn = primaryKeyColumn;
            this.blobColumn = blobColumn;
            this.primaryKey = primaryKey;
        }

        public Boolean getResult() {
            return this.result;
        }

        public void execute(java.sql.Connection connection) throws SQLException {
            final String sqlClean = "update " + table + " set " + blobColumn + " = empty_blob() where " + primaryKeyColumn + " = ?";
            final String sqlUpdate = "select " +blobColumn+ " from " + table + " where "+primaryKeyColumn+"= ? for update";
            PreparedStatement ps = null;
            ResultSet rs = null;
            OutputStream out = null;
            try {
                ps = connection.prepareStatement(sqlClean);
                ps.setString(1, primaryKey);
                ps.executeUpdate();
                ps.close();

                ps = connection.prepareStatement(sqlUpdate);
                ps.setString(1, primaryKey);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Blob blob = rs.getBlob (1);
                    out = new BufferedOutputStream(blob.setBinaryStream(1L));

                    byte[] data = new byte[1024 * 4];
                    int count = 0;
                    while ((count = this.in.read(data)) != -1) {
                        out.write(data, 0, count);
                        out.flush();
                    }
                    out.close();
                    out = null;
                }
                rs.close();
                rs = null;

                ps.close();
                ps = null;

                this.result = Boolean.TRUE;
            } catch (SQLException e ) {
                log.error(e.getMessage(), e);
                throw e;
            } catch (IOException e) {
                log.error(e.getMessage(), e);
                throw new RuntimeException(e.getMessage(), e);
            } finally {
                IOUtils.closeQuietly(out);

                closeQuietly(rs);

                closeQuietly(ps);
            }
        }
    }

    private void closeQuietly(Statement s) {
        if (s != null) {
            try {
                s.close();
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    private void closeQuietly(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
	
	/***************************************************************************************
	 * *************************************分割线 :私有工具方法**********************************
	 ***************************************************************************************/
	
	/**
	 * 从行信息取得Map：忽略列类型
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Map<String, Object> getColumnMapIgnoreType(ResultSet rs) throws SQLException{
		if(rs!=null){
			Map<String, Object> map=new HashMap<String, Object>();
			ResultSetMetaData metaData = rs.getMetaData();
			for (int i = 1; i <=metaData.getColumnCount(); i++) {
				map.put(metaData.getColumnName(i), rs.getObject(i));
			}
			return map;
		}
		return null;
	}
	/**
	 * 获取行 ： 敏感列类型
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object> getColumnMap(ResultSet rs) throws Exception{
		ResultSetMetaData metaData = rs.getMetaData();
		String columnType=null;
		Map<String, Object> map=new HashMap<String, Object>();
		int columnCount = metaData.getColumnCount();
		for (int i = 1; i <=columnCount; i++) {
			columnType=metaData.getColumnTypeName(i);
			String columnName = metaData.getColumnName(i).toLowerCase();
			if(columnType.equalsIgnoreCase("timestamp")||
					metaData.getColumnTypeName(i).equalsIgnoreCase("date")||
					metaData.getColumnTypeName(i).equalsIgnoreCase("time")){
				map.put(columnName,rs.getTimestamp(i));
			}else if(columnType.equalsIgnoreCase("clob")){
				StringBuffer result=new StringBuffer();
				Clob clob = rs.getClob(i);
				BufferedReader reader=new BufferedReader(new InputStreamReader(clob  
                        .getAsciiStream()));
				try {
					String line;
					while ((line = reader.readLine()) != null) {
						result.append(line);
					}
				} catch (Exception e) {
					throw e;
				}finally{
					if(reader!=null){
						reader.close();
					}
				}
				map.put(columnName, result.toString());
			}else if(columnType.equalsIgnoreCase("blob")){
				//TODO
			}else{
				Object val=rs.getObject(i);
				if(val instanceof BigDecimal){
					map.put(columnName, ((BigDecimal)val).doubleValue());
				}else{
					map.put(columnName, rs.getObject(i) instanceof String? (String)rs.getObject(i):rs.getObject(i));
				}
			}
		}
		return map;
	}
	/**
	 * 移除order by 后面的字符串(包含Order by)
	 * @param sql
	 * @return
	 */
	private String removeOrderByStr(String sql){
		int index=sql.toLowerCase().lastIndexOf("order by");
		int index2=sql.lastIndexOf(")");
		if(index>0){
			if(index2<index){
				sql=sql.substring(0, index);
			}
		}
		return sql;
	}
	/**
	 * 获得order by 后的所有字符串（包括order by）
	 * @param sql
	 * @return
	 */
	private String getOrderByStr(String sql){
		int index=sql.toLowerCase().lastIndexOf("order by");
		if(index>0){
			int index2=sql.lastIndexOf(")");
			if(index2<index){
				sql=sql.substring(index, sql.length());
			}
		}
		return sql;
	}
	/**
	 * 判断sql语句最外层是否有where子句，如果有，则直接返回，如果没有，则加上where 1=1
	 * @param sql
	 * @return
	 */
	private String isNeedWhereStatament(String sql){
		int whereIndex=sql.lastIndexOf("where");
		int index1=sql.lastIndexOf(")");
		if(whereIndex>0){
			if(whereIndex>index1){
				return sql;
			}else{
				sql+=" where 1=1 ";
			}
		}else{
			sql+=" where 1=1 ";
		}
		return sql;
	}
	//**************************************************分割线：共有工具方法*************************************************************/

	@Override
	public List<?> turnMapToBean(Class<?> clazz, List<Map<String, Object>> list) throws IntrospectionException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		BeanInfo beanInfo = Introspector.getBeanInfo(clazz);  
		 PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		List result=new ArrayList();
		if(list!=null&&list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				Object object = clazz.newInstance();
				Map<String, Object> map=list.get(i);
				Set<String> keySet = map.keySet();
				if(keySet.size()>0){
					Iterator<String> it=keySet.iterator();
					while (it.hasNext()) {
						String key=it.next();
						for(PropertyDescriptor property:propertyDescriptors){
							String name = property.getName();
							if(name.equalsIgnoreCase(key)){
								Method setter = property.getWriteMethod();
								setter.invoke(object, map.get(key));
							}
						}
					}
				}
				result.add(object);
			}
		}
		
		return result;
	}
	/**
	 * 根据实体bean的注解，将一个Map行转换成Bean对象 将列名转换为列名对应的属性名
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IntrospectionException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public Object columnToProperty(Class<?> clazz,Map<String, Object> map) throws InstantiationException, IllegalAccessException, IntrospectionException, IllegalArgumentException, InvocationTargetException{
		Object obj=clazz.newInstance();
		/*BeanInfo beanInfo = Introspector.getBeanInfo(clazz);  
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();*/
		Field[] fields = clazz.getDeclaredFields();
		if(map!=null&&map.size()>0){
			Set<String> keySet = map.keySet();
			Iterator<String> it = keySet.iterator();
			while(it.hasNext()){
				String key = it.next();
				for(Field field:fields){
					String property=field.getName();
					if(!"class".equalsIgnoreCase(property)){
						String tableColumn = ReflectionTool.getTableColumnByPropertyName(clazz, property);
						if(tableColumn.equalsIgnoreCase(key)){
							field.setAccessible(true);
							Object value=map.get(key);
							if(value!=null){
								if(value instanceof BigDecimal){
									value=((BigDecimal)value);
								}else if(value instanceof String){
									value=value.toString();
								}
								Class<?> type = field.getType();
								String name = type.getSimpleName();
								if(name.equalsIgnoreCase("Double")){
									value=Double.valueOf(value.toString());
								}
								if(name.equalsIgnoreCase("Integer")){
									value=Integer.valueOf(value.toString());
								}
							}
							field.set(obj, value);
						}
					}
					
				}
				
			}
		}
		return obj;
	}

	/**
     * 判断对象的属性值在数据库内是否唯一.
     * <p/>
     * 在修改对象的情景下,如果属性新修改的值(value)等于属性原来的值(orgValue)则不作比较.
     */
    public boolean isPropertyUnique(final String entity,
                                    final String propertyName, final Object newValue,
                                    final Object orgValue) {
        if (newValue == null || newValue.equals(orgValue))
            return true;
        Object object = findUniqueByProperty(entity, propertyName, newValue);
        return (object == null);
    }

    /**
     * 判断对象的属性值在数据库内是否唯一.
     * <p/>
     * 在修改对象的情景下,如果属性新修改的值(value)等于属性原来的值(orgValue)则不作比较.
     */
    public boolean isPropertyUnique(final Class entity,
                                    final String propertyName, final Object newValue,
                                    final Object orgValue) {
        if (newValue == null || newValue.equals(orgValue))
            return true;
        Object object = findUniqueByProperty(entity, propertyName, newValue);
        return (object == null);
    }

    /**
     * 按属性查找唯一对象,匹配方式为相等.
     */
    public T findUniqueByProperty(final String entity,
                                  final String propertyName, final Object value) {
        return (T) findUniqueByProperty14(entity, propertyName, value);
    }

    /**
     * 按属性查找唯一对象,匹配方式为相等.
     */
    public T findUniqueByProperty(final Class entity,
                                  final String propertyName, final Object value) {
        return (T) findUniqueByProperty14(entity, propertyName, value);
    }

    /**
     * 按属性查找唯一对象,匹配方式为相等.
     */
    public Object findUniqueByProperty14(final String entity,
                                         final String propertyName, final Object value) {
        final String hql = "from " + entity + " where " + propertyName + "=?";
        return findUnique14(hql, value);
    }

    /**
     * 按属性查找唯一对象,匹配方式为相等.
     */
    public Object findUniqueByProperty14(final Class entity,
                                         final String propertyName, final Object value) {
        DetachedCriteria criteria = DetachedCriteria.forClass(entity);
        criteria.add(Restrictions.eq(propertyName, value));
        return findUnique14(criteria);
    }

    /**
     * 按HQL查询唯一对象（支持泛型）.
     *
     * @param hql
     * @param values
     * @return
     */
    public T findUnique(final String hql, final Object... values) {
        return (T) findUnique14(hql, values);
    }

    /**
     * 按DetachedCriteria查询唯一对象（支持泛型）.
     *
     * @param detachedCriteria
     * @return
     */
    public T findUnique(final DetachedCriteria detachedCriteria) {
        return (T) findUnique14(detachedCriteria);
    }

    /**
     * 按HQL查询唯一对象.
     *
     * @param hql
     * @param values
     * @return
     */
    public Object findUnique14(final String hql, final Object... values) {
    	 Session session=getSession();
    	 Query query = session.createQuery(hql);
         if (values != null) {
             for (int i = 0; i < values.length; i++) {
                 query.setParameter(i, values[i]);
             }
         }
         return query.uniqueResult();
    }

    /**
     * 按DetachedCriteria查询唯一对象.
     *
     * @param detachedCriteria
     * @return
     */
    public Object findUnique14(final DetachedCriteria detachedCriteria) {
    	Session session=getSession();
    	 Criteria criteria = detachedCriteria
                 .getExecutableCriteria(session);
         return criteria.uniqueResult();
    }

    public PaginationSupport<T> findPageByCriteria(
            final DetachedCriteria detachedCriteria, final int pageSize,
            final int startIndex) {
        return (PaginationSupport<T>) findPageByCriteria14(detachedCriteria,
                pageSize, startIndex);

    }
    /**
     * 分页查询
     *
     * @param detachedCriteria
     * @param pageSize
     * @param startIndex
     * @return
     */
    public PaginationSupport findPageByCriteria14(
            final DetachedCriteria detachedCriteria, final int pageSize,
            final int startIndex) {
    	Session session=getSession();
    	Criteria criteria = detachedCriteria
                .getExecutableCriteria(session);
        int totalCount = 0;
        CriteriaImpl impl = (CriteriaImpl) criteria;
        // 取出projection
        Projection projection = impl.getProjection();
        // 用来存放排序字段
        List orderEntries = new ArrayList();
        Field field = null;

        try {
            field = CriteriaImpl.class
                    .getDeclaredField("orderEntries");
            field.setAccessible(true);
            // 将对象中的排序字段存入数组中
            orderEntries = (List) field.get(impl);
            // 将排序字段设置为空
            field.set(criteria, new ArrayList());
            // criteria.setProjection(Projections.rowCount());
            totalCount = ((Integer) criteria.setProjection(
                    Projections.rowCount()).uniqueResult())
                    .intValue();
            // 重新设置回projection

            criteria.setProjection(projection);
            if (projection == null) {
                criteria
                        .setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
            }
            // 重新设置回排序字段
            field.set(criteria, orderEntries);
        } catch (SecurityException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (NoSuchFieldException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }

        int start = startIndex;
        // 防止显示空页
        if (start >= totalCount) {
            start = start - pageSize;
            start = (start < 0) ? 0 : start;
        }

        List items = criteria.setFirstResult(start)
                .setMaxResults(pageSize).list();
        PaginationSupport ps = new PaginationSupport(items,
                totalCount, pageSize, start);
        return ps;
    }

    @SuppressWarnings("rawtypes")
	public List findBySqlQueryMap(final String sql) {
    	Session session=getSession();
    	SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List list = query.list();
		return list;
	}
    
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    
	
}
