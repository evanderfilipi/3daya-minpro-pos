<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Suppliers</h3>
		<br/><br/>
		<!-- <a href="packages/create" class="btn btn-success pull-right"><i class="fa fa-plus-square"></i> Add</a> -->
		<div class="col-md-3">
		<input type="text" class="form-control" id="search" placeholder="Search" onKeypress="cari();"/>
		</div>
		<button type="button" class="btn btn-success pull-right" id="btn-add" style="margin-right: 10px;">
			<i class="fa fa-plus"></i> Create
		</button>
	</div>
	<div class="box-body">
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Address</th>
					<th>Phone</th>
					<th>E-mail</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody id="list-supplier">
				
			</tbody>
		</table>
	</div>
</div>

<div class="modal" id="modal-evander">
	<div class="modal-dialog">
		<div class="box box-success">
			<div class="box-header">
				<h3 class="box-title" id="modal-title"></h3>
			</div>
			<div class="box-body" id="modal-data">
				
			</div>
		</div>
	</div>
</div>

<script>
//method yang pertama kali dipanggil saat page di load
$(function(){
	// memanggil method loadData;
	loadData();
});

//method loadData
function loadData(){
	$.ajax({
		// url ke api/supplier/
		url:'${contextName}/api/supplier/',
		type:'get',
		// data type berupa JSON
		dataType:'json',
		success : function(result){
			//kosong data di table
			$("#list-supplier").empty();
			// looping data dengan jQuery
			$.each(result, function(index, item){
				var dataRow ='<tr>'+
					'<td>'+ item.name +'</td>'+
					'<td>'+ item.address+'</td>'+
					'<td>'+ item.phone+'</td>'+
					'<td>'+ item.email+'</td>'+
					'<td class="col-md-1">'+
						'<button type="button" class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i> Edit</button> '+
					'</td>'+
					'</tr>';
				$("#list-supplier").append(dataRow);
			});
			// menampilkan data ke console => F12
			console.log(result);
		}
	});
}

function cari(){
	// pencarian berdasarkan nama supplier
	var cari = $('#search').val();
	$.ajax({
		url:'${contextName}/api/supplier/search/'+cari,
		type:'get',
		dataType:'json',
		success : function(result){
			//kosongkan data di table
			$("#list-supplier").empty();
			$.each(result, function(index, item){
				var dataRows ='<tr>'+
					'<td>'+ item.name +'</td>'+
					'<td>'+ item.address+'</td>'+
					'<td>'+ item.phone+'</td>'+
					'<td>'+ item.email+'</td>'+
					'<td class="col-md-1">'+
						'<button type="button" class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i> Edit</button> '+
					'</td>'+
					'</tr>';
				$("#list-supplier").append(dataRows);
			});
			console.log(result);
		}
	});
}

$('#btn-add').click(function(){
	var d = new Date($.now());
	$.ajax({
		url :'${contextName}/supplier/create/',
		tipe :'get',
		dataType :'html',
		success : function(result){
			//mencari element yang ada di modal-evander
			//mengganti judul modal
			$("#modal-title").html("Supplier Detail");
			//mengisi content dengan variable result
			$("#modal-data").html(result);
			//menampilkan modal pop up
			$("#modal-evander").modal('show');
			
			loadProvince($("#modal-data"), 0);
			$('#modal-data').find("#createdOn").val(d.getDate() + "-" + (d.getMonth()+1) + "-"
					+ d.getFullYear() + " " + d.getHours()
					+ ":" + d.getMinutes() + ":"
					+ d.getSeconds());
			$('#modal-data').find("#modifiedOn").val(d.getDate() + "-" + (d.getMonth()+1) + "-"
					+ d.getFullYear() + " " + d.getHours()
					+ ":" + d.getMinutes() + ":"
					+ d.getSeconds());
		}
	});
});

function loadProvince($form, $selected){
	$.ajax({
		
		url:'${contextName}/api/province/',
		type:'get',
		// data type berupa JSON
		dataType:'json',
		success : function(result){
			// empty data first
			$("#provinceId").empty();
			$("#provinceId").append('<option value="">Province</option>');
			// looping data
			$.each(result, function(index, province){
				if($selected == province.id){
					$("#provinceId").append('<option value="'+ province.id +'" selected="selected">'+ province.name +'</option>');
				} else {
					$("#provinceId").append('<option value="'+ province.id +'">'+ province.name +'</option>');
				}
			});
		}
	});
}

function loadRegion($form, $selected, $getRid){
	$.ajax({
		
		url:'${contextName}/api/region/id/'+$getRid,
		type:'get',
		// data type berupa JSON
		dataType:'json',
		success : function(result){
			// empty data first
			$("#regionId").empty();
			$("#regionId").append('<option value="">Region</option>');
			// looping data
			$.each(result, function(index, region){
				if($selected == region.id){
					$("#regionId").append('<option value="'+ region.id +'" selected="selected">'+ region.name +'</option>');
				} else {
					$("#regionId").append('<option value="'+ region.id +'">'+ region.name +'</option>');
				}
			});
		}
	});
}

function loadDistrict($form, $selected, $getDid){
	$.ajax({
		
		url:'${contextName}/api/district/id/'+$getDid,
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

function getRegionById(rId){
	$.ajax({
		url:'${contextName}/api/region/id/'+rId,
		type:'get',
		dataType:'json',
		success:function(result){
			$('#modal-data').find("#regionId").empty();
			$('#modal-data').find("#regionId").append('<option value="">Region</option>');
			// looping data
			$.each(result, function(index, region){
				$('#modal-data').find("#regionId").append('<option value="'+ region.id +'">'+ region.name +'</option>');
			});
		}
	});
}

function getDistrictById(dId){
	$.ajax({
		url:'${contextName}/api/district/id/'+dId,
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

function addData($form){
	var name = $('#modal-data').find("#name").val();
	var province = $('#modal-data').find("#provinceId").val();
	var region = $('#modal-data').find("#regionId").val();
	var district = $('#modal-data').find("#districtId").val();
	var postalCode = $('#modal-data').find("#postalCode").val();
	var email = $('#modal-data').find("#email").val();
	var cekEmail = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	var len1 = name.length;
	var len2 = province.length;
	var len3 = region.length;
	var len4 = district.length;
	var len5 = postalCode.length;
	
	if(len1 < 1) {
		alert("Kolom Nama tidak boleh kosong!");
	} else if (len2 < 1){
		alert("Pilih Provinsi terlebih dahulu!");
	} else if (len3 < 1){
		alert("Pilih Region terlebih dahulu!");
	} else if (len4 < 1){
		alert("Pilih District terlebih dahulu!");
	} else if (len5 < 1){
		alert("Kolom Postal Code tidak boleh kosong!");
	} else if (len5 < 5){
		alert("Postal Code harus 5 digit/lebih!");
	} else if (!cekEmail.test(email)){
		alert("Format Email salah!");
	} else {
		var dataForm = getFormData($form);
			$.ajax({
				// url ke api/packages/
				url:'${contextName}/api/supplier/',
				type:'post',
				// data type berupa JSON
				dataType:'json',
				// mengirim parameter data
				data:JSON.stringify(dataForm),
				// mime type 
				contentType: 'application/json',
				success : function(result){
					//menutup modal
					$("#modal-evander").modal('hide');
					// panggil method load data, untuk melihat data terbaru
					loadData();
				}
			});
		console.log(dataForm);
	}
}

function getData(dataId){
	var d = new Date($.now());
	// panggil API
	$.ajax({
		// url ke api/product/
		url:'${contextName}/api/supplier/'+dataId,
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
			$('#modal-data').find('#createdOn').val(dataApi.createdOn);
			$('#modal-data').find('#active').val(dataApi.active);
			
			loadProvince($("#modal-data"), dataApi.provinceId);
			loadRegion($("#modal-data"), dataApi.regionId, dataApi.provinceId);
			loadDistrict($("#modal-data"), dataApi.districtId, dataApi.regionId);
			
			$('#modal-data').find("#modifiedOn").val(d.getDate() + "-" + (d.getMonth()+1) + "-"
					+ d.getFullYear() + " " + d.getHours()
					+ ":" + d.getMinutes() + ":"
					+ d.getSeconds());
			console.log(dataApi);
		}
	});
}

$('#list-supplier').on('click','.btn-edit', function(){
	var sid = $(this).val();
	$.ajax({
		url:'${contextName}/supplier/edit/',
		type:'get',
		dataType:'html',
		success : function(result){
			//mengganti judul modal
			$("#modal-title").html("Supplier Detail");
			//mengisi content dengan variable result
			$("#modal-data").html(result);
			//menampilkan modal pop up
			$("#modal-evander").modal('show');
			// panggil method getData

			getData(sid);
		}
	});
});

// method untuk delete data
function editData($form){
	var dataForm = getFormData($form);
	var name = $('#modal-data').find("#name").val();
	var province = $('#modal-data').find("#provinceId").val();
	var region = $('#modal-data').find("#regionId").val();
	var district = $('#modal-data').find("#districtId").val();
	var postalCode = $('#modal-data').find("#postalCode").val();
	var email = $('#modal-data').find("#email").val();
	var cekEmail = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	var len1 = name.length;
	var len2 = province.length;
	var len3 = region.length;
	var len4 = district.length;
	var len5 = postalCode.length;
	
	if(len1 < 1) {
		alert("Kolom Nama tidak boleh kosong!");
	} else if (len2 < 1){
		alert("Pilih Provinsi terlebih dahulu!");
	} else if (len3 < 1){
		alert("Pilih Region terlebih dahulu!");
	} else if (len4 < 1){
		alert("Pilih District terlebih dahulu!");
	} else if (len5 < 1){
		alert("Kolom Postal Code tidak boleh kosong!");
	} else if (!cekEmail.test(email)){
		alert("Format Email salah!");
	} else {
		var dataForm = getFormData($form);
		$.ajax({
			// url ke api/packages/
			url:'${contextName}/api/supplier/',
			type:'put',
			// data type berupa JSON
			dataType:'json',
			// mengirim parameter data
			data:JSON.stringify(dataForm),
			// mime type 
			contentType: 'application/json',
			success : function(result){
				//menutup modal
				$("#modal-evander").modal('hide');
				// panggil method load data, untuk melihat data terbaru
				loadData();
			}
		});
	}
	console.log(dataForm);
}
	
</script>