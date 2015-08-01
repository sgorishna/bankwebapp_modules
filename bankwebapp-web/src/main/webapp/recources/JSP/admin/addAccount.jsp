<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title><fmt:message key="ADD_NEW_ACCONT" /></title>
</head>
<body>


	<form method="POST" action='addAccount.php' name="formAddAccount">
		<%--  Account ID : <input type="text" readonly="readonly" name="idAccount"
            value="<c:out value="${account.idAccount}" />" /> <br />  --%>
		<fmt:message key="CUSTOMER_ID" />
		: <input type="text" readonly="readonly" name="idCustomer"
			value="<c:out value="${customer.idCustomer}" />" /> <br />
		<fmt:message key="NAME" />
		: <input type="text" readonly="readonly" name="name"
			value="<c:out value="${customer.name}" />" /> <br />
		<fmt:message key="ACCOUNT_NUMBER" />
		: <input type="text" name="accountNumber"
			value="<c:out value="${account.accountNumber}" />" /> <br />

		<fmt:message key="ACCOUNT_TYPE" />
		: <input TYPE="radio" NAME="accountType" VALUE="1" CHECKED>
		<fmt:message key="DEBIT" />
		<br> <INPUT TYPE="radio" NAME="accountType" VALUE="2">
		<fmt:message key="CREDIT" />
		<br> <br />
		<fmt:message key="CURRENCY" />
		: <input TYPE="radio" NAME="currency" VALUE="1" CHECKED>
		<fmt:message key="EUR" />
		<br> <INPUT TYPE="radio" NAME="currency" VALUE="2">
		<fmt:message key="USD" />
		<br> <br />
		<fmt:message key="BALANCE" />
		: <input type="text" name="balance"
			value="<c:out value="${account.balance}" />" /> <br /> <input
			type="submit" value="Submit" />
	</form>
</body>
</html>