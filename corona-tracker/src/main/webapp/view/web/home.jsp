<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="edu.hanu.model.CovidData"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Corona Tracker</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
</head>
<link href="${pageContext.request.contextPath}/common/css/box.css"
	rel="stylesheet">
<body>
	<!-- <div class="container"> -->
	<%
		List<CovidData> covidData = (List<CovidData>) getServletContext().getAttribute("covidData");
		CovidData world = (CovidData) request.getAttribute("world");
	%>

	<jsp:include page="template/header.jsp"></jsp:include>
	<div class="container">
		<div class="box">
			<div class="content">
				<h2 style="color: #FF9C00" style="color:#FF9C00">Confirmed</h2>
				<p style="color: #FF9C00">
					<c:out value="${world.cases.total}" />
				</p>
			</div>
		</div>
		<div class="box">
			<div class="content">
				<h2 style="color: #C9302C">Deaths</h2>
				<p style="color: #C9302C">
					<c:out value="${world.deaths.total}" />
				</p>
			</div>
		</div>

		<div class="box">
			<div class="content">
				<h2 style="color: #337AB7">Recovered</h2>
				<p style="color: #337AB7">
					<c:out value="${world.cases.recovered}" />
				</p>
			</div>
		</div>
	</div>
	<br />
	<div class="flourish-embed flourish-chart" data-src="story/230114">
		<script src="https://public.flourish.studio/resources/embed.js"></script>
	</div>
	<div class="flourish-embed flourish-map" data-src="story/225979">
		<script src="https://public.flourish.studio/resources/embed.js"></script>
	</div>
	<br />
	<!-- Search form -->
	<form class="form-group" action="home">
		<!-- Search form -->
		<!-- <div class="md-form mt-0"> -->
			<input class="form-control" type="text" placeholder="Search"
				aria-label="Search" name="country">
		<!-- </div> -->
		<!-- <div class="input-field second-wrap"> -->
			<button class="btn btn-outline-info waves-effect" type="submit">SEARCH</button>
		<!-- </div> -->
	</form>
	<br />
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Country</th>
				<th scope="col">Confirmed</th>
				<th scope="col">New Cases</th>
				<th scope="col">Deaths</th>
				<th scope="col">New Deaths</th>
				<th scope="col">Serious</th>
				<th scope="col">Recovered</th>
			</tr>
		</thead>
		<c:forEach items="${covidData}" var="covidData" varStatus="i"
			begin="0">
			<tbody>
				<tr>
					<td><c:out value="${covidData.location.country}" /></td>
					<td><c:out value="${covidData.cases.total}" /></td>
					<td><c:out value="${covidData.cases.newCase}" /></td>
					<td><c:out value="${covidData.deaths.total}" /></td>
					<td><c:out value="${covidData.deaths.newDeath}" /></td>
					<td><c:out value="${covidData.cases.critical}" /></td>
					<td><c:out value="${covidData.cases.recovered}" /></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<!-- </div> -->
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>