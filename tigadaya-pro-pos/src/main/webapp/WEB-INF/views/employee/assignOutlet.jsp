
<%
	request.setAttribute("contextName", request.getServletContext().getContextPath());
%>
<form id="form-outlet" class="form-horizontal">
	<div class="panel panel-success">
		<div class="panel-heading"></div>
		<div class="panel-body">
			<table>
				<thead>
				</thead>
				<tbody id="tboutlet">
				
				</tbody>
			</table>
		</div>
	</div>
	<div class="panel-footer">
		<button type="button" onClick="assignOutlet($('#form-outlet'))"
			class="btn btn-primary">Select</button>

	</div>

</form>
