<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="jumbotron text-center">
	<h4>Welcome to Contract Management</h4>
</div>
<div class="container-fluid">
	<h4 class="p-2 text-center">Select Role</h4>
	<div class="row">
		<div class="col-sm-3 offset-2 text-center">
			<div class="card shadow">
				<div class="card-body p-5">
					<a href="/supplier">Supplier</a>
				</div>
			</div>
		</div>
		<div class="col-sm-3 offset-1 text-center">
			<div class="card shadow">
				<div class="card-body p-5">
					<a href="/adminlogin">Contract Admin</a>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>