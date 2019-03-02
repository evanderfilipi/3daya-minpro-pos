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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pos_mst_item")
public class ItemModel {
	@Id
	@Column(name="ID", columnDefinition="serial")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pos_mst_item_seq")
	@TableGenerator(name = "pos_mst_item_seq", table = "tbl_squence", 
	pkColumnName = "seq_id", valueColumnName = "seq_value",
	initialValue = 0, allocationSize=1)
	private Integer id;


	@Column(name = "name")
	private String name;
	
	@Column(name = "category_id")
	private String categoryId;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "created_on")
	private Date createdOn;
	
	@Column(name = "modified_by")
	private  Integer modifiedBy;
	
	@Column(name = "modified_on")
	private Date modifiedOn;
	
	@Column(name= "active")
	private Boolean active;
	
	@JsonIgnore
	@OneToMany(mappedBy="itemMod")
	private List<VariantModel> listVariant;
	

	public List<VariantModel> getListVariant() {
		return listVariant;
	}

	public void setListVariant(List<VariantModel> listVariant) {
		this.listVariant = listVariant;
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

	
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
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
	

}