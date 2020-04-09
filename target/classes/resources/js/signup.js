function validate(e){
	alert("Going to save User Details.");
	//e.preventDefault();
	var f=document.getElementById("registerForm");
	var hasEmailError = validateEmail(f);
	var hasFirstNameError = firstNameValidate(f);
	var hasLastNameError = lastNameValidate(f);
	var hasDobError = dobValidate(f);
	var hasAddress1Error = address1Validate(f);
	var hasAddress2Error = address2Validate(f);
	var hasCityError = cityValidate(f);
	var hasStateError = stateValidate(f);
	var hasPinCodeError = pinCodeValidate(f);
	var hasMobileNumberError = mobileNumberValidate(f);
	var hasUserNameError = userNameValidate(f);
	var hasAadharError = aadharValidate(f);
	var hasPanError = panValidate(f);
	var hasPasswordError = passwordValidate(f);
	var hasCnfPasswordError = confirmPasswordValidate(f);
	var hasPanProofError = panProofValidate(f);
	var hasAddressProofError = addressProofValidate(f);
	var hasAadharProofError = aadharProofValidate(f);
	var hasBirthProofError = birthProofValidate(f);
	
	if(!hasEmailError || !hasFirstNameError || !hasLastNameError || !hasAddress1Error || !hasAddress2Error || !hasCityError || !hasCityError || !hasStateError
			|| !hasPinCodeError || !hasMobileNumberError|| !hasUserNameError|| !hasAadharError|| !hasPanError|| !hasPasswordError|| !hasCnfPasswordError|| !hasPanProofError
			|| !hasAddressProofError|| !hasAadharProofError|| !hasBirthProofError){
	       e.preventDefault();
	       return false;
			}else{
				return true;}
}
function validateEmail(form){
	var error=document.getElementById("emailError");
	error.innerHTML="";
	var email=form["email"].value;	
	var regx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

	if( email==null || email==""){
	error.innerHTML="Enter Your Email";
	}

	else if(!email.match(regx)){
	error.innerHTML="Invalid Email";
	}
	if(error.innerHTML.length > 0)
	return false;
	else
	return true;
	}

function firstNameValidate(form){
	var error=document.getElementById("firstNameError");

	var firstName=form["firstName"].value;

	error.innerHTML="";

	if( firstName==null || firstName==""){
	error.innerHTML="Enter Your FirstName";
	}

	else if(!isNaN(id)){
	error.innerHTML="Name Can Not be a number";
	}

	else if(firstName.length<5 || firstName.length>10){
	error.innerHTML="Name has to be 5 to 10 chars"
	}

	if(error.innerHTML.length > 0)
	return false;
	else
	return true;
	}
function lastNameValidate(form){
	var error=document.getElementById("lastNameError");

	var firstName=form["lastName"].value;

	error.innerHTML="";

	if( firstName==null || firstName==""){
	error.innerHTML="Enter Your LastName";
	}

	else if(!isNaN(id)){
	error.innerHTML="Name Can Not be a number";
	}

	else if(firstName.length<5 || firstName.length>10){
	error.innerHTML="Name has to be 5 to 10 chars"
	}

	if(error.innerHTML.length > 0)
	return false;
	else
	return true;
	}

function dobValidate(form){
	var error=document.getElementById("dobError");

	var dob=form["dob"].value;

	error.innerHTML="";

	if( dob==null || dob==""){
	error.innerHTML="Date of Birth cannot be Blank";}
	if(error.innerHTML.length > 0)
		return false;
		else
		return true;
}
	function address1Validate(form){
		var error=document.getElementById("address1Error");

		var address=form["address1"].value;

		error.innerHTML="";

		if( address==null || address==""){
		error.innerHTML="Input Your Address";
		}

		else if(!isNaN(id)){
		error.innerHTML="Address Can Not be a number";
		}

		else if(address.length<5 || address.length>10){
		error.innerHTML="Address has to be 5 to 10 chars"
		}       
		if(error.innerHTML.length > 0)
		return false;
		else
		return true;
		}
	function address2Validate(form){
		var error=document.getElementById("address2Error");

		var address=form["address2"].value;

		error.innerHTML="";

		if( address==null || address==""){
		error.innerHTML="Enter Your Address";
		}

		else if(!isNaN(id)){
		error.innerHTML="Address Can Not be a number";
		}

		else if(address.length<5 || address.length>10){
		error.innerHTML="Address has to be 5 to 10 chars"
		}       
		if(error.innerHTML.length > 0)
		return false;
		else
		return true;
		}
	function cityValidate(form){
		var error=document.getElementById("cityError");

		var firstName=form["city"].value;

		error.innerHTML="";

		if( firstName==null || firstName==""){
		error.innerHTML="Enter Your City you are living";
		}

		else if(!isNaN(id)){
		error.innerHTML="City Can Not be a number";
		}

		else if(firstName.length<5 || firstName.length>10){
		error.innerHTML="City has to be 3 to 30 chars"
		}

		if(error.innerHTML.length > 0)
		return false;
		else
		return true;
		}
	function stateValidate(form){
		var error=document.getElementById("stateError");

		var firstName=form["state"].value;

		error.innerHTML="";

		if( firstName==null || firstName==""){
		error.innerHTML="Enter Your Sate you are living";
		}

		else if(!isNaN(id)){
		error.innerHTML="State Can Not be a number";
		}

		else if(firstName.length<5 || firstName.length>10){
		error.innerHTML="State has to be 3 to 30 chars"
		}

		if(error.innerHTML.length > 0)
		return false;
		else
		return true;
		}
	function pinCodeValidate(form){
		var error=document.getElementById("pinCodeError");

		var firstName=form["pinCode"].value;

		error.innerHTML="";

		if( firstName==null || firstName==""){
		error.innerHTML="Pincode cannot be Blank";
		}

		else if(isNaN(id)){
		error.innerHTML="Pincode Can Not be a text";
		}

		else if(firstName.length<5 || firstName.length>10){
		error.innerHTML="Pincode has to be minimum 5 chars"
		}

		if(error.innerHTML.length > 0)
		return false;
		else
		return true;
		}
	function mobileNumberValidate(form){
		var error=document.getElementById("mobileNumberError");

		var firstName=form["mobileNumber"].value;

		error.innerHTML="";

		if( firstName==null || firstName==""){
		error.innerHTML="mobileNumber cannot be Blank";
		}

		else if(isNaN(id)){
		error.innerHTML="mobileNumber Can Not be a text";
		}

		else if(firstName.length!=10){
		error.innerHTML="mobileNumber has to be of 10 chars"
		}

		if(error.innerHTML.length > 0)
		return false;
		else
		return true;
		}
	function aadharValidate(form){
		var error=document.getElementById("aadharError");

		var aadhar=form["aadhar"].value;

		error.innerHTML="";

		if( aadhar==null || aadhar==""){
		error.innerHTML="Aadhar cannot be Blank";
		}

		else if(isNaN(aadhar)){
		error.innerHTML="Aadhar Can Not be a text";
		}

		else if(aadhar.length!=10){
		error.innerHTML="Aadhar has to be of 10 chars"
		}

		if(error.innerHTML.length > 0)
		return false;
		else
		return true;
		}
	function panValidate(form){
		var error=document.getElementById("panError");

		var pan=form["pan"].value;

		error.innerHTML="";

		if( pan==null || pan==""){
		error.innerHTML="pan cannot be Blank";
		}

		else if(!isNaN(pan)){
		error.innerHTML="pan Can Not be a Number";
		}

		else if(pan.length > 0 || pan.length < 11){
		error.innerHTML="pan has to be of 10 chars"
		}

		if(error.innerHTML.length > 0)
		return false;
		else
		return true;
		}
	function userNameValidate(form){
		var error=document.getElementById("userNameError");

		var userName=form["userName"].value;

		error.innerHTML="";

		if( userName==null || userName==""){
		error.innerHTML="userName cannot be Blank";
		}

		else if(!isNaN(userName)){
		error.innerHTML="userName Can Not be a Number";
		}

		else if(userName.length < 5){
		error.innerHTML="pan has to be greater than 5 chars"
		}

		if(error.innerHTML.length > 0)
		return false;
		else
		return true;
		}
	function passwordValidate(form){
		var error=document.getElementById("passwordError");

		var password=form["password"].value;
		var lowerCaseLetters = /[a-z]/g;
		var upperCaseLetters = /[A-Z]/g;
		var numbers = /[0-9]/g;
		error.innerHTML="";

		if( password==null || password==""){
		error.innerHTML="password cannot be Blank";
		}
		else if(password.value.match(lowerCaseLetters) && password.value.match(upperCaseLetters) && password.value.match(numbers)){
		error.innerHTML="Password Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
		}

		if(error.innerHTML.length > 0)
		return false;
		else
		return true;
		}
	function confirmPasswordValidate(form){
		var error=document.getElementById("confirmPasswordError");
		var password=form["password"].value;
		var cnfPassword=form["confirmPassword"].value;
		error.innerHTML="";

		if( password==null || password==""){
		error.innerHTML="password cannot be Blank";
		}
		else if(password !=cnfPassword){
		error.innerHTML="Password Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
		}
		else{
        error.innerHTML="Password Matched"
			}

		if(error.innerHTML.length > 0)
		return false;
		else
		return true;
		}
	function birthProofValidate(form){
		var error=document.getElementById("dobProofError");
		var dobProof=form["dobProof"].value;
		error.innerHTML="";

		if( dobProof==null || dobProof==""){
		error.innerHTML="Date of Birth Support Document is Required";
		}
		else{
		var ext = dobProof.val().split('.').pop().toLowerCase();
		if($.inArray(ext, ['pdf','jpg','jpeg']) == -1) {
		    alert('invalid extension!');
		    error.innerHTML="Uploaded Only PDF,JPG,JPEG Documents";
		}
		}
		}
	function aadharProofValidate(form){
		var error=document.getElementById("aadharProofError");
		var dobProof=form["aadharProof"].value;
		error.innerHTML="";

		if( dobProof==null || dobProof==""){
		error.innerHTML="Aadhar Support Document is Required";
		}
		else{
		var ext = dobProof.val().split('.').pop().toLowerCase();
		if($.inArray(ext, ['pdf','jpg','jpeg']) == -1) {
		    alert('invalid extension!');
		    error.innerHTML="Uploaded Only PDF,JPG,JPEG Documents";
		}
		}
		}
	function addressProofValidate(form){
		var error=document.getElementById("addressProofError");
		var dobProof=form["addressProof"].value;
		error.innerHTML="";

		if( dobProof==null || dobProof==""){
		error.innerHTML="Address proof Support Document is Required";
		}
		else{
		var ext = dobProof.val().split('.').pop().toLowerCase();
		if($.inArray(ext, ['pdf','jpg','jpeg']) == -1) {
		    alert('invalid extension!');
		    error.innerHTML="Uploaded Only PDF,JPG,JPEG Documents";
		}
		}
		}
	function panProofValidate(form){
		var error=document.getElementById("panProofError");
		var dobProof=form["panProof"].value;
		error.innerHTML="";

		if( dobProof==null || dobProof==""){
		error.innerHTML="Date of Birth Support Document is Required";
		}
		else{
		var ext = dobProof.val().split('.').pop().toLowerCase();
		if($.inArray(ext, ['pdf','jpg','jpeg']) == -1) {
		    alert('invalid extension!');
		    error.innerHTML="Uploaded Only PDF,JPG,JPEG Documents";
		}
		}
		}
	function resetUser(){
		 $("#registerForm").trigger('reset');
	}