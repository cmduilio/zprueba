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
				<img src="${contextPath}/resources/images/icon.jpg" width="100"
					height="80" alt="profile-icon" /> ${userForm.username} | <a
					href="${contextPath}/logout">Logout<br></a> <a
					href="${contextPath}/profile">Ver perfil</a>
			</h4>
		</div>
	</form:form>

	<div class="form-signin">
		<input class="form-control" type="date" value="inserte fecha" />
		<div class="form-signin">
			<input type="submit" onclick="addSchedule()"
				class="btn btn-lg btn-primary btn-block" value="Add Schedule" /> <input
				type="submit" onclick="showSchedule()"
				class="btn btn-lg btn-primary btn-block" value="Show all" />
		</div>
		<c:if test="${schedules != null}">
			<table id="table" class="grid" style="width: 850px;">
				<tr>
					<th style="width: 100px;">Date</th>

				</tr>
				<c:forEach var="schedule" items="${schedules}">
					<tr>
						<td>${schedule.date}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

    <script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>

	<script type="text/javascript">
		function addSchedule() {
			$.ajax({
				url : 'addSchedule.html',
				success : function(data) {
				}
			});
		}

		function showSchedule() {
			$.ajax({
				url : 'showSchedule.html',
				success : function(data) {
					var table = $('#pepe').DataTable();
					table.ajax.reload();
				}
			});
		}
	</script>

</body>
</html>
