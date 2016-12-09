<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Browse Bundle</title>
<link rel="stylesheet" href="./menu.css">
</head>
<body>

	<ul id="menu">
		<li><a href="./login.html">Login</a></li>
		<li><a href="#">Register</a></li>
		<form id = "account-form" action = "generateEditAccountServlet" method = "post">
			<li onclick= "document.forms['account-form'].submit();">My Account
				<!-- <a href="./myAccount.ftl">My Account</a> -->
				<input type="hidden" name = "userId" value="${currentUser.userId?c}">
			</li>
		 </form> 
		
		<li><a href="./CartServlet?userId=${currentUser.userId?c}">My Cart</a></li>
		

		<li><a href="faq.html">FAQs</a></li>
		<li><a class="active" href="./browseBundle.ftl">Browse
				Bundles</a></li>
	</ul>

	<h1>Bundle Types </h1>
	<h2>User: ${currentUser.name} </h2>
	<h2>Customer Id: ${currentUser.userId?c} </h2>
	<div class="row">
		<form action="BundlesServlet" id="camping">
			<div class="column">
				<img src="https://qmkit.co.uk/729/425.jpg" style="width: 100%"
					onClick="document.forms['camping'].submit();"> <input
					type="hidden" name="action" value="camping">
				<p>Camping</p>
			</div>
			<input type="hidden" name="userId" value="${currentUser.userId?c}">
		</form>

		<form action="BundlesServlet" id="baseball">
			<div class="column">
				<img src="http://www.arseventsusa.com/assets/baseball_equpiment.jpg"
					style="width: 100%" onClick="document.forms['baseball'].submit();">
				<input type="hidden" name="action" value="baseball">
				<p>Baseball</p>
			</div>
			<input type="hidden" name="userId" value="${currentUser.userId?c}">
		</form>

		
	</div>
	
	<form action="BundlesServlet" id="football" method="POST">
			<div class="column">
				<img
					src="http://media.staps.nantes.free.fr/L3EM_G1/David/res/L-equipement-d-un-joueur.jpg"
					style="width: 100%" onClick="document.forms['football'].submit();">
				<input type="hidden" name="action" value="football">
				<p>Football</p>
			</div>
			<input type="hidden" name="userId" value="${currentUser.userId?c}">
		</form>


	<div class="row">
		<form action="BundlesServlet" id="soccer">
			<div class="column">
				<img
					src="https://www.3qsports.co.uk/userfiles/lg_images/Mitre_Football_Training_Pack_Clearance-CI9ixi.jpg"
					style="width: 100%" onClick="document.forms['soccer'].submit();">
				<input type="hidden" name="action" value="soccer">
				<p>Soccer</p>
			</div>
			<input type="hidden" name="userId" value="${currentUser.userId?c}">
		</form>

		<form action="BundlesServlet" id="volleyball">
			<div class="column">
				<img
					src="http://www.kbacoach.com/images/promo/2/kba_volleyball_banner.jpg"
					style="width: 100%"
					onClick="document.forms['volleyball'].submit();"> <input
					type="hidden" name="action" value="volleyball">
				<p>Volleyball</p>
			</div>
			<input type="hidden" name="userId" value="${currentUser.userId?c}">
		</form>

		<div class="column">
			<a href="#"> <img
				src="http://www.fashionreturns.com/coming_soon.jpg"
				style="width: 100%">
			</a>
			<p>Gymnastics/Aerial Dance</p>
		</div>
	</div>

</body>
</html>