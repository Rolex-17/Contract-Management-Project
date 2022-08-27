<jsp:include page="header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="card shadow">
	<div class="card-body">
		<h4 class="p-2" style="border-bottom:2px solid green;">Create Requirement</h4>
		<c:if test="${msg ne null }">
			<div class="alert text-success font-weight-bold">${msg }</div>
		</c:if>
		<div class="row">
			<div class="col-sm-4 mx-auto">
			<form method="post">
				<div class="form-group">
					<label>Requirement Id</label>
					<input type="text" readonly name="reqid" value="${reqid }" class="form-control">
				</div>
				<div class="form-group">
					<label>Requirement Type</label>
					<select name="reqtype" required class="form-control">
						<option value="">Select type</option>
						<option>Birthday</option>
						<option>Marriage</option>
						<option>Workshops</option>
						<option>Conferences</option>
						<option>Reunions</option>
					</select>
				</div>
				<div class="form-group">
					<label>Description</label>
					<textarea rows="3" name="description" required class="form-control"></textarea>
				</div>
				<div class="form-group">
					<label>Delivery Date</label>
					<input type="date" name="deldate" required class="form-control">
				</div>
				<input type="submit" value="Save Requirement" class="btn btn-primary">
			</form>
			</div>
		</div>
		
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>