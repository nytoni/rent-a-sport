<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type = "text/css" href="registerPageCss.css">
		
		
	</head>
	<body>
		<h1>Create Account</h1>
		
		<form action="createAccount" method="GET">
			<input id = "name" type="text" name="name" placeholder = "Name" value = "${fullName}"><br />
			<input id = "email" type = "text" name = "email" placeholder = "Email"><br />
			<input id = "password" type = "password" name = "password" placeholder = "Password"><br />
			<input id = "confirmPassword" class = "lastRow" type = "password" name = "password" placeholder = "Confirm Password"><br />
			
			
			<input class = "submit" type="submit" onClick = "return checkFields()">
		</form>
		
		
		
		<p class = "top">Email address has already been registered.</p>
		<p class = "bottom">Please log in or register with a new account.</p>
		
		<div id = "errorMsg"></div>
		<a href = "LogInPage.html">login</a>
		
		<script src = "RegisterPage.js"></script>
	</body>
</html>