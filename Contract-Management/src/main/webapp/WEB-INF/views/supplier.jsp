<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="jumbotron text-center rounded-0 bg-primary text-white mb-2">
	<h4>Welcome to Contract Management</h4>
</div>
<div class="container-fluid">
	<div class="row">
			<div class="col-sm-5 mx-auto mt-2">
				<div class="card shadow">
					<div class="card-header text-center">
						<h5>Supplier Register Screen</h5>
					</div>
					<div class="card-body">
						<sf:form method="post" modelAttribute="supplier">
							<div class="form-group form-row">
								<sf:label path="name" cssClass="col-sm-4 col-form-label">Supplier Name</sf:label>
								<div class="col-sm-8">
									<sf:input type="text" path="name" cssClass="form-control" />
									<sf:errors path="name" cssClass="text-danger text-small" />
								</div>
							</div>
							<div class="form-group form-row">
								<sf:label path="phone" cssClass="col-sm-4 col-form-label">Contact No</sf:label>
								<div class="col-sm-8">
									<sf:input type="text" path="phone" maxlength="10"
										cssClass="form-control" />
										<sf:errors path="phone" cssClass="text-danger text-small" />
								</div>
							</div>
							<div class="form-group form-row">
								<sf:label path="address" cssClass="col-sm-4 col-form-label">Address</sf:label>
								<div class="col-sm-8">
									<sf:input type="text" path="address"
										cssClass="form-control" />
									<sf:errors path="address" cssClass="text-danger text-small" />
								</div>
							</div>
							<div class="form-group form-row">
								<sf:label path="supid" cssClass="col-sm-4 col-form-label">Supplier ID</sf:label>
								<div class="col-sm-8">
									<sf:input type="text" readonly="true" path="supid" cssClass="form-control" />
									<sf:errors path="supid" cssClass="text-danger text-small" />
								</div>
							</div>
							<div class="form-group form-row">
								<sf:label path="pwd"  cssClass="col-sm-4 col-form-label">Password</sf:label>
								<div class="col-sm-8">
									<sf:input type="password" path="pwd" cssClass="form-control" />
									<sf:errors path="pwd" cssClass="text-danger text-small" />
								</div>
							</div>
							<div class="form-group form-row">
								<sf:label path="cpwd"  cssClass="col-sm-4 col-form-label">Repeat Password</sf:label>
								<div class="col-sm-8">
									<sf:input type="password" path="cpwd" cssClass="form-control" />
									<sf:errors path="cpwd" cssClass="text-danger text-small" />
								</div>
							</div>
							<div class="clearfix"></div>
							<a href="/suplogin">Already register login</a>
							<input type="submit" value="Register"
								class="btn btn-primary float-right px-4">
						</sf:form>
					<c:if test="${msg ne null }">
					<div class="alert text-success font-weight-bold">${msg }</div>
					</c:if>
					</div>
				</div>
			</div>
			
		</div>
</div>
</body>
</html>