<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Review Restaurant</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
	<%
		//HttpSession session = request.getSession();
		String uName = (String) session.getAttribute("username");
		if (uName == null)
			response.sendRedirect("Login.jsp");
	%>
</head>
<body>
	
	<jsp:include page="/Navbar.jsp" />
	<div class="container">
		<form action="ReviewServlet" method="POST">



			<br> <br>
			<div class="form-group">

				<label for="rating">Rating</label> <select class="form-control"
					name="rating">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
			</div>
			<br> <br> <label for="review">Leave Review</label>
			<textarea class="form-control" rows="3" name="review"
				placeholder="Review"></textarea>
			<br>

			<button type="Submit" class="btn btn-primary btn-sm">Submit
				Review</button>




		</form>

	</div>
	<jsp:include page="/Footer.jsp" />
</body>
</html>