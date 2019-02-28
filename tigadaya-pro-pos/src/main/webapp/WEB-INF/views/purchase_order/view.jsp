<form id="form-view" class="form-horizontal">
	
	<div class="col-md-12" >
	
		<div class="form-group">
			<div class="col-md-12">
				<label>Purchase Order Detail</label>
				<select name="status" id="status" class="btn btn-primary pull-right" onChange="transValue($(this).val());">
					<option value="">More</option>
					<option value="Approved">Approv</option>
					<option value="Rejected">Reject</option>
					<option value="Processed">Process</option>
					<option value="Print">Print</option>
				</select>
				<hr style="margin-top: 5px">	
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
			
			<!-- TABEL SUPPLIER -->
				
				<input type="text" readonly id="name-sup" class="form-control"/> <!-- Supplier -->
				<table class="table table-bordered" style="margin: 0">
					<tbody id="supplier">
					
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<label>Notes</label>
				<textarea rows="4" cols="63" id="notes-sup" placeholder="Notes" style="padding: 10px"></textarea>
			</div>
		</div>
		<br/>
		<!-- TABEL OUTLET -->
		<div class="form-group">
			<div class="col-md-12">
				<table style="margin: 0">
					<tbody id="outlet">
					
					</tbody>
				</table> 
			</div>
		</div>
	
		<!--  TABEL PO HISTORY -->
		<div class="form-group">
			<div class="col-md-12">
			<label>Status History</label> <hr style="margin-top: 0; margin-bottom: 10px">
				<table>
					<tbody id="historyPo">
					
					</tbody>
				</table>
				<!-- <label>Status History</label> <hr style="margin-top: 0; margin-bottom: 10px">	
				<p>PO Number : PO001</p> 
				<p>Created By : Evander</p>  -->
			</div>
		</div>
		<br/>
		<!-- TABEL ITEM -->
		<div class="form-group">
			<div class="col-md-12">
				<label>Purchase Item</label> <hr style="margin: 0">	
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<table>
					<tr>
						<th width="25%">Item</th>
						<th width="15%">In Stock</th>
						<th width="10%">Qty</th>
						<th width="25%">Unit Cost</th>
						<th>Sub Total</th>
					</tr>
					<tr>
						<td><input type="text" class="form-control" name="name" placeholder="Baju - Merah" id="name" /></td>
						<td><input type="text" class="form-control" name="name" placeholder="3" id="name" readOnly /></td>
						<td><input type="text" class="form-control" name="name" placeholder="10" id="name" readOnly /></td>
						<td><input type="text" class="form-control" name="name" placeholder="Rp. 50.000" id="name" /></td>
						<td><input type="text" class="form-control" name="name" placeholder="Rp. 500.000" id="name" readOnly /></td>
					</tr>
				</table>
			</div>
		</div>
		
		<br />
		
		<div class="form-group">
			<div class="col-md-12">
				<table>
					<tr>
						<th width="84%">TOTAL</th>
						<th>Rp. 500.000</th>
					</tr>
				</table>	
			</div>
		</div>
</div>
</form>

<form id="form-update">
	<input type="hidden" name="id" id="v1" />
	<input type="hidden" name="prId" id="v2" />
	<input type="hidden" name="outletId" id="v3" />
	<input type="hidden" name="supplierId" id="v4" />
	<input type="hidden" name="poNo" id="v5" />
	<input type="hidden" name="notes" id="v6" />
	<input type="hidden" name="grandTotal" id="v7" />
	<input type="hidden" name="status" id="poStatus" />
	<input type="hidden" name="createdBy" id="v8" />
	<input type="hidden" name="createdOn" id="v9" />
	<input type="hidden" name="modifiedBy" value="2" />
	<input type="hidden" name="modifiedOn" id="modifiedOn-Po" />	
</form>

<form id="form-insert">
	<input type="hidden" id="poHisId" name="poId" />
	<input type="hidden" id="poHisStatus" name="status" />
	<input type="hidden" id="createdBy" name="createdBy" value="2" />
	<input type="hidden" id="createdOn-PoHis" name="createdOn" />	
</form>

<div class="modal-footer">
	<button type="button" class="btn btn-primary" onClick="updateStatus($('#form-update')); insertPoHis($('#form-insert'))">Done</button>
</div>