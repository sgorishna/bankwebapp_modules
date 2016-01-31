<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<form role="form" method="POST" action=''>

	<div class="form-group">

		<div class="form-group">

			<label class="control-label"><fmt:message key="WE_BUY" /></label> <input
				type="text" class="form-control" name="buy"
				value="<c:out value="${rates.buy}" />" required="required">

		</div>

		<div class="form-group">
			<label class="control-label"><fmt:message key="WE_SELL" /></label> <input
				type="text" class="form-control" name="sell"
				value="<c:out value="${rates.sell}" />"
				required="required">
		</div>

		<div class="form-group">
			<label class="control-label"><fmt:message
					key="CURRENCY" /></label> <input type="text" class="form-control"
				name="currency" value="<c:out value="${rates.currency}"  />"
				disabled="disabled">
		</div>

	</div>



	<button type="submit" class="btn  btn-primary" value="Submit">Submit</button>
</form>