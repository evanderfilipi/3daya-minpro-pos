<!-- form mulai -->
<form id="form-create" class="form-horizontal">

	<div class="form-group">
		<label class="control-label col-md-2">Category Name</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="name" />
		</div>
	</div>
		
	<input type="hidden" class="form-control" name="active" value="true" />
	
	<div class="modal-footer">
	
		<button type="button" onClick="addData($('#form-create'))" class="btn btn-primary">Save</button>
		<button type="reset" class="btn btn-primary pull-left">Cancel</button>
	</div>
</form>
<!-- Form Selesai -->