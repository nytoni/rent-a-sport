<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Account</title>
    <link rel="stylesheet" href="./menu.css">
</head>
<body>
    
<ul id="menu">
  <li><a href="./login.html">Login</a></li>
  <li><a href="registration.html">Register</a></li>  
  <li><a href="myAccount.html">My Account</a></li>
  <li><a href="./#">My Cart</a></li>
  <li><a href="faq.html">FAQs</a></li>
</ul>         
    
 
<h1>Edit Account Information</h1>
<p></p> 
    
<form action="EditAccount" method="post">
    <fieldset>
        <legend>Change Password</legend>      
            <label>Old Password: </label>
            <input type="password" name="oldPassId" id="oldPassId" placeholder="Enter Password"/><br/>
            <label>New Password: </label>
            <input type="password" name="newPassId" id="newPassId" placeholder="Enter Password"/><br/>
            <label>Confirm Password: </label>
            <input type="password" name="confirmPassId" id="confirmPassId" placeholder="Enter Password"/><br/>
        	<input type="hidden" name = "userId" value = "${currentUser.userId?c}">
    <input type="Submit" value="Change">
    </fieldset>
</form>
    
<form action="AccountServlet" method="post">
   <fieldset>
        <legend>Payment</legend>       
            <label>Name: </label>
            <input id="checkoutNameId" type="text" name="checkoutNameId">   
            <label>Billing Address: </label>
            <input id="billAddressId" type="text" name="billingAddressId">
            <br/>
            <label>Shipping Address: </label>
            <input id="shippingAddressId" type = "text" name = "shippingAddressId">
            <label>Credit Card Number: </label>
            <input id="checkoutNameId" type="text" name="creditCardNumber">   
             <br/>
            <label>Expiration Date: </label>
            <input id="expireDate" type="date" name="expireDate">  
             <br/>
            <label>Security Code: </label>
            <input id="secureCode" type="text" name="secureCode">
            <br/>
            <input type="hidden" name = "userId" value = "${currentUser.userId?c}">
       
    <input type="Submit" value="Change">
    </fieldset> 
</form>
    
    <button href="./browseBundle.ftl">Cancel</button>
    
</body>
</html>