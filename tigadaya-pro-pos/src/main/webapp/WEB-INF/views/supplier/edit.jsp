<form id="form-edit" class="form-horizontal">
<div class="table-responsive">
	<div class="col-md-12">
		<div class="form-group">
			<div class="col-md-12">
				<input type="hidden" class="form-control" name="id" id="id" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<input type="text" class="form-control" name="name" id="name" placeholder="Name" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<textarea rows="4" cols="65" name="address" id="address" placeholder="Address"></textarea>
			</div>
		</div>
	
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<select name="provinceId" id="provinceId" class="form-control" onChange="getRegionById($(this).val());">
						<option value="">Province</option>
					</select>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<select name="regionId" id="regionId" class="form-control" onChange="getDistrictById($(this).val());">
							<option value="">Region</option>
					</select>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<select name="districtId" id="districtId" class="form-control">
						<option value="">District</option>
					</select>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="postalCode" id="postalCode" placeholder="Postal Code" />
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="phone" id="phone" placeholder="Phone" />
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="email" id="email" placeholder="Email" />
				</div>
			</div>
		</div>
		
		<input type="hidden" class="form-control" name="createdBy" value="1"/>
		<input type="hidden" class="form-control" name="createdOn" id="createdOn"/>
		<input type="hidden" class="form-control" name="modifiedBy" value="2"/>
		<input type="hidden" class="form-control" name="modifiedOn" id="modifiedOn"/>
		<input type="hidden" class="form-control" name="active" value="true"/>
	</div>
	
	<div class="modal-footer">
		<button type="button" onClick="editData($('#form-edit'))" class="btn btn-primary pull-right"><i class="fa fa-save"></i> Save</button>
		<button type="reset" class="btn btn-danger pull-right" style="margin-right: 15px;"><i class="fa fa-times-circle"></i> Cancel</button>
	</div>
	</div>
</form>