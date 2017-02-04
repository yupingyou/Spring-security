package com.xingguo.service.sys.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xingguo.dao.sys.AppDeptDao;
import com.xingguo.entity.AppDept;
import com.xingguo.entity.common.PaginationSupport;
import com.xingguo.service.common.impl.BaseServiceImpl;
import com.xingguo.service.sys.AppDeptService;
@Service
@Transactional
public class AppDeptServiceImpl extends BaseServiceImpl<AppDept> implements
		AppDeptService {
	@Autowired
	private AppDeptDao appDeptDao;
	
	@Override
	public List<AppDept> findListByCondition(Map<String, Object> map) {
		return appDeptDao.findListByCondition(map);
	}

}
