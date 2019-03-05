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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "pos_t_po_history")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=PoHistoryModel.class)
public class PoHistoryModel {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pos_t_po_history_seq")
	@TableGenerator(name = "pos_t_po_history_seq", table = "tbl_squence", pkColumnName = "seq_id", valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
	private Integer id;
	
	@Column(name="po_id")
	private Integer poId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_by")
	private Integer createdBy;
	
	@Column(name="created_on")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Timestamp createdOn;
	
	@ManyToOne
	@JoinColumn(name="po_id", updatable=false, insertable=false)
	private PurchaseOrderModel pOrder;

	public PurchaseOrderModel getpOrder() {
		return pOrder;
	}

	public void setpOrder(PurchaseOrderModel pOrder) {
		this.pOrder = pOrder;
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

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

}
