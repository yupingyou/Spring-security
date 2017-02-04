package com.xingguo.service.sys;

import java.util.Map;

import com.xingguo.entity.AppOrg;
import com.xingguo.entity.common.PaginationSupport;
import com.xingguo.service.common.BaseService;

public interface AppOrgService extends BaseService<AppOrg>{

	PaginationSupport<AppOrg> findPageWithCondition(
			Map<String, Object> condition, int pageNo, int pageSize);

	
}
