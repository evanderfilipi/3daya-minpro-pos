package com.eksad.propos.model;

import java.sql.Timestamp;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "pos_t_po")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=PurchaseOrderModel.class)
public class PurchaseOrderModel {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pos_t_po_seq")
	@TableGenerator(name = "pos_t_po_seq", table = "tbl_squence", pkColumnName = "seq_id", valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
	private Integer id;
	
	@Column(name = "pr_id")
	private Integer prId;
	
	@Column(name = "outlet_id")
	private Integer outletId;
	
	@Column(name = "supplier_id")
	private Integer supplierId;
	
	@Column(name = "po_no")
	private String poNo;
	
	@Column(name = "notes")
	private String notes;
	
	@Column(name = "grand_total")
	private Integer grandTotal;
	
	@Column(name = "status")
	private String status;
	
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
	@JoinColumn(name="supplier_id", updatable=false, insertable=false)
	private SupplierModel supplier;
	
	@JsonIgnore
	@OneToMany(mappedBy="pOrder")
	private List<PoHistoryModel> listPoHistory;
	
	@JsonIgnore
	@OneToMany(mappedBy="poMod")
	private List<PoDetailModel> listPoDetail;
	

	public List<PoDetailModel> getListPoDetail() {
		return listPoDetail;
	}

	public void setListPoDetail(List<PoDetailModel> listPoDetail) {
		this.listPoDetail = listPoDetail;
	}

	public List<PoHistoryModel> getListPoHistory() {
		return listPoHistory;
	}

	public void setListPoHistory(List<PoHistoryModel> listPoHistory) {
		this.listPoHistory = listPoHistory;
	}

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

	public Integer getOutletId() {
		return outletId;
	}

	public void setOutletId(Integer outletId) {
		this.outletId = outletId;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Integer grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public SupplierModel getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierModel supplier) {
		this.supplier = supplier;
	}
}
