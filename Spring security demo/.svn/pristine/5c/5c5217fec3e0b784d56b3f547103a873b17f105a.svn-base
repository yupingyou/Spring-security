package com.xingguo.action.sys;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xingguo.action.common.BaseAction;
import com.xingguo.entity.AppDept;
import com.xingguo.service.sys.AppDeptService;

public class DeptAction extends BaseAction<AppDept> {
	@Autowired
	private AppDeptService deptService;
	
	public String loadDeptTree(){
		jsonData=new HashMap<String, Object>();
		try {
			List<AppDept> list = deptService.findListByCondition(condition);
			jsonData.put("list", list);
			jsonData.put("status", 0);
		} catch (Exception e) {
			jsonData.put("status", 1);
			jsonData.put("msg", e.getMessage());
		}
		return JSON_RESULT;
	}
	
	@Override
	public AppDept getModel() {
		if(entity==null){
			entity=new AppDept();
		}
		return entity;
	}
	
}
