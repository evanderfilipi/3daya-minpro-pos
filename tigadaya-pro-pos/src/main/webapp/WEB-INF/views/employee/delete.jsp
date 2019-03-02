<form id="form-delete" class="form-horizontal">
	<div class="panel panel-success">
		<div class="panel-heading"></div>
		<div class="panel-body">
		
		<input type="hidden" name="id" id="id" />
			<div class="col-md-4">
				<div class="form-group">
					<div class="col-md-12">
						<input type="text" class="form-control" name="firstName" id="firstName" readonly="readonly" />
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="form-group">
					<div class="col-md-12">
						<input type="text" class="form-control" name="lastName" id="lastName" readonly="readonly"/>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="form-group">
					<div class="col-md-12">
						<input type="email" class="form-control" name="email" id="email" readonly="readonly"/>
					</div>
				</div>
			</div>

		<input type="hidden" name="title" id="title">
			

				
					<input type="hidden" name="haveAccount" value="true" id="title">
			</div>
		</div>
	</div>
	<input type="hidden" class="form-control" name="active" id="active"/>


	<div class="panel-footer">
		<button type="button" onClick="deleteData($('#form-delete'))" class="btn btn-danger">Delete</button>
		<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
	</div>

</form>
