<% request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Item ${username}</h3>
		<div class="box-tools">
		</div>
	</div>
	<div class="box-body">
	<div class="row">
	<div class="col-md-3">
	<input type="text"  id="txt-search" placeholder="Search" onKeypress="cari($(this).val());"/>
	</div>
	<div class="col-md-2 col-md-offset-8">
		<button type="button" id="btn-add"  class="btn btn-primary pull-right"  >Create</button>
		<button type="button" id="btn-export" class="btn btn-primary pull-right" >Export</button>
		
	
	</div>
	</div>
		<table class="table table-striped table-bordered" >
			<thead>
				<tr>
					<th>Name</th>
					<th>Category</th>
					<th>Unit Price</th>
					<th>In Stock</th>
					<th>Stock Alert</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody id="list-data">
			</tbody>
		</table>		
	</div>
</div>

<div class="modal" id="modal-form">
	<div class="modal-dialog-lg">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title" id="modal-title">Form Input</h3>
			</div>
			<div class="box-body" id="modal-data">
				
			</div>
		</div>
	</div>
</div>

<div class="modal" id="modal-cilik">
<div class="modal-dialog">
<div class="box box-success">
<div class="box-header with-border" >
	<h3 class="box-title" id="modal-title"> Form Input</h3>
	</div>
	<div class="box-body" id="modal-bawah">
	</div>
</div>
</div>
</div>


<script>
	// method yang pertama kali dipanggil saat page di load
	$(function(){
		// memanggil method loadData;
		loadData();
	});
	
		function loadData(){
		$.ajax({
			// url ke api/category/
			url:'${contextName}/api/item',
			type:'get',
			// data type berupa JSON
			dataType:'json',
			success : function(result){
				//kosong data di table
				$("#list-data").empty();
				// looping data dengan jQuery
				$.each(result, function(index, item){
					var dataRow ='<tr>'+
						'<td>'+ item.variant.item.name +'</td>'+
						'<td>'+ item.variant.item.category.name+'</td>'+
						'<td>'+ item.variant.price+'</td>'+
						'<td>'+ item.begining+'</td>'+
						'<td>'+ item.alertAtQty+'</td>'+
						'<td class="col-md-1"> '+
						'<button type-"button" class="btn btn-edit btn-info btn-xs" value="'+item.id+'"><i class="fa fa-eye"></i>Edit</button>'+
						'</td>'+
						'</tr>';
					$("#list-data").append(dataRow);
				});
				// menampilkan data ke console => F12
				console.log(result);
			}
		});
	}
		
		$("#btn-add").click(function(){
			$.ajax({
				url:'${contextName}/item/create',
				type:'get',
				dataType:'html',
				success : function(result){
					//mengganti judul modal
					$("#modal-title").html("Items");
					//mengisi content dengan variable result
					$("#modal-data").html(result);
					//menampilkan modal pop up
					$("#modal-form").modal('show');
					//menampilkan modal pop up
					loadCategory();
				}
			});
		});
		
		
		function addData($form){
			var name = $('#modal-data').find("#name").val();
			var category = $('#modal-data').find("#categoryId").val();
			var len = name.length;
			var len2 = category.length;
			if(len<1) {
				alert('"Name" tidak boleh kosong');
			} else if(len2<1){
				alert('Pilih Category');
			}else {
			// memangil method getFormData dari file
			// resources/dist/js/map-form-objet.js
			var dataForm = $form.serializeJSON();
			$.ajax({
				// url ke api/category/
				url:'${contextName}/api/item',
				type:'post',
				// data type berupa JSON
				dataType:'json',
				// mengirim parameter data
				data:JSON.stringify(dataForm),
				// mime type 
				contentType: 'application/json',
				success : function(result){
					//menutup modal
					$("#modal-form").modal('hide');
					// panggil method load data, untuk melihat data terbaru
					loadData();
				}
			});
			console.log(dataForm);
		}
		}
		
		function loadCategory(){
			$.ajax({
				url:'${contextName}/api/category/',
				type:'get',
				dataType:'json',
				success:function(result){
					$('#modal-data').find('#categoryId').empty();
					$('#modal-data').find('#categoryId').append('<option value="">select Category</option>');
					$.each(result, function(index, item){
						$('#modal-data').find('#categoryId').append('<option value="'+ item.id +'">'+ item.name +'</option>');
					});
				}
			});
		}
		
		function cari(key){
			var cari = $('#search').val();
			$.ajax({
				// url ke api/supplier/
				url:'${contextName}/api/item/search/'+key,
				type:'get',
				// data type berupa JSON
				dataType:'json',
				success : function(result){
					//kosong data di table
					$("#list-data").empty();
					// looping data dengan jQuery
					$.each(result, function(index, item){
						var dataRows ='<tr>'+
							'<td>'+ item.name +'</td>'+
							'<td>'+ item.categoryId+'</td>'+
							'<td class="col-md-1">'+		
							'</td>'+
							'</tr>';
						$("#list-data").append(dataRows);
					});
					// menampilkan data ke console => F12
					console.log(result);
				}
			});
		}
		
		function addVariant($variant){
			$.ajax({
				url:'${contextName}/item/variant',
				type:'get',
				dataType:'html',
				success : function(result){
					//mengganti judul modal
					$("#modal-title").html("Items");
					//mengisi content dengan variable result
					$("#modal-bawah").html(result);
					//menampilkan modal pop up
					$("#modal-cilik").modal('show');
				} 
			});			
			}

		function addDataVariant($product){
			var name = $('#modal-bawah').find("#name").val();
			var price = $('#modal-bawah').find("#price").val();
			var begining = $('#modal-bawah').find("#begining").val();
			var alertat = $('#modal-bawah').find("#alertAtQty").val();
			var len = name.length;
			var len2 = price.length;
			var len3 = begining.length;
			var len4 = alertat.length;
			if(len <1 ){
				alert('Variant Name harus diisi');
			}else if(len2<1){
				alert('Price Harus Diisi');
			}else if(len3<1){
				alert('Begining Harus Diisi');
			}else if(len4<1){
				alert('AlertAt harus Diisi');
			}else{
			var dataVariant = $product.serializeJSON();
			var dataRow = '<tr>'+
			'<td>'+
			'<input type="hidden" name="vm[][itemId]" value="1" class="form-control ItemId"/>'+
			'<input type="text" name="vm[][name]" value="'+ dataVariant.name +'" class="form-control name"/>'+
		'</td>'+
		'<td><input type="text" name="vm[][price]" value="'+ dataVariant.price +'" class="form-control price"/></td>'+
		'<td><input type="text" name="vm[][sku]" value="'+ dataVariant.sku +'" class="form-control sku"/></td>'+
		'<td><input type="text" name="im[][begining]" value="'+ dataVariant.begining +'" class="form-control begining"/></td>'+
		'<td><input type="text" name="im[][alertAtQty]" value="'+ dataVariant.alertAtQty +'" class="form-control alertAtQty"/></td>'+
		'<td><button type="button" class="btn btn-remove btn-xs btn-danger"><i class="fa fa-trash"></i></button></td>'
		'</tr>';
			// add data to list-detail
			$('#list-variant').append(dataRow);
			// hide modal
			$("#modal-cilik").modal('hide');
		}
		}
		
		function getData(dataId){
			// panggil API
			$.ajax({
				// url ke api/category/
				url:'${contextName}/api/item/'+dataId,
				type:'get',
				// data type berupa JSON
				dataType:'json',
				success : function(dataApi){
					$('#modal-data').find('#id').val(dataApi.id);
					$('#modal-data').find('#name').val(dataApi.name);
					$('#modal-data').find('#categoryId').val(dataApi.categoryId);
					console.log(dataApi);
				}
			});
		}

		$('#list-data').on('click','.btn-edit', function(){
			var vid = $(this).val();
			$.ajax({
				url:'${contextName}/item/edit',
				type:'get',
				dataType:'html',
				success : function(result){
					//mengganti judul modal
					$("#modal-title").html("Item Edit ");
					//mengisi content dengan variable result
					$("#modal-data").html(result);
					//menampilkan modal pop up
					$("#modal-form").modal('show');
					// panggil method getData	
					loadCategory();
					getData(vid);
					getDataInven(vid);
					//getDataVariant(vid);
				}
			});
		});

		function editData($form){
			var name = $('#modal-data').find("#name").val();
			var len = name.length
			if(len<1){
				alert('Nama Harus diisi');
			}else{
			// memangil method getFormData dari file
			// resources/dist/js/map-form-objet.js
			var dataForm = $form.serializeJSON();
			$.ajax({
				// url ke api/purchaseorder/
				url:'${contextName}/api/item',
				type:'put',
				// data type berupa JSON
				dataType:'json',
				// mengirim parameter data
				data:JSON.stringify(dataForm),
				// mime type 
				contentType: 'application/json',
				success : function(result){
					//menutup modal
					$("#modal-form").modal('hide');
					// panggil method load data, untuk melihat data terbaru
					loadData();
				}
			});
			console.log(dataForm);
		}
		}
		
		function getDataInven(dataId){
			// panggil API
			$.ajax({
				// url ke api/purchaseorder/
				url:'${contextName}/api/inven/'+dataId,
				type:'get',
				// data type berupa JSON
				dataType:'json',
				success : function(dataApiDetail){
					$("#list-variant").empty();
					
					
					var dataRow ='<tr>'+
						'<td> '+dataApiDetail.variant.name+'</td>'+
						'<td> '+dataApiDetail.variant.price+'</td>'+
						'<td> '+dataApiDetail.variant.sku+'</td>'+
						'<td> '+dataApiDetail.alertAtQty+'</td>'+
						'<td> '+dataApiDetail.begining+'</td>'+
						
						'</tr;>'
					$('#list-variant').append(dataRow);
					//$('#modal-data').find('#name').val(dataApiDetail.name);
					
					console.log(dataApi);
				}
			});
		}
		
		
	</script>