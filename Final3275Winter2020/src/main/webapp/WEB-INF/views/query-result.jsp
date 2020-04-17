<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CSIS3275 Final Winter 2020</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

<style>
	table {
	  font-family: arial, sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	}
	
	td, th {
	  border: 1px solid #dddddd;
	  text-align: left;
	  padding: 8px;
	}
	
	tr:nth-child(even) {
	  background-color: #dddddd;
	}
</style>

</head>
<body>
	<div class="container" style="margin-top:50px;">
		<div class="col-md-offset-2 col-md-7">
			<h1>Query Results:</h1>
			<hr>
			<table>
			<c:forEach var="user" items="${users}">
			  <tr>
			    <td><c:out value="${user.userName}, ${user.email}"/> </td>
			  </tr>
			</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>