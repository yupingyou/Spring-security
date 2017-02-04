package com.xingguo.service.sys;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.xingguo.entity.AppUsers;
import com.xingguo.entity.common.PaginationSupport;
import com.xingguo.service.common.BaseService;



public interface AppUserService extends BaseService<AppUsers>{
	/**
	 * 根据用户登录名查询用户信息
	 * @param userLoginName
	 * @return
	 */
	public AppUsers findByUserLoginName(String userLoginName);
	/**
	 * 根据用户登录名，密码查询用户信息
	 * @param loginName
	 * @param password
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	Map<String, String> findUserByLoginNameAndPassword(String loginName,
			String password) throws FileNotFoundException, IOException;
	/**
	 * 分页查询用户对象
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PaginationSupport<AppUsers> findPageWithCondition(Map<String, Object> map,int pageNo,int pageSize);
	
}
