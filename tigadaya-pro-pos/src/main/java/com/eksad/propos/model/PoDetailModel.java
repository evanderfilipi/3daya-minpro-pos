package com.eksad.propos.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pos_t_po_detail")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=PurchaseOrderModel.class)
public class PoDetailModel {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pos_t_po_detail_seq")
	@TableGenerator(name = "pos_t_po_detail_seq", table = "tbl_squence", pkColumnName = "seq_id", valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
	private Integer id;
	
	@Column(name = "po_id")
	private Integer poId;
	
	@Column(name = "variant_id")
	private Integer variantId;
	
	@Column(name = "request_qty")
	private Integer requestQty;
	
	@Column(name = "unit_cost")
	private Integer unitCost;
	
	@Column(name = "sub_total")
	private Integer subTotal;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "created_on")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Timestamp createdOn;
	
	@Column(name = "modified_by")
	private Integer modifiedBy;
	
	@Column(name = "modified_on")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Timestamp modifiedOn;
	
	@ManyToOne
	@JoinColumn(name="po_id", updatable=false, insertable=false)
	private PurchaseOrderModel poMod;
	
	@ManyToOne
	@JoinColumn(name="variant_id", updatable=false, insertable=false)
	private VariantModel variant;
	
	@ManyToOne
	@JoinColumn(name="variant_id", updatable=false, insertable=false)
	private InvenModel inventory;
	
	
	public InvenModel getInventory() {
		return inventory;
	}

	public void setInventory(InvenModel inventory) {
		this.inventory = inventory;
	}

	public VariantModel getVariant() {
		return variant;
	}

	public void setVariant(VariantModel variant) {
		this.variant = variant;
	}

	public PurchaseOrderModel getPoMod() {
		return poMod;
	}

	public void setPoMod(PurchaseOrderModel poMod) {
		this.poMod = poMod;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPoId() {
		return poId;
	}

	public void setPoId(Integer poId) {
		this.poId = poId;
	}

	public Integer getVariantId() {
		return variantId;
	}

	public void setVariantId(Integer variantId) {
		this.variantId = variantId;
	}

	public Integer getRequestQty() {
		return requestQty;
	}

	public void setRequestQty(Integer requestQty) {
		this.requestQty = requestQty;
	}

	public Integer getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Integer unitCost) {
		this.unitCost = unitCost;
	}

	public Integer getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Integer subTotal) {
		this.subTotal = subTotal;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
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

	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
}
