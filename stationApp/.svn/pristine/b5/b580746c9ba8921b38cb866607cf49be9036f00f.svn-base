package com.xingguo.dao.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xingguo.dao.common.impl.BaseDaoImpl;
import com.xingguo.dao.sys.AppDeptDao;
import com.xingguo.entity.AppDept;
@Repository
public class AppDeptDaoImpl extends BaseDaoImpl<AppDept> implements AppDeptDao {

	@Override
	public List<AppDept> findListByCondition(Map<String, Object> map) {
		String hql=" from AppDept "+getHQLCondition(map)+" order by createDate desc ";
		return findListByHqlWithCondition(hql, map);
	}
	
	private String getHQLCondition(Map<String, Object> map){
		StringBuffer sf=new StringBuffer(" where 1=1 ");
		if(map!=null&&map.size()>0){
			//TODO something
		}
		sf.append(" and deleteFlag='1'");
		return sf.toString();
	}
	
	
}
