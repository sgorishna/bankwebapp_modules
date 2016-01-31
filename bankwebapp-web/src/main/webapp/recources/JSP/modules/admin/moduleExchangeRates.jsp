<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="table-responsive">

<c:choose>


<c:when test="${empty requestScope.rates}">

<big><fmt:message key="NO_EXCHANGE_RATES" /></big>


</c:when>

<c:otherwise>




<table class="table table-bordered">

<thead>
            <tr class = "info">
               
                <th><fmt:message key="CURRENCY" /></th>
                <th><fmt:message key="WE_BUY" /></th>
                
                 <th><fmt:message key="WE_SELL" /></th>
               
               <th colspan=4 ><fmt:message key="ACTION"/></th>
                
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.rates}" var="rates">
                <tr>
                   
                    <td><c:out value="${rates.currency}" /></td>
                     <td><c:out value="${rates.buy}" /></td>
                     <td><c:out value="${rates.sell}" /></td>
                     
                   <td><a href="updateExchangeRates?id=${rates.idCurrency}" > <fmt:message key="UPDATE" /> </a></td>
                    
              
                </tr>
            </c:forEach>
            
            
        </tbody>
 
</table>

</c:otherwise>

</c:choose>

</div>

