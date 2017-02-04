package com.xingguo.dao.sys;

import java.util.Map;

import com.xingguo.dao.common.BaseDao;
import com.xingguo.entity.AppUsers;
import com.xingguo.entity.common.PaginationSupport;

public interface AppUserDao extends BaseDao<AppUsers> {
	/**
	 * 按条件查询单个用户
	 * @param map
	 * @return
	 */
	public AppUsers findEntityByCondition(Map<String, Object> map);
	/**
	 * 按条件分页查询用户信息
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PaginationSupport<AppUsers> findPageByCondition(Map<String, Object> map,
			int pageNo, int pageSize);
}
