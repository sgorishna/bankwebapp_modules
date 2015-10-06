<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title><fmt:message key="UPDATE_CUSTOMER_INFO" /></title>
</head>


<body onload=" myFunction()">

	<c:choose>
		<c:when test="${sessionScope.uploadPhotoStatus == false}">
			<script type="text/javascript">
				function myFunction() {
					alert("The File Is In The Wrong Format! Please, choose .JPG or .PNG file");
				}
			</script>
		</c:when>
	</c:choose>

<%-- <c:choose>
<c:when test="${sessionScope.photoStatus == false}">
<img alt="" src="${requestScope.path}">
</c:when>
</c:choose> --%>

 <img alt="" src="showImage.php?IdCustomer=${customer.idCustomer} " height="250" width="190">

<img alt="" src="<c:url value = "C:\Users\Sunny\Documents\workspace-sts-3.4.0.RELEASE\bankwebapp-parent\bankwebapp-web\src\main\webapp\recources\photos\1.JPG" > </c:url>" height="250" width="190">
		

<p>

	<form method="POST" action='updateCustomer.php'
		name="formUpdateCustomer" enctype="multipart/form-data">
		<fmt:message key="ID_CUSTOMER" />
		: <input type="text" readonly="readonly" name="idCustomer"
			value="<c:out value="${customer.idCustomer}" />" /> <br />
		<fmt:message key="LOGIN" />
		: <input type="text" name="login"
			value="<c:out value="${customer.login}" />" /> <br />
		<fmt:message key="PASSWORD" />
		: <input type="password" name="password"
			value="<c:out value="${customer.password}" />" /> <br />
		<fmt:message key="NAME" />
		: <input type="text" name="name"
			value="<c:out value="${customer.name}" />" /> <br />
		<fmt:message key="GENDER" />
		: <input TYPE="radio" NAME="gender" VALUE="male" CHECKED>
		<fmt:message key="MALE" />
		<br> <INPUT TYPE="radio" NAME="gender" VALUE="female">
		<fmt:message key="FEMALE" />
		<br>

		<fmt:message key="ROLE" />
		: <input TYPE="checkbox" NAME="role" VALUE="1" CHECKED>
		<fmt:message key="ADMIN" />
		<br> <INPUT TYPE="checkbox" NAME="role" VALUE="2">
		<fmt:message key="CUSTOMER" />
		<br> <br />

		<fmt:message key="PHOTO" />
		: <input type="file" name="photo" /> <br /> <input type="submit"
			value="Submit" />
	</form>
</body>
</html>