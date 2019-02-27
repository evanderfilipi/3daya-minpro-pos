<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%	request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<!-- Form Mulai -->
<form id="form-additem" class="form-horizontal">	
	<div class="form-group">
		<label class="control-label col-md-3">Add Transfer Item</label>
		<div class="col-md-8">
			<input type = "text" name = "search" id="search" placeholder="Item Name - Variant Name" onKeypress="getSearch();"/>
		</div>
	</div>
	
	<div>
		<table class="table">
			<thead>
				<tr>
					<th>Item</th>
					<th>In Stock</th>
					<th>Trans. Qty.</th>
				</tr>
			</thead>
			<tbody id="list-additem">
			</tbody>
		</table>
	</div>
	
	<div class="box-footer">
		<button type="button" class="btn btn-success btn-sm" onClick="addItem($('#form-additem'));">
			<i class="fa fa-plus"></i>Add
		</button>
		<button type="button" class="btn btn-warning btn-sm pull-right" data-dismiss="modal">
			<i class="fa fa-close"></i>Close
		</button>
	</div>
</form>
<!-- Form Selesai -->