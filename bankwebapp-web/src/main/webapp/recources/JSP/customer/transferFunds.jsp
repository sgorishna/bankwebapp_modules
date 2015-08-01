<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title><fmt:message key="TRANSFER_FUNDS" /></title>
</head>
<body>
 

    <form method="POST" action='transferFunds.php' name="formUTransferMoney" >
        <fmt:message key="FROM_ACCOUNT" /> : <input type="text"  name="senderAccountNumber"
            value="<c:out value="${param.accountNumber}" />" /> <br /> 
        <fmt:message key="TO_ACCOUNT" /> : <input
            type="text" name="receiverAccountNumber" /> <br /> 
            <fmt:message key="AMOUNT" /> : <input
            type="text" name="amount" /> <br /> 
            
             <fmt:message key="COMMENTS" /> : <input
            type="text" name="comments" /> <br /> 
       
          <input
            type="submit" value="Submit" />
    </form>
</body>
</html>