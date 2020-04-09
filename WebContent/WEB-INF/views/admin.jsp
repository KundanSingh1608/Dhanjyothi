<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:url var="actionUrl" value="/register/enableUser" />
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
<title>Admin Page</title>
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
    <a href="${context}/logout" style="position:absolute;right:0%;" ><span class="fa fa-sign-out"></span>Logout</a></div>
  </div><br>
    <div class="col-lg-12  AccountLabel">
   <div style="width: 100%;">Welcome : ${sessionScope.userName}</div>
   <span > Users to be enabled</span>
    </div>
	<form:form modelAttribute="userBean" method="POST" enctype="multipart/form-data"  id="registerForm" action="${actionUrl}">
					<div class="col-sm-12">
						<div class="row">
						<!-- Table with panel -->
   <table class="table table-bordered">
        <thead>
          <tr>
            <th scope="col">Select User</th>
            <th scope="col"> Name</th>
            <th scope="col">UserName</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
          </tr>
        </thead>
        <tbody class="table-hover" id="tbBody">
        <c:forEach items="${listUsers}" var="user">
          <tr>
            <td>
              <div class="custom-control custom-checkbox">
                  <input type="checkbox" class="custom-control-input" id="isSelected" value="${user.id}">
                  <label class="custom-control-label" for="isSelected"></label>
              </div>
            </td>
            <td>${user.firstName}</td>
            <td>${user.userName}</td>
            <td>${user.email}</td>
            <td>${user.address1}</td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
      <input type="hidden" name="userToBeEnabled" id="enableUser">
      <c:if test="${fn:length(listUsers) lt 1}">
      <div style="background-color: gray;width: 100%;text-align: center;color: aliceblue;margin-bottom: 20px;">
        <span>Oops!No User is available to be Enabled</span>
      </div></c:if>
<!-- Table with panel -->
						</div>
						<button id="enableUserBtn" type="submit" class="btn btn-lg btn-warning" onclick="" title="Enable User" style="position: absolute;
    left: 45%;">Enable</button>
					</div>
	</form:form>
</div>
<script type="text/javascript">
$('#isSelected').bind('change', function () {
	var favorite = [];
	   if ($(this).is(':checked')){
		     alert("Checked");
		   favorite.push($(this).val());
		   console.log("checked values are:["+favorite+"]")
		   $("#enableUser").val(favorite);
		   }
	   else
	     alert("Unchecked");

	});
  if($("#tbBody").children().length == 0){
		$("#enableUserBtn").attr("disabled", true);
	  }
</script>
</body>
</html>