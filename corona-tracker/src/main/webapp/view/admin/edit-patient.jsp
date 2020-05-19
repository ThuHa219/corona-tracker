<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<link href="${pageContext.request.contextPath}/common/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link href="${pageContext.request.contextPath}/common/css/simple-sidebar.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/common/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/common/bootstrap/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/edit-patient.css">
</head>
<body>
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
								<a class="dropdown-item" href="adminchangepassword">Change
									Password</a>

								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="login">Logout</a>
							</div></li>
					</ul>
				</div>
			</nav>
			
			<div class="container w-50">
				<div class="card">
					<div class="card-body">
						<form action="edit" method="post">
							<h3 class="text-center">EDIT PATIENT</h3>
							<fieldset class="form-group">
								<label for="quantity">Age</label> <input type="number"
									value='${patient.age}' class="form-control" name="age"
									id="quantity" required="required" min="0" max="150">
							</fieldset>
							<br>
							<fieldset class="form-group">
								<label>Gender:</label><br> <input type="radio" id="male"
									name="gender" value='Male'> <label
									for="male">Male</label><br> <input type="radio"
									id="female" name="gender" value='Female'> <label
									for="female">Female</label><br>
							</fieldset>
							<fieldset class="form-group">
								<label>Nationality : </label> <select name="patientNationality">
									<option value='American'>American</option>
									<option value='Australian'>Australian</option>
									<option value='Brazilian'>Brazilian</option>
									<option value='Cambodian'>Cambodian</option>
									<option value='Canadian'>Canadian</option>
									<option value='Chinese'>Chinese</option>
									<option value='Cuban'>Cuban</option>
									<option value='English'>English</option>
									<option value='French'>French</option>
									<option value='German'>German</option>
									<option value='Indonesian'>Indonesian</option>
									<option value='Italian'>Italian</option>
									<option value='Japanese'>Japanese</option>
									<option value='Korean'>Korean</option>
									<option value='Laotian'>Laotian</option>
									<option value='Malaysian'>Malaysian</option>
									<option value='Polish'>Polish</option>
									<option value='Russian'>Russian</option>
									<option value='Spanish'>Spanish</option>
									<option value='Taiwanese'>Taiwanese</option>
									<option value='Thai'>Thai</option>
									<option value='Vietnamese'>Vietnamese</option>
								</select>
							</fieldset>

							<fieldset class="form-group">
								<label>Address : </label> <select name="patientAddress">
									<option value='Bac Lieu'>Bac Lieu</option>
									<option value='Bac Giang'>Bac Giang</option>
									<option value='Dong Thap'>Dong Thap</option>
									<option value='Ninh Thuan'>Ninh Thuan</option>
									<option value='Tay Ninh'>Tay Ninh</option>
									<option value='Quang Ninh'>Quang Ninh</option>
									<option value='Ha Noi'>Ha Noi</option>
									<option value='Bac Ninh'>Bac Ninh</option>
									<option value='Hai Phong'>Hai Phong</option>
									<option value='Hai Duong'>Hai Duong</option>
									<option value='Thai Binh'>Thai Binh</option>
									<option value='Vinh Phuc'>Vinh Phuc</option>
									<option value='Ninh Binh'>Ninh Binh</option>
									<option value='Binh Thuan'>Binh Thuan</option>
									<option value='TP HCM'>TP HCM</option>
									<option value='Da Nang'>Da Nang</option>
									<option value='Quang Nam'>Quang Nam</option>
									<option value='Khanh Hoa'>Khanh Hoa</option>
									<option value='Thanh Hoa'>Thanh Hoa</option>
									<option value='Thua Thien Hue'>Thua Thien Hue</option>
									<option value='Tra Vinh'>Tra Vinh</option>
									<option value='Lai Chau'>Lai Chau</option>
								</select>
							</fieldset>

							<fieldset class="form-group">
								<label>Patient Status:</label> <select name="patientStatus">
									<option value='Confirmed'>Confirmed</option>
									<option value='Died'>Died</option>
									<option value='Recovered'>Recovered</option>
								</select>
							</fieldset>
							<fieldset class="form-group">
								<label for="description">Patient Description:</label>
								<textarea placeholder="Write something.." style="height: 200px"
									name="description" required="required" class="form-control"
									id="description"></textarea>
							</fieldset>


							<div class="col text-center">
								<c:set var="patientId" scope="request"
									value='<%=request.getParameter("patientId")%>' />
								<button type="submit" class="btn btn-success" name="patientId"
									value="${patientId}">EDIT</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
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