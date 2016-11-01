function checkFields() {
	var fieldOne, fieldTwo;
	var text;
	
//	var terrorMsg = document.getElementById("errorMsg");
//	terrorMsg.innerHTML = "hello";
//	return false;
	
	
	fieldOne = document.getElementById("email").value;
	fieldTwo = document.getElementById("password").value;
	
	
	var errorMsg = document.getElementById("errorMsg");

	
	if( isEmpty(fieldOne)){
		text = "Please enter your email address";
		errorMsg.innerHTML = text;
		return false;
	}
	if( isEmpty(fieldTwo)){
		text = "Please enter your password";
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