<meta charset="ISO-8859-1">
<title>Review Order</title>
    <link rel="stylesheet" href="./menu.css">
</head>
<body>
<ul>
  <li><a href="./login.html">Login</a></li>
  <li><a href="./registration.html">Register</a></li>  
  <li><a href="./myAccount.html">My Account</a></li>
  <li><a href="#">My Cart</a></li>
   <li><a href="./login.html">logout</a></li>
  <li><a href="./faq.html">FAQs</a></li>
</ul>         
    
 
<h1>Review Order</h1>
<p></p> 
    
<form action="CartServlet">

    <fieldset>
        <legend>Shipping</legend>
            <label>Name: ${names} </label>
            <br/>
            <label>Address: ${sa} </label>
    </fieldset>
    
    <fieldset>
        <legend>Payment</legend>
            <label>Name: ${names}</label>
            <br/>
            <label>Billing Address: ${ba} </label>
            <br/>
            <label>Credit Card Number: ${cc} </label> 
             <br/>
            <label>Expiration Date: ${ed}</label>  
             <br/>
        
    </fieldset>

    <fieldset>
        <legend>Items:
        	<#list items as item>
        		${item.bundleName} quantity: ${item.quantity}
        	</#list>
        </legend>
           
    </fieldset>
    
   <p>Total: $ ${totprice}</p>

<input type="Submit" name ="submitOrder" value="Checkout">


</form>
    
</body>
</html>
