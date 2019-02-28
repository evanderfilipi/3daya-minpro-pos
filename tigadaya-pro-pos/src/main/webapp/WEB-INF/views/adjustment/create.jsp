<form id="form-create" class="form-horizontal">
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">CREATE NEW ADJUSTMENT : Outlet Login</h3>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Notes</label>
			<div class="col-md-10">
				<input style="height: 200px;" type="text" class="form-control"
					name="notes" id="notes" />
			</div>
		</div>

		<input type="hidden" class="form-control" name="outletId"
			id="outletId" value="1" /> <input type="hidden" class="form-control"
			name="status" id="status" value="Submitted" />


	</div>
	<div class="box box-success">
		<div class="box-header with-border">
			<h3 class="box-title">Adjustment Stock</h3>
			<div class="modal-footer">
				<button style="width: 100%;" type="reset"
					class="btn btn-primary pull-left" id="btn-add-adj">Add Item</button>
			</div>
		</div>
		<div class="boc-body no-padding">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Item</th>
					<th>In Stock</th>
					<th>Adj. Qty</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody id="list-adjustment">
			</tbody>
		</table>
		</div>
	</div>

	<div class="modal-footer">
		<button type="reset" class="btn btn-primary"
			style="margin-right: 10px">Cancel</button>
		<button type="button" onClick="addData($('#form-create'))"
			class="btn btn-primary">Save & Submit</button>
	</div>

</form>

<div class="modal" id="modal-kerja">
	<div class="modal-dialog">
		<div class="box box-success">
			<div class="box-header">
				<h3 class="box-title">Form Input</h3>
			</div>
			<div class="box-body" id="modal-data">
				
			</div>
		</div>
	</div>
</div>

<script>

$('#btn-add-adj').click(function(){
	$.ajax({
		url :'${contextName}/adjustment/form-adjustment',
		tipe :'get',
		dataType :'html',
		success : function(result){
			$('#modal-data').html(result);
			$("#modal-kerja").modal('show');
			load
		}
	});
});

//load adjustment
function loadAdjustment(){
	$.ajax({
		url:'${contextName}/api/product/',
		type:'get',
		dataType:'json',
		success:function(result){
			$('#modal-data').find('#productId').empty();
			$('#modal-data').find('#productId').append('<option value=""></option>');
			$.each(result, function(index, item){
				$('#modal-data').find('#productId').append('<option value="'+ item.id +'">'+ item.name +'</option>');
			});
		}
	});
}


	function addProduct($product){
		var dataProduct = $product.serializeJSON();
		var dataRow = '<tr>'+
				'<td>'+
					'<input type="hidden" name="pod[][productId]" value="'+ dataProduct.productId +'" class="form-control productId"/>'+
					'<input type="text" name="pod[][productName]" value="'+ dataProduct.productName +'" class="form-control packageName"/>'+
				'</td>'+
				'<td>'+
					'<input type="hidden" name="pod[][packageId]" value="'+ dataProduct.packageId +'" class="form-control packageId"/>'+
					'<input type="text" name="pod[][packageName]" value="'+ dataProduct.packageName +'" class="form-control packageName"/>'+
				'</td>'+
				'<td><input type="text" name="pod[][price]" value="'+ dataProduct.price +'" class="form-control price"/></td>'+
				'<td><input type="text" name="pod[][quantity]" value="'+ dataProduct.quantity +'" class="form-control quantity"/></td>'+
				'<td><input type="text" name="pod[][subTotal]" value="'+ dataProduct.subTotal +'" class="form-control subTotal"/></td>'+
				'<td><button type="button" class="btn btn-remove btn-xs btn-danger"><i class="fa fa-trash"></i></button></td>'
			'</tr>';
		// add data to list-detail
		$('#list-purchase').append(dataRow);
		// hide modal
		$('#modal-kerja').modal('hide');
	}


	$('#list-detail').on('click','.btn-remove', function(){
		$(this).closest('tr').remove();
	});
	
	
</script>