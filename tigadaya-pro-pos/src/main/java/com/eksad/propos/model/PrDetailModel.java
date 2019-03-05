package com.eksad.propos.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pos_t_pr_detail")
public class PrDetailModel {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pos_t_pr_detail_seq")
	@TableGenerator(name = "pos_t_pr_detail_seq", table = "tbl_squence", pkColumnName = "seq_id", valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
	private Integer id;
	
	@Column(name = "pr_id")
	private Integer prId;
	
	@Column(name = "variant_id")
	private Integer variantId;
	
	@Column(name = "request_qty")
	private Integer requestQty;
	
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
	@JoinColumn(name="pr_id", updatable=false, insertable=false)
	private PurchaseRequestModel prMod;
	
	@ManyToOne
	@JoinColumn(name="variant_id", updatable=false, insertable=false)
	private VariantModel variant;
	
	@ManyToOne
	@JoinColumn(name="variant_id", updatable=false, insertable=false)
	private InvenModel inventory;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPrId() {
		return prId;
	}

	public void setPrId(Integer prId) {
		this.prId = prId;
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

	public PurchaseRequestModel getPrMod() {
		return prMod;
	}

	public void setPrMod(PurchaseRequestModel prMod) {
		this.prMod = prMod;
	}

	public VariantModel getVariant() {
		return variant;
	}

	public void setVariant(VariantModel variant) {
		this.variant = variant;
	}

	public InvenModel getInventory() {
		return inventory;
	}

	public void setInventory(InvenModel inventory) {
		this.inventory = inventory;
	}
	
}
