<!doctype html>
<%@page import="com.ty.ca.entity.Contact"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">

		<h1>${msg}</h1>
		<h1>DashBoard</h1>

		<nav class="navbar bg-primary" data-bs-theme="dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Navbar</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
					aria-controls="navbarNavAltMarkup" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav">
						<a class="nav-link active" aria-current="page" href="add">Add</a>
					</div>
				</div>
			</div>
		</nav>

		<%
		List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
		%>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Cid</th>
					<th scope="col">Name</th>
					<th scope="col">Phone</th>
					<th scope="col">Adhar No</th>
					<th scope="col">Update</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>

				<%
				for (Contact contact : contacts) {
				%>
				<tr>
					<th scope="row"><%=contact.getCid()%></th>
					<td><%=contact.getName()%></td>
					<td><%=contact.getPhone()%></td>
					<td><%=contact.getAdharNo()%></td>
					<td><a href="update?cid=<%=contact.getCid()%>">update</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<a href="#">Logout</a>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>