<jsp:include page="header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="card shadow">
	<div class="card-body">
		<h4 class="p-2" style="border-bottom:2px solid green;">Update Delivery status</h4>
		<div class="row">
			<div class="col-sm-4 mx-auto">
			<form method="post">
			<input type="hidden" value="${c.id }" name="cid">
			<table class="table table-borderless">
				<tr>
				<td>Contract Id</td>
				<td>${c.id }</td>
				</tr>
				<tr>
				<td>Contract Type</td>
				<td>${c.ctype }</td>
				</tr>
				<tr>
				<td>Contract Duration</td>
				<td>${c.duration }</td>
				</tr>
				<tr>
				<td>Contract Terms</td>
				<td>${c.terms }</td>
				</tr>
				<tr>
					<td>Delivery</td>
					<td><input type="text" required name="delivery" value="${c.delivery }" class="form-control"></td>
				</tr>
				<tr>
				<td colspan="2"><input type="submit" value="Update Delivery" class="btn btn-info float-right"></td>
				</tr>
			</table>
				
			</form>
			</div>
		</div>
		
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>