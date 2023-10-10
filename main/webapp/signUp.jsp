<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Registration</title>
<style>
body {
	font-family: Arial, sans-serif;
}

.container {
	width: 80%;
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

h2 {
	text-align: center;
}

.form-group {
	margin-bottom: 15px;
}

label {
	display: block;
	margin-bottom: 5px;
}

input[type="text"], input[type="email"], input[type="tel"], input[type="password"],
	select {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

button {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="container">
		<h2>User Registration</h2>
		<form action="userModelController" method="post">
			<div class="form-group">
				<label for="first-name">First Name</label> <input type="text"
					id="first-name" name="fname" required>
			</div>
			<div class="form-group">
				<label for="last-name">Last Name</label> <input type="text"
					id="last-name" name="lname" required>
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input type="email" id="email"
					name="email" required>
			</div>
			<div class="form-group">
				<label for="contact">Contact</label> <input type="tel" id="contact"
					name="contact" required>
			</div>
			<div class="form-group">
				<label for="address">Address</label> <input type="text" id="address"
					name="address" required>
			</div>
			<div class="form-group">
				<label for="gender">Gender</label> <select id="gender" name="gender"
					required>
					<option value="male">Male</option>
					<option value="female">Female</option>
					</select>
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					id="password" name="password" required>
			</div>
			<div class="form-group">
				<label for="confirm-password">Confirm Password</label> <input
					type="password" id="confirm-password" name="confirm-password"
					required>
			</div>
			<button type="submit" name="action" value="Register">Register</button>
		</form>
	</div>
	<script>document.addEventListener("DOMContentLoaded", function () {
	    const registrationForm = document.getElementById("registration-form");

	    registrationForm.addEventListener("submit", function (e) {
	        e.preventDefault();

	        const firstName = document.getElementById("first-name").value;
	        const lastName = document.getElementById("last-name").value;
	        const email = document.getElementById("email").value;
	        const contact = document.getElementById("contact").value;
	        const address = document.getElementById("address").value;
	        const gender = document.getElementById("gender").value;
	        const password = document.getElementById("password").value;
	        const confirmPassword = document.getElementById("confirm-password").value;

	        // You can perform validation and registration logic here

	        // For this example, we'll just log the form data
	        console.log({
	            firstName,
	            lastName,
	            email,
	            contact,
	            address,
	            gender,
	            password,
	            confirmPassword,
	        });
	    });
	});
</script>
</body>
</html>
