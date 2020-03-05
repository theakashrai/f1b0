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
			<table class="table">
				<thead>
					<tr>
						<th>Patient id</th>
						<th>Name</th>
						<th>Mobile Number</th>
						<th>Room number</th>
						<th>Disease</th>
						<th>Date of admission</th>
						<th>Date of discharge</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="row" items="${patientList}">
						<tr>
							<td><c:out value="${row.id}" /></td>
							<td><c:out value="${row.name}" /></td>
							<td><c:out value="${row.mobileNumber}" /></td>
							<td><c:out value="${row.roomNo}" /></td>
							<td><c:out value="${row.disease}" /></td>
							<td><c:out value="${row.dateOfAdmission}" /></td>
							<td><c:out value="${row.dateOfDischarge}" /></td>
							<td><a
								href='delete?PatientID="<c:out value="${row.id}" />"'>DELETE</a></td>
							<td><a href='edit?PatientID="<c:out value="${row.id}" />"'>EDIT</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


</body>
</html>