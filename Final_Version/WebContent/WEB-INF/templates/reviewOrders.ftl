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
  <li><a href="./myCart.ftl">My Cart</a></li>
  <li><a href="faq.html">FAQs</a></li>
  <li><a href="./browseBundle.ftl">Browse Bundles</a></li>
</ul>         
    
 <em><h2>Current Orders</h2></em>
			 <h4>User ID: ${userId?c}</h4>
			</br>
			<form action = "RemoveOrderServlet" method = "post">
				<input type ="hidden" name = "userId" value = ${userId?c}>
				<#list myOrders as orderItem>
			
					<input type = "radio" name = "radio" value = "${orderItem.orderNum?c}">Item Details:
					<ul>
					<li>Ship Date: ${orderItem.shipDate}</li>
					<li>Price: ${orderItem.price}</li>
					<li> Condition: ${orderItem.conditionStat}</li>
					<li> Due Date: ${orderItem.dueDate}</li>
					<li> Order Status:${orderItem.orderStatus}</li>
					</ul>
					
				</#list>
				</br></br>
				<input type = "Submit" value ="Delete Order">
</form>
</body>
</html>