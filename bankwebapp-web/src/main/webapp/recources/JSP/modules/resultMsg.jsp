<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<c:if test="${not empty requestScope.error}">

<div class="form-group">
<h3 style="color: red;" align="center"> < c:out value="${error}" /> </h3> 
</div>
</c:if>



<c:if test="${not empty requestScope.success}"> 

<div class="form-group">
<h3 style="color: red;" align="center"> < c:out value="${success}" /> </h3> 
</div>
</c:if>


