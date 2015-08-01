<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title><fmt:message key="REGISTER_NEW_CUSTOMER" /></title>
</head>
<body>


	<form method="POST" action='registerCustomer.php'
		name="formAddCustomer">

		<fmt:message key="LOGIN" />
		: <input type="text" name="login" /> <br />
		<fmt:message key="PASSWORD" />
		: <input type="password" name="password" /> <br />
		<fmt:message key="NAME" />
		: <input type="text" name="name" /> <br />
		<fmt:message key="GENDER" />
		: <input TYPE="radio" NAME="gender" VALUE="male" CHECKED>
		<fmt:message key="MALE" />
		<br> <INPUT TYPE="radio" NAME="gender" VALUE="female">
		<fmt:message key="FEMALE" />
		<br>

		<fmt:message key="ROLE" />
		: <input TYPE="checkbox" NAME="role" VALUE="1" CHECKED>
		<fmt:message key="ADMIN" />
		<br> <INPUT TYPE="checkbox" NAME="role" VALUE="2">
		<fmt:message key="CUSTOMER" />
		<br> <br /> <input type="submit" value="Submit" />
	</form>
</body>
</html>