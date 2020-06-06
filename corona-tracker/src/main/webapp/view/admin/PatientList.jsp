
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<title>Patient List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<link href="${pageContext.request.contextPath}/common/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link href="${pageContext.request.contextPath}/common/css/simple-sidebar.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/common/css/patientList.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/common/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/common/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<!-- Header -->
	<div class="d-flex h5" id="wrapper">

		<!-- Sidebar -->
		<div class="bg-light border-right" id="sidebar-wrapper">
			<div class="sidebar-heading">Menu</div>
			<div class="list-group list-group-flush">
				<a href="PatientServlet"
					class="list-group-item list-group-item-action bg-light">Patient
					List</a> <a href="add"
					class="list-group-item list-group-item-action bg-light">Add
					Patient</a>
			</div>
		</div>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div style="text-align: center; color: DodgerBlue;">
				<h1>WEBSITE ABOUT COVID-19 INFECTIOUS DISEASE</h1>
			</div>
			<nav
				class="navbar navbar-expand-lg navbar-light bg-light border-bottom h5">
				<button class="btn btn-primary h5" id="menu-toggle">Toggle
					Menu</button>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ml-auto mt-2 mt-lg-0">

						<li class="nav-item dropdown h5"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Admin </a>
							<div class="dropdown-menu dropdown-menu-right"
								aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="adminchangepassword">Change
									Password</a>

								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="login">Logout</a>
							</div></li>
					</ul>
				</div>
			</nav>
	
	<div class="row">
		<div class="container ">
			<h3 class="text-center">PATIENT LIST</h3>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Time update</th>
						<th>Patient ID</th>
						<th>Age</th>
						<th>Gender</th>
						<th>Nationality</th>
						<th>Address</th>
						<th>Patient status</th>
						<th>Patient description</th>
						<th>Options</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="patient" items="${listPatient}">

						<tr>
							<td><c:out value="${patient.timeUpdate}" /></td>
							<td><c:out value="${patient.patientId}" /></td>
							<td><c:out value="${patient.age}" /></td>
							<td><c:out value="${patient.gender}" /></td>
							<td><c:out value="${patient.nationality}" /></td>
							<td><c:out value="${patient.address}" /></td>
							<td><c:out value="${patient.patientStatus}" /></td>
							<td><c:out value="${patient.patientDescription}" /></td>
							<td><a href="edit?patientId=${patient.patientId} ">
							<button type="button" >&nbsp;&nbsp;Edit&nbsp;&nbsp;</button></a> 
						
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?patientId=${patient.patientId}">
								<button type="button" onclick="abc()">Delete</button></a> 
						<script>
							function abc() {
								confirm("Are you sure you want to delete this?");
							}
						</script>
								</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	</div>
		<!-- /#page-content-wrapper -->
	</div>
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>
	
	<jsp:include page="/view/admin/footer.jsp"></jsp:include>
	
</body>
</html>
