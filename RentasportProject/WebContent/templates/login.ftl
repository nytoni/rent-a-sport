<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
    <link rel="stylesheet" href="./menu.css">
</head>
<body>
<ul>
  <li><a class="active" href="./login.ftl">Login</a></li>
  <li><a href="./registration.ftl">Register</a></li>  
  <li><a href="./myAccount.ftl">My Account</a></li>
  <li><a href="./myCart.ftl">My Cart</a></li>
  <li><a href="./faq.ftl">FAQs</a></li>
</ul>         
    
<center> 
<h1>Sign-In</h1>
<p>Sign in with your username (email) and password</p> 
    
<form action="UserServlet">
<label>Username: </label>
    <input type="text" name="username" id="loginUserId" placeholder="Enter Email"/><br/>
<label>Password: </label>
    <input type="password" name="password" id="loginPassId" placeholder="Enter Password"/><br/>
    
<input type="Submit" value="Login">
</form>
    
<br/>    
<a href="./registration.ftl">Create Account</a> 
    
</center>
</body>
</html>


<!--

<div class="bruh">
    <ul>
        <li><a class="button" href="./home">Register</a></li>
        <li><a class="button" href="./home">Login</a></li>
        <li><a class="button" href="./home">Something</a></li>
    </ul>    
    </div>

-->