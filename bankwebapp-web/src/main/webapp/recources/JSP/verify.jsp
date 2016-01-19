<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
        <%@include file="/recources/css/style.css" %>
        <%@include file="/recources/css/bootstrap.min.css" %>
</style>


<title>Verify account</title>
</head>
<body>

 
	<c:choose>

		<c:when test="${requestScope.success != null}">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h4 class="text">${requestScope.success}</h4>


			</div>


		</c:when>

		<c:when test="${requestScope.error != null}">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h4 class="text">${requestScope.error}</h4>


			</div>
		</c:when>

	</c:choose>

	<a href="login.php" class="text-left new-account">Back to Login </a>
  
</body>
</html>