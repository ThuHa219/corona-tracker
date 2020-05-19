<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/css/login.css">
<title>Login</title>
</head>
<body>
	<div class="container-login100"
		style="background-image: url('${pageContext.request.contextPath}/images/covid19.jpg');">
		<div class="wrapper fadeInDown">
			<div id="formContent">
				<span class="fadeIn first">Admin Login</span>
				<form id="form-login" action="login" method="post">
					<input type="text" id="username" class="fadeIn second" name="name"
						placeholder="Username"> <input type="password"
						id="password" class="fadeIn third" name="pass"
						placeholder="Password"> <br>
					<c:if test="${not empty errorMessage}">
						<font color="red"> <c:out value="${errorMessage}" />
						</font>
					</c:if>
					<br>
					<input type="submit" id="submit" class="fadeIn fourth"
						value="Log In">
				</form>

			</div>
		</div>
	</div>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="common/bootstrap/js/login.js"></script>
</body>
</html>