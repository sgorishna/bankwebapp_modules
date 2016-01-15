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
            <tr class = "info">
               
                <th><fmt:message key="CUSTOMER" /></th>
                <th><fmt:message key="ACCOUNT_NUMBER" /></th>
                <th><fmt:message key="BALANCE" /></th>
                 <th><fmt:message key="CURRENCY" /></th>
                <th><fmt:message key="ACCOUNT_TYPE" /></th>
                <th><fmt:message key="ACTIVE" /></th>
               <th colspan=4 ><fmt:message key="ACTION"/></th>
                
                <th><fmt:message key="CREATED" /></th>
                <th><fmt:message key="UPDATED" /></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.accounts}" var="account">
                <tr>
                   
                    <td><c:out value="${account.customerName}" /></td>
                     <td><c:out value="${account.accountNumber}" /></td>
                     <td><c:out value="${account.balance}" /></td>
                     <td><c:out value="${account.currency}" /></td>
                     <td><c:out value="${account.accountType}" /></td>
                    <td><c:choose>
                     <c:when test="${account.active==1}">
                     ACTIVE
                     </c:when>
                    <c:otherwise>
                   BLOCKED
                    
                    </c:otherwise>
                    </c:choose></td>
                    
                   
                    <c:choose>
                    <c:when test="${account.active==0}">
                    
                    <td>
                    <fmt:message key="TOP_UP" /></td>
                    <td><fmt:message key="WITHDRAW" /></td>
                    </c:when>
                    <c:otherwise>
                    
                    <td>
                    <a href="topUp.php?IdAccount=${account.idAccount}"><fmt:message key="TOP_UP" /></a></td>
                    <td><a href="withdraw.php?IdAccount=${account.idAccount}"><fmt:message key="WITHDRAW" /></a></td>
                    
                    </c:otherwise>
                    </c:choose>
                     
                    <td><c:choose>
                     <c:when test="${account.active==1}">
                     <a href="deactivateAccount?idAccount=${account.idAccount}"  onclick="return deactivateAccount()"> <fmt:message key="BLOCK" /> </a>
                     </c:when>
                    <c:otherwise>
                  <a href="activateAccount?idAccount=${account.idAccount}" onclick="return activateAccount()"> <fmt:message key="UNBLOCK" /> </a>
                    
                    </c:otherwise>
                    </c:choose></td>
                    <td><a href="deleteAccount?idAccount=${account.idAccount}" onclick="return deleteAccount()"> <fmt:message key="DELETE" /> </a></td>
                
                    <td><c:out value="${account.created}" /></td>
                     <td><c:out value="${account.updated}" /></td>
                   
                </tr>
            </c:forEach>
            
            
        </tbody>
 
</table>

</c:otherwise>

</c:choose>

</div>

