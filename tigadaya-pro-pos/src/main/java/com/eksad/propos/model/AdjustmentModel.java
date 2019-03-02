package com.eksad.propos.model;

	import java.text.SimpleDateFormat;
	import java.util.Date;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.persistence.TableGenerator;
	import javax.persistence.Temporal;
	import javax.persistence.TemporalType;

	import com.fasterxml.jackson.annotation.JsonFormat;

	@Entity
	@Table(name="pos_t_adjustment")

	public class AdjustmentModel {
		@Id
		@Column(name="ID", columnDefinition="serial")
		@GeneratedValue(strategy = GenerationType.TABLE, generator = "pos_t_adjustment_seq")
		@TableGenerator(name = "pos_t_adjustment_seq", table = "tbl_squence", 
		pkColumnName = "seq_id", valueColumnName = "seq_value",
		initialValue = 0, allocationSize=1)
		private Integer id;
		
		@Column(name="outlet_id")
		private Integer outletId;
		
		@Column(name="notes")
		private String notes;
		
		@Column(name="status")
		private String status;
		
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
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getOutletId() {
			return outletId;
		}
		public void setOutletId(Integer outletId) {
			this.outletId = outletId;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
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

	}