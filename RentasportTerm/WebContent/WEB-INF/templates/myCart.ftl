<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
    <link rel="stylesheet" href="./menu.css">
</head>
<body>
<ul>
  <li><a href="./login.html">Log Out</a></li>
  <li><a href="#">Register</a></li>  
  <li><a href="./myAccount.ftl">My Account</a></li>
  <li><a class="active" href="#">My Cart</a></li>
  <li><a href="./faq.html">FAQs</a></li>
</ul>         
    
 
<h1>My Cart</h1>
<p></p> 
    
<form action="CartSevlet" id = "HEY" method = "get">
<a href="registration.html">Remove</a> 

  
    <#list items as item >
    	<fieldset>
            <input id = "button" name ="${item.bundleName}" type="checkbox" value="item1">     
             ${item.bundleName} Quantity: ${item.quantity} Time:${item.time Price: ${item.price}
   	 </fieldset>
   	 </#list>
    
    
<p>There are ${totalItems} items in cart. Subtotal:$ {totprice}</p>

    
<input type="Submit" value="Update" name = "update1">
<input type="Submit" value="Checkout" name = "checkout1">

</form>
    
</body>
</html>