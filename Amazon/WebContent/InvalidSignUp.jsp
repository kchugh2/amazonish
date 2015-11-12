<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
	<jsp:include page="/Navbar.jsp" />

	<div class="container">
	<h1>USERNAME ALREADY EXISTS TRY AGAIN YOU UNGODLY BUFOON</h1>
		<form action="AddUserServlet">
			<div class="form-group">
				<label for="UserName" style="color: #141452"></label> <input
					type="UserName" class="form-control" name="UserName"
					placeholder="UserName">
			</div>
			<br>

			<div class="form-group">
				<label for="Password" style="color: #141452"></label> <input
					type="Password" class="form-control" name="Password"
					placeholder="Password">
			</div>
			<br>
			<!-- Single button -->
			<br> <br>

			<button type="Submit" class="btn btn-primary btn-sm">Create
				Account</button>




		</form>
	</div>

	<br />
	<br />


	<jsp:include page="/Footer.jsp" />
</body>
</html>