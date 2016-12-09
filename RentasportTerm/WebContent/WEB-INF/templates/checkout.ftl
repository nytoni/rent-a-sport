<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
    <link rel="stylesheet" href="./menu.css">
</head>
<body>
	
<ul>
  <li><a href="./login.html">Login</a></li>
  <li><a href="./registration.html">Register</a></li>  
  <li><a href="./myAccount.html">My Account</a></li>
  <li><a class="active" href="./#">My Cart</a></li>
   <li><a href="./login.html">logout</a></li>
  <li><a href="./faq.html">FAQs</a></li>
</ul>         
    
 
<h1>Checkout</h1>
<p></p> 
    
<form action="CartServlet">
	<input type ="hidden" name ="userId" value ="1001">
    <fieldset>
        <legend>Shipping</legend>
            <label>Name: </label>
            <input id="checkoutNameId" type="text" name="name">
               
            
    </fieldset>
    
     <fieldset>
        <legend>Payment:</legend>
           Credit Card: ${cc}
          <br> Address: ${addr}
      </fieldset>

<input type="Submit" name = "goToOrderpage" value="Continue">

</form>
    
</body>
</html>
