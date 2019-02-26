<%	request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Form Mulai -->
<form id="form-edit" class="form-horizontal">
	<input type="hidden" name="id" id="id" />
<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">Edit Purchase Order</h3>
	</div>	
	<div class="box-body">
		<div class="col-md-12">
			<div class="col-md-2">Image</div>
			
			<div class="col-md-10">
				<div class="form-group">
					<label>Name</label>
					<div>
						<input type="text" class="form-control" name="name" id="name" />
					</div>
				</div>
				
				<div class="form-group">
					<label>Category</label>
					<div>
						<select name="categoryId" id="categoryId" class="form-control">
							<option value="">Category</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-md-12">
			<h3 class="col-md-2" style="margin: 0">VARIANT</h3>
			<button type="button" class="btn btn-primary pull-right" onClick="addVariant()" id="btn-add-variant"> Add Variant</button>
		</div>
	
		<table class="table table-stripped table-bordered">
			<thead>
				<tr>
					<th>Variant Name</th>
					<th>Unit Price</th>
					<th>SKU</th>
					<th>Beginning Stock</th>
					<th>Alert at</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody id="list-variant">
			</tbody>
		</table>
	</div>	
	<div class="box-footer">
		<button type="button" class="btn btn-success pull-left" onClick="editData($('#form-edit'))">update</button>
		<button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
	</div>
</div>
</form>
<!-- Form Selesai -->