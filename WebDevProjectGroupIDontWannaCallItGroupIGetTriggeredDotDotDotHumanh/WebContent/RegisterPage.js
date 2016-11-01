function checkFields() {
	var fieldOne, fieldTwo, fieldThree, fieldFour;
	var text;
	
//	var terrorMsg = document.getElementById("errorMsg");
//	terrorMsg.innerHTML = "hello";
//	return false;
	
	
	fieldOne = document.getElementById("name").value;
	fieldTwo = document.getElementById("email").value;
	fieldThree = document.getElementById("password").value;
	fieldFour = document.getElementById("confirmPassword").value;
	
	var errorMsg = document.getElementById("errorMsg");

	
	if( isEmpty(fieldOne)){
		text = "No Name";
		errorMsg.innerHTML = text;
		return false;
	}
	if( isEmpty(fieldTwo)){
		text = "Please enter a valid email address";
		errorMsg.innerHTML = text;
		return false;
	}
	if( isEmpty(fieldThree)){
		text = "Please enter a password";
		errorMsg.innerHTML = text;
		return false;
	}
	if( isEmpty(fieldFour)){
		text = "Confirm password";
		errorMsg.innerHTML = text;
		return false;
	}
	
	if (fieldThree != fieldFour){
		text = "Passwords not identical";
		errorMsg.innerHTML = text;
		return false;
	}
	
	
	/*
	if ( !isEmpty(fieldOne) && !isEmpty(fieldTwo) && !isEmpty(fieldThree)){
		text = "Processing...";
		document.getElementById("reply").innerHTML = text;
	}
	else {
		text = "Empty fields. Please do not leave fields blank";
		document.getElementById("reply").innerHTML = text;
	}
	
	*/

}

function isEmpty(str) {
	return (!str || 0 === str.length);
}