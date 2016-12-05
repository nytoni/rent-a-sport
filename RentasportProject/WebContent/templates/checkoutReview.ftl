<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review Order</title>
    <link rel="stylesheet" href="./menu.css">
    <script>
       function message(){
        alert("Thank you for making a purchase with Rent-A-Sport! An email confirmation was sent.");   
       }
    </script>
</head>
<body>
<ul>
  <li><a href="./login.ftl">Login</a></li>
  <li><a href="./registration.ftl">Register</a></li>  
  <li><a href="./myAccount.ftl">My Account</a></li>
  <li><a href="./myCart.ftl">My Cart</a></li>
  <li><a href="./faq.ftl">FAQs</a></li>
    <li><a href="./browseBundle.ftl">Browse Bundles</a></li>
</ul>             
 
<h1>Review Order</h1>
<p></p> 
    
<form action="AccountServlet">

    <fieldset>
        <legend>Shipping</legend>
            <label>Name: </label>
            <br/>
            <label>Address: </label>
    </fieldset>
    
    <fieldset>
        <legend>Payment</legend>
            <label>Name: </label>
            <br/>
            <label>Billing Address: </label>
            <br/>
            <label>Credit Card Number: </label> 
             <br/>
            <label>Expiration Date: </label>  
             <br/>
            <label>Security Code: </label>
    </fieldset>

    <fieldset>
        <legend>Items</legend>
           
    </fieldset>
    
   <p>Total: $____</p>

<input type="Submit" value="Checkout" onclick="message();">


</form>
    
</body>
</html>