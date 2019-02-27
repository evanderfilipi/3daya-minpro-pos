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
				<button type="button" class="btn btn-primary btn-sm" id="btn-additem">Add Transfer Item</button>
			</div>
		</div>
		<div class="box-body no-padding">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Item</th>
						<th>In Stock</th>
						<th>Transfer Quantity</th>
						<th>#</th>
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

<div class="modal" id="modal-form">
	<div class="modal-dialog">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title" id="modal-title">Form Input</h3>
			</div>
			<div class="box-body" id="modal-data">
				
			</div>
		</div>
	</div>
</div>

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

$("#btn-additem").click(function(){
	$.ajax({
		url:'${contextName}/ts/additem',
		type:'get',
		dataType:'html',
		success: function(result){
			//$("#modal-kerja").find(".box-title").html("Add New Purchase Detail");
			$("#modal-data").html(result);
			$("#modal-kerja").modal('show');
			
			//loadPackage($("#modal-data"));
			//loadProduct($("#modal-data"));
			loadProduct();
		}	
	});					
});

function addPurchase($detail){
	var dataPODetail = $detail.serializeJSON();
	var dataRow = '<tr>'+
					'<td>'+
						'<input type="hidden" name="pod[][productId]" value="'+dataPODetail.productId+'" class="form-control productId"/>'+
						'<input type="text" name="pod[][productName]" value="'+dataPODetail.productName+'" class="form-control productName"/>'+
					'</td>'+
					'<td>'+
						'<input type="hidden" name="pod[][packageId]" value="'+dataPODetail.packageId+'" class="form-control packageId"/>'+
						'<input type="text" name="pod[][packageName]" value="'+dataPODetail.packageName+'" class="form-control packageName"/>'+
					'</td>'+
					'<td><input type="text" name="pod[][price]" value="'+ dataPODetail.price+'" class="form-control price"/></td>'+
					'<td><input type="text" name="pod[][quantity]" value="'+ dataPODetail.quantity+'" class="form-control quantity"/></td>'+
					'<td><input type="text" name="pod[][subTotal]" value="'+ dataPODetail.subTotal+'" class="form-control subTotal"/></td> '+
					'<td><button type"button" class="btn btn-remove btn-xs btn-danger"><i class="fa fa-trash"></i></button></td> '
				'</tr>';	
	//add data to list-detail
	$('#list-purchase').append(dataRow);
	//hide modal
	$('#modal-kerja').modal('hide');
	
	//menambahkan ke total
	//1. get total yang lama
	var total = parseInt($('#totalAmount').val());
	var subTotal = parseInt(dataPODetail.subTotal);
	//2. total lama ditambah subtotal
	total = total+subTotal;
	//3. kirim nilai total yang terakhir ke id totalAmount
	$('#totalAmount').val(total);
}

//remove button
$('#list-purchase').on('click','.btn-remove',function(){
	$(this).closest('tr').remove();
});

</script>