<jsp:include page="header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="card shadow">
	<div class="card-body">
		<h4 class="p-2" style="border-bottom:2px solid green;">Create Contract</h4>
		<c:if test="${msg ne null }">
			<div class="alert text-success font-weight-bold">${msg }</div>
		</c:if>
		<div class="row">
			<div class="col-sm-4 mx-auto">
			<form method="post">
				<input type="hidden" name="supid" value="${sessionScope.userid }">
				<input type="hidden" name="supname" value="${sessionScope.uname }">
				<input type="hidden" name="delivery" value="0% completed">
				<div class="form-group">
					<label>Contract Id</label>
					<input type="text" readonly name="id" value="${id }" class="form-control">
				</div>
				<div class="form-group">
					<label>Contract Type</label>
					<input type="text" required name="ctype" class="form-control">
				</div>
				<div class="form-group">
					<label>Duration</label>
					<input type="text" required name="duration" class="form-control">
				</div>
				<div class="form-group">
					<label>Terms</label>
					<input type="text" required name="terms" class="form-control">
				</div>
				<input type="submit" value="Save Contract" class="btn btn-primary">
			</form>
			</div>
		</div>
		
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>