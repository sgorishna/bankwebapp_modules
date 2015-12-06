<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.webapp.model.Account"%>
<div class="table-responsive">
<jsp:useBean id="accountList" class="com.webapp.dao.impl.AccountDaoImpl" scope="page"/>
<table class="table table-bordered">

<thead>
            <tr>
               
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
                   
                    
                    <td><%=account.getCustomerName()%></td>
                    
                    <td><%=account.getAccountNumber()%></td>
                    <td><%=account.getAccountType()%></td>
                     
                    <td><%=account.getCurrency()%></td>
                    
                    <td><%=account.getBalance()%></td>
                    
                    <td><%=account.getCreated()%></td>
                    <td><%=account.getUpdated()%></td>
                    
                    
                </tr>
    <%}%>

</table>

</div>