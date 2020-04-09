<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link href="${context}/resources/css/signup.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.css" >
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>AddBeneficiary Page</title>
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
<div class="card bg-light text-dark">
<div class="card-body"><a href="${context}/loadaccount">Account Summary</a> 
    <a href="${context}/logout" style="position:absolute;right:0%;" ><i class="fa fa-sign-out"></i>Logout</a></div>
  </div><br>
    <div class="col-lg-12  AccountLabel">
   Select Benificiery Type
    </div>
	<div class="col-lg-12 customwell">
	<table class="table table-striped">
    <tbody>
      <tr>
		<td><a href="beneficiarywithinbank">Transfer With In Bank</a></td>
        <td><a href="#">Transfer To Other Bank</a></td>
      </tr>
    </tbody>
  </table>
  </div>
</div>
</body>
</html>