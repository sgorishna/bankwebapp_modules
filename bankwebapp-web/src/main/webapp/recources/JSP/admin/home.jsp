<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title><fmt:message key="HOME" /></title>
</head>
<body>
  <p ><fmt:message key="HELLO_ADMIN" /></p>
  
  <p><a href="customerList.php"><fmt:message key="CUSTOMERS" /></a></p>
  
  <p><a href="accountList.php"><fmt:message key="ACCOUNTS" /></a></p>
  
  <p><a href="registerCustomer.php"><fmt:message key="REGISTER_NEW_CUSTOMER" /></a></p>
  
  
  
  
</body>
</html>