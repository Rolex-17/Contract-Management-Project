<jsp:include page="header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="card shadow">
	<div class="card-body">
		<h4 class="p-2" style="border-bottom:2px solid green;">Manage Contract Delivery</h4>
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
					<c:if test="${sessionScope.role=='Supplier' }">
					<th>Status</th>
					<th>Delivery</th>
					</c:if>
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
						<c:if test="${sessionScope.role=='Supplier' }">
						<td>${u.status }</td>
						<td><a href="updatedelivery?id=${u.id }" class="btn btn-info btn-sm">Update </a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>