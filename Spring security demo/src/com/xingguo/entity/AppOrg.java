package com.xingguo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="app_org")
public class AppOrg implements Serializable{
	private String id;
	private String orgName;
	private String orgSimpleName;
	private String orgEmail;
	private String orgTel;
	private String lawRepresentative;//法人代表
	private String addr;
	private Date orgCreateDate;
	private Date createDate;
	private String creator;
	private Date modifyDate;
	private String modifer;
	private String remark;
	private String deleteFlag;
	@Id
	@Column(name="id",length=50)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name="org_name",nullable=false,length=200)
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	@Column(name="org_simple_name",length=100)
	public String getOrgSimpleName() {
		return orgSimpleName;
	}
	public void setOrgSimpleName(String orgSimpleName) {
		this.orgSimpleName = orgSimpleName;
	}
	@Column(name="org_email",length=100)
	public String getOrgEmail() {
		return orgEmail;
	}
	public void setOrgEmail(String orgEmail) {
		this.orgEmail = orgEmail;
	}
	@Column(name="org_tel",length=20)
	public String getOrgTel() {
		return orgTel;
	}
	public void setOrgTel(String orgTel) {
		this.orgTel = orgTel;
	}
	@Column(name="law_Representative",length=50)
	public String getLawRepresentative() {
		return lawRepresentative;
	}
	public void setLawRepresentative(String lawRepresentative) {
		this.lawRepresentative = lawRepresentative;
	}
	@Column(name="addr",length=100)
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Column(name="org_create_Date")
	public Date getOrgCreateDate() {
		return orgCreateDate;
	}
	public void setOrgCreateDate(Date orgCreateDate) {
		this.orgCreateDate = orgCreateDate;
	}
	@Column(name="create_date")
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
