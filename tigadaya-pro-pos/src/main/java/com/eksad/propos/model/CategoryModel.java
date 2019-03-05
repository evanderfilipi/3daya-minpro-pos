package com.eksad.propos.model;

import java.text.SimpleDateFormat;
import java.util.Date;

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
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
=======
>>>>>>> 2a108cb5d90c2aee81e4c02f152012596f4efe85

@Entity
@Table(name="pos_mst_category")

public class CategoryModel {
	@Id
	@Column(name="ID", columnDefinition="serial")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pos_mst_category_seq")
	@TableGenerator(name = "pos_mst_category_seq", table = "tbl_squence", 
	pkColumnName = "seq_id", valueColumnName = "seq_value",
	initialValue = 0, allocationSize=1)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="created_by")
	private Integer createdBy;
	
	@Column(name="created_on")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date createdOn;
	
	@Column(name="modified_by")
	private Integer modifiedBy;
	
	@Column(name="modified_on")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date modifiedOn;
	
<<<<<<< HEAD
	@JsonIgnore
	@OneToMany(mappedBy="category")
	private List<ItemModel> itemModel;

=======
	@Column(name="active")
	private Boolean active;
	
>>>>>>> 2a108cb5d90c2aee81e4c02f152012596f4efe85
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
		Date co = null;
		try {
			co = format.parse(createdOn); 
		} catch (Exception e) {
			this.createdOn= null;
		}
		this.createdOn=co;
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
		Date mo = null;
		try {
			mo = format.parse(modifiedOn); 
			} catch (Exception e) {
				this.modifiedOn= null;
			}
		this.modifiedOn=mo;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
		
	}

	public List<ItemModel> getItemModel() {
		return itemModel;
	}

	public void setItemModel(List<ItemModel> itemModel) {
		this.itemModel = itemModel;
	}

}