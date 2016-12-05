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
  //reference
  
  <form id = "cart-form" action = "CartServlet" method = "post">
    <li onclick = "document.forms['cart-form'].submit();"><!-- <a href="./myCart.ftl"> -->My Cart<!-- </a> -->
        <input type = "hidden" value = "${customer.customerId}">
    </li>
    
  </form>
  
  <li><a href="./faq.ftl">FAQs</a></li>
  <li><a class="active" href="./browseBundle.ftl">Browse Bundles</a></li>
  <li><a href="./login.ftl">Logout</a></li>
</ul>         
    
 
<h1>Bundle Types</h1>

<div class="row">
  <div class="column">
    <a href="./sportPackage.ftl">
        <img src="https://qmkit.co.uk/729/425.jpg" style="width:100%">
      </a>
      <p>Camping</p>
  </div>
 <div class="column">
     <a href="./sportPackage.ftl"><img src="http://www.arseventsusa.com/assets/baseball_equpiment.jpg" style="width:100%"></a>
     <p>Baseball</p>
  </div> 
<div class="column">
    <a href="./sportPackage.ftl"><img src="http://media.staps.nantes.free.fr/L3EM_G1/David/res/L-equipement-d-un-joueur.jpg" style="width:100%"></a>
    <p>Football</p>
  </div> 
</div>
    
<div class="row">
  <div class="column">
    <a href="./sportPackage.ftl">
    <img src="https://www.3qsports.co.uk/userfiles/lg_images/Mitre_Football_Training_Pack_Clearance-CI9ixi.jpg" style="width:100%">
      </a>
      <p>Soccer</p>
        </div>
 <div class="column">
     <a href="./sportPackage.ftl">
    <img src="http://www.kbacoach.com/images/promo/2/kba_volleyball_banner.jpg" style="width:100%">
     </a>
     <p>Volleyball</p>
  </div> 
<div class="column">
    <a href="#">
    <img src="http://www.fashionreturns.com/coming_soon.jpg" style="width:100%">
    </a>
    <p>Gymnastics/Aerial Dance</p>
  </div> 
</div>
    
    
</body>
</html>
