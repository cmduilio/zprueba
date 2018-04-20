<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
	
	
<head>
	<title>index</title>
	
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<meta name="description" content="">
	<meta name="author" content="">
		
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link href="${contextPath}/resources/css/bootstrap.min.css"
		rel="stylesheet">
	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-default navbar-static-top">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-left" href="${contextPath}/index"><img src="${contextPath}/resources/images/samit.jpg"/> </a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="?lang=es"><spring:message code="messageResource.spanish" text="default text" /></a></li>
	      <li><a href="?lang=en"><spring:message code="messageResource.english" text="default text" /></a></li>
	    </ul>
        
        <ul class="nav navbar-nav navbar-right">
      		<li><a href="${contextPath}/registration"><span class="glyphicon glyphicon-user"></span><spring:message code="messageResource.register" text="default text" /></a></li>
      		<li><a href="${contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> <spring:message code="messageResource.login" text="default text" /></a></li>
    	</ul>
	  </div>
	</nav>
		
	<div class="container">
	
	  	<h2></h2> 
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
		  <!-- Indicators -->
		  <ol class="carousel-indicators">
		    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		    <li data-target="#myCarousel" data-slide-to="1"></li>
		    <li data-target="#myCarousel" data-slide-to="2"></li>
		  </ol>
		
		  <!-- Wrapper for slides -->
		  <div class="carousel-inner">
		    <div class="item active">
		      <img src="${contextPath}/resources/images/Priceless-Cities-21.jpg" alt="City 1">
		    </div>
		
		    <div class="item">
		      <img src="${contextPath}/resources/images/twin-cities.jpg" alt="City 2">
		    </div>
		
		    <div class="item">
		      <img src="${contextPath}/resources/images/PragueCentre.jpg" alt="City 3">
		    </div>
		  </div>
		
		  <!-- Left and right controls -->
		  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#myCarousel" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
	</div>
	<div class="container" style="margin-top:50px; text-align: center;">
		<h1>Información personal</h1>
		
		<h2>Mauro Duilio Candotti</h2>
		
		<h2>About me</h2>
		<p> 
			Es un gatito <span style="color:orange;">naranjoso</span>, se la pasa haciendo cagadas, pero es buenito.
		</p>
			
		<p>
			Edad: 
			<br>
			Algo: 
			<br>
			Otro algo: 
			<br>
			Otro otro algo: 
		</p> 
		<div class="row">
		<h1>Estudios</h1>
		    <div class="col-sm-4">
		    	<h2>Primaria</h2>
		      	Instituto Espíritu Sánto XXXX-2002
		    </div>
		    <div class="col-sm-4">
		    	<h2>Secundaria</h2>
		      	Instituto Espíritu Sánto 2003-2007
		    </div>
		    
		    <div class="col-sm-4">
		    	<h2>Universitario</h2>
		      	Ciencias en computacion - UBA 2008 - actualidad
		    </div>
  		</div>
  		
  		<div>
  			Universitario
  		</div>
	
	</div>
	
	<div id="footer" style="background-color:black; color:white; text-align: center;">
	    <div class="container">
		    <div class="row" >
			    <div class="col-sm-4">
			    	<h2>Links</h2>
			    </div>
	  		</div>
	  		<div class="row" >
			    <div class="col-sm-4">
			      	iconoFacebook - iconoLinkedIn - otroIcono
			    </div>
			    <div class="col-sm-4">
			      	alguna otra cosa acá?
			    </div>
			    
	  		</div>
	    </div>
  	</div>
	
		<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
