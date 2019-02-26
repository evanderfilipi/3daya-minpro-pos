<% request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Outlets</h3>
		<!-- div class="box-tools">
			<button type="button" id="btn-add" class="btn btn-success btn-sm">
				<i class="fa fa-plus"></i>
			</button>
		</div-->
	</div>
	<div class="box-body">
		<input type = "text" name = "search" id="search" placeholder="Search" onKeypress="getSearch();"/>
		<div class="box-tools">
			<button type="button" id="btn-add" class="btn btn-primary btn-sm pull-right">
				<i class="fa fa-plus"></i> Create
			</button>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Address</th>
					<th>Phone</th>
					<th>Email</th>					
					<th>#</th>
				</tr>
			</thead>
			<tbody id="list-outlet">
			</tbody>
		</table>		
	</div>
</div>

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
		loadData();
	});
	
	function loadData(){
		$.ajax({
			url:'${contextName}/api/outlet/',
			type:'get',
			dataType:'json',
			success : function(result){
				$("#list-outlet").empty();
				$.each(result, function(index, item){
					var dataRow ='<tr>'+
						'<td>'+ item.name +'</td>'+
						'<td>'+ item.address+'</td>'+
						'<td>'+ item.phone+'</td>'+
						'<td>'+ item.email+'</td>'+
						'<td class="col-md-1">'+
							'<button type="button" class="btn btn-edit btn-success btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i>Edit</button> '+
						'</td>'+
						'</tr>';
					$("#list-outlet").append(dataRow);
				});
				// menampilkan data ke console => F12
				console.log(result);
			}
		});
	}
	
	/**function getSearch(){
		var dataId = $('#search').val();
		$.ajax({
			url : '${contextName}/api/outlet/search/'+dataId,
			type : 'get',
			dataType : 'json',
			success : function(dataApi){
				$("#list-outlet").empty();
				$.each(dataApi, function(index, item){
					var dataRow ='<tr>'+
						'<td>'+ item.name +'</td>'+
						'<td>'+ item.address+'</td>'+
						'<td>'+ item.phone+'</td>'+
						'<td>'+ item.email+'</td>'+
						'<td class="col-md-1">'+
							'<button type="button" class="btn btn-edit btn-success btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i>Edit</button> '+
						'</td>'+
						'</tr>';
					$("#list-outlet").append(dataRow);
				});
				// menampilkan data ke console => F12
				console.log(dataApi);
			}
		});
	}**/
	
	function getSearch(){
		var dataId = $('#search').val();
		$.ajax({
			url: '${contextName}/api/outlet/search/'+dataId,
			type:'get',
			dataType: 'json',
			success: function(result){
				//kosong data di table
				$("#list-outlet").empty();
				// looping data dengan jQuery
				$.each(result, function(index, item){
					var dataRow ='<tr>'+
						'<td>'+ item.name +'</td>'+
						'<td>'+ item.address +'</td>'+
						'<td>'+ item.phone +'</td>'+
						'<td>'+ item.email +'</td>'+
						'<td class="col-md-1">'+
							'<button type="button" class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i> Edit</button> '+
						'</td>'+
						'</tr>';
					$("#list-outlet").append(dataRow);
				});
				// menampilkan data ke console => F12
				console.log(result);
			}
		});
	}
	
	$('#btn-add').click(function(){
		$.ajax({
			url :'${contextName}/outlet/create/',
			tipe :'get',
			dataType :'html',
			success : function(result){
				//mencari element yang ada di modal-evander
				//mengganti judul modal
				$("#modal-title").html("Input Outlet");
				//mengisi content dengan variable result
				$("#modal-data").html(result);
				//menampilkan modal pop up
				$("#modal-form").modal('show');
				
				loadProvince($("#modal-data"), 0);
			}
		});
	});
	

	function addData($form){
		// memangil method getFormData dari file
		// resources/dist/js/map-form-objet.js
		var dataForm = getFormData($form);
		$.ajax({
			// url ke api/packages/
			url:'${contextName}/api/outlet/',
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
	
	function loadProvince($form, $selected){
		$.ajax({
			// url ke api/product/
			url:'${contextName}/api/province/',
			type:'get',
			// data type berupa JSON
			dataType:'json',
			success : function(result){
				$('#provinceId').empty();
				$('#provinceId').append('<option value="">Province</option>');
				$.each(result, function(index, item){
					if($selected == item.id){
						$("#provinceId").append('<option value="'+item.id+'" selected="selected">'+item.name+'</option>');
					}else{
						$("#provinceId").append('<option value="'+ item.id +'">'+ item.name +'</option>');
					}
				});
			}
		});
	}
	
	function loadRegion($form, $selected, $getRid){
		$.ajax({
			url:'${contextName}/api/region/'+$getRid,
			type:'get',
			dataType:'json',
			success: function(result){
				$("#regionId").empty();
				$("#regionId").append('<option value="">Region</option>');
				$.each(result, function(index, item){
					if($selected == item.id){
						$("#regionId").append('<option value="'+item.id+'" selected="selected">'+item.name+'</option>');
					}else{
						$("#regionId").append('<option value="'+ item.id +'">'+ item.name +'</option>');
					}
				});
			}
		});
	}
	
	function getRegionById(regId){
		$.ajax({
			url:'${contextName}/api/region/'+regId,
			type:'get',
			dataType:'json',
			success: function(result){
				$('#modal-data').find('#regionId').empty();
				$('#modal-data').find('#regionId').append('<option value="">Region</option>');
				$.each(result, function(index, item){
					$('#modal-data').find('#regionId').append('<option value="'+item.id+'">'+item.name+'</option>');
				});
			}
		});
	}
	
	function loadDistrict($form, $selected, $getDid){
		$.ajax({
			url:'${contextName}/api/district/'+$getDid,
			type:'get',
			// data type berupa JSON
			dataType:'json',
			success : function(result){
				// empty data first
				$("#districtId").empty();
				$("#districtId").append('<option value="">District</option>');
				// looping data
				$.each(result, function(index, district){
					if($selected == district.id){
						$("#districtId").append('<option value="'+ district.id +'" selected="selected">'+ district.name +'</option>');
					} else {
						$("#districtId").append('<option value="'+ district.id +'">'+ district.name +'</option>');
					}
				});
			}
		});
	}

	
	function getDistrictById(dId){
		$.ajax({
			url:'${contextName}/api/district/'+dId,
			type:'get',
			dataType:'json',
			success:function(result){
				$('#modal-data').find("#districtId").empty();
				$('#modal-data').find("#districtId").append('<option value="">District</option>');
				// looping data
				$.each(result, function(index, district){
					$('#modal-data').find("#districtId").append('<option value="'+ district.id +'">'+ district.name +'</option>');
				});
			}
		});
	}
	
	function getData(dataId){
		// panggil API
		$.ajax({
			// url ke api/product/
			url:'${contextName}/api/outlet/'+dataId,
			type:'get',
			// data type berupa JSON
			dataType:'json',
			success : function(dataApi){
				$('#modal-data').find('#id').val(dataApi.id);
				$('#modal-data').find('#name').val(dataApi.name);
				$('#modal-data').find('#address').val(dataApi.address);
				$('#modal-data').find('#postalCode').val(dataApi.postalCode);
				$('#modal-data').find('#phone').val(dataApi.phone);
				$('#modal-data').find('#email').val(dataApi.email);
				$('#modal-data').find('#active').val(dataApi.active);
				
				loadProvince($("#modal-data"), dataApi.provinceId);
				loadRegion($("#modal-data"), dataApi.regionId, dataApi.provinceId);
				loadDistrict($("#modal-data"), dataApi.districtId, dataApi.regionId);
				console.log(dataApi);
			}
		});
	}
	
	$('#list-outlet').on('click','.btn-edit', function(){
		var oId = $(this).val();
		$.ajax({
			url:'${contextName}/outlet/edit',
			type:'get',
			dataType:'html',
			success : function(result){
				//mengganti judul modal
				$("#modal-title").html("Outlet Edit");
				//mengisi content dengan variable result
				$("#modal-data").html(result);
				//menampilkan modal pop up
				$("#modal-form").modal('show');
				// panggil method getData				
				
				getData(oId);
			}
		});
	});
	
	function editData($form){
		// memangil method getFormData dari file
		// resources/dist/js/map-form-objet.js
		var dataForm = getFormData($form);
		$.ajax({
			// url ke api/packages/
			url:'${contextName}/api/outlet/',
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
</script>