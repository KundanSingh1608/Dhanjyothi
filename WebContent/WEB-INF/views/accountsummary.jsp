<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
  <link href="${context}/resources/css/signup.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.css" >
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
  
  <title>Account Summary and Adding of Saving Account</title>
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
  </style>
</head>
<body>
<div class="container">
<!--start Adding Modal -->
<div class="modal fade right" id="myModal">
    <div class="modal-dialog modal-lgt">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Info</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          <h4 style="background-color: lightblue;color: #fff;">Your cheque book will be delivered to your registered address within a week.Thanks!!</h4>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>

<!-- end of Adding Modal -->
<div class="card bg-light text-dark">
    <div class="card-body">Welcome &nbsp;&nbsp;<b style="font-weight: bold;color: skyblue;font-style: italic;">${sessionScope.userName} <i class="fa fa-user"></i></b>
    <a href="${context}/logout" style="position:absolute;right:0%;" ><i class="fa fa-sign-out"></i>Logout</a></div>
  </div><br>
    <div class="col-lg-12  AccountLabel">
   Account Summary
    </div>
	<div class="col-lg-12 customwell">
	<div class="btn-group">
	<div class=" dropdown">	
    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" style="color: cornflowerblue;">
      Account
    </button>
    <div class="dropdown-menu" >
    <c:if test="${empty savingAccount}">
      <a class="dropdown-item" href="createsavingsaccount"style="color: cornflowerblue;">Create Saving Account</a></c:if>
      <c:if test="${not empty savingAccount}">
      <a class="dropdown-item" href="loadtermaccount"style="color: cornflowerblue;">Create Term Deposit Account</a></c:if>
    </div>
  </div>
  <div class=" dropdown">
    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" style="color: cornflowerblue;">
      Funds Transfer
    </button>
    <div class="dropdown-menu" >
    	<c:if test="${not empty savingAccount}">
       <a class="dropdown-item" href="loadbeneficiary"style="color: cornflowerblue;">Add Beneficiary</a>
      <a class="dropdown-item" href="loadtransfer"style="color: cornflowerblue;">Fund Transfer</a>
      </c:if>	
    </div>
    </div>
    <div class=" dropdown">
    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" style="color: cornflowerblue;">
      Others
    </button>
    <div class="dropdown-menu" > <c:if test="${not empty savingAccount}">
      <a class="dropdown-item" href="#"style="color: cornflowerblue;"  data-toggle="modal" data-target="#myModal">Cheque Book Request</a>
      </c:if>
    </div>
    </div>
  </div>
  <c:if test="${empty savingAccount}">
  <hr>
	Kindly Add Your Savings Account</c:if><br>
	<c:if test="${not empty savingAccount}">
	<div><span class="acntDetail">Saving Account Details</span><br></div>
	<table class="table table-striped">
    <thead>
      <tr>
        <th>Account Number</th>
        <th>Account Type</th>
        <th>Account Balance</th>
        <th>Created Date</th>
        <th>Updated Date</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${savingAccount.id}</td>
        <td>${savingAccount.accountType}</td>
        <td>${savingAccount.accountBalance}</td>
        <td>${savingAccount.accountCreatedDate}</td>
        <td>${savingAccount.accountUpdatedDate}</td>
        <td><a href="${context}/viewtransactions?ac_Id=${savingAccount.id}">View</a></td>
      </tr>
    </tbody>
  </table>
  </c:if><br><br>
  <c:if test="${not empty termAccounts}">
	<div><span class="acntDetail">Term Account Details</span><br></div>
	<table class="table table-striped">
    <thead>
      <tr>
        <th>Account Number</th>
        <th>Account Type</th>
        <th>Term Amount</th>
        <th>Term Tenure</th>
        <th>Interest</th>
        <th>Term Date</th>
        <th>Created Date</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${termAccounts.id}</td>
        <td>${termAccounts.accountType}</td>
        <td>${termAccounts.maturityAmount}</td>
        <td>${termAccounts.accountTenure}</td>
        <td>${termAccounts.interestRate}</td>
        <td>${termAccounts.maturityDate}</td>
        <td>${termAccounts.accountCreatedDate}</td>
      </tr>
    </tbody>
  </table>
  </c:if>
	</div>
	</div>
</body>
</html>