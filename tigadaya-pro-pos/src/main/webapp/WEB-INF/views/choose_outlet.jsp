<% request.setAttribute("contextName", request.getServletContext().getContextPath()); %>

<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Choose Outlet First</h3>
		<br/><br/>
		<div class="col-md-3">
			<select id="cOutlet" class="form-control">
				<option value="">-Choose Outlet-</option>
			</select>
		</div>
		<div class="col-md-3">
			<button type="button" class="btn btn-success" id="outletBtn">Choose</button>
		</div>
	</div>
</div>

<script>
$(function() {
	loadOutlet();
});

function loadOutlet(){
	$.ajax({	
		url:'${contextName}/api/outlet/',
		type:'get',
		// data type berupa JSON
		dataType:'json',
		success : function(result){
			// empty data first
			$("#cOutlet").empty();
			$("#cOutlet").append('<option value="">-Choose Outlet-</option>');
			// looping data
			$.each(result, function(index, outlet){
				$("#cOutlet").append('<option value="'+ outlet.id +'">'+ outlet.name +'</option>');
			});
		}
	});
}
</script>