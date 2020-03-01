<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Edit</title>
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
			<li class="nav-item"><a class="nav-link" href="index2.html">Patient
					Management</a></li>
			<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
		</ul>
	</nav>
	<br>
	<div class="container-fluid">
		<div class="row">
					<div class="col-sm-3"></div>
					<div class="card col-sm-6">
						<img class="card-img-top" src="header-banner.jpg"
							alt="Patient information">
						<div class="card-body">
							<form action="#" method="post">
								<div class="form-group">
									<label for="name">Name:</label> <input type="text" name="name"
										class="form-control" placeholder="Enter name" id="name"
										value="<c:out value="${patient.name}"/>" disabled>
								</div>
								<div class="form-group">
									<label for="mob">Mobile:</label> <input type="number"
										name="mob" class="form-control"
										placeholder="Enter mobile number" id="mob"
										value="<c:out value="${patient.mobileNumber}"/>" disabled>
								</div>
								<div class="form-group">
									<label for="rom">Room No:</label> <input type="number"
										name="rom" class="form-control"
										placeholder="Enter room number" id="rom"
										value="<c:out value="${patient.roomNo}"/>" disabled>
								</div>
								<div class="form-group">
									<label for="dis">Disease:</label> <input type="text" name="dis"
										class="form-control" placeholder="Enter Disease" id="dis"
										value="<c:out value="${patient.disease}"/>" disabled>
								</div>
								<div class="form-group">
									<label for="doa">Date of admission:</label> <input type="date"
										name="doa" class="form-control"
										placeholder="Enter Date of admission" id="doa"
										value="<c:out value="${patient.dateOfAdmission}"/>" disabled>
								</div>
								<div class="form-group">
									<label for="doa">Date of discharge:</label> <input type="date"
										name="dod" class="form-control"
										placeholder="Enter Date of discharge" id="dod"
										value="<c:out value="${patient.dateOfDischarge}"/>" disabled>
								</div>
						<button type="submit" class="btn btn-primary" value="Update">Update</button>
							</form>
						</div>
					</div>
					<div class="col-sm-3"></div>
		</div>
	</div>
</body>
</html>