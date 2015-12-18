<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="table-responsive">

<c:choose>


<c:when test="${empty requestScope.accounts}">

<big><fmt:message key="NO_ACCOUNTS" /></big>


</c:when>

<c:otherwise>




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
            <c:forEach items="${requestScope.accounts}" var="account">
                <tr>
                   
                    <td><c:out value="${account.customerName}" /></td>
                     <td><c:out value="${account.accountNumber}" /></td>
                     <td><c:out value="${account.accountType}" /></td>
                    <td><c:out value="${account.currency}" /></td>
                    <td><c:out value="${account.balance}" /></td>
                
                    <td><c:out value="${account.created}" /></td>
                     <td><c:out value="${account.updated}" /></td>
                   
                </tr>
            </c:forEach>
            
            
        </tbody>
 
</table>

</c:otherwise>

</c:choose>

</div>

