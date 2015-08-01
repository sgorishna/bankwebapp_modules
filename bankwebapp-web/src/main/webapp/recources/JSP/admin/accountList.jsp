<%@page import="com.webapp.dao.impl.AccountDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.webapp.model.Account"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><fmt:message key="ACCOUNTS" /></title>
</head>
<body>



<jsp:useBean id="accountList" class="com.webapp.dao.impl.AccountDaoImpl" scope="page"/>
    <table border=1>
        <thead>
            <tr>
                <th> <fmt:message key="ID_ACCOUNT" /></th>
                <th><fmt:message key="CUSTOMER" /></th>
                <th><fmt:message key="ACCOUNT_NUMBER" /></th>
                <th><fmt:message key="ACCOUNT_TYPE" /></th>
                <th><fmt:message key="CURRENCY" /></th>
                <th><fmt:message key="BALANCE" /></th>
                <th><fmt:message key="CREATED" /></th>
                <th><fmt:message key="UPDATED" /></th>
                
            </tr>
        </thead>
        <tbody>

            <%

            for (Account account : accountList.findAll()) {

        %>
            
                <tr>
                    <td><%=account.getIdAccount()%></td>
                    
                    <td><%=account.getCustomerName()%></td>
                    
                    <td><%=account.getAccountNumber()%></td>
                    <td><%=account.getAccountType()%></td>
                     
                    <td><%=account.getCurrency()%></td>
                    
                    <td><%=account.getBalance()%></td>
                    
                    <td><%=account.getCreated()%></td>
                    <td><%=account.getUpdated()%></td>
                    
                    
                </tr>
           
           
         
        </tbody>
         <%}%>
    </table>
    
    <p><a href="home.php"><fmt:message key="HOME" /></a></p>
</body>
</html>