
<%	request.setAttribute("contextName", request.getServletContext().getContextPath());%>
<style type="text/css">
.margin {
	margin: 10px 10px 10px 10px;
	border: 1px solid #000;
}
</style>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Purchase Request ${username}</h3>
		<div class="box-tools">
			<button type="button" id="export" class="btn btn-primary">Export</button>

			<button type="button" id="btn-add" class="btn btn-primary">Create</button>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-4">
		<div class='picker'>
			<label for="fromperiod">From</label> <input type="text"
				id="fromperiod" name="from"> <label for="toperiod">to</label>
				<input type="text" id="toperiod" name="to">
				</div>
			</div>
			
			<div class="col-md-2">
						<select name="title">
							<option value="">Status</option>
							<option value="created">Created</option>
							<option value="submited">Submited</option>
							<option value="rejected">Rejected</option>
						</select>
				</div>
		
		<div class="col-md-2">
			
				<input type="text" name="search" id="search" placeholder="Search"
					onKeypress="getSearch();">
			</div>
		</div>
			</div>
	<div class="box-body">
		<table class="table" border="1">
			<thead>
				<tr>
					<th>Create Date</th>
					<th>PR No</th>
					<th>Note</th>
					<th>Status</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody id="list-data">
			</tbody>
		</table>
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

	$(function() {
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

	function loadData(){
		$.ajax({
			// url ke api/employee/
			url:'${contextName}/api/purchaserequest/',
			type:'get',
			// data typenya berupa JSON
			dataType:'json',
			success : function(result){
				//kosong data di table
				$("#list-data").empty();
				// looping data dengan jQuery
				$.each(result, function(index, item){
					var dataRow ='<tr>'+
						'<td>'+ item.createdOn +'</td>'+
						'<td>'+ item.prNo +'</td>'+
						'<td>'+ item.notes +'</td>'+
						'<td>'+ item.status +'</td>'+
						'<td class="col-md-1">'+
							'<button type="button" class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'">Edit</button> '+
							'<button type="button" class="btn btn-delete btn-warning btn-xs" value="'+ item.id +'">View</button> '+
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
			url:'${contextName}/purchaseRequest/create',
			type:'get',
			dataType:'html',
			success : function(result){
				var d = new Date($.now());
				//mengganti judul modal
				$("#modal-title").html("PURCHASE REQUEST");
				//mengisi content dengan variable result
				$("#modal-data").html(result);
				//menampilkan modal pop up
				$("#modal-pr").modal('show');
				$('#modal-data').find("#createdOn").val(d.getDate() + "-" + (d.getMonth()+1) + "-"
						+ d.getFullYear() + " " + d.getHours()
						+ ":" + d.getMinutes() + ":"
						+ d.getSeconds());
			}
		});
	});

	
</script>