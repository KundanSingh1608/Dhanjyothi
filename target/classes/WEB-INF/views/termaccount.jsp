<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:url var="actionUrl" value="/createtermaccount" />
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
<title>Term Account Page</title>
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
<div class="card-body"><a href="${context}/loadaccount">Account Summary 
    <a href="${context}/logout" style="position:absolute;right:0%;" ><i class="fa fa-sign-out"></i>Logout</a></div>
  </div><br>
    <div class="col-lg-12  AccountLabel">
   Term Account Creation
    </div>
	<div class="col-lg-12 customwell">
				<form:form method="POST" modelAttribute="account" action="${actionUrl}" id="termForm">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-2 form-group">
								<label>Term Amount</label><br>
								<form:input  path="maturityAmount" placeholder="Enter Amount" class="form-control"></form:input>
								<form:errors path="maturityAmount" cssClass="error" element="div" />
								<div class="fieldError" id="firstNameError"></div>
							</div>
							<div class="col-sm-5 form-group">
								<label></label>
							</div>	
							<div class="col-sm-2 form-group">
								<label>Tenure</label><br>
								<form:select path="accountTenure">
								<form:option value="1">One year</form:option>
								<form:option value="2">Two year</form:option>
								<form:option value="5">5 year</form:option>
								<form:option value="10">10 year</form:option>
								</form:select>
								<%-- <form:input  path="" placeholder="Enter Last Name Here.." class="form-control" />
								<form:errors path="" cssClass="error" element="div" /> --%>
								<div class="fieldError" id="lastNameError"></div>
							</div>
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
							
							<div class="col-sm-2 form-group">
								<label></label>
							</div>	
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
			</form:form> 
<br>
<span class="btn btn-danger">Once Take a Look at the Intrest rates best suited for you</span>
  <table class="table-striped">
  <col>
  <colgroup span="2"></colgroup>
  <colgroup span="2"></colgroup>
  <tr style="background-color: buttonshadow;">
    <td rowspan="2">Tenure Years</td>
    <th colspan="2" scope="colgroup">Deposit Amount &#8377;</th>
    <th colspan="2" scope="colgroup"></th>
  </tr>
  <tr style="background-color: lightblue;">
    <th scope="col">&lt; 1Lac</th>
    <th scope="col">&lt; 5Lac</th>
    <th scope="col">Upto 1cr</th>
    <th scope="col"></th>
  </tr>
  <tr>
    <th scope="row">1</th>
    <td>5.75</td>
    <td>6</td>
    <td>6.25</td>
    <td></td>
  </tr>
  <tr>
    <th scope="row">2</th>
    <td>5.75</td>
    <td>6</td>
    <td>6.50</td>
    <td></td>
  </tr>
   <tr>
    <th scope="row">3</th>
    <td>5.75</td>
    <td>6.25</td>
    <td>6.75</td>
    <td></td>
  </tr>
  <tr>
    <th scope="row">4</th>
    <td>6</td>
    <td>6.25</td>
    <td>6.75</td>
    <td></td>
  </tr>
  <tr>
    <th scope="row">5</th>
    <td>6</td>
    <td>6.50</td>
    <td>7</td>
    <td></td>
  </tr>
</table>
</div>  </div>
<script type="text/javascript">
function reset(){
	alert("Reset called......");
		 $("#termForm").trigger('reset');
}
</script>
</body>
</html>