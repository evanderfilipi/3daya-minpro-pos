<form id="form-edit" class="form-horizontal">
	<!-- id -->
	<input type="hidden" name="id" id="id" />
	
	<div class="col-md-12" style="border-top: 0px">
	
		<div class="form-group">
			<div class="col-md-12">
				<label>EDIT NEW PO: Outlet Login</label> <hr style="margin: 0">	
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<label>Choose Supplier</label>
				<select name="regionId" id="regionId" class="form-control" onChange="getDistrictById($(this).val());">
						<option value="">Supplier</option>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<label>Notes</label>
				<textarea rows="4" cols="63" name="address" placeholder="Notes" id="address" style="padding: 10px"></textarea>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<label>Purchase Order</label> <hr style="margin: 0">	
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
	
	<div class="modal-footer">
		
		<button type="button" class="btn btn-success" onClick="editData($('#form-edit'))">Submit</button>
		<button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
		<button type="button" class="btn btn-primary" onClick="editData($('#form-edit'))">Save</button>
	</div>
	</div>
</form>
<!-- Form Selesai -->