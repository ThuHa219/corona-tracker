<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Corona Tracker</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/common/css/timeline.css"
	rel="stylesheet">
</head>
<body>
<jsp:include page="template/header.jsp"></jsp:include>

<div class="container mt-5 mb-5">
	<div class="row">
		<div class="col-md-6 offset-md-3">
			<h4>Latest News</h4>
			<ul class="timeline">
			<c:forEach var="patient" items="${listPatient}">
				<li>
					<a target="_blank" href="#"><c:out value="${patient.patientId}" /></a>
					<a href="#" class="float-right"><c:out value="${patient.timeUpdate}" /></a>
					<p><c:out value="${patient.patientDescription}" /></p>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
</div>
</body>
</html>