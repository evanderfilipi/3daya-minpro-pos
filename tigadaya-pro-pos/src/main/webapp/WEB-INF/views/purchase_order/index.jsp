<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Purchase Order ${username}</h3>
		<br/><br/>
		<!-- <a href="packages/create" class="btn btn-success pull-right"><i class="fa fa-plus-square"></i> Add</a> -->
		<form class="form-inline">
		<div class="picker col-md-4">
			<label for="fromperiod">From</label>
			<input type="text" data-date-format="dd-mm-yyyy" id="tanggalAwal" class="form-control" name="from">
			<label for="toperiod">to</label>
			<input type="text" data-date-format="dd-mm-yyyy" id="tanggalAkhir" class="form-control" name="to">
		</div>
		</form>
		<div class="col-md-2">
			<select id="status" class="form-control">
				<option value="">Status</option>
				<option value="Approved">Approved</option>
				<option value="Rejected">Rejected</option>
				<option value="Processed">Process</option>
			</select>
		</div>
		<div class="col-md-2">
			<input type="text" class="form-control" id="searchPoNo" placeholder="Search PO Number"/>
		</div>
		<div class="col-md-1">
		<button type="button" class="btn btn-primary" id="btn-cek">
			<i class="fa fa-search"></i>
		</button>
		</div>
	</div>
	<div class="box-body">
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Create Date</th>
					<th>Supplier</th>
					<th>PO No.</th>
					<th>Total</th>
					<th>Status</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody id="list-po">
				
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

$(function() {
	$("#tanggalAwal").datepicker({
		defaultDate : "+1w",
		changeMonth : true,
		numberOfMonths : 1,
		onClose : function(selectedDate) {
			$("#tanggalAwal").datepicker("option", "minDate", selectedDate);
		}
	});
	$("#tanggalAkhir").datepicker({
		defaultDate : "+1w",
		changeMonth : true,
		numberOfMonths : 1,
		onClose : function(selectedDate) {
			$("#tanggalAkhir").datepicker("option", "maxDate", selectedDate);
		}
	});
});

$('#btn-cek').click(function(){
	var tgl1 = $("#tanggalAwal").val();
	var tgl2 = $("#tanggalAkhir").val();
	var status = $("#status").val();
	var poNo = $("#searchPoNo").val();
	var v1 = tgl1.length;
	var v2 = tgl2.length;
	var v3 = status.length;
	var v4 = poNo.length;
	
	if (v1 < 1){
		alert("Kolom tanggal awal tidak boleh kosong!")
	} else if (v2 < 1){
		alert("Kolom tanggal akhir tidak boleh kosong!")
	} else if (v3 < 1){
		alert("Pilih status terlebih dahulu!")
	} else if (v4 < 1){
		alert("Kolom search PO Number tidak boleh kosong!")
	} else {
		$.ajax({
			url :'${contextName}/api/po/search/'+tgl1+'/'+tgl2+'/'+status+'/'+poNo,
			tipe :'get',
			dataType :'json',
			success : function(result){
				$("#list-po").empty();
				$.each(result, function(index, item){
					var dataRows ='<tr>'+
						'<td>'+ item.createdOn +'</td>'+
						'<td>'+ item.supplier.name+'</td>'+
						'<td>'+ item.poNo+'</td>'+
						'<td>'+ item.grandTotal+'</td>'+
						'<td>'+ item.status+'</td>'+
						'<td class="col-md-1">'+
						'<button type="button" class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i> Edit</button> '+
						'<button type="button" class="btn btn-view btn-info btn-xs" value="'+ item.id +'"><i class="fa fa-eye"></i> View</button> '+
						'</td>'+
						'</tr>';
					$("#list-po").append(dataRows);
				});
				console.log(result);
			}
		});
	}
});

//method loadData
function loadData(){
	$.ajax({
		// url ke api/po/
		url:'${contextName}/api/po/',
		type:'get',
		// data type berupa JSON
		dataType:'json',
		success : function(result){
			//kosong data di table
			$("#list-po").empty();
			// looping data dengan jQuery
			$.each(result, function(index, item){
				var dataRow ='<tr>'+
					'<td>'+ item.createdOn +'</td>'+
					'<td>'+ item.supplier.name+'</td>'+
					'<td>'+ item.poNo+'</td>'+
					'<td>'+ item.grandTotal+'</td>'+
					'<td>'+ item.status+'</td>'+
					'<td class="col-md-1">'+
						'<button type="button" class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i> Edit</button> '+
						'<button type="button" class="btn btn-view btn-info btn-xs" value="'+ item.id +'"><i class="fa fa-eye"></i> View</button> '+
					'</td>'+
					'</tr>';
				$("#list-po").append(dataRow);
			});
			// menampilkan data ke console => F12
			console.log(result);
		}
	});
}

$('#list-po').on('click','.btn-edit', function(){
	var sid = $(this).val();
	$.ajax({
		url:'${contextName}/po/edit/',
		type:'get',
		dataType:'html',
		success : function(result){
			//mengganti judul modal
			$("#modal-title").html("Purchase Order");
			//mengisi content dengan variable result
			$("#modal-data").html(result);
			//menampilkan modal pop up
			$("#modal-evander").modal('show');
			// panggil method getData				
			
			// getData(sid);
		}
	});
});

$('#list-po').on('click','.btn-view', function(){
	var poId = $(this).val();
	$.ajax({
		url:'${contextName}/po/view?id='+poId,
		type:'get',
		dataType:'html',
		success : function(result){
			//mengganti judul modal
			$("#modal-title").html("Purchase Order Detail");
			//mengisi content dengan variable result
			$("#modal-data").html(result);
			//menampilkan modal pop up
			$("#modal-evander").modal('show');
			
			loadPo(poId);
		}
	});
});

function loadPo(po_id){
	$.ajax({
		// url ke api/purchase order/
		url:'${contextName}/api/po/'+po_id,
		type:'get',
		// data type berupa JSON
		dataType:'json',
		success : function(dataPo){
			var d = new Date($.now());
			var supId = dataPo.supplierId;
			var outId = dataPo.outletId;
			var pn = dataPo.poNo;
			var stat = dataPo.status;
			loadSupplier(supId);
			loadOutlet(outId, pn, stat);
			loadPoHistory(po_id);
			
			$('#modal-data').find('#notes-sup').val(dataPo.notes);
			
			// transfer value ke form input PO
			$('#modal-data').find('#notes-sup').val(dataPo.notes);
			$('#modal-data').find('#v1').val(dataPo.id);
			$('#modal-data').find('#v2').val(dataPo.prId);
			$('#modal-data').find('#v3').val(dataPo.outletId);
			$('#modal-data').find('#v4').val(dataPo.supplierId);
			$('#modal-data').find('#v5').val(dataPo.poNo);
			$('#modal-data').find('#v6').val(dataPo.notes);
			$('#modal-data').find('#v7').val(dataPo.grandTotal);
			$('#modal-data').find('#v8').val(dataPo.createdBy);
			$('#modal-data').find('#v9').val(dataPo.createdOn);
			
			// transfer value ke form input PO History
			$('#modal-data').find('#poHisId').val(dataPo.id);
			
			// transfer value time today ke modal				
			$('#modal-data').find("#createdOn-PoHis").val(d.getDate() + "-" + (d.getMonth()+1) + "-"
					+ d.getFullYear() + " " + d.getHours()
					+ ":" + d.getMinutes() + ":"
					+ d.getSeconds());
			$('#modal-data').find("#modifiedOn-Po").val(d.getDate() + "-" + (d.getMonth()+1) + "-"
					+ d.getFullYear() + " " + d.getHours()
					+ ":" + d.getMinutes() + ":"
					+ d.getSeconds());
			
			/*var total = parseInt($('#total').val());
			var subTotal = parseInt($('#sub-total').val());
			// 2. total lama ditambah subtotal
			total = total+subTotal;
			// 3. kirim nilai total yang terakhir ke id totalAmount
			$('#total').val(total);*/
			
		}
	
	});
}

function loadPoHistory(poId){
	$.ajax({
		// url ke api/pohistory/
		url:'${contextName}/api/pohistory/id/'+poId,
		type:'get',
		// data type berupa JSON
		dataType:'json',
		success : function(result){
			//kosong data di table
			$("#historyPo").empty();
			// looping data dengan jQuery
			$.each(result, function(index, item){
				var dataRow ='<tr>'+
					'<td> On '+ item.createdOn +' - '+ item.pOrder.poNo +' is '+ item.status+'</td>'+
					'</td>'+
					'</tr>';
				$("#historyPo").append(dataRow);
			});
			// menampilkan data ke console => F12
			console.log(result);
		}
	});
}

function loadSupplier(sId){
	
	$.ajax({
		// url ke api/supplier/
		url:'${contextName}/api/supplier/'+sId,
		type:'get',
		// data type berupa JSON
		dataType:'json',
		success : function(dataApi){
			$("#supplier").empty();
			
			var dataRow ='<tr>'+
				'<td> '+dataApi.phone+' </td>'+
				'<td colspan="2"> '+dataApi.email+' </td>'+
				'</tr> <tr>'+
				'<td colspan="3"> '+dataApi.address+' </td>'+
				'</tr> <tr>'+
				'<td> '+dataApi.province.name+' </td>'+
				'<td> '+dataApi.region.name+' </td>'+
				'<td> '+dataApi.postalCode+' </td>'+
				'</tr>';
			$("#supplier").append(dataRow);
			$('#modal-data').find('#name-sup').val(dataApi.name);
			
			console.log(dataApi);
		}
	});
}

function loadOutlet(oId, poNo, stat){
	
	$.ajax({
		// url ke api/outlet/
		url:'${contextName}/api/outlet/'+oId,
		type:'get',
		// data type berupa JSON
		dataType:'json',
		success : function(dataApi){
			$("#outlet").empty();
			
			var dataRow ='<tr>'+
				'<td><p>PO Number : '+poNo+' </p></td>'+
				'</tr> <tr>'+
				'<td><p>Created By : Evander Filipi</p></td>'+
				'</tr> <tr>'+
				'<td><p>Email : '+dataApi.email+' </p></td>'+
				'</tr> <tr>'+
				'<td><p>Outlet : '+dataApi.name+' </p></td>'+
				'</tr> <tr>'+
				'<td><p>Phone : '+dataApi.phone+' </p></td>'+
				'</tr> <tr>'+
				'<td><p>Address : '+dataApi.address+' </p></td>'+
				'</tr> <tr>'+
				'<td><p>Status : '+stat+' </p></td>'+
				'</tr>';
			$("#outlet").append(dataRow);
			$('#modal-data').find('#name-sup').val(dataApi.name);
			
			console.log(dataApi);
		}
	});
}

function updateStatus($poForm){
	var dataForm = getFormData($poForm);
	var cekStatus = $('#modal-data').find("#status").val();
	if (cekStatus != ""){
		$.ajax({
			// url ke api/po/
			url:'${contextName}/api/po/',
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
	} else {
		$("#modal-evander").modal('hide');
	}
}


// function untuk merubah input-text status secara berkala ketika combobox status di modal-form berubah
function transValue(getStatus){
	$('#modal-data').find('#poStatus').val(getStatus);
	$('#modal-data').find('#poHisStatus').val(getStatus);
}

function insertPoHis($poHisForm){
	var dataForm = getFormData($poHisForm);
	var cekStatus = $('#modal-data').find("#status").val();
	if (cekStatus != ""){
		$.ajax({
			// url ke api/po_history/
			url:'${contextName}/api/pohistory/',
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
			}
		});
	} else {
		$("#modal-evander").modal('hide');
	}
}
</script>