<%	request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Form Mulai -->
<form id="form-create" class="form-horizontal">
<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">New Item</h3>
	</div>	
	<div class="box-body">
		<div class="col-md-12">
			<div class="col-md-2">Image</div>
			
			<div class="col-md-10">
				<div class="form-group">
					<label>Name</label>
					<div>
						<input type="text" class="form-control" name="io[name]" id="name" />
					</div>
				</div>
				
				<div class="form-group">
					<label>Category</label>
					<div>
						<select name="io[categoryId]" id="categoryId" class="form-control">
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
		<button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
		<button type="button" onClick="addData($('#form-create'))" class="btn btn-primary pull-left">Simpan</button>
	</div>
</div>
</form>
<!-- Form Selesai -->