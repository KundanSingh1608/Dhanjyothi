<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
	<c:url var="actionUrl" value="/transferamt" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link href="${context}/resources/css/signup.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Transfer Page</title>
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
  			label{
  			font-weight: bold;
  			}
  </style>
  </head>
  <body>
<!-- 			Fund Transfer Page......... -->
<%-- modelAttribute="userBean" method="POST" enctype="multipart/form-data"  id="registerForm" action="${actionUrl}" --%>
	<div class="container">
<div class="card bg-light text-dark">
<div class="card-body"><a href="${context}/loadaccount">Account Summary</a>&ensp;/&ensp;<a href="${context}/loadbeneficiary">Add Benificiery</a> 
    <a href="${context}/logout" style="position:absolute;right:0%;" >Logout</a></div>
  </div><br>
    <div class="col-lg-12  AccountLabel">
   Fund Transfer
    </div>
	<div class="col-lg-12 customwell">
					<form:form method="POST" modelAttribute="transaction" action="${actionUrl}" id="transferForm">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-2 form-group">
								<label>Beneficiaries</label><br>
								<form:select  path="benefeciaryId">
								    <c:forEach items="${beneficiaryList}" var="category">
								        <form:option value="${category.owner_id.id}">${category.beneficiaryName}</form:option>
								    </c:forEach>
								</form:select>
								<%-- <form:input  path="" placeholder="Enter First Name Here.." class="form-control"></form:input> --%>
								<form:errors path="benefeciaryId" cssClass="error" element="div" />
								<div class="fieldError" id="benefeciaryIdError"></div>
							</div>
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
							<div class="col-sm-2 form-group">
								<label>Amount</label>
								<form:input  path="transactionAmount" placeholder="" class="form-control" />
								<form:errors path="transactionAmount" cssClass="error" element="div" />
								<div class="fieldError" id="transactionAmountError"></div>
							</div>
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
							<div class="col-sm-2 form-group">
								<label>Remarks</label>
							
								<form:input  path="transactionDesc"  class="form-control" id="" autocomplete="off"></form:input>
								<form:errors path="transactionDesc" cssClass="error" element="div" />
								<div class="fieldError" id="transactionDesc"></div>
							</div>
							<div class="col-sm-2 form-group">
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
    left: 53%;" onclick="return validate(event);">Transfer</button>
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
		 $("#transferForm").trigger('reset');
}
function validate(e){
	alert("validating transfer fields........");
	var f=document.getElementById("transferForm");
	var hasAmountError = validateTransactionAmount(f);
	var hasDescriptonError = validateDescrption(f);
	var hasAccountNumberError = validateBeneficiary(f);
	if(!hasAmountError | !hasDescriptonError | !hasAccountNumberError ){
	       e.preventDefault();
	       return false;
			}else{
				return true;}
}
function validateTransactionAmount(form){
	var error=document.getElementById("transactionAmountError");

	var amount=form["transactionAmount"].value;

	error.innerHTML="";

	if( amount==null || amount==""){
	error.innerHTML="Amount cannot be blank or empty";
	}


	if(error.innerHTML.length > 0)
	return false;
	else
	return true;
}
function validateDescrption(form){
	var error=document.getElementById("transactionDesc");

	var nickName=form["transactionDesc"].value;

	error.innerHTML="";

	if( nickName==null || nickName==""){
	error.innerHTML="Enter Your descripton";
	}

	else if(!isNaN(nickName)){
	error.innerHTML="Description Can Not be a number";
	}

	if(error.innerHTML.length > 0)
	return false;
	else
	return true;
}
//benAccountNumber
function validateBeneficiary(form){
	var error=document.getElementById("benefeciaryIdError");

	var benefeciaryId=form["benefeciaryId"].value;

	error.innerHTML="";

	if( benefeciaryId==null || benefeciaryId==""){
	error.innerHTML="Enter Your Beneficiary Account Number";
	}

	else if(isNaN(benefeciaryId)){
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