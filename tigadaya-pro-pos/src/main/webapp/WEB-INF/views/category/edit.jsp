<!-- form mulai -->
<form id="form-edit" class="form-horizontal">
	<!-- id -->
	<input type="hidden" name="id" id="id" />

	<div class="form-group">
		<label class="control-label col-md-2">Category Name</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="name" id="name" />
		</div>
	</div>
		
	<input type="hidden" class="form-control" name="active" value="true" />

	<div class="modal-footer">
		<button type="reset" class="btn btn-primary" >Cancel</button>
		<button type="button" class="btn btn-primary" onClick="editData($('#form-edit'))">Save</button>

		<button type="button" class="btn btn-danger pull-left" onClick="deleteData('#form-edit')" >X</button>


	</div>
</form>
<!-- Form Selesai -->