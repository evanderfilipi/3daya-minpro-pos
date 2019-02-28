<% request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Transfer Stock ${username}</h3>
		<!-- div class="box-tools">
			<button type="button" id="btn-add" class="btn btn-success btn-sm">
				<i class="fa fa-plus"></i>
			</button>
		</div-->
	</div>
	<div class="box-body">
		<select name = "toOutlet" id="toOutlet" onChange="getOutletById($(this).val());">
			<option value="">To Outlet</option>
		</select>
		<button type="button" id="btn-add" class="btn btn-primary btn-sm pull-right">
			<i class="fa fa-plus"></i> Create
		</button>
		<button type="button" id="btn-export" class="btn btn-primary btn-sm pull-right"> Export
		</button>
		<table class="table">
			<thead>
				<tr>
					<th>Transfer Date</th>
					<th>From Outlet</th>
					<th>To Outlet</th>
					<th>Status</th>					
					<th>#</th>
				</tr>
			</thead>
			<tbody id="list-ts">
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
		loadOutlet();
	});
	
	function loadData(){
		$.ajax({
			url:'${contextName}/api/ts/',
			type:'get',
			dataType:'json',
			success : function(result){
				$("#list-ts").empty();
				$.each(result, function(index, item){
					var dataRow ='<tr>'+
						'<td>'+ item.createdOn +'</td>'+
						'<td>'+ item.outletf.name+'</td>'+
						'<td>'+ item.outlet.name+'</td>'+
						'<td>'+ item.status+'</td>'+
						'<td class="col-md-1">'+
							'<button type="button" class="btn btn-edit btn-success btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i>View</button> '+
						'</td>'+
						'</tr>';
					$("#list-ts").append(dataRow);
				});
				// menampilkan data ke console => F12
				console.log(result);
			}
		});
	}
	
	function loadOutlet($form, $selected){
		$.ajax({
			url:'${contextName}/api/outlet/',
			type:'get',
			// data type berupa JSON
			dataType:'json',
			success : function(result){
				// empty data first
				$("#toOutlet").empty();
				$("#toOutlet").append('<option value="">To Outlet</option>');
				// looping data
				$.each(result, function(index, outlet){
					if($selected == outlet.id){
						$("#toOutlet").append('<option value="'+ outlet.id +'" selected="selected">'+ outlet.name +'</option>');
					} else {
						$("#toOutlet").append('<option value="'+ outlet.id +'">'+ outlet.name +'</option>');
					}
				});
			}
		});
	}
	
	function getOutletById(oId){
		$.ajax({
			url:'${contextName}/api/ts/'+oId,
			type:'get',
			dataType:'json',
			success:function(result){
				$("#list-ts").empty();
				$.each(result, function(index, item){
					var dataRow ='<tr>'+
						'<td>'+ item.createdOn +'</td>'+
						'<td>'+ item.outletf.name+'</td>'+
						'<td>'+ item.outlet.name+'</td>'+
						'<td>'+ item.status+'</td>'+
						'<td class="col-md-1">'+
							'<button type="button" class="btn btn-edit btn-success btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i>View</button> '+
						'</td>'+
						'</tr>';
					$("#list-ts").append(dataRow);
				});
				// menampilkan data ke console => F12
				console.log(result);
			}
		});
	}
	
	//ketika button add di click
	$("#btn-add").click(function(){
		$.ajax({
			url:'${contextName}/ts/create',
			type:'get',
			dataType:'html',
			success : function(result){
				//mengganti judul modal
				$("#modal-title").html("Transfer Stock");
				//mengisi content dengan variable result
				$("#modal-data").html(result);
				//menampilkan modal pop up
				$("#modal-form").modal('show');
				
				// call add outlet
				loadOutlet($("#modal-data"));
			}
		});
	});
	
	
</script>