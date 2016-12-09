<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review Orders</title>
    <link rel="stylesheet" href="./menu.css">
    <script>
    function cancelOrderPop(){
     var mssg;
        if(confirm("Are you sure you want to cancel this order?")==true)
        {mssg="This order has been cancelled!";}
        else{
            mssg="You pressed cancel.";
        }
        alert(mssg);  
    }
    function cancelItemPop(){
     alert('This Item has been cancelled!');  
    }
    </script>
</head>
<body>
    
<ul id="menu">
  <li><a href="./login.html">Logout</a></li>
  <li><a href="./registration.html">Register</a></li>  
  <li><a href="myAccount.html">My Account</a></li>
  <li><a href="#">My Cart</a></li>
  <li><a href="faq.html">FAQs</a></li>
  <li><a href="./browseBundle.ftl">Browse Bundles</a></li>
</ul>         
    
 
<h1>View Only Current Order</h1>
<h1>Order #: </h1>
    
<form action="OrdersServlet" method="post">
     <input type="radio" name="toBeModified" value="item1">Item 1: 
            <ul>
            <ol>Ship Date:__</ol>
            <ol>Estimated Arrival:__ </ol>
            <ol>Price:__ </ol>
            <ol>Status:__ </ol>
            <ol>Due Date:__ </ol>
            </ul>
    <input type="radio" name="toBeModified" value="item2">Item 2:
            <ul>
            <ol>Ship Date:__</ol>
            <ol>Estimated Arrival:__ </ol>
            <ol>Price:__ </ol>
            <ol>Status:__ </ol>
            <ol>Due Date:__ </ol>
            </ul>
    <input type="submit" value="Cancel Order" onclick="cancelOrderPop()">
    <input type="submit" value="Cancel Item" onclick="cancelItemPop()"> 
</form>
    
</body>
</html>
