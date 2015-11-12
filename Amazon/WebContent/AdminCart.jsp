<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="/Navbar.jsp" />
	<div align="center">
		<h3>Complete Order List Is Below</h3>
	</div>
	<div class="container" style="overflow-y: scroll">
		<table class="table table-striped">${message}
		</table>
		<div align="center">
			<p>Total Ordered Items :  ${noOfItems} </p>
			<p>Total Order Amount: ${cost}</p>
		</div>
		<a href="HomeServlet" class="btn btn-info" role="button">Back To
			Shopping</a> <a href="LogoutServlet" class="btn btn-info" role="button">Check
			Out</a>
	</div>
	<jsp:include page="/Footer.jsp" />
</body>
</html>