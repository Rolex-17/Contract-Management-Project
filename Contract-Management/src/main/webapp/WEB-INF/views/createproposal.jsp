<jsp:include page="header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="card shadow">
	<div class="card-body">
		<h4 class="p-2" style="border-bottom:2px solid green;">Create Proposal</h4>
		<c:if test="${msg ne null }">
			<div class="alert text-success font-weight-bold">${msg }</div>
		</c:if>
		<div class="row">
			<div class="col-sm-4 mx-auto">
			<form method="post">
				<input type="hidden" name="supid" value="${sessionScope.userid }">
				<input type="hidden" name="supname" value="${sessionScope.uname }">
				<div class="form-group">
					<label>Proposal Id</label>
					<input type="text" readonly name="propid" value="${propid }" class="form-control">
				</div>
				<div class="form-group">
					<label>Requirement</label>
					<select name="reqid" required class="form-control">
						<option value=""> -- Select Requirement -- </option>
						<c:forEach items="${reqs }" var="r">
							<option value="${r.reqid }">${r.reqid} - ${r.reqtype }</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label>Proposal Date</label>
					<input type="date" name="pdate" required class="form-control">
				</div>
				<div class="form-group">
					<label>Quotation</label>
					<input type="number" placeholder="in rupees" name="quotation" required class="form-control">
				</div>
				<input type="submit" value="Send Proposal" class="btn btn-primary">
			</form>
			</div>
		</div>
		
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>