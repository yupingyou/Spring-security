package com.xingguo.dao.common;

import java.beans.IntrospectionException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.xingguo.entity.common.PaginationSupport;
/**
 * 通用持久层数据操作接口
 * @author yyp
 *
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 新增
	 * @param entity 一个瞬时对象
	 */
	public void add(T entity);
	/**
	 * 更新实体
	 * @param entity 持久化对象
	 */
	public void update(T entity);
	/**
	 * 删除实体
	 * @param entity 持久化对象
	 */
	public void delete(T entity);
	/**
	 * 根据ID加载一个对象
	 * @param clazz 类的全限定名
	 * @param id 主键
	 * @return
	 */
	public T loadEntityById(String clazz,Serializable id);
	/**
	 * 根据HQL带条件查询单一实体
	 * @param hql
	 * @param conditionMap
	 * @return
	 */
	public T loadEntityByHQLWithCondition(String hql,Map<String, Object> conditionMap);
	/**
	 * 根据hql语句查询列表
	 * @param hql
	 * @return
	 */
	public List<T> findListByHql(String hql);
	/**
	 * 带条件根据HQL语句查询列表
	 * @param hql
	 * @param coonditionMap
	 * @return
	 */
	public List<T> findListByHqlWithCondition(String hql,Map<String, Object> coonditionMap);
	/**
	 * 根据HQL分页查询
	 * @param hql
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 */
	public List<T> findListByPage(String hql,int pageSize,int pageIndex);
	/**
	 * 根据HQL带条件查询记录条数 按名称 参数绑定
	 * @param hql
	 * @param conditionMap
	 * @return
	 */
	public int getCountByHql(String hql,Map<String, Object> conditionMap);
	
	/**
	 * 根据HQL带条件查询记录条数 按位置 参数绑定
	 * @param hql
	 * @param conditionMap
	 * @return
	 */
	public int getCountByHql(String hql,List<Object> params);
	/**
	 * 根据sql语句查询总记录数
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	public int getCountBySQL(String sql,List<Object> params) throws Exception;
	/**
	 * 根据HQL带条件分页查询一个page对象
	 * @param hql
	 * @param pageSize 每页记录数
	 * @param pageIndex 当前页
	 * @param conditionMap 条件
	 * @return
	 */
	public PaginationSupport<T> findListByPageWithCondition(String hql,int pageSize,int pageIndex,Map<String, Object> conditionMap);
	/**
	 * 根据HQL带条件分页查询一个list
	 * @param hql
	 * @param pageSize 每页记录数
	 * @param pageIndex 当前页
	 * @param conditionMap 条件
	 * @return
	 */
	public List<T> findListByPageWithCondition(String hql,int pageSize,int pageIndex,List<Object> params);
	
	/**
	 * 根据HQL带条件查询
	 * @param sql
	 * @param conditionMap
	 * @return
	 */
	public List<T> findListBySQL(String sql,Map<String, Object> conditionMap);
	/**
	 * 根据SQL带条件分页查询：强制转换为泛型类型
	 * @param sql
	 * @param pageSize
	 * @param pageIndex
	 * @param map
	 * @return
	 */
	public List<T> findListPageBySQL(String sql,int pageSize,int pageIndex,Map<String, Object> map);
	/**
	 * 根据SQL语句查询一条记录
	 * @param sql
	 * @param param
	 * @return
	 * @throws SQLException 
	 * @throws Exception 
	 */
	public Map<String, Object> findResultMapBySQL(String sql,Object param) throws  Exception;
	/**
	 * 根据SQL语句查询一条记录，带参数 ： 自动绑定参数（拼接的sql无需在后面跟上where子句）
	 * @param sql
	 * @param conditionMap 条件 key：value-->列名：列值
	 * @return
	 * @throws Exception 
	 */
	public Map<String, Object> findResultMapBySQLWithCondition(String sql,Map<String, Object> conditionMap) throws Exception;
	/**
	 * 根据sql语句查询一条记录 带参数：手动绑定参数，即若需要带参数查询sql语句后必须加上where XXX=? and XXX=?
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	public Map<String, Object> findResultMapBySQLWithCondition(String sql,List<Object> params) throws Exception;
	/**
	 * 根据SQL语句查询一个结果集
	 * @param sql
	 * @return
	 * @throws Exception 
	 */
	public List<Map<String, Object>> findBySQL(String sql,Object param) throws Exception;
	/**
	 * 根据SQL语句查询一个结果集，带参数
	 * @param sql
	 * @param condition 条件 key：value-->列名：列值
	 * @return
	 * @throws Exception 
	 */
	public List<Map<String, Object>> findBySQLWithCondition(String sql,Map<String, Object> condition) throws Exception;
	/**
	 * 根据SQL语句查询一个结果集，带参数:手动绑定参数
	 * @param sql
	 * @param condition 条件 key：value-->列名：列值
	 * @return
	 * @throws Exception 
	 */
	public List<Map<String, Object>> findBySQLWithCondition(String sql,List<Object> params) throws Exception;
	
	/**
	 * 根据SQL语句分页查询：手动绑定参数；在类型不确定的情况下使用，直接返回Map List
	 * @param sql
	 * @param list
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws Exception 
	 */
	public List<Map<String, Object>> findPageBySQLWithCondition(String sql,List<Object> params,int pageIndex,int pageSize) throws Exception;
	/**
	 * 将Maplist转换为List<Bean.class>
	 * @param clazz
	 * @param list
	 * @return
	 * @throws IntrospectionException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public List<?> turnMapToBean(Class<?> clazz,List<Map<String, Object>> list) throws IntrospectionException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	/**
	 * 执行DMLSQL语句（insert，update，delete）
	 * @return 影响行数
	 * @throws Exception 
	 */
	public int excuteDMLSql(String sql) throws Exception;
	/**
	 * 批量执行SQL
	 * @param sqls 
	 * @throws Exception 
	 */
	public int[] excuteBatchSQL(String[] sqls) throws Exception;
	/**
     * 判断对象的属性值在数据库内是否唯一.
     * <p/>
     * 在修改对象的情景下,如果属性新修改的值(value)等于属性原来的值(orgValue)则不作比较.
     */
    public boolean isPropertyUnique(final Class entity,
                                    final String propertyName, final Object newValue,
                                    final Object orgValue);
    /**
     * 执行DMLSQL
     * @param sql
     * @param params
     * @return
     * @throws Exception
     */
	public int excuteDMLSql(String sql, Object[] params) throws Exception;
	
	public PaginationSupport<T> findPageByCriteria(
            final DetachedCriteria detachedCriteria, final int pageSize,
            final int startIndex);
	public PaginationSupport findPageByCriteria14(
	            final DetachedCriteria detachedCriteria, final int pageSize,
	            final int startIndex);
	 
}
