
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setAttribute("contextName", request.getServletContext().getContextPath());
%>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Purchase Request</h3>
		<br><br>
		<div class="box-tools"><br><br>	
			<button type="button" id="export" class="btn btn-primary">Export</button>
			<button type="button" id="btn-add" class="btn btn-primary">Create</button>
		</div>
	<div class="col-md-2">
		<input type="date" class="form-control" id="tanggalAwal"
			placeholder="yyyy-MM-dd" />
	</div>
	<div class="col-md-2">
		<input type="date" class="form-control" id="tanggalAkhir"
			placeholder="yyyy-MM-dd" />
	</div>
	<div class="col-md-2">
		<select id="status" class="form-control">
			<option value="">Status</option>
			<option value="Approved">Approved</option>
			<option value="Rejected">Rejected</option>
			<option value="Process">Process</option>
		</select>
	</div>
	<div class="col-md-2">
		<input type="text" class="form-control" id="searchPrNo"
			placeholder="Search PR Number" />
	</div>
	<div class="col-md-1">
		<button type="button" class="btn btn-primary" id="btn-cek">
			<i class="fa fa-search"></i>
		</button>
	</div>
</div>
<br>
<div class="box-body">
	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th>Create Date</th>
				<th>PR No</th>
				<th>Note</th>
				<th>Status</th>
				<th>#</th>
			</tr>
		</thead>
		<tbody id="list-pr">
		</tbody>
	</table>
</div>
</div>

<div class="modal" id="modal-pr">
	<div class="modal-dialog-lg">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title" id="modal-title">Form Input</h3>
			</div>
			<div class="box-body" id="modal-data"></div>
		</div>
	</div>
</div>

<div class="modal" id="modal-item">
	<div class="modal-dialog">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title" id="modal-title2">Form Input</h3>
			</div>
			<div class="box-body" id="modal-data2"></div>
		</div>
	</div>
</div>

<script>
	//method yang pertama di panggil saat page di load
	$(function() {
		// memanggil method load data
		loadData();
	});
	
	$('#btn-cek').click(function(){
		var tgl1 = $("#tanggalAwal").val();
		var tgl2 = $("#tanggalAkhir").val();
		var status = $("#status").val();
		var prNo = $("#searchPrNo").val();
		var v1 = tgl1.length;
		var v2 = tgl2.length;
		var v3 = status.length;
		var v4 = prNo.length;
		
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
				url :'${contextName}/api/pr/search/'+tgl1+'/'+tgl2+'/'+status+'/'+prNo,
				tipe :'get',
				dataType :'json',
				success : function(result){
					$("#list-po").empty();
					$.each(result, function(index, item){
						var dataRows ='<tr>'+
							'<td>'+ item.modifiedOn +'</td>'+
							'<td>'+ item.prNo+'</td>'+
							'<td>'+ item.notes+'</td>'+
							'<td>'+ item.status+'</td>'+
							'<td class="col-md-1">'+
							'<button type="button" class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i> Edit</button> '+
							'<button type="button" class="btn btn-view btn-info btn-xs" value="'+ item.id +'"><i class="fa fa-eye"></i> View</button> '+
							'</td>'+
							'</tr>';
						$("#list-pr").append(dataRows);
					});
					console.log(result);
				}
			});
		}
	});
	
	/*$(function() {
		$("#fromperiod").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			numberOfMonths : 1,
			onClose : function(selectedDate) {
				$("#toperiod").datepicker("option", "minDate", selectedDate);
			}
		});
		$("#toperiod").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			numberOfMonths : 1,
			onClose : function(selectedDate) {
				$("#fromperiod").datepicker("option", "maxDate", selectedDate);
			}
		});
	});
	*/
	function loadData() {
		$
				.ajax({
					// url ke api/employee/
					url : '${contextName}/api/pr/',
					type : 'get',
					// data typenya berupa JSON
					dataType : 'json',
					success : function(result) {
						//kosong data di table
						$("#list-pr").empty();
						// looping data dengan jQuery
						$.each(result,function(index, item) {
							var dataRow = '<tr>'+ 
							'<td>'+ item.createdOn + '</td>'+
							'<td>'+ item.prNo+ '</td>'+
							'<td>'+ item.notes+ '</td>'+
							'<td>'+ item.status+ '</td>'+
							'<td class="col-md-1">'+ 
							'<button type="button" class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i>Edit</button> '+ 
							'<button type="button" class="btn btn-delete btn-info btn-xs" value="'+ item.id +'"><i class="fa fa-eye"></i> View</button> '+
							'</td>' + 
							'</tr>';
							$("#list-pr").append(dataRow);
						});
						// menampilkan data ke console => F12
						console.log(result);
					}
				});
	}

	$("#btn-add").click(
			function() {
				$.ajax({
					url : '${contextName}/pr/create',
					type : 'get',
					dataType : 'html',
					success : function(result) {
						var d = new Date($.now());
						//mengganti judul modal
						$("#modal-title").html("PURCHASE REQUEST");
						//mengisi content dengan variable result
						$("#modal-data").html(result);
						//menampilkan modal pop up
						$("#modal-pr").modal('show');
						$('#modal-data').find("#createdOn").val(d.getDate() + "-" + (d.getMonth() + 1) + "-"
										+ d.getFullYear() + " " + d.getHours()
										+ ":" + d.getMinutes() + ":"
										+ d.getSeconds());
					}
				});
			});
</script>