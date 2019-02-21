
<%
	request.setAttribute("contextName", request.getServletContext().getContextPath());
%>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Category</h3>
	</div>
	<div class="box-body">
		<input type="text" name="Search" id="Search" placeholder="Search">
		<button type="button" id="btn-add" class="btn btn-primary btn xs pull-right"><i class="fa fa-plus"></i>  Create</button>
			<table class="table">
			<thead>
				<tr>
					<th>Category Name</th>
					<th>Item Stocks</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody id="list-category">
			</tbody>
		</table>
	</div>
</div>

<div class="modal" id="modal-form">
	<div class="modal-dialog">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title" id="modal-title">Form Input Category</h3>
			</div>
			<div class="box-body" id="modal-data"></div>
		</div>
	</div>
</div>


<script>
	// method yang pertama kali dipanggil saat page di load
	$(function() {
		// memanggil method loadData;
		loadData();
	});

	function loadData() {
		$.ajax({
					// url ke api/category/
					url : '${contextName}/api/category/',
					type : 'get',
					// data type berupa JSON
					dataType : 'json',
					success : function(result) {
						//kosong data di table
						$("#list-category").empty();
						// looping data dengan jQuery
						$
								.each(
										result,
										function(index, item) {
											var dataRow = '<tr>'
													+ '<td>'+ item.name +'</td>'+
													'<td>'+ item.id+'</td>'+
													'<td class="col-md-1">'+
														'<button type="button" class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i></button> '+ '</td>' + '</tr>';
											$("#list-category").append(dataRow);
										});
						// menampilkan data ke console => F12
						console.log(result);
					}
				});
	}
</script>