<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./menu.css">
</head>
<body>
Items Added to cart

<#list toCart as c>
<p>Customer Id: ${c.customerId} </p><br>
<p>Bundle Name: ${c.bundleName} </p><br>
<p>Quantity: ${c.quantity} </p><br>
<p>Rental Duration: ${c.time} </p><br>
</#list>

</body>
</html>