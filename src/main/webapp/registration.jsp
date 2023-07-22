<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!--<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />-->
<title>Registration Form</title>
<link rel="stylesheet" href="./css/login.css">
</head>
<body>
	<div class="container">
		<div class="form-box">
			<div class="form-value">
				<form action="registrationServlet" method="POST">
					<h2>Registration</h2>
					<div class="inputbox">
						<ion-icon name="person-circle-outline"></ion-icon>
						<input type="text" name="username" required> <label for="username">Username</label>
					</div>
					<div class="inputbox">
						<ion-icon name="lock-closed-outline"></ion-icon>
						<input type="password" name="password" required> <label for="password">Password</label>
					</div>
					<button>Register</button>

				</form>
			</div>
		</div>
	</div>


<script type="module"
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule=""
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>