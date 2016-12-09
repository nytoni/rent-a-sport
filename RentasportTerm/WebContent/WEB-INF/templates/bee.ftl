<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./menu.css">
</head>
<body>

<ul id="menu">
  <li><a class="active" href="./login.html">Log Out</a></li>
  <li><a href="registration.html">Register</a></li>  
  <li><a href="myAccount.html>My Account</a></li>
  <li><a href="./CartServlet?userId=${c.customerId}">My Cart</a></li>
  <li><a href="faq.html">FAQs</a></li>
</ul>     

Items Added to cart

<#list toCart as c>
<p>Customer Id: ${c.customerId} </p>
<p>Bundle Name: ${c.bundleName} </p>
<p>Quantity: ${c.quantity} </p>
<p>Rental Duration: ${c.time} </p>
<br>
</#list>


<h3>THANK YOU FOR USING RENT-A-SPORT</h3>
<h5>Your order will arrive in the mail</h5>
<a href="login.html">Log Out</a> 
</body>
</html>
