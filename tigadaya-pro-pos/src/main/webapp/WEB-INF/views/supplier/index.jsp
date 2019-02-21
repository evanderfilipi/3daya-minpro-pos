<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Suppliers</h3>
		<br/><br/>
		<!-- <a href="packages/create" class="btn btn-success pull-right"><i class="fa fa-plus-square"></i> Add</a> -->
		<div class="col-md-3">
		<input type="text" class="form-control" name="search" placeholder="Search"/>
		</div>
		<button type="button" class="btn btn-success pull-right" id="btn-add">
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
			<tbody id="list-data">
				
			</tbody>
		</table>
	</div>
</div>

<div class="modal" id="modal-evander">
	<div class="modal-dialog">
		<div class="box box-success">
			<div class="box-header">
				<h3 class="box-title">Modal Form</h3>
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
			$("#list-data").empty();
			// looping data dengan jQuery
			$.each(result, function(index, item){
				var dataRow ='<tr>'+
					'<td>'+ item.name +'</td>'+
					'<td>'+ item.address+'</td>'+
					'<td>'+ item.phone+'</td>'+
					'<td>'+ item.email+'</td>'+
					'<td class="col-md-1">'+
						'<button type="button" class="btn btn-detail btn-info btn-xs" value="'+ item.id +'"><i class="fa fa-eye"></i> Edit</button> '+
					'</td>'+
					'</tr>';
				$("#list-data").append(dataRow);
			});
			// menampilkan data ke console => F12
			console.log(result);
		}
	});
}
	
</script>