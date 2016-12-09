<!DOCTYPE html>
	<html>
		<head>
			<title>Review Orders</title>
		</head>
		<body>
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
					<li> Quantity: ${orderItem.quantity}</li>
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
