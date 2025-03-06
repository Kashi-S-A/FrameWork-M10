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
		<h1>Update Contact</h1>

		<form action="update" method="post">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label"></label>
				<input type="hidden" class="form-control" name="cid"
					id="exampleFormControlInput1" value="${contact.cid}" placeholder="Ex : Dinga">
			</div>

			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Name</label>
				<input type="text" class="form-control" name="name"
					id="exampleFormControlInput1" value="${contact.name}" placeholder="Ex : Dinga">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput3" class="form-label">Phone</label>
				<input type="number" class="form-control" name="phone"
					id="exampleFormControlInput3" value="${contact.phone}" placeholder="Ex : 2345678901">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput4" class="form-label">Adhar
					No</label> <input type="number" class="form-control" name="adharNo"
					id="exampleFormControlInput4" value="${contact.adharNo}" placeholder="Ex : 111222333">
			</div>

			<button type="submit" class="btn btn-primary">Update</button>

		</form>

		<a href="#">Logout</a>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>