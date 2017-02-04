package com.xingguo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * AppRoles entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "APP_ROLES")
public class AppRoles implements java.io.Serializable {

	// Fields

	private String id;
	private String roleName;
	private String remark;
	private Set<AppUsers> users = new HashSet<AppUsers>(0);
	private Set<AppResource> resources = new HashSet<AppResource>(0);

	// Constructors

	/** default constructor */
	public AppRoles() {
	}

	/** minimal constructor */
	public AppRoles(String id) {
		this.id = id;
	}

	/** full constructor */
	public AppRoles(String id, String roleName, String remark,
			Set<AppUsers> users, Set<AppResource> resources) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.remark = remark;
		this.users = users;
		this.resources = resources;
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

	@Column(name = "ROLE_NAME", length = 50)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "REMARK", length = 500)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the users
	 */
	@ManyToMany(mappedBy="roles")
	public Set<AppUsers> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<AppUsers> users) {
		this.users = users;
	}

	/**
	 * @return the resources
	 */
	@ManyToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinTable(name="app_role_resouce",
			joinColumns=@JoinColumn(name="ROLE_ID"),
			inverseJoinColumns=@JoinColumn(name="RESOURCE_ID"))
	public Set<AppResource> getResources() {
		return resources;
	}

	/**
	 * @param resources the resources to set
	 */
	public void setResources(Set<AppResource> resources) {
		this.resources = resources;
	}

}