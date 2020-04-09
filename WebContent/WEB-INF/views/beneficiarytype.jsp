<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<c:url var="actionUrl" value="/savebeneficiary" />
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link href="${context}/resources/css/signup.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.css" >
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Beneficiary Type Page</title>
<style type="text/css">
  .AccountLabel{
      background-color: #3399B9;
	  font-size: 22px;
	  color:#fff;
  			}
  			.acntDetail{
  			font-size:22px;
  			padding-bottom: 2px;
  			}
  			.error{
  			color: red;
  			}
  </style>
</head>
<body>
	<!-- Adding beneficiary for within a bank/otherbank -->
	<%-- modelAttribute="userBean" method="POST" enctype="multipart/form-data"  id="registerForm" action="${actionUrl}" --%>
	<div class="container">
<div class="card bg-light text-dark">
<div class="card-body"><a href="${context}/loadaccount">Account Summary</a> 
    <a href="${context}/logout" style="position:absolute;right:0%;" ><i class="fa fa-sign-out"></i>Logout</a></div>
  </div><br>
    <div class="col-lg-12  AccountLabel">
   Add Benificiery
    </div>
	<div class="col-lg-12 customwell">
					 <form:form action="${actionUrl}" modelAttribute="beneficiary" method="POST" id="beneficiaryForm">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-3 form-group">
								<label><b>Beneficiary Nick Name</b></label>
								<form:input  path="beneficiaryNickName" placeholder="" class="form-control"></form:input>
								<form:errors path="beneficiaryNickName" cssClass="error" element="div" />
								<div class="fieldError" id="firstNameError"></div>
							</div>
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
							<div class="col-sm-2 form-group">
								<label><b>Beneficiary Name</b></label>
								<form:input  path="beneficiaryName" placeholder="" class="form-control" ></form:input>
								<form:errors path="beneficiaryName" cssClass="error" element="div" />
								<div class="fieldError" id="lastNameError"></div>
							</div>
							<div class="col-sm-1 form-group">
								<label></label>
							</div>	
							<div class="col-sm-3 form-group">
								<label><b>Beneficiary Acc Num</b></label>
								<form:input  path="benAccountNumber" placeholder="0" class="form-control" autocomplete="off"></form:input>
								<form:errors path="benAccountNumber" cssClass="error" element="div"></form:errors>
								<div id="dobError" class="error">${accountMissing}</div>
							</div>
							<div class="col-sm-3 form-group">
								<label></label>
							</div>	
						</div>
						</div>
						<div class="row">
					<div class="col-sm-12 form-group ">
					<label></label>
						<button type="button" class="btn btn-lg btn-warning" onclick="reset();" style="position: absolute;
    left: 45%;">Reset</button>
						<button type="submit" class="btn btn-lg btn-info" style="position: absolute;
    left: 53%;" onclick="return validate(event);">Add</button>
					</div>
						
					</div>
					<div class="row">
					<div class="col-sm-12 form-group ">
					</div><span></span></div>
						</form:form>
  </div>
</div>
<script type="text/javascript">
function reset(){
	alert("Reset called......");
		 $("#beneficiaryForm").trigger('reset');
}
function validate(e){
	alert("validating benefeciary........");
	var f=document.getElementById("beneficiaryForm");
	var hasNickNameError = validateNickName(f);
	var hasNameError = validateName(f);
	var hasAccountNumberError = validateAccountNumber(f);
	if(!hasNickNameError | !hasNameError | !hasAccountNumberError ){
	       e.preventDefault();
	       return false;
			}else{
				return true;}
}
function validateNickName(form){
	var error=document.getElementById("firstNameError");

	var nickName=form["beneficiaryNickName"].value;

	error.innerHTML="";

	if( nickName==null || nickName==""){
	error.innerHTML="Enter Your Nick Name";
	}

	else if(!isNaN(nickName)){
	error.innerHTML="Name Can Not be a number";
	}

	if(error.innerHTML.length > 0)
	return false;
	else
	return true;
}
function validateName(form){
	var error=document.getElementById("lastNameError");

	var nickName=form["beneficiaryName"].value;

	error.innerHTML="";

	if( nickName==null || nickName==""){
	error.innerHTML="Enter Your Beneficiary Name";
	}

	else if(!isNaN(nickName)){
	error.innerHTML="Beneficary Name Can Not be a number";
	}

	if(error.innerHTML.length > 0)
	return false;
	else
	return true;
}
//benAccountNumber
function validateAccountNumber(form){
	var error=document.getElementById("dobError");

	var nickName=form["benAccountNumber"].value;

	error.innerHTML="";

	if( nickName==null || nickName==""){
	error.innerHTML="Enter Your Beneficiary Account Number";
	}

	else if(isNaN(nickName)){
	error.innerHTML="Beneficary Accnt Number should be a number";
	}

	if(error.innerHTML.length > 0)
	return false;
	else
	return true;
}
</script>
</body>
</html>