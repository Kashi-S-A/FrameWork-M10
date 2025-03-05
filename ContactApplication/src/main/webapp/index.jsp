<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Contact App</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	
	<div class="container">
	<h1>Register Here</h1>
	
		<form action="save" method="post">

			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Name</label>
				<input type="text" class="form-control"	name="name"
					id="exampleFormControlInput1" placeholder="Ex : Dinga">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput2" class="form-label">Email
					address</label> <input type="email" class="form-control" name="email"
					id="exampleFormControlInput2" placeholder="ex : dinga@gmail.com">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput3" class="form-label">Phone</label> <input type="number" class="form-control"
					name="phone" id="exampleFormControlInput3" placeholder="Ex : 2345678901">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput4" class="form-label">Password</label> <input type="password" class="form-control"
					name="password" id="exampleFormControlInput4" placeholder="Ex : Dinga@123">
			</div>
			
			<button type="submit" class="btn btn-primary">Register</button>

		</form>
		
		<a href="login">Login Here</a>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>