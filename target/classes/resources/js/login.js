function verifyCredential(e){
	var username = $("#").val();
	var password = $("#").val();
	if(username.length ==0 || password.length ==0){
		alert("Username or Password cannot be empty");
		 e.preventDefault();
	}
}