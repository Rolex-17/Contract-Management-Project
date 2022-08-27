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
				<input type="hidden" name="supid" value="${sessionScope.userid }">
				<input type="hidden" name="supname" value="${sessionScope.uname }">
				<input type="hidden" name="delivery" value="0% completed">
				<div class="form-group">
					<label>Contract Id</label>
					<span class="font-weight-bold">${c.id }</span>
				</div>
				<div class="form-group">
					<label>Contract Type</label>
					<span class="font-weight-bold">${c.ctype }</span>
				</div>
				<div class="form-group">
					<label>Duration</label>
					<span class="font-weight-bold">${c.duration }</span>
				</div>
				<div class="form-group">
					<label>Terms</label>
					<span class="font-weight-bold">${c.terms }</span>
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
				
			</div>
			<div class="col-sm-4">
				<form method="post" action="addamenity">
					<input type="hidden" value="${c.id }" name="cid">
				<div class="form-group">
					<label>Amenity Type</label>
					<input type="text" name="atype" required class="form-control">
				</div>
				<div class="form-group">
					<label>Amenity Details</label>
					<input type="text" name="aminity" required class="form-control">
				</div>
				<input type="submit" value="Save Amenity" class="btn btn-primary">
				</form>
			</div>
		</div>
		
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>