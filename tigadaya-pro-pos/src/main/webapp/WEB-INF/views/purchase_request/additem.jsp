
<%
	request.setAttribute("contextName", request.getServletContext().getContextPath());
%>
<form id="form-create" class="form-horizontal">

	<div class="col-md-12" style="border-top: 0px">
		<div class="form-group">
			<div class="col-md-12">
				<input type="text" class="form-control" name="search"
					placeholder="Item Name - Variant Name" />
			</div>
		</div>
		<div class="box-body">
			<table class="table">
				<thead>
					<tr>
						<th>Item</th>
						<th>In Stock</th>
						<th>Request Qty.</th>

					</tr>
				</thead>
				<tbody id="list-data">
				</tbody>
			</table>
		</div>
		<div class="modal-footer">

			<button type="button" class="btn btn-primary pull-left"
				data-dismiss="modal">Cancel</button>
			<button type="button" class="btn btn-add btn-primary pull-right">Add</button>

		</div>
	</div>
</form>
<script>
$(".btn-add").click(function(){
	alert("Test Button Add")
});
</script>