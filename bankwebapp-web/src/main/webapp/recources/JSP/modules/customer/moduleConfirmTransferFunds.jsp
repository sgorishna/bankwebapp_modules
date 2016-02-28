<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>






<form role="form" name="form" method="POST"
	action='transferFunds.php?IdAccount=${requestScope.idAccount}'>
	<div class="form-group">

		<div class="form-group">

			<label class="control-label" for="sender"><fmt:message
					key="FROM_ACCOUNT" /></label> <input type="text" class="form-control"
				name="sender" value="<c:out value="${requestScope.sender}" />"
				readonly="readonly">



		</div>


		<label class="control-label" for="receiver"><fmt:message
				key="TO_ACCOUNT" /></label> <input type="text" class="form-control"
			name="receiver" value="<c:out value="${requestScope.receiver}" />"
			readonly="readonly">




	</div>


	<div class="form-group">

		<label class="control-label" for="amount"><fmt:message
				key="AMOUNT" /> <input type="text" class="form-control"
			name="amount" value="<c:out value="${requestScope.amount}" />"
			readonly="readonly"> </label>
	</div>

	<div class="form-group">

		<label class="control-label" for="comment"><fmt:message
				key="COMMENTS" /></label> <input type="text" class="form-control"
			name="comments" value="<c:out value="${requestScope.comments}" />"
			readonly="readonly">


	</div>





	<button type="submit" class="btn  btn-primary" value="Submit">Confirm</button>
</form>
<div>

	<form role="form" name="form" method="GET">

		<button type="submit" class="btn  btn-primary" value="Submit">Cancel</button>

	</form>

</div>

