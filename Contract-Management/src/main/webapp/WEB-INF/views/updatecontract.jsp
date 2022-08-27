<jsp:include page="header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="card shadow">
	<div class="card-body">
		<h4 class="p-2" style="border-bottom:2px solid green;">Contract Details</h4>
		<c:if test="${msg ne null }">
			<div class="alert text-success font-weight-bold">${msg }</div>
		</c:if>
		<div class="row">
			<div class="col-sm-4">
				
				<div class="form-group">
					<label>Contract Id</label>
					<span class="font-weight-bold">${c.id }</span>
				</div>
				<div class="form-group">
					<label>Contract Type</label>
					<span class="font-weight-bold">${c.ctype }</span>
				</div>
				<div class="form-group">
					<label>Supplier Name</label>
					<span class="font-weight-bold">${c.supname }</span>
				</div>
				<div class="form-group">
					<label class="border-bottom">Contract Amenities</label>
					<ul>
					<c:forEach items="${alist }" var="a">	
						<li>${a.atype} - ${a.aminity }</li>
					</c:forEach>
					</ul>
				</div>
				<form method="post">
				<input type="hidden" value="${c.id }" name="id">
				<input type="hidden" value="Unapproved" name="status">
				<div class="form-group">
					<label>Duration</label>
					<input type="text" required name="duration" value="${c.duration }" class="form-control">
				</div>
				<div class="form-group">
					<label>Terms</label>
					<input type="text" required name="terms" value="${c.terms }" class="form-control">
				</div>
				
				<button class="btn btn-primary">Update Contract</button>
				</form>
			</div>
		</div>
		
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>