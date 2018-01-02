<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Welcome</title>
	
	<link href="${contextPath}/resources/css/bootstrap.min.css"
		rel="stylesheet">
	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

</head>
<body>
	
	<form:form class="form-signin">
		<div class="container">
				<h4 class="text-center">
					<img src="${contextPath}/resources/images/icon.jpg" width="100" height="80" alt="profile-icon"/> 
					<div>
						${userForm.username} | 
						<a href="${contextPath}/logout">Logout<br></a>
						<a href="${contextPath}/profile">Ver perfil</a>
					</div>
				</h4>
		</div>
	</form:form>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
