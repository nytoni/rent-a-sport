<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Account</title>
    <link rel="stylesheet" href="./menu.css">
</head>
<body>
    
<ul>
  <li><a href="./login.ftl">Login</a></li>
  <li><a href="./registration.ftl">Register</a></li>  
  <li><a href="./myAccount.ftl">My Account</a></li>
  <li><a href="./myCart.ftl">My Cart</a></li>
  <li><a href="./faq.ftl">FAQs</a></li>
</ul>         
    
 
<h1>Edit Account Information</h1>
<p></p> 
    
<form action="UserServlet" method="post">
    <fieldset>
        <legend>Change Password</legend>      
            <label>Old Password: </label>
            <input type="password" name="password" id="oldPassId" placeholder="Enter Password"/><br/>
            <label>New Password: </label>
            <input type="password" name="password" id="newPassId" placeholder="Enter Password"/><br/>
            <label>Confirm Password: </label>
            <input type="password" name="password" id="confirmPassId" placeholder="Enter Password"/><br/>
        
    <input type="Submit" value="Change">
    </fieldset>
</form>
    
<form action="AccountServlet" method="post">
   <fieldset>
        <legend>Payment</legend>       
            <label>Name: </label>
            <input id="checkoutNameId" type="text" name="name">   
            <label>Billing Address: </label>
            <input id="billAddressId" type="text" name="billingAddress">
            <br/>
            <label>Credit Card Number: </label>
            <input id="checkoutNameId" type="text" name="name">   
             <br/>
            <label>Expiration Date: </label>
            <input id="expireDate" type="date" name="expireDate">  
             <br/>
            <label>Security Code: </label>
            <input id="secureCode" type="text" name="secureCode">
            <br/>
       
    <input type="Submit" value="Change">
    </fieldset> 
</form>
    
    <button href="./browseBundle.ftl">Cancel</button>
    
</body>
</html>