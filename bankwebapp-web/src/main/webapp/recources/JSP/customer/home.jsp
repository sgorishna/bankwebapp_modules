<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>Home</title>
</head>
<body>
  <p > Hello, ${sessionScope.CURRENT_SESSION_ACCOUNT.name}</p>
  
  <p><a href="myAccounts.php">My accounts</a></p>
  
  <p><a href="transferFunds.php">Transfer funds</a></p>
  
  <p><a href="myTransactions.php">MyTransactions</a></p>
  
  
</body>
</html>