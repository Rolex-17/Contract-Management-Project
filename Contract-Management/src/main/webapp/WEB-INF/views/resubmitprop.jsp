<jsp:include page="header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="card shadow">
	<div class="card-body">
		<h4 class="p-2" style="border-bottom:2px solid green;">Resubmit Proposal</h4>
		<c:if test="${msg ne null }">
			<div class="alert text-success font-weight-bold">${msg }</div>
		</c:if>
		<div class="row">
			<div class="col-sm-4 mx-auto">
			<form method="post">
				<input type="hidden" name="status" value="Submitted">
				<input type="hidden" name="supid" value="${p.supid }">
				<input type="hidden" name="supname" value="${p.supname }">
				<div class="form-group">
					<label>Proposal Id</label>
					<input type="text" readonly name="propid" value="${p.propid }" class="form-control">
				</div>
				<div class="form-group">
					<label>Requirement</label>
					<input type="text" readonly name="reqid" value="${p.reqid }" class="form-control">					
				</div>
				<div class="form-group">
					<label>Proposal Date</label>
					<input type="date" required name="pdate" class="form-control">
				</div>
				<div class="form-group">
					<label>Quotation</label>
					<input type="text" required name="quotation" class="form-control">
				</div>
				<input type="submit" value="Send Proposal" class="btn btn-primary">
			</form>
			</div>
		</div>
		
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>