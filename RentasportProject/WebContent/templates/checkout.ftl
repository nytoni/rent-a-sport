<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
    <link rel="stylesheet" href="./menu.css">
</head>
<body>
<ul>
  <li><a href="./login.ftl">Login</a></li>
  <li><a href="./registration.ftl">Register</a></li>  
  <li><a href="./myAccount.ftl">My Account</a></li>
  <li><a class="active" href="./myCart.ftl">My Cart</a></li>
  <li><a href="./faq.ftl">FAQs</a></li>
</ul>         
    
 
<h1>Checkout</h1>
<p></p> 
    
<form action="AccountServlet">

    <fieldset>
        <legend>Shipping</legend>
            <label>Name: </label>
            <input id="checkoutNameId" type="text" name="name">
            <br/>    
            <label>Address: </label>
            <input id="checkoutAddressId" type="text" name="address">
    </fieldset>
    
     <fieldset>
        <legend>Payment</legend>
            <input id="currentCard" type="checkbox" name="">Current Card: ${cc}
    </fieldset>

<input type="Submit" value="Continue">

</form>
    
</body>
</html>