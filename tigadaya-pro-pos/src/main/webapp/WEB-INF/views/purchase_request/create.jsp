<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setAttribute("contextName", request.getServletContext().getContextPath());
%>
<!-- form mulai -->
<form id="form-create" class="form-horizontal">
	<div class="form-group">
		<div class="col-md-12">
			<input type="text" class="form-control" name="prNo" id="prNo"
				value="${KodeBaru}" />
		</div>
	</div>
	<input type="text" id="createdOn" name="createdOn" />

	<div class="col-md-12" style="border-top: 0px">
		<div class="form-group">
			<div class="col-md-12">
				<h3>CREATE NEW PR : Outlet Login</h3>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-12">
				<h4>Target Waktu Item Ready</h4>
			</div>
		</div>

		<div class="form-group">
			<div class="col-md-12">
				<input type="date" class="form-control" name="name"
					placeholder="tanggal" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-md-12">
				<h4>Notes</h4>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-12">
				<textarea rows="7" cols="220" name="notes"></textarea>
			</div>
		</div>
		<div class="form-group">
			<h3 class="box-title col-md-8">Purchase Request</h3>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<table>
					<tr>
						<th width="25%">Item</th>
						<th width="15%">In Stock</th>
						<th width="10%">Request Qty</th>
					</tr>
					<c:forEach var="data" items="${pod}">
					<tr>
							<td><input type="text" class="form-control" name="item-variant" placeholder="-" value="${data.variant.itemMod.name} - ${data.variant.name}" id="name" /></td>
							<td><input type="text" class="form-control" name="stock" placeholder="-" readOnly value="${data.inventory.beginning}" /></td>
							<td><input type="text" class="form-control" name="qty" placeholder="-" readOnly value="${data.requestQty}" /></td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>

		<div class="form-group">
			<div class="col-md-12">
				<button type="button" class="btn btn-primary col-md-12" id="addItem">Add
					Item</button>
			</div>
		</div>
	</div>
	<div class="modal-footer">

		<button type="button" class="btn  btn-primary pull-right"
			data-dismiss="modal">Cancel</button>
		<button type="button" class="btn btn-save btn-primary pull-right">Save</button>
		<button type="button" class="btn btn-submit btn-success pull-right">Submit</button>
	</div>
</form>
<!-- Form Selesai -->


<script>
	$("#addItem").click(function() {
		$.ajax({
			url : '${contextName}/purchaserequest/additem',
			type : 'get',
			dataType : 'html',
			success : function(result) {
				//mengganti judul modal
				$("#modal-title2").html("Add Purchase Item");
				//mengisi content dengan variable result
				$("#modal-data2").html(result);
				//menampilkan modal pop up
				$("#modal-item").modal('show');

			}
		});
	});

	$(".btn-save").click(function() {
		alert("Test Function Button Save")
	});

	$(".btn-submit").click(function() {
		alert("Test Function Button Submit")
	});
</script>