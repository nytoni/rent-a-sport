<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
    <link rel="stylesheet" href="./menu.css">
</head>
<body>
<ul>
  <li><a href="./login.ftl">Login</a></li>
  <li><a href="./registration.ftl">Register</a></li>  
  <li><a href="./myAccount.ftl">My Account</a></li>
    <li><a class="active" href="./myCart.ftl">My Cart</a></li>
  <li><a href="./faq.ftl">FAQs</a></li>
   <li><a href="./browseBundle.ftl">Browse Bundles</a></li>
</ul>         
    
 
<h1>My Cart</h1>
<p></p> 
    
<form action="UserServlet">
<a href="./registration.ftl">Remove</a> 

    <fieldset>
            <input id="speedId" type="checkbox" value="item1">Item
            
            <label>Quanitity: </label>
            <input id="quanitityId" type="text" name="quantity1" value="defaultValue">
        
            <label>Price: </label>
    </fieldset>
    
     <fieldset>
            <input id="speedId" type="checkbox" value="item2">Item
            
            <label>Quanitity: </label>
            <input id="quanitityId" type="text" name="quantity2" value="defaultValue">
        
            <label>Price: </label>
    </fieldset>
    
    
<p>There are ___ items in cart. Subtotal:___</p>

    
<input type="Submit" value="Update">
<input type="Submit" value="Checkout">

</form>
    
</body>
</html>