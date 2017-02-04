package com.xingguo.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * AppResource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "APP_RESOURCE")
public class AppResource implements java.io.Serializable {

	// Fields

	private String id;
	private String url;
	private String resouceCode;
	private Integer priority;
	private String parentResouce;
	private String description;
	private Date createDate;
	private String creator;
	private Date modifyDate;
	private String modifer;
	private String deleteFlag;
	private Set<AppRoles> roles = new HashSet<AppRoles>(0);

	// Constructors

	/** default constructor */
	public AppResource() {
	}

	/** minimal constructor */
	public AppResource(String id, String url, Timestamp createDate) {
		this.id = id;
		this.url = url;
		this.createDate = createDate;
	}

	/** full constructor */
	public AppResource(String id, String url, String resouceCode,
			Integer priority, String parentResouce, String description,
			Timestamp createDate, String creator, Timestamp modifyDate,
			String modifer, String deleteFlag,
			Set<AppRoles> roles) {
		this.id = id;
		this.url = url;
		this.resouceCode = resouceCode;
		this.priority = priority;
		this.parentResouce = parentResouce;
		this.description = description;
		this.createDate = createDate;
		this.creator = creator;
		this.modifyDate = modifyDate;
		this.modifer = modifer;
		this.deleteFlag = deleteFlag;
		this.roles = roles;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "URL", nullable = false, length = 200)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "RESOUCE_CODE", length = 200)
	public String getResouceCode() {
		return this.resouceCode;
	}

	public void setResouceCode(String resouceCode) {
		this.resouceCode = resouceCode;
	}

	@Column(name = "priority", length = 50)
	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Column(name = "PARENT_RESOUCE", length = 50)
	public String getParentResouce() {
		return this.parentResouce;
	}

	public void setParentResouce(String parentResouce) {
		this.parentResouce = parentResouce;
	}

	@Column(name = "DESCRIPTION", length = 1000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "CREATE_DATE", nullable = false, length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "CREATOR", length = 50)
	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name = "MODIFY_DATE", length = 7)
	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Column(name = "MODIFER", length = 50)
	public String getModifer() {
		return this.modifer;
	}

	public void setModifer(String modifer) {
		this.modifer = modifer;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@ManyToMany(mappedBy="resources",cascade=CascadeType.ALL)
	public Set<AppRoles> getRoles() {
		return roles;
	}

	public void setRoles(Set<AppRoles> roles) {
		this.roles = roles;
	}

	
	

}