package com.eksad.propos.model;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonManagedReference;
=======
>>>>>>> 04cd6569413b416b49741567327b74a3b1f8397d
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="pos_mst_item_variant")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope=SupplierModel.class)
public class VariantModel {

	
	@Id
	@Column(name = "id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pos_mst_item_variant")
	@TableGenerator(name = "pos_mst_item_variant", table = "tbl_squence", 
	pkColumnName = "seq_id", valueColumnName = "seq_value", 
	initialValue = 0, allocationSize=1)
	private Integer id;
	
	@Column(name="item_id")
	private Integer itemId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="sku")
	private String sku;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name="created_by")
	private Integer createdBy;
	
	@Column(name="created_on")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Timestamp createdOn;
	
	@Column(name="modified_by")
	private Integer modifiedBy;
	
	@Column(name="modified_on")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Timestamp modifiedOn;
	
	@Column(name="active")
	private Boolean active;
	
<<<<<<< HEAD
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="item_id", referencedColumnName="id", updatable=false, insertable=false)
	@JsonManagedReference
	private ItemModel item; 
	
	@JsonIgnore
	@OneToMany(mappedBy="variantInven")
	private List<InvenModel> listInven;
	
=======
	@JsonIgnore
	@OneToMany(mappedBy="variant")
	private List<PoDetailModel> listPoDetail;
	
	@ManyToOne
	@JoinColumn(name="item_id", updatable=false, insertable=false)
	private ItemModel itemMod;
	
	
	public ItemModel getItemMod() {
		return itemMod;
	}
	public void setItemMod(ItemModel itemMod) {
		this.itemMod = itemMod;
	}
	public List<PoDetailModel> getListPoDetail() {
		return listPoDetail;
	}
	public void setListPoDetail(List<PoDetailModel> listPoDetail) {
		this.listPoDetail = listPoDetail;
	}
>>>>>>> 04cd6569413b416b49741567327b74a3b1f8397d
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
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
	public void setCreatedOn(Timestamp createdOn) {
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
	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
