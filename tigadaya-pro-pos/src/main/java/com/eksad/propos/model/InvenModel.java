package com.eksad.propos.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
<<<<<<< HEAD
=======
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
>>>>>>> 2a108cb5d90c2aee81e4c02f152012596f4efe85
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="pos_item_inventory")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class InvenModel {
	
@Id
@Column(name = "id", columnDefinition = "serial")
@GeneratedValue(strategy = GenerationType.TABLE, generator = "pos_mst_item_variant")
@TableGenerator(name = "pos_mst_item_variant", table = "tbl_squence", 
pkColumnName = "seq_id", valueColumnName = "seq_value", 
initialValue = 0, allocationSize=1)
private Integer id;

@Column(name="variant_id")
private Integer variantId;

@Column(name="outlet_id")
private Integer outletId;

@Column(name="beginning")
private Integer beginning;

@Column(name="purchase_qty")
private Integer purchaseQty;

@Column(name="sales_order_qty")
private Integer salesOrderQty;

@Column(name="transfer_stock_qty")
private Integer transferStockQty;

@Column(name="adjustment_qty")
private Integer adjustmentQty;

@Column(name="ending_qty")
private Integer endingQty;

@Column(name="alert_at_qty")
private Integer alertAtQty;

@Column(name="created_by")
private Integer createdBy;

@Column(name="created_on")
private Date createdOn;

@Column(name="modified_by")
private Integer modifiedBy;

@Column(name="modified_on")
private Date modifiedOn;

<<<<<<< HEAD
@ManyToOne
@JoinColumn(name="variant_id", updatable = false, insertable = false)
private VariantModel variant;



public VariantModel getVariant() {
	return variant;
}
public void setVariant(VariantModel variant) {
	this.variant = variant;
=======
@JsonIgnore
@OneToMany(mappedBy="inventory")
private List<PoDetailModel> listPoDetail;

@OneToOne
@JoinColumn(name="variant_id", updatable=false, insertable=false)
private VariantModel variant_invent;


public VariantModel getVariant_invent() {
	return variant_invent;
}
public void setVariant_invent(VariantModel variant_invent) {
	this.variant_invent = variant_invent;
}
public Integer getBeginning() {
	return beginning;
}
public void setBeginning(Integer beginning) {
	this.beginning = beginning;
}
public List<PoDetailModel> getListPoDetail() {
	return listPoDetail;
}
public void setListPoDetail(List<PoDetailModel> listPoDetail) {
	this.listPoDetail = listPoDetail;
>>>>>>> 2a108cb5d90c2aee81e4c02f152012596f4efe85
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getVariantId() {
	return variantId;
}
public void setVariantId(Integer variantId) {
	this.variantId = variantId;
}
public Integer getOutletId() {
	return outletId;
}
public void setOutletId(Integer outletId) {
	this.outletId = outletId;
}
public Integer getBegining() {
	return beginning;
}
public void setBegining(Integer begining) {
	this.beginning = begining;
}
public Integer getPurchaseQty() {
	return purchaseQty;
}
public void setPurchaseQty(Integer purchaseQty) {
	this.purchaseQty = purchaseQty;
}
public Integer getSalesOrderQty() {
	return salesOrderQty;
}
public void setSalesOrderQty(Integer salesOrderQty) {
	this.salesOrderQty = salesOrderQty;
}
public Integer getTransferStockQty() {
	return transferStockQty;
}
public void setTransferStockQty(Integer transferStockQty) {
	this.transferStockQty = transferStockQty;
}
public Integer getAdjustmentQty() {
	return adjustmentQty;
}
public void setAdjustmentQty(Integer adjustmentQty) {
	this.adjustmentQty = adjustmentQty;
}
public Integer getEndingQty() {
	return endingQty;
}
public void setEndingQty(Integer endingQty) {
	this.endingQty = endingQty;
}
public Integer getAlertAtQty() {
	return alertAtQty;
}
public void setAlertAtQty(Integer alertAtQty) {
	this.alertAtQty = alertAtQty;
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
		co= format.parse(createdOn);
	} catch (Exception e) {
		this.createdOn= null;
		
	}
	this.createdOn = co;
}
public Integer getModifiedBy() {
	return modifiedBy;
}
public void setModifiedOn(String modifiedOn) {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");
	Date mo = null;
	try {
		mo = format.parse(modifiedOn);
	} catch (Exception e) {
		this.modifiedOn=null;
	}
	this.modifiedOn = mo;
}
public Date getModifiedOn() {
	return modifiedOn;
}
public void setModifiedOn(Date modifiedOn) {
	this.modifiedOn = modifiedOn;
}


}
