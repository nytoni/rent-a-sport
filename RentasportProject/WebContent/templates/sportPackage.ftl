<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Account</title>
    <link rel="stylesheet" href="./menu.css">
     <script>
       function message(){
        alert("This item has been added to your cart!");   
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
    <li><a class="active" href="./browseBundle.ftl">Browse Bundles</a></li>
</ul>         
    
 
<h1>Sport Package:___Football</h1>

<img src="http://media.staps.nantes.free.fr/L3EM_G1/David/res/L-equipement-d-un-joueur.jpg" style="width:20%">
    
<form autocomplete="on" action="./CartServlet" method="post">
<div class="tbl">
<ul class="rentTable">
    <li>Rental Duration</li>
    <li><input type="radio" name="rentDuration" value="wk1" checked>1 Week<br/>
    <input type="radio" name="rentDuration" value="wk2">2 Weeks<br/>
    <input type="radio" name="rentDuration" value="mnth1">1 Month<br/>
    <input type="radio" name="rentDuration" value="mnth3">3 Months<br/>
    <input type="radio" name="rentDuration" value="mnth6">6 Months</li>
    <li>Quantity:<input type="number" name="quantity" min="1" max="10" required></li>
    <li><input type="submit" onclick="message();"value="Add to Cart"/></li>
</ul>
    </div>
</form>
    
<h2>Includes: </h2>   
    
<p>...description...(items in Bundle table)</p>
    
</body>
</html>