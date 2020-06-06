<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>APIs</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<div class="container col-9">
		<div class="card">
			<div class="card-body">
				<form action="update" method="post">
					<h1 class="text-center">APIs</h1>
					<br>
					<div>This link will help you get our data about COVID-19
						pandemic.</div>
					<div class="form-inline desciption">
						Link to our APIs: &nbsp;&nbsp;&nbsp;&nbsp; <a
							href="http://localhost:8080/corona-tracker/webapi/covidDatas"
							class="form-inline">
							http://localhost:8080/corona-tracker/webapi/covidDatas</a>
							</div> <img
							alt="" src="${pageContext.request.contextPath}/images/api.jpg">
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>