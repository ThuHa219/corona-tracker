<nav class="navbar navbar-dark bg-dark sticky-top">
	<a class="navbar-brand" href="home"> <img
		src="<%=request.getContextPath()%>/images/corona-icon.png" width="30"
		height="30" alt=""> Corona Tracker
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		<div class="navbar-nav">
			<a class="nav-item nav-link active" href="home">Home <span
				class="sr-only">(current)</span></a>
				 <a class="nav-item nav-link"
				href="analysis">Analysis</a>
				 <a class="nav-item nav-link" href="map">Map</a>
			<a class="nav-item nav-link" href="timeline">Timeline</a>
		</div>
	</div>
</nav>