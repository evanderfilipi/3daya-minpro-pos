<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form id="form-edit" class="form-horizontal">
	<!-- id -->
	<input type="hidden" name="id" id="id" />
	
	<div class="col-md-12" style="border-top: 0px">
	
		<div class="form-group">
			<div class="col-md-12">
				<label>EDIT NEW PO: Outlet Login</label> <hr style="margin: 0">	
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<label>Choose Supplier</label>
				<select name="regionId" id="regionId" class="form-control" onChange="getDistrictById($(this).val());">
						<option value="">-Supplier-</option>
						<c:forEach var="sup" items="${supl}">
       						<option value="${sup.id}" ${pom.supplierId==sup.id ? "selected='selected'":""}>${sup.name}</option>
       					</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<label>Notes</label>
				<textarea rows="4" cols="63" name="notes" placeholder="Notes" id="notes" style="padding: 10px">${pom.notes}</textarea>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<label>Purchase Order</label> <hr style="margin: 0">	
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<table class="table table-bordered" id="table-item">
					<tr>
						<th width="28%">Item</th>
						<th width="15%">In Stock</th>
						<th width="10%">Qty</th>
						<th width="24%">Unit Cost</th>
						<th>Sub Total</th>
					</tr>
					<c:forEach var="data" items="${pod}">
						<tr>
							<td><input type="text" class="form-control" placeholder="Item - Variant"  value="${data.variant.itemMod.name} - ${data.variant.name}" /></td>
							<td><input type="text" class="form-control" readonly placeholder="In Stock"  value="${data.variant.varInventory.beginning}" /></td>
							<td><input type="text" class="form-control qty" readonly placeholder="Qty" value="${data.requestQty}" /></td>
							<td><input type="text" class="form-control unitCost" onKeypress="sumUnitCost();" placeholder="Unit Cost" value="${data.unitCost}" /></td>
							<td><input type="text" class="form-control subTo" placeholder="Sub Total" value="${data.subTotal}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
		<div class="form-inline">
			<label>TOTAL</label>
			<label id="total2" class="pull-right"></label>
		</div>
		<hr/>
	
	<div class="modal-footer">
		
		<button type="button" class="btn btn-success" onClick="editData($('#form-edit'))">Submit</button>
		<button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
		<button type="button" class="btn btn-primary" onClick="editData($('#form-edit'))">Save</button>
	</div>
	</div>
</form>

<script>
function sumUnitCost(){
	
	$('tr').each(function () {
        var sum = 0;
        var v1 = $('.qty', this).val();
        var v2 = $('.unitCost', this).val();
        sum = parseInt(v1) * parseInt(v2);
        $('.subTo', this).val(sum);
    });
	
	sumSubTotal();
}

function sumSubTotal(){
	/*var cls = document.getElementById("table-item").getElementsByTagName("label");
	var sum2 = 0;
	for (var i = 0; i < cls.length; i++){
		if(cls[i].className == "form-control subTo"){
	        sum2 += parseInt(cls[i].innerHTML);
	    }
	}
	document.getElementById('total').innerHTML = 'Rp. '+sum2;
	console.log(sum2);*/
	var sum2 = 0;
	$('tr').each(function () {
        //the value of sum needs to be reset for each row, so it has to be set inside the row loop
        //find the combat elements in the current row and sum it 
        $(this).find('.subTo').each(function () {
            var combat = $(this).val();
                sum2 += parseInt(combat);
        });
        //set the value of currents rows sum to the total-combat element in the current row
    });
	document.getElementById('total2').innerHTML = 'Rp. '+sum2;
}
</script>