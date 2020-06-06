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
			
			<div class="container col-6">
				<div class="card">
					<div class="card-body">
						<form action="edit" method="post">
							<h3 class="text-center">EDIT PATIENT</h3>
							<fieldset class="form-group">
								<label class="h5" for="quantity">Age</label> <input type="number"
									value='${patient.age}' class="form-control" name="age"
									id="quantity" required="required" min="0" max="150">
							</fieldset>
							<br>
							<fieldset class="form-group h5">
								<label class="h5">Gender:</label><br> <input type="radio" id="male"
									name="gender" value='Male'> <label
									for="male" class="h5">Male</label><br> <input type="radio"
									id="female" name="gender" value='Female'> <label
									for="female" class="h5">Female</label><br>
							</fieldset>
							<fieldset class="form-group h5">
								<label class="h5">Nationality : </label> <select name="patientNationality">
									<option class="h5" value='American'>American</option>
									<option class="h5" value='Australian'>Australian</option>
									<option class="h5" value='Brazilian'>Brazilian</option>
									<option class="h5" value='Cambodian'>Cambodian</option>
									<option class="h5" value='Canadian'>Canadian</option>
									<option class="h5" value='Chinese'>Chinese</option>
									<option class="h5" value='Cuban'>Cuban</option>
									<option class="h5" value='English'>English</option>
									<option class="h5" value='French'>French</option>
									<option class="h5" value='German'>German</option>
									<option class="h5" value='Indonesian'>Indonesian</option>
									<option class="h5" value='Italian'>Italian</option>
									<option class="h5" value='Japanese'>Japanese</option>
									<option class="h5" value='Korean'>Korean</option>
									<option class="h5" value='Laotian'>Laotian</option>
									<option class="h5" value='Malaysian'>Malaysian</option>
									<option class="h5" value='Polish'>Polish</option>
									<option class="h5" value='Russian'>Russian</option>
									<option class="h5" value='Spanish'>Spanish</option>
									<option class="h5" value='Taiwanese'>Taiwanese</option>
									<option class="h5" value='Thai'>Thai</option>
									<option class="h5" value='Vietnamese'>Vietnamese</option>
								</select>
							</fieldset>

							<fieldset class="form-group h5">
								<label class="h5">Address : </label> <select name="patientAddress">
									<option class="h5" value='Bac Lieu'>Bac Lieu</option>
									<option class="h5" value='Bac Giang'>Bac Giang</option>
									<option class="h5" value='Dong Thap'>Dong Thap</option>
									<option class="h5" value='Ninh Thuan'>Ninh Thuan</option>
									<option class="h5" value='Tay Ninh'>Tay Ninh</option>
									<option class="h5" value='Quang Ninh'>Quang Ninh</option>
									<option class="h5" value='Ha Noi'>Ha Noi</option>
									<option class="h5" value='Bac Ninh'>Bac Ninh</option>
									<option class="h5" value='Hai Phong'>Hai Phong</option>
									<option class="h5" value='Hai Duong'>Hai Duong</option>
									<option class="h5" value='Thai Binh'>Thai Binh</option>
									<option class="h5" value='Vinh Phuc'>Vinh Phuc</option>
									<option class="h5" value='Ninh Binh'>Ninh Binh</option>
									<option class="h5" value='Binh Thuan'>Binh Thuan</option>
									<option class="h5" value='TP HCM'>TP HCM</option>
									<option class="h5" value='Da Nang'>Da Nang</option>
									<option class="h5" value='Quang Nam'>Quang Nam</option>
									<option class="h5" value='Khanh Hoa'>Khanh Hoa</option>
									<option class="h5" value='Thanh Hoa'>Thanh Hoa</option>
									<option class="h5" value='Thua Thien Hue'>Thua Thien Hue</option>
									<option class="h5" value='Tra Vinh'>Tra Vinh</option>
									<option class="h5" value='Lai Chau'>Lai Chau</option>
								</select>
							</fieldset>

							<fieldset class="form-group h5">
								<label class="h5">Patient Status:</label> <select name="patientStatus">
									<option class="h5" value='Confirmed'>Confirmed</option>
									<option class="h5" value='Died'>Died</option>
									<option class="h5" value='Recovered'>Recovered</option>
								</select>
							</fieldset>
							<fieldset class="form-group h5">
								<label class="h5" for="description">Patient Description:</label>
								<textarea placeholder="Write something.." style="height: 200px"
									name="description" required="required" class="form-control h5"
									id="description"></textarea>
							</fieldset>


							<div class="col text-center h5">
								<c:set var="patientId" scope="request"
									value='<%=request.getParameter("patientId")%>' />
								<button type="submit" class="btn btn-success" name="patientId"
									value="${patientId}" class="h5">EDIT</button>
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