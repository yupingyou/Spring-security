package com.xingguo.action.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.xingguo.action.common.BaseAction;
import com.xingguo.constants.SystemConst;
import com.xingguo.entity.AppDept;
import com.xingguo.entity.AppOrg;
import com.xingguo.entity.AppUsers;
import com.xingguo.service.sys.AppDeptService;
import com.xingguo.service.sys.AppOrgService;
import com.xingguo.service.sys.AppUserService;
import com.xingguo.springSecurity.utils.SpringSecurityUtils;
import com.xingguo.utils.Const;
import com.xingguo.utils.MD5;
import com.xingguo.utils.UUIDSupport;

public class UserAction extends BaseAction<AppUsers> {
	@Autowired
	private AppUserService userService;
	@Autowired
	private AppDeptService appDeptService;
	@Autowired
	private AppOrgService appOrgService;
	private String orgName;
	private Date dateStart;
	private Date dateEnd;
	
	private String orgId;
	private String deptId;
	private String ids;
	/**
	 * 加载列表
	 * @return
	 */
	public String list(){
		jsonData=new HashMap<String, Object>();
		try {
			getPageParams();
			pagination=userService.findPageWithCondition(condition, pageNo, pageSize);
			List<AppUsers> items = pagination.getItems();
			List<AppUsers> newItems=new ArrayList<AppUsers>();
			if(items!=null&&items.size()>0){
				for(AppUsers user:items){
					AppUsers u=new AppUsers(user.getId(),user.getLoginName(),user.getUserName(),user.getDisabled()
							,user.getUserLockErrorNum(),user.getUserLockNum(),user.getCreateDate(),user.getCreator()
							,user.getModifyDate(),user.getModifer(),user.getMobilePhone(),user.getTel(),
							user.getEmail(),user.getGender(),user.getAddr(),user.getRemark(),user.getDeleteFlag());
					AppDept dept = user.getDept();
					AppOrg org = user.getOrg();
					u.setDept(dept);
					u.setOrg(org);
					newItems.add(u);
				}
			}
			pagination.setItems(newItems);
			log.info("----------------------------------------------");
			jsonData.put("page", pagination);
		} catch (Exception e) {
			log.error("",e);
			jsonData.put("status", 1);
			jsonData.put("msg", Const.LOAD_FAIL);
		}
		return JSON_RESULT;
	}
	/**
	 * 获取页面传递过来的数据
	 */
	private void getPageParams(){
		condition=new HashMap<String, Object>();
		if(entity!=null){
			if(StringUtils.isNotBlank(entity.getLoginName())){
				condition.put("loginName", entity.getLoginName());
			}
			if(StringUtils.isNotBlank(entity.getUserName())){
				condition.put("userName", entity.getUserName());
			}
			if(StringUtils.isNotBlank(entity.getMobilePhone())){
				condition.put("mobilePhone", entity.getMobilePhone());
			}
			if(StringUtils.isNotBlank(orgName)){
				condition.put("orgName", orgName);
			}
			if(StringUtils.isNotBlank(entity.getDisabled())){
				condition.put("disabled", entity.getDisabled());
			}
			if(dateStart!=null){
				condition.put("dateStart", dateStart);
			}
			if(dateEnd!=null){
				dateEnd.setHours(23);
				dateEnd.setMinutes(59);
				dateEnd.setSeconds(59);
				condition.put("dateEnd", dateEnd);
			}
			
		}
	}
	
	
	public String userDetail(){
		jsonData=new HashMap<String, Object>();
		try {
			AppUsers user = userService.findById(entity.getId());
			jsonData.put("user", user);
		} catch (Exception e) {
			log.error("",e);
			jsonData.put("status", 1);
			jsonData.put("msg", e.getMessage());
		}
		return JSON_RESULT;
	}
	
	public String addUser(){
		jsonData=new HashMap<String, Object>();
		try {
			entity.setId(UUIDSupport.getUUIDWithoutMinus());
			Date date=new Date();
			entity.setCreateDate(date);
			entity.setCreator(SpringSecurityUtils.getCurrUserName());
			entity.setPassword(MD5.MD5Encode(entity.getPassword()));
			entity.setDeleteFlag(SystemConst.DELETE_FLAG_NO+"");
			entity.setDisabled("1");
			entity.setUserLockErrorNum(0);
			AppDept dept = appDeptService.findById(deptId);
			AppOrg org = appOrgService.findById(orgId);
			entity.setOrg(org);
			entity.setDept(dept);
			userService.save(entity);
			jsonData.put("status", 0);
			jsonData.put("msg", Const.SUCCESS_STR);
		} catch (Exception e) {
			log.error("",e);
			jsonData.put("status", 1);
			jsonData.put("msg", e.getMessage());
		}
		return JSON_RESULT;
	}
	
	
	
	public String update(){
		jsonData=new HashMap<String, Object>();
		try {
			AppUsers presist = userService.findById(entity.getId());
			presist.setUserName(entity.getUserName());
			presist.setAddr(entity.getAddr());
			presist.setEmail(entity.getEmail());
			presist.setGender(entity.getGender());
			presist.setMobilePhone(entity.getMobilePhone());
			presist.setModifer(SpringSecurityUtils.getCurrUserName());
			presist.setModifyDate(new Date());
			presist.setTel(entity.getTel());
			presist.setRemark(entity.getRemark());
			if(StringUtils.isNotBlank(entity.getPassword())){
				presist.setPassword(MD5.MD5Encode(entity.getPassword()));
			}
			AppDept dept = appDeptService.findById(deptId);
			AppOrg org = appOrgService.findById(orgId);
			presist.setOrg(org);
			presist.setUserLockErrorNum(entity.getUserLockErrorNum());
			presist.setUserLockNum(entity.getUserLockNum());
			presist.setDept(dept);
			userService.update(presist);
			jsonData.put("status", 0);
			jsonData.put("msg", Const.SUCCESS_STR);
		} catch (Exception e) {
			log.error("",e);
			jsonData.put("status", 1);
			jsonData.put("msg", e.getMessage());
		}
		return JSON_RESULT;
	}
	
	public String delete(){
		jsonData=new HashMap<String, Object>();
		try {
			if(StringUtils.isNotBlank(ids)){
				String[] split = ids.split(",");
				userService.batchDelete(split);
				jsonData.put("status", 0);
				jsonData.put("msg", Const.SUCCESS_STR);
			}else{
				jsonData.put("status", 1);
				jsonData.put("msg", Const.PARAM_ERROR);
			}
		} catch (Exception e) {
			log.error("",e);
			jsonData.put("status", 1);
			jsonData.put("msg", e.getMessage());
		}
		return JSON_RESULT;
	}
	
	public String moveDept(){
		jsonData=new HashMap<String, Object>();
		try {
			if(StringUtils.isNotBlank(deptId)){
				if(StringUtils.isNotBlank(ids)){
					String[] split = ids.split(",");
					List<AppUsers> list=new ArrayList<AppUsers>();
					for(String id:split){
						AppUsers user = userService.findById(id);
						AppDept dept = appDeptService.findById(deptId);
						if(dept!=null){
							user.setDept(dept);
						}
						list.add(user);
					}
					userService.batchUpdate(list);
					jsonData.put("status", 0);
					jsonData.put("msg", Const.SUCCESS_STR);
				}else{//后台验证
					jsonData.put("status", 1);
					jsonData.put("msg", "请选择至少选择一个用户");
				}
			}else{
				jsonData.put("status", 1);
				jsonData.put("msg", "请选择一个部门");
			}
		} catch (Exception e) {
			log.error("",e);
			jsonData.put("status", 1);
			jsonData.put("msg", Const.FAIL_STR);
		}
		return JSON_RESULT;
	}
	
	public String lock(){
		jsonData=new HashMap<String, Object>();
		try {
			if(entity!=null){
				AppUsers users = userService.findById(entity.getId());
				users.setDisabled("0");
				userService.update(users);
				jsonData.put("status", 0);
				jsonData.put("msg", Const.SUCCESS_STR);
			}else{
				jsonData.put("status", 1);
				jsonData.put("msg", Const.PARAM_ERROR);
			}
		} catch (Exception e) {
			log.error("",e);
			jsonData.put("status", 1);
			jsonData.put("msg", e.getMessage());
		}
		return JSON_RESULT;
	}
	
	public String unlock(){
		jsonData=new HashMap<String, Object>();
		try {
			if(entity!=null){
				AppUsers users = userService.findById(entity.getId());
				users.setDisabled("1");
				userService.update(users);
				jsonData.put("status", 0);
				jsonData.put("msg", Const.SUCCESS_STR);
			}else{
				jsonData.put("status", 1);
				jsonData.put("msg", Const.PARAM_ERROR);
			}
		} catch (Exception e) {
			log.error("",e);
			jsonData.put("status", 1);
			jsonData.put("msg", e.getMessage());
		}
		return JSON_RESULT;
	}
	

	@Override
	public AppUsers getModel() {
		if(entity==null){
			entity=new AppUsers();
		}
		return entity;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * @return the dateStart
	 */
	public Date getDateStart() {
		return dateStart;
	}
	/**
	 * @param dateStart the dateStart to set
	 */
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	/**
	 * @return the dateEnd
	 */
	public Date getDateEnd() {
		return dateEnd;
	}
	/**
	 * @param dateEnd the dateEnd to set
	 */
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	/**
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}
	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	/**
	 * @return the ids
	 */
	public String getIds() {
		return ids;
	}
	/**
	 * @param ids the ids to set
	 */
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	
}
