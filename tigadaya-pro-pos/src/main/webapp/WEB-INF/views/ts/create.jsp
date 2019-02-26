<!-- form mulai -->
<form id="form-create" class="form">
	<div class="form-group">
		<label class="control-label">Create New Transfer Stock Form</label>
	</div>

	<div class="form-group">
		<label class="control-label">To</label>
		<select class="form-control" name = "toOutlet" id="toOutlet">
			<option value="">To Outlet</option>
		</select>
	</div>
	
	<div class="form-group">
		<label class="control-label">Notes</label>
		<textarea class="form-control" rows="4" cols="65" name="notes"></textarea>
	</div>
	<div class="box box-success">
		<div class="box-header with-border">
			<h3 class="box-title">Transfer Item</h3>
			<div class="box-tools">
				<button type="button" class="btn btn-primary btn-sm" id="btn-add-purchase">Add Transfer Item</button>
			</div>
		</div>
		<div class="box-body no-padding">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Item</th>
						<th>In Stock</th>
						<th>Transfer Quantity</th>
					</tr>
				</thead>
				<tbody id="list-item">
				</tbody>
			</table>
		</div>
	</div>

	<div class="box-footer">
		<button type="button" onClick="addData($('#form-create'))" class="btn btn-primary pull-left">Save & Submit</button>
		<button type="button" class="btn btn-warning" data-dismiss="modal">Cancel</button>
	</div>
</form>
<!-- Form Selesai -->

<script>
$(function(){
	loadOutlet();
});

function loadOutlet($form, $selected){
	$.ajax({
		url:'${contextName}/api/ts/',
		type:'get',
		// data type berupa JSON
		dataType:'json',
		success : function(result){
			// empty data first
			$("#toOutlet").empty();
			$("#toOutlet").append('<option value="">To Outlet</option>');
			// looping data
			$.each(result, function(index, outlet){
				if($selected == outlet.id){
					$("#toOutlet").append('<option value="'+ outlet.id +'" selected="selected">'+ outlet.name +'</option>');
				} else {
					$("#toOutlet").append('<option value="'+ outlet.id +'">'+ outlet.name +'</option>');
				}
			});
		}
	});
}

</script>