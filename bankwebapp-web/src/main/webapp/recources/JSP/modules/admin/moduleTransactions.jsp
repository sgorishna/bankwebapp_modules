<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="table-responsive">

<c:choose>


<c:when test="${empty requestScope.accounts}">

<big><fmt:message key="NO_ACCOUNTS" /></big>


</c:when>

<c:otherwise>

<div class = "form-group">

<a href="transactions.php?All=yes&IdCustomer=${requestScope.idCustomer}" > <fmt:message key="VIEW_ALL_TRANSACTIONS" /> </a>

</div>

 <c:forEach items="${requestScope.accounts}" var="account">

<table class="table table-bordered">

<thead>
            <tr class = "info">
               
              
                <th ><fmt:message key="ACCOUNT_NUMBER" /></th>
                <th><fmt:message key="BALANCE" /></th>
                 <th><fmt:message key="CURRENCY" /></th>
                <th><fmt:message key="ACCOUNT_TYPE" /></th>
                <th><fmt:message key="ACTIVE" /></th>
               <th colspan=3 ><fmt:message key="TRANSACTIONS"/></th>
                
                
            </tr>
        </thead>
        <tbody>
           
                <tr>
                   
                    
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
                    
                   
                    
                   
                
                    <td><a href="transactionsForAccount.php?IdAccount=${account.idAccount}" > <fmt:message key="VIEW_ALL" /></a></td>
                    <td><a href="receivedFunds.php?IdAccount=${account.idAccount}" > <fmt:message key="VIEW_RECEIVED" /></a></td>
                     <td><a href="transferredFunds.php?IdAccount=${account.idAccount}" > <fmt:message key="VIEW_TRANSFERRED" /></a></td>
                     
                   
                </tr>
            
            
            
        </tbody>
 
</table>

</c:forEach>

</c:otherwise>

</c:choose>

</div>

