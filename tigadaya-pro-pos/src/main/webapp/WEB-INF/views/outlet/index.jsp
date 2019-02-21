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
		<input type = "text" name = "search" id="search" placeholder="Search">
		<div class="box-tools">
			<button type="button" id="btn-add" class="btn btn-primary btn-sm pull-right"><i class="fa fa-plus"></i> Create</button>
		</div>
		<!-- button type="button" id = "btn-add" class="btn btn-primary btn-xs pull-right"><i class="fa fa-plus"> Create</i></button-->
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
</script>