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
    
 <form id = "cart-form" action = "CartServlet" method = "post">
    <li onclick = "document.forms['cart-form'].submit();"><!-- <a href="./myCart.ftl"> -->My Cart<!-- </a> -->
        <input type = "hidden" value ="${currentUser.userId}" >
    </li>
  </form>    
    
  <li><a href="./faq.ftl">FAQs</a></li>
  <li><a class="active" href="./browseBundle.ftl">Browse Bundles</a></li>
  <li><a href="./login.ftl">Logout</a></li>
</ul>         
    
 
<h1>Bundle Types</h1>

   
<div class="row">
<form action="BundlesServlet"> 
  <div class="column">
    <a href="./sportPackage.ftl">
        <img src="https://qmkit.co.uk/729/425.jpg" style="width:100%">
        <input type="hidden" name="action" value="camping">
      </a>
      <p>Camping</p>
  </div>
  <input type = "hidden" name = "userId" value = "${currentUser.userId}">
</form> 
<form action="BundlesServlet"> 
 <div class="column">
     <a href="./sportPackage.ftl"><img src="http://www.arseventsusa.com/assets/baseball_equpiment.jpg" style="width:100%"><input type="hidden" name="action" value="baseball"></a>
     <p>Baseball</p>
  </div> 
    <input type = "hidden" name = "userId" value = "${currentUser.userId}">
    </form>
    <form action="BundlesServlet"> 
<div class="column">
    <a href="./sportPackage.ftl"><img src="http://media.staps.nantes.free.fr/L3EM_G1/David/res/L-equipement-d-un-joueur.jpg" style="width:100%">
        <input type="hidden" name="action" value="football"></a>
    <p>Football</p>
  </div>
        <input type = "hidden" name = "userId" value = "${currentUser.userId}">
    </form>
</div>
    
<div class="row">
    <form action="BundlesServlet"> 
  <div class="column">
    <a href="./sportPackage.ftl">
    <img src="https://www.3qsports.co.uk/userfiles/lg_images/Mitre_Football_Training_Pack_Clearance-CI9ixi.jpg" style="width:100%">
     <input type="hidden" name="action" value="soccer">
      </a>
      <p>Soccer</p>
        </div>
        <input type = "hidden" name = "userId" value = "${currentUser.userId}">
    </form>
    <form action="BundlesServlet"> 
 <div class="column">
     <a href="./sportPackage.ftl">
    <img src="http://www.kbacoach.com/images/promo/2/kba_volleyball_banner.jpg" style="width:100%">
    <input type="hidden" name="action" value="volleyball">
     </a>
     <p>Volleyball</p>
  </div> 
        <input type = "hidden" name = "userId" value = "${currentUser.userId}">
    </form>
    <form action="BundlesServlet"> 
<div class="column">
    <a href="#">
    <img src="http://www.fashionreturns.com/coming_soon.jpg" style="width:100%">
    </a>
    <p>Gymnastics/Aerial Dance</p>
  </div> 
    </form>
</div>
 
    
</body>
</html>