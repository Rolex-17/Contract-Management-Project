<jsp:include page="header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="card shadow">
	<div class="card-body">
		<h4 class="p-2" style="border-bottom:2px solid green;">Contracts List</h4>
		<c:if test="${msg ne null }">
			<div class="alert text-success font-weight-bold">${msg }</div>
		</c:if>
		<table class="table table-bordered table-sm">
			<thead>
				<tr>
					<th>Id</th>
					<th>Supplier Name</th>
					<th>Contract Type</th>
					<th>Terms</th>
					<th>Delivery Progress</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${list }">
					<tr>
						<td>${u.id }</td>
						<td>${u.supname }</td>
						<td>${u.ctype }</td>
						<td>${u.terms }</td>
						<td>${u.delivery}</td>
						<td>${u.status }</td>
						<c:if test="${sessionScope.role == 'Supplier' }">
						<td>
						<a href="/cdetails?id=${u.id }" class="btn btn-success btn-sm">Details</a>
						<a href="/editdetails?id=${u.id }" class="btn btn-success btn-sm">Edit</a>
						</td>
						</c:if>
						<c:if test="${sessionScope.role == 'Admin' }">
						<td>
						<a href="/caction?status=Approved&id=${u.id }" class="btn btn-success btn-sm">Approve</a>
						<a href="/caction?status=Rejected&id=${u.id }" class="btn btn-danger btn-sm">Reject</a>
						<a href="/caction?status=To be revisit&id=${u.id }" class="btn btn-info btn-sm">Revisit</a>
						<a href="/caction?status=Closed&id=${u.id }" class="btn btn-dark btn-sm">Close</a>
						<a href="/caction?status=Extended&id=${u.id }" class="btn btn-secondary btn-sm">Extend</a>
						</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>