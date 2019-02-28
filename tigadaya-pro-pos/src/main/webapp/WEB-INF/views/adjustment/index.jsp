<% request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Adjustment</h3>
	</div>
		
		<div class="box-body">
		<div class="box-tools" style="margin-top: -10px">
			<input type="date"  id="txt-search" placeholder="Tanggal" onKeypress="cari($(this).val());"/>	

			<button type="button" id="btn-add" class="btn btn-primary  pull-right" style="margin-right: 10px">Create</button>
				
		</div>
	</div>
	<div class="box-body">
		<table class="table">
			<thead>
				<tr>
					<th>Adjustment Date</th>
					<th>Notes</th>
					<th>Status</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody id="list-data">
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
	// method yang pertama kali dipanggil saat page di load
	$(function(){
		// memanggil method loadData;
		loadData();
	});
	
	//ketika button add di click
	$("#btn-add").click(function(){
		$.ajax({
			url:'${contextName}/adjustment/create',
			type:'get',
			dataType:'html',
			success : function(result){
				//mengganti judul modal
				$("#modal-title").html("Add New Adjustment");
				//mengisi content dengan variable result
				$("#modal-data").html(result);
				//menampilkan modal pop up
				$("#modal-form").modal('show');
			}
		});
	});
	
	//method loadData
	function loadData(){
		$.ajax({
			// url ke api/category/
			url:'${contextName}/api/adjustment/',
			type:'get',
			// data type berupa JSON
			dataType:'json',
			success : function(result){
				//kosong data di table
				$("#list-data").empty();
				// looping data dengan jQuery
				$.each(result, function(index, item){
						var dataRow ='<tr>'+
							'<td>'+ item.createdOn +'</td>'+
							'<td>'+ item.notes+'</td>'+
							'<td>'+ item.status+'</td>'+
							'<td class="col-md-1">'+
								'<button type="button" class="btn btn-edit" value="'+ item.id +'"> <u>View</u> </button> '+
							'</td>'+
							'</tr>';
						$("#list-data").append(dataRow);
				});
				// menampilkan data ke console => F12
				console.log(result);
			}
		});
	}
	
	
	function getDateToday() {
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1; //January is 0!
		var yyyy = today.getFullYear();
		if(dd<10) { dd = '0'+dd } 
		if(mm<10) { mm = '0'+mm } 
		return yyyy + '-' + mm + '-' + dd;
	}
	
	// method untuk add data
	function addData($form){
		// memangil method getFormData dari file
		// resources/dist/js/map-form-objet.js
		var vnote = $($form).find("#notes").val();
		var voutletId = $($form).find("#outletId").val();
		var vStatus = $($form).find("#status").val();
		//var dataForm = getFormData($form);
		$.ajax({
			// url ke api/category/
			url:'${contextName}/api/adjustment/',
			type:'post',
			// data type berupa JSON
			dataType:'json',
			// mengirim parameter data
			data:'{"notes":"'+vnote+'","outletId":'+voutletId+',"status":"'+vStatus+'","createdOn":"'+getDateToday()+'"}',
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
	
	// function get data 
	function getData(dataId){
		// panggil API
		$.ajax({
			// url ke api/category/
			url:'${contextName}/api/adjustment/'+dataId,
			type:'get',
			// data type berupa JSON
			dataType:'json',
			success : function(dataApi){
				$('#modal-data').find('#name').val(dataApi.name);
				$('#modal-data').find('#id').val(dataApi.id);
				console.log(dataApi);
			}
		});
	}
	
	
	// ketidak btn-edit di click
	$('#list-data').on('click','.btn-edit', function(){
		var vid = $(this).val();
		$.ajax({
			url:'${contextName}/adjustment/edit',
			type:'get',
			dataType:'html',
			success : function(result){
				//mengganti judul modal
				$("#modal-title").html("Edit Data Adjustment");
				//mengisi content dengan variable result
				$("#modal-data").html(result);
				//menampilkan modal pop up
				$("#modal-form").modal('show');
				// panggil method getData
				getData(vid);
			}
		});
	});
	
	// method untuk edit data
	function editData($form){
		// memangil method getFormData dari file
		// resources/dist/js/map-form-objet.js
		var dataForm = getFormData($form);
		$.ajax({
			// url ke api/category/
			url:'${contextName}/api/adjustment/',
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
	
	// ketidak btn-detail di click
	$('#list-data').on('click','.btn-detail', function(){
		var vid = $(this).val();
		$.ajax({
			url:'${contextName}/adjustment/detail',
			type:'get',
			dataType:'html',
			success : function(result){
				//mengganti judul modal
				$("#modal-title").html("Detail Data Adjustment");
				//mengisi content dengan variable result
				$("#modal-data").html(result);
				//menampilkan modal pop up
				$("#modal-form").modal('show');
				//panggil method
				getData(vid);
			}
		});
	});
	
	// ketidak btn-delete di click
	$('#list-data').on('click','.btn-delete', function(){
		var vid = $(this).val();
		$.ajax({
			url:'${contextName}/adjustment/delete',
			type:'get',
			dataType:'html',
			success : function(result){
				//mengganti judul modal
				$("#modal-title").html("Delete Data Adjustment");
				//mengisi content dengan variable result
				$("#modal-data").html(result);
				//menampilkan modal pop up
				$("#modal-form").modal('show');
				//panggil method
				getData(vid);
			}
		});
	});
	
	// method untuk delete data
	function deleteData($form){
		// memangil method getFormData dari file
		var vid = $($form).find("#id").val();
		var vname = $($form).find("#name").val();
		$.ajax({
			// url ke api/category/
			url:'${contextName}/api/adjustment/',
			// method http di controller
			type:'put',
			// data type berupa JSON
			dataType:'json',
			// mengirim parameter data
			data: '{"id":' + vid + ',"name":"' + vname +'","active": false }',
			// mime type 
			contentType: 'application/json',
			success : function(result){
				//menutup modal
				$("#modal-form").modal('hide');
				// panggil method load data, untuk melihat data terbaru
				
				loadData();
				console.log(result);
				
			}
		});
	}
</script>	