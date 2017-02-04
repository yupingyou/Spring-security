package com.xingguo.service.sys.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xingguo.dao.sys.AppOrgDao;
import com.xingguo.entity.AppOrg;
import com.xingguo.entity.common.PaginationSupport;
import com.xingguo.service.common.impl.BaseServiceImpl;
import com.xingguo.service.sys.AppOrgService;

@Service
@Transactional
public class AppOrgServiceImpl extends BaseServiceImpl<AppOrg> implements AppOrgService{

	@Autowired
	private AppOrgDao appOrgDao;
	
	@Override
	public PaginationSupport<AppOrg> findPageWithCondition(
			Map<String, Object> condition, int pageNo, int pageSize) {
		return appOrgDao.findPageWithCondition(condition,pageNo,pageSize);
	}

}
