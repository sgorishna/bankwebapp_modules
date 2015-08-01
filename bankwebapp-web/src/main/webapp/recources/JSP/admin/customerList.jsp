<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><fmt:message key="SHOW_ALL_CUSTOMERS" /></title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th><fmt:message key="ID_CUSTOMER" /></th>
                <th><fmt:message key="LOGIN" /></th>
                <th><fmt:message key="PASSWORD" /></th>
                <th><fmt:message key="NAME" /></th>
                <th><fmt:message key="GENDER" /></th>
               
                <th><fmt:message key="CREATED" /></th>
                <th><fmt:message key="UPDATED" /></th>
                <th colspan=3><fmt:message key="ACTION" /></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.customers}" var="customer">
                <tr>
                    <td><c:out value="${customer.idCustomer}" /></td>
                    <td><c:out value="${customer.login}" /></td>
                     <td><c:out value="${customer.password}" /></td>
                    <td><a href="accountList.php?IdCustomer=<c:out value="${customer.idCustomer}"/>"><c:out value="${customer.name}" /></a></td>
                    <td><c:out value="${customer.gender}" /></td>
                    
                    <td><c:out value="${customer.created}" /></td>
                    <td><c:out value="${customer.updated}" /></td>
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
    <p><a href="registerCustomer.php"><fmt:message key="REGISTER_NEW_CUSTOMER" /></a></p>
    <p><a href="home.php"><fmt:message key="HOME" /></a></p>
    
    <script type="text/javascript"> </script>
</body>
</html>