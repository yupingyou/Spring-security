package com.xingguo.service.common.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xingguo.dao.common.BaseDao;
import com.xingguo.entity.common.PaginationSupport;
import com.xingguo.service.common.BaseService;
@Service
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {
	protected static final Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	@Autowired
	@Qualifier("baseDao")
	private BaseDao<T> baseDao;
	@Override
	public void save(T entity) {
		baseDao.add(entity);
	}

	@Override
	public void update(T entity) {
		baseDao.update(entity);
	}

	@Override
	public void delete(T entity) {
		baseDao.delete(entity);
	}

	@Override
	public T findById(Serializable id) {
		String clazz=getCurrParamType();
		return baseDao.loadEntityById(clazz, id);
	}

	@Override
	public PaginationSupport<T> findByPageWithCondition(Map<String, Object> map,
			int pageIndex, int pageSize,Map<String,String> orders) {
		String hql=getHQL(map,orders);
		return baseDao.findListByPageWithCondition(hql, pageSize, pageIndex, map);
	}

	@Override
	public T findEntityByCondition(Map<String, Object> map) {
		String hql=getHQL(map,null);
		return baseDao.loadEntityByHQLWithCondition(hql, map);
	}
	/**
	 * 获取当前实现类的泛型
	 * @return
	 */
	public String getCurrParamType(){
		String clazz=null;
		Type type = this.getClass().getGenericSuperclass();
        if (type  instanceof  ParameterizedType) {
                ParameterizedType  paramType  =  (ParameterizedType) type;
                Type[] args = paramType.getActualTypeArguments();
                if (args != null && args.length>0) {
                          Type arg = args[0]; 
                          if (arg instanceof Class) {
                                    clazz= ((Class<T>) arg).getName();
                          }
                }
        }
        return clazz;
	}
	
	private String getHQLCondition(Map<String, Object> map){
		StringBuffer sf=new StringBuffer("  where 1=1 ");
		if(map!=null&&map.size()>0){
			Set<String> keySet = map.keySet();
			for(String key:keySet){
				sf.append(" and "+key+"=:"+key);
			}
		}
		return sf.toString();
	}
	/**
	 * 获取HQL语句，取得当前泛型类名 拼接HQL
	 * @param map
	 * @param list 
	 * @return
	 */
	private String getHQL(Map<String, Object> map, Map<String,String> orders){
		StringBuffer sf=new StringBuffer();
		String type=getCurrParamType();
		String entityClass=type.substring(type.lastIndexOf(".")+1);
		sf.append(" from ");
		sf.append(entityClass);
		sf.append(getHQLCondition(map));
		sf.append(addOrderByStatement(orders));
		return sf.toString();
	}
	/**
	 * 添加排序字段 支持多个 支持传入排序方式 升序或降序
	 * @param list
	 * @return
	 */
	private String addOrderByStatement(Map<String,String> orders){
		if(orders!=null&&orders.size()>0){
			Set<String> set = orders.keySet();
			StringBuffer sf=new StringBuffer(" order by ");
			Iterator<String> iterator = set.iterator();
			String firstKey = iterator.next();
			sf.append(firstKey);
			if(orders.get(firstKey)!=null){
				sf.append(" "+orders.get(firstKey));
			}
			while (iterator.hasNext()) {
				String key=iterator.next();
				sf.append(","+key);
				if(orders.get(key)!=null&&!orders.get(key).equals("")){
					sf.append(" "+orders.get(key));
				}
			}
			return sf.toString();
		}
		return "";
	}
	
	@Override
	public List<T> findListByCondition(Map<String, Object> map, Map<String,String> orders) {
		String hql=getHQL(map,orders);
		return baseDao.findListByHqlWithCondition(hql, map);
	}


	@Override
	public void batchDelete(String[] ids) {
		if(ids!=null&&ids.length>0){
			for(String id:ids){
				T t = findById(id);
				delete(t);
			}
		}
	}

	@Override
	public void batchUpdate(List<T> presisEntity) {
		if(presisEntity!=null&&presisEntity.size()>0){
			for(T entity:presisEntity){
				update(entity);
			}
		}
	}

}
