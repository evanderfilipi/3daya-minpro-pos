<!-- Form Mulai -->
<form id="form-edit" class="form-horizontal">

	<input type="hidden" name="id" id="id" />

	<div class="form-group">
		<label class="control-label col-md-2">First Name</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="firstName"
				id="firstName" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-md-2">Last Name</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="lastName" id="lastName" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-md-2">email</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="email" id="email" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-md-2">Title</label>
		<div class="col-md-9">
			<select name="title" id="title" class="form-control">
				<option value="Mr.">Mr.</option>
				<option value="Mrs.">Mrs.</option>
			</select>
		</div>
	</div>

	<div class="row" id="row-role" style="display: none;">
		<div class="col-md-2">
			<select id="roleId" name="ur[roleId]" class="form-control">
				<option value="">=Select Role=</option>
			</select>
		</div>

		<div class="modal-footer">
			<button type="button" class="btn btn-primary"
				onClick="editData($('#form-edit'))">Simpan</button>
			<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
		</div>
</form>
<!-- Form Selesai -->