<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Footer</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/css/footer.css">
   
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<footer class="section footer-classic context-dark bg-image" style="background: #2d3246;">
        <div class="container">
          <div class="row row-30">
            <div class="col-md-4 col-xl-5">
              <div class="pr-xl-4"><a class="brand" href="index.html"></a>
               <br/>
                <p> WEBSITE ABOUT COVID-19 INFECTIOUS DISEASE</p>
               
                <p class="rights"><span>©  </span><span class="copyright-year">2020</span><span> </span><span>Faculty of Information Technology - Hanoi University</span><span>. </span><span>All Rights Reserved.</span></p>
              </div>
            </div>
            <div class="col-md-4">
             <br/>
              <h5>Contacts</h5>
              <dl class="contact-list">
                <dt>Address:</dt>
                <dd>Nguyen Trai Street, Thanh Xuan District, Ha Noi City, Viet Nam</dd>
              </dl>
              <dl class="contact-list">
                <dt>Email:</dt>
                <dd><a href="#">Group1@s.hanu.edu.vn</a></dd>
              </dl>
              
            </div>
            <div class="col-md-4 col-xl-3">
            <br/>
              <h5>Links</h5>
              <ul class="nav-list">
                <li><a href="<%=request.getContextPath()%>/view/web/api.jsp">APIs</a></li>
                
              </ul>
            </div>
          </div>
        </div>
        <div class="row no-gutters social-container">
          <div class="col"><a class="social-inner" href="#"><span class="icon mdi mdi-facebook"></span><span>Facebook</span></a></div>
          <div class="col"><a class="social-inner" href="#"><span class="icon mdi mdi-instagram"></span><span>instagram</span></a></div>
          <div class="col"><a class="social-inner" href="#"><span class="icon mdi mdi-twitter"></span><span>twitter</span></a></div>
          <div class="col"><a class="social-inner" href="#"><span class="icon mdi mdi-youtube-play"></span><span>google</span></a></div>
        </div>
      </footer> 
</body>
</html>