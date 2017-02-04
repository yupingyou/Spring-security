package com.xingguo.dao.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xingguo.dao.common.impl.BaseDaoImpl;
import com.xingguo.dao.sys.AppUserDao;
import com.xingguo.entity.AppUsers;
import com.xingguo.entity.common.PaginationSupport;
@Repository
public class AppUserDaoImpl extends BaseDaoImpl<AppUsers> implements AppUserDao {

	@Override
	public AppUsers findEntityByCondition(Map<String, Object> map) {
		String hql=" from AppUsers "+getHQLCondition(map);
		List<AppUsers> list = findListByHqlWithCondition(hql, map);
		return list!=null&&list.size()>0?list.get(0):null;
	}
	
	private String getHQLCondition(Map<String, Object> map){
		StringBuffer sf=new StringBuffer(" where 1=1 ");
		if(map!=null&&map.size()>0){
			if(map.get("loginName")!=null){
				sf.append(" and loginName=:loginName");
			}
			if(map.get("mobilePhone")!=null){
				sf.append(" and mobilePhone=:mobilePhone");
			}
			if(map.get("orgName")!=null){
				sf.append(" and org.orgName=:orgName");
			}
			if(map.get("userName")!=null){
				sf.append(" and userName=:userName");
			}
			if(map.get("disabled")!=null){
				sf.append(" and disabled=:disabled");
			}
			if(map.get("dateStart")!=null){
				sf.append(" and createDate>=:dateStart");
			}
			if(map.get("dateEnd")!=null){
				sf.append(" and createDate<=:dateEnd");
			}
		}
		
		return sf.toString();
	}
	@Override
	public PaginationSupport<AppUsers> findPageByCondition(Map<String, Object> map,int pageNo,int pageSize){
		String hql=" from AppUsers "+getHQLCondition(map);
		return findListByPageWithCondition(hql, pageSize, pageNo, map);
	}
	
}
