<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="table-responsive">

<table class="table table-bordered">

<thead>
            <tr>
               
                <th><fmt:message key="LOGIN" /></th>
                <th><fmt:message key="PASSWORD" /></th>
                <th><fmt:message key="EMAIL" /></th>
                <th><fmt:message key="NAME" /></th>
                <th><fmt:message key="GENDER" /></th>
               
                <th><fmt:message key="CREATED" /></th>
                <th><fmt:message key="UPDATED" /></th>
                 <th><fmt:message key="ROLE" /></th> 
                <th><fmt:message key="ACTIVE" /></th>                
                <th colspan=3 ><fmt:message key="ACTION" /></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.customers}" var="customer">
                <tr>
                   
                    <td><c:out value="${customer.login}" /></td>
                     <td><c:out value="${customer.password}" /></td>
                     <td><c:out value="${customer.email}" /></td>
                    <td><a href="accountList.php?IdCustomer=<c:out value="${customer.idCustomer}"/>"><c:out value="${customer.name}" /></a></td>
                    <td><c:out value="${customer.gender}" /></td>
                    
                    <td><c:out value="${customer.created}" /></td>
                    <td><c:out value="${customer.updated}" /></td>
                    <td><c:out value="${customer.role}" /></td>
                    <td><c:choose>
                     <c:when test="${customer.active==1}">
                     ACTIVE
                     </c:when>
                    <c:otherwise>
                   INACTIVE
                    
                    </c:otherwise>
                    </c:choose></td>
                    <td><a href="updateCustomer.php?IdCustomer=${customer.idCustomer}"><fmt:message key="UPDATE" /></a></td>
                    
                    <td><c:choose>
                    
                    <c:when test="${customer.idCustomer==sessionScope.CURRENT_SESSION_ACCOUNT.idCustomer}">
                  <fmt:message key="CURRENT_ACCOUNT" />
                    </c:when>
                    <c:otherwise>
                    <a href="deleteCustomer.php?IdCustomer=${customer.idCustomer}" > <fmt:message key="DELETE" /> </a>
                    </c:otherwise>
                    </c:choose>
                    </td>
                     
                  
                     <td><a href="addAccount.php?IdCustomer=${customer.idCustomer}"><fmt:message key="ADD_ACCOUNT" /></a></td>
                </tr>
            </c:forEach>
        </tbody>

</table>

</div>

