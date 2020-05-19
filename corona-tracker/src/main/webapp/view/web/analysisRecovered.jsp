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
<%
	List<CovidData> topCovidCountry = (List<CovidData>) getServletContext().getAttribute("topCovidCountry");
%>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load("current", {packages:["corechart"]});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ["Element", "Density"],
        <c:forEach items="${topCovidCountry}" var="covidData">
        ['${covidData.location.country}', ${covidData.cases.recovered}],
        </c:forEach>
    ]);

      var view = new google.visualization.DataView(data);

      var options = {
        title: "Report by Recovered",
        width: 900,
        height: 600,
        bar: {groupWidth: "95%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.BarChart(document.getElementById("barchart_values"));
      chart.draw(view, options);
  }
</script>
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
<link
	href="${pageContext.request.contextPath}/common/css/simple-sidebar.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/common/jquery/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<div class="row">
		<div class="col-3">
			<jsp:include page="template/sidebar.jsp"></jsp:include>
		</div>
		<div class="col-9">
			<div id="barchart_values" style="width: 900px; height: 500px"></div>
		</div>
	</div>
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>