package com.xingguo.dao.sys.impl;

import java.beans.IntrospectionException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.xingguo.dao.common.impl.BaseDaoImpl;
import com.xingguo.dao.sys.AppResourceDao;
import com.xingguo.entity.AppResource;
import com.xingguo.entity.common.PaginationSupport;
@Repository
public class AppResourceDaoImpl extends BaseDaoImpl<AppResource> implements
		AppResourceDao {

	@Override
	public List<AppResource> findAllResource() {
		String hql=" from AppResource where deleteFlag='1' order by priority";
		return findListByHql(hql);
	}
	
}
