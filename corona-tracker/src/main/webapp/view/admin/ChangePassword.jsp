<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Change Password</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/common/css/simple-sidebar.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/common/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/common/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<!-- Header -->
	<div class="d-flex" id="wrapper">

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
				class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
				<button class="btn btn-primary" id="menu-toggle">Toggle
					Menu</button>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ml-auto mt-2 mt-lg-0">

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Admin </a>
							<div class="dropdown-menu dropdown-menu-right"
								aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="ChangePassword.jsp">Change
									Password</a>

								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="login">Logout</a>
							</div></li>
					</ul>
				</div>
			</nav>

			<!-- Change password -->
			<div class="container w-50">
				<div class="card">
					<div class="card-body">
						<form action="adminchangepassword" method="post">
							<h3 class="text-center">CHANGE PASSWORD</h3>
							<fieldset class="form-group">
								<label>Current Password</label> <input type="password"
									class="form-control" name="oldPassword" required="required">
							</fieldset>

							<fieldset class="form-group">
								<label>New Password</label> <input type="password"
									class="form-control" name="newPassword">
							</fieldset>

							<fieldset class="form-group">
								<label>Confirm Password</label> <input type="password"
									class="form-control" name="cfNewPassword">
							</fieldset>
							<c:if test="${not empty errorMessage1}">
								<font color="red"> <c:out value="${errorMessage1}" />
								</font>
							</c:if>
							<c:if test="${not empty errorMessage2}">
								<font color="red"> <c:out value="${errorMessage2}" />
								</font>
							</c:if>
							<div class="col text-center">
								<button type="submit" class="btn btn-success">CONFIRM</button>
							</div>
						</form>
					</div>
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

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
