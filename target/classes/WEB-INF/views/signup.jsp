<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url var="actionUrl" value="/register/save" />
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="${context}/resources/css/signup.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.css" >
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>:Registration Page:</title>
</head>
<body>

	<div class="container">
    <h1 class="well"><a href="${context}/login" style="font-size: 12px;"><i class="fa fa-user"></i>Login</a></h1>
    <div class="col-lg-12  SignupLabel">
   Customer Registration
    </div>
	<div class="col-lg-12 customwell">
	<c:if test="${resultsize >0}">
		<div class="alert alert-success">${registrationMsg}</div>
		</c:if>
		<c:if test="${resultsize <=0}">
		<div class="alert alert-danger">${registrationMsg}</div>
		</c:if>
				<form:form modelAttribute="userBean" method="POST" enctype="multipart/form-data"  id="registerForm" action="${actionUrl}">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-2 form-group">
								<label>First Name</label>
								<form:input  path="firstName" placeholder="Enter First Name Here.." class="form-control"></form:input>
								<form:errors path="firstName" cssClass="fieldError"  element="div" />
								<div class="fieldError" id="firstNameError"></div>
							</div>
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
							<div class="col-sm-2 form-group">
								<label>Last Name</label>
								<form:input  path="lastName" placeholder="Enter Last Name Here.." class="form-control" />
								<form:errors path="lastName" cssClass="fieldError"  element="div" />
								<div class="fieldError" id="lastNameError"></div>
							</div>
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
							<div class="col-sm-2 form-group">
								<label>DOB</label>
								<form:input  path="dob" placeholder="mm/dd/yyyy" class="form-control" id="datepicker" autocomplete="off"></form:input>
								<form:errors path="dob" cssClass="fieldError"  element="div" />
								<div id="dobError" class="fieldError"></div>
							</div>
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
						</div>	
						<div class="row">				
						<div class="col-sm-2 form-group">
							<label>Address Line1</label>
							<form:textarea path="address1" placeholder="Enter Address Here.." rows="3" class="form-control"></form:textarea>
							<form:errors path="address1" cssClass="fieldError"  element="div" />
							<div id="address1Error" class="fieldError"></div>
						</div>
						<div class="col-sm-2 form-group">
								<label></label>
							</div>	
						<div class="col-sm-2 form-group">
							<label>Address Line2</label>
							<form:textarea path="address2" placeholder="Enter Address Here.." rows="3" class="form-control"></form:textarea>
							<form:errors path="address2" cssClass="fieldError"  element="div" />
							<div id="address2Error" class="fieldError"></div>
						</div>
						<div class="col-sm-2 form-group">
								<label></label>
							</div>	
						<div class="col-sm-2 form-group">
								<label>City</label>
								<form:input path="city"  placeholder="Enter City Name Here.." class="form-control"></form:input>
								<form:errors path="city" cssClass="fieldError"  element="div" />
								<div id="cityError" class="fieldError"></div>
							</div>
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
						</div>	
						<div class="row">
								
							<div class="col-sm-2 form-group">
								<label>State</label>
								<form:input  path="state" placeholder="Enter State Name Here.." class="form-control"></form:input>
								<form:errors path="state" cssClass="fieldError"  element="div" />
								<div id="stateError" class="fieldError"></div>
							</div>	
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
							<div class="col-sm-2 form-group">
								<label>Pincode</label>
								<form:input  path="pinCode" placeholder="Enter Zip Code Here.." class="form-control" autocomplete="off"></form:input>
								<form:errors path="pinCode" cssClass="fieldError"  element="div" />
								<div id="pinCodeError" class="fieldError"></div>
							</div>	
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
							<div class="col-sm-2 form-group">
								<label>Mobile Number</label>
								<form:input  path="mobileNumber" placeholder="Enter Mobile no. Here.." class="form-control" autocomplete="off"></form:input>
								<form:errors path="mobileNumber" cssClass="fieldError"  element="div" />
								<div id="mobileNumberError" class="fieldError"></div>
							</div>	
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
						</div>
						<div class="row">
							<div class="col-sm-2 form-group">
								<label>Email</label>
								<form:input  path="email" placeholder="Enter Email Here.." class="form-control" autocomplete="off"></form:input>
								<form:errors path="email" ></form:errors>
								<div id="emailError" class="fieldError"></div>
							</div>		
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
							<div class="col-sm-2 form-group">
								<label>Aadhar</label>
								<form:input  path="aadhar" placeholder="Enter Aadhar no." class="form-control" autocomplete="off"></form:input>
								<form:errors path="aadhar" cssClass="fieldError"  element="div" />
								<div id="aadharError" class="fieldError"></div>
							</div>	
							<div class="col-sm-2 form-group">
								<label></label>
							</div>
							<div class="col-sm-2 form-group">
								<label>Pan</label>
								<form:input  path="pan" placeholder="Enter Pan no." class="form-control" autocomplete="off"></form:input>
								<form:errors path="pan" cssClass="fieldError"  element="div" />
								<div id="panError" class="fieldError"></div>
							</div>
							<div class="col-sm-2 form-group">
								<label></label>
							</div>
						</div>						
					<div class="row">
							<div class="col-sm-2 form-group">
								<label>Username</label>
								<form:input  path="userName" placeholder="UserName u want" class="form-control" autocomplete="off"></form:input>
								<form:errors path="userName" cssClass="fieldError"  element="div" />
								<div id="userNameError" class="fieldError"></div>
							</div>		
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
							<div class="col-sm-2 form-group">
								<label>Password</label>
								<form:password  path="password" placeholder="****************" class="form-control"></form:password>
								<form:errors path="password" cssClass="fieldError"  element="div" />
								<div id="passwordError" class="fieldError"></div>
							</div>	
							<div class="col-sm-2 form-group">
								<label></label>
							</div>
							<div class="col-sm-2 form-group">
								<label>Confirm Password</label>
								<form:password  path="confirmPassword" placeholder="****************" class="form-control"></form:password>
								<form:errors path="confirmPassword" cssClass="fieldError"  element="div" />
								<div id="confirmPasswordError" class="fieldError"></div>
							</div>
							<div class="col-sm-2 form-group">
								<label></label>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-2 form-group">
								<label>Date of Birth Proof</label>								
							</div>		
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
							<div class="col-sm-2 form-group">
								<input type="file" name="dobProof"></input><br>
								<div id="dobProofError" class="fieldError"></div>
							</div>	
							<div class="col-sm-2 form-group">
								<label></label>
							</div>
							<div class="col-sm-3 form-group">
								<small>Ex:Passport,Birth Certificate Uploaded Only</small>
								PDF,JPG,JPEG Documents.
								
							</div>
						
						</div>
						<div class="row">
							<div class="col-sm-2 form-group">
								<label>Address Proof</label>								
							</div>		
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
							<div class="col-sm-2 form-group">
								<input type="file" name="addressProof" ></input>
								<div id="addressProofError" class="fieldError"></div>
							</div>	
							<div class="col-sm-2 form-group">
								<label></label>
							</div>
							<div class="col-sm-3 form-group">
								<small>Ex:Licence,Voter Id Uploaded Only</small>
								PDF,JPG,JPEG Documents.
								
							</div>
						
						</div>
						<div class="row">
							<div class="col-sm-2 form-group">
								<label>Aadhar</label>								
							</div>		
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
							<div class="col-sm-2 form-group">
								<input type="file" name="aadharProof"></input><br>
								<div id="aadharProofError" class="fieldError"></div>
								
							</div>	
							<div class="col-sm-2 form-group">
								<label></label>
							</div>
							<div class="col-sm-3 form-group">
								<small> Uploaded Only PDF,JPG,JPEG Documents.</small>
								
								
							</div>
						
						</div>
						<div class="row">
							<div class="col-sm-2 form-group">
								<label>Pan</label>								
							</div>		
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
							<div class="col-sm-2 form-group">
								<input type="file" name="panProof"></input><br>
								<div id="panProofError" class="fieldError"></div>
							</div>	
							<div class="col-sm-2 form-group">       
								<label></label>
							</div>
							<div class="col-sm-3 form-group">
								<small> Uploaded Only PDF,JPG,JPEG Documents.</small>
								
								
							</div>
						
						</div>
						<div class="row">
							<div class="col-sm-2 form-group">
								<label>User Role</label>		
								<select name="userRole">
								<option value="2" selected="selected">USER</option>
								<option value="1">ADMIN</option>
								<option></option>
								</select>						
							</div>		
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
							<div class="col-sm-2 form-group">
							</div>	
							<div class="col-sm-2 form-group">       
								<label></label>
							</div>
							<div class="col-sm-3 form-group">
							</div>
						
						</div>
					<div class="row">
					<div class="col-sm-12 form-group ">
					<label></label>
						<button type="button" class="btn btn-lg btn-warning" onclick="resetUser();" style="position: absolute;
    left: 45%;">Reset</button>
						<button type="submit" class="btn btn-lg btn-info" style="position: absolute;
    left: 53%;" onclick="return validate(event);">Register</button>
					</div>
						
					</div>
					<div class="row">
					<div class="col-sm-12 form-group ">
					</div><span></span></div>					
					</div>
				</form:form>
				</div>
	</div>
<script type="text/javascript" src="${context}/resources/js/signup.js"></script>
<script type="text/javascript">
$(function(){
    $("#datepicker").datepicker(
			{
				dateFormat: "dd-mm-yy",
				changeMonth: true,
   			 changeYear: true}
    	    );
});
</script>
</body>
</html>