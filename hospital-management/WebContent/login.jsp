<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Hospital Managment:Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/default.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="index.html">Home</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="detail-info.html">Patient
					Management</a></li>
			<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
		</ul>
	</nav>
	<br>
	<div class="container-fluid">
		<div class="row">
			<c:if test="${not empty errorMsg}">
				<div class="col-sm-12 alert alert-warning text-center">
					<c:out value="${errorMsg}" />
				</div>
			</c:if>
			<div class="col-sm-3"></div>
			<div class="card col-sm-6">
				<img class="card-img-top" src="header-banner.jpg"
					alt="Patient information">
				<div class="card-header">Admin Login</div>
				<div class="card-body">
					<form action="login" method="post">
						<div class="form-group">
							<label for="id">ID:</label> <input type="text" name="id"
								class="form-control" placeholder="Enter id" id="id">
						</div>
						<div class="form-group">
							<label for="pass">Password:</label> <input type="password"
								name="pass" class="form-control" placeholder="Enter password"
								id="pass">
						</div>
						<button type="submit" class="btn btn-primary" value="LOGIN">Submit</button>
					</form>
				</div>
				<div class="card-footer">
				
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
</body>
</html>