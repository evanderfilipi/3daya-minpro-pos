package com.eksad.propos.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.eksad.propos.model.EmployeeModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="pos_mst_employee")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope=EmployeeModel.class)
public class EmployeeModel {
	@Id
	@Column(name ="id",columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pos_mst_employee_seq")
	@TableGenerator(name="pos_mst_employee_seq", table="tbl_squence", pkColumnName="seq_id", valueColumnName="seq_value", initialValue = 0, allocationSize=1)
	private Integer id;
	
@Column(name="first_name")
private String firstName;

@Column(name="last_name")
private String lastName;

@Column(name="email")
private String email;

@Column(name="title")
private String title;

@Column(name="have_account")
private Boolean haveAccount;

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

@ManyToOne(cascade = CascadeType.ALL)
@JoinTable(name = "pos_mst_user", 
  joinColumns = { @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable=false, updatable=false, insertable=false) },
  inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
private RoleModel role;

/*@JsonIgnore
@OneToOne
@JoinColumn(name="id", nullable=false, updatable=false, insertable=false)
private UserModel user;*/

public Integer getId() {
	return id;
}

public RoleModel getRole() {
	return role;
}

public void setRole(RoleModel role) {
	this.role = role;
}

public void setId(Integer id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public Boolean getHaveAccount() {
	return haveAccount;
}

public void setHaveAccount(Boolean haveAccount) {
	this.haveAccount = haveAccount;
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

public void setCreatedOn(String createdOn) {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Date sDate = null;
	try{
		sDate = format.parse(createdOn);
	} catch (Exception e) {
		sDate=null;
	}
	this.createdOn = sDate;
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

public void setModifiedOn(String modifiedOn) {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Date sDate2 = null;
	try{
		sDate2 = format.parse(modifiedOn);
	} catch (Exception e) {
		sDate2=null;
	}
	this.modifiedOn = sDate2;
}

public Boolean getActive() {
	return active;
}

public void setActive(Boolean active) {
	this.active = active;
}

}