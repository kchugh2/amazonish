
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="/Navbar.jsp" />
	<br>
	<div class="container" style="overflow-y: scroll">
		<table class="table table-striped">
			<tr>
				<th>Company</th>
				<th>Product</th>
				<th>Description</th>
				<th>Price</th>
			</tr>
			${message}
		</table>
		<div align="center">
			<img src="${url}">
		</div>
		<div align="center">
			<h3>Reviews</h3>
			<h3>Average Rating : ${avgRating}</h3>

			<div align="center">
				<div class="container" style="overflow-y: scroll">
					<table class="table table-striped">
						<tr>
							<th>User</th>
							<th>Rating</th>
							<th>Review</th>
						</tr>
						${message2}
					</table>
					<a href="CartAddServlet" class="btn btn-info" role="button">Add
						To Cart</a> <a href="HomeServlet" class="btn btn-info" role="button">Back
						To Shopping</a> <a href="ReviewPage.jsp" class="btn btn-info"
						role="button">Add a Review</a>
				</div>
			</div>
		</div>


		<jsp:include page="/Footer.jsp" />
</body>
</html>