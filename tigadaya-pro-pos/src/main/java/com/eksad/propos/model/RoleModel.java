package com.eksad.propos.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="pos_mst_role")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope=RoleModel.class)
public class RoleModel {
	@Id
	@Column(name ="id",columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pos_mst_role_seq")
	@TableGenerator(name="pos_mst_role_seq", table="tbl_squence", pkColumnName="seq_id", valueColumnName="seq_value", initialValue = 0, allocationSize=1)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
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
	@OneToMany(mappedBy="role")	
	private List<UserModel> listUser;
	
	
	public List<UserModel> getListUser() {
		return listUser;
	}

	public void setListUser(List<UserModel> listUser) {
		this.listUser = listUser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
