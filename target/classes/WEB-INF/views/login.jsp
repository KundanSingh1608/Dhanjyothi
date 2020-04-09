<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url var="actionUrl" value="/login/submit" />
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8; X-Content-Type-Options=nosniff;">
<title>Login</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" type="text/css">
<link rel="stylesheet" type="text/css" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"  >
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" >
<link type="text/css" rel="stylesheet" href="${context}/resources/css/login.css"/>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<%-- <script type="text/javascript" src="${context}/resources/js/jquery3.3.min.js"></script>	
 --%>
</head>
<body>
	<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
		
			<div class="user_card">
			<c:if test="${resultsize >0}">
		<div class="d-flex justify-content-center alert alert-success" style="position: relative;top: -212px;">${loginStatus }</div>
		</c:if>
		<c:if test="${resultsize <=0}">
		<div class="d-flex justify-content-center alert alert-danger" style="position: relative;top: -212px;">${loginStatus}</div>
		</c:if>
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<img src="${context}/resources/images/lock.jpg" class="brand_logo" alt="Logo">
					</div>
				</div>
				<div class="d-flex justify-content-center form_container">
					<form:form modelAttribute="Signin" method="post" id="signinform" action="${actionUrl}">
						<div class="input-group mb-3">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<form:input path="userName" name="" class="form-control input_user" value="" placeholder="username"></form:input>
						</div>
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<form:password  path="password" class="form-control input_pass" value="" placeholder="password"></form:password>
						</div>
						<!-- <div class="form-group">
							<div class="custom-control custom-checkbox">
								<input type="checkbox" class="custom-control-input" id="customControlInline">
								<label class="custom-control-label" for="customControlInline">Remember me</label>
							</div>
						</div> -->
							<div class="d-flex justify-content-center mt-3 login_container">
				 	<button type="submit" name="button" class="btn login_btn" onclick="verifyCredential(event);">Login</button>
				   </div>
				   <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
					</form:form>
				</div>
		
				<div class="mt-4">
					<div class="d-flex justify-content-center links">
						Don't have an account? <a href="<%=request.getContextPath() %>/signup" class="ml-2">Sign Up</a>
					</div>
					 <!-- <div class="d-flex justify-content-center links">
						<a href="#">Forgot your password?</a>
					</div> --> 
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${context}/resources/js/login.js"></script>
</body>
</html>