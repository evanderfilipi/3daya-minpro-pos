package com.eksad.propos.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="pos_mst_user")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope=UserModel.class)
public class UserModel {
	@Id
	@Column(name ="id",columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pos_mst_user_seq")
	@TableGenerator(name="pos_mst_user_seq", table="tbl_squence", pkColumnName="seq_id", valueColumnName="seq_value", initialValue = 0, allocationSize=1)
	private Integer id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role_id")
	private Integer roleId;
	
	@Column(name="employee_id")
	private Integer employeeId;
	
	@Column(name="created_by")
	private Integer createdBy;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss")
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="modified_by")
	private Integer modifiedBy;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss")
	@Column(name="modified_on")
	private Date modifiedOn;
	
	@Column(name="active")
	private Boolean active;
	
	@JsonIgnore
	@OneToMany(mappedBy="userMod")
	private List<OutletModel> listOutletUser;
	
	@JsonIgnore
	@OneToMany(mappedBy="userModif")
	private List<OutletModel> listOutletUserModif;
	/*
	@ManyToOne
	@JoinColumn(name="role_id", nullable=false, updatable=false, insertable=false)
	private RoleModel role;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="employee_id", nullable=false, updatable=false, insertable=false)
	private EmployeeModel employee;
	*/
	

	public List<OutletModel> getListOutletUser() {
		return listOutletUser;
	}

	public List<OutletModel> getListOutletUserModif() {
		return listOutletUserModif;
	}

	public void setListOutletUserModif(List<OutletModel> listOutletUserModif) {
		this.listOutletUserModif = listOutletUserModif;
	}

	public void setListOutletUser(List<OutletModel> listOutletUser) {
		this.listOutletUser = listOutletUser;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
