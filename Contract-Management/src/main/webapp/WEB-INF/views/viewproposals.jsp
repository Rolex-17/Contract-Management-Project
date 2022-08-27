<jsp:include page="header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="card shadow">
	<div class="card-body">
		<h4 class="p-2" style="border-bottom:2px solid green;">View Requirement</h4>
		<c:if test="${msg ne null }">
			<div class="alert text-success font-weight-bold">${msg }</div>
		</c:if>
		<table class="table table-bordered table-sm">
			<thead>
				<tr>
					<th>Prop Id</th>
					<th>Req Id</th>
					<th>Prop Date</th>
					<th>Quotation</th>
					<th>Supplier Name</th>
					<th>Status</th>
					<c:if test="${sessionScope.role == 'Admin' }">
					<th>Action</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${list }">
					<tr>
						<td>${u.propid }</td>
						<td>${u.reqid }</td>
						<td>${u.pdate }</td>
						<td>${u.quotation }</td>
						<td>${u.supname}</td>
						<td>${u.status }
						<c:if test="${sessionScope.role == 'Supplier' and u.status=='To be revisit' }">
						<a href="/resendprop?propid=${u.propid }" class="btn btn-success btn-sm">Resubmit</a>
						</c:if>
						</td>
						<c:if test="${sessionScope.role == 'Admin' }">
						<td>
						<a href="/propaction?status=Approved&propid=${u.propid }" class="btn btn-success btn-sm">Approve</a>
						<a href="/propaction?status=Rejected&propid=${u.propid }" class="btn btn-danger btn-sm">Reject</a>
						<a href="/propaction?status=To be revisit&propid=${u.propid }" class="btn btn-danger btn-sm">Revisit</a>
						</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>