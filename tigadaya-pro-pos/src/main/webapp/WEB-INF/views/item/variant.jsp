<form id="form-variant" class="form-horizontal">
<div class="table-responsive">
	<div class="col-md-12">
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="name" id="name" placeholder="Variant Name" />
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text"  class="form-control" name="price" id="price" placeholder=" Unit Price" />
				</div>
			</div>
		</div>
	
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="sku" id="sku" placeholder=" SKU " value="${kodeBaru }" readonly="readonly"/>
				</div>
			</div>
		</div>
		
		<div class="col-md-12">
			<div class="form-group">
				<div class="col-md-12">
					<h3 class="box-title col-md-8">Set Beginning Stock</h3>
				</div>
			</div>
		</div>
		
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="begining" id="begining" placeholder="Begining Stock" />
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
			
				<div class="col-md-12">
					<input type="text" class="form-control" name="alertAtQty" id="alertAtQty" placeholder="Alert at" />
				</div>
			</div>
		</div>
		
	
	
	</div>
	
	<div class="modal-footer">
		<button type="button" onClick="addDataVariant($('#form-variant'))" class="btn btn-primary pull-right">Save</button>
		<button type="button" class="btn btn-warning pull-right" style="margin-right: 15px;" data-dismiss="modal">Cancel</button>
	</div>
	</div>
</form>