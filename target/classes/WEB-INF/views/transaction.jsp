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
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
  <link href="${context}/resources/css/transaction.css" rel="stylesheet">
  <link href="${context}/resources/css/signup.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.css" >
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Transaction Page</title>
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
      Transactions
    </div>
	<div class="col-lg-12 customwell">
					 <table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th>Transaction Id</th>
                <th>Transaction Desc</th>
                <th>Transaction Amount</th>
                <th>Transaction type</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${listTransaction}" var="transaction">
            <tr>
                <td>${transaction.id}</td>
                <td>${transaction.transactionDesc}</td>
                <td>${transaction.transactionAmount}</td>
                <td>${transaction.transactionType}</td>
                
            </tr>
            </c:forEach>
        </tbody>
        
    </table>
  </div>
</div>
<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable({
    	"dom": 'lrtip'
        });
} );
</script>
</body>
</html>