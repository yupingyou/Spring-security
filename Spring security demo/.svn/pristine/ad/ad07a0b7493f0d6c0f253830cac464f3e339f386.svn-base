package com.xingguo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="app_dept")
public class AppDept implements Serializable{
	private String id;
	private String deptName;
	private String priority;
	private AppDept parentDept;
	private AppOrg org;
	private Date createDate;
	private String creator;
	private Date modifyDate;
	private String modifer;
	private String remark;
	private String deleteFlag;
	@Id
	@Column(length=50)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name="dept_name",length=50)
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Column(name="priority",length=10)
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	@ManyToOne(cascade={CascadeType.REMOVE},fetch=FetchType.LAZY)
	@JoinColumn(name="parent_id")
	public AppDept getParentDept() {
		return parentDept;
	}
	public void setParentDept(AppDept parentDept) {
		this.parentDept = parentDept;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="org_id")
	public AppOrg getOrg() {
		return org;
	}
	public void setOrg(AppOrg org) {
		this.org = org;
	}
	@Column(name="createD_date")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Column(name="creator",length=50)
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	@Column(name="modify_date")
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Column(name="modifer",length=50)
	public String getModifer() {
		return modifer;
	}
	public void setModifer(String modifer) {
		this.modifer = modifer;
	}
	@Column(name="remark",length=200)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the deleteFlag
	 */
	@Column(name="delete_flag",length=1)
	public String getDeleteFlag() {
		return deleteFlag;
	}
	/**
	 * @param deleteFlag the deleteFlag to set
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	
}
