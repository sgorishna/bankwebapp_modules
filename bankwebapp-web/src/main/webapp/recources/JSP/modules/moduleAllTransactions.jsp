<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="table-responsive">

	<c:choose>


		<c:when test="${empty requestScope.transactions}">

			<big><fmt:message key="NO_TRANSACTIONS" /></big>


		</c:when>

		<c:otherwise>




			<table class="table table-bordered">

				<thead>
					<tr class = "info">

						<th><fmt:message key="SENDER_ACCOUNT_NUMBER" /></th>
						<th><fmt:message key="SENDER_NAME" /></th>
						<th><fmt:message key="RECEIVER_ACCOUNT_NUMBER" /></th>
						<th><fmt:message key="RECEIVER_NAME" /></th>
						<th><fmt:message key="AMOUNT" /></th>
						<th><fmt:message key="CURRENCY" /></th>
						<th><fmt:message key="COMMENTS" /></th>
						<th><fmt:message key="CREATED" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.transactions}" var="tr">
						<tr>

							<td><c:out value="${tr.senderAccountNumber}" /></td>
							<td><c:out value="${tr.senderName}" /></td>
							<td><c:out value="${tr.receiverAccountNumber}" /></td>
							<td><c:out value="${tr.receiverName}" /></td>
							<td><c:out value="${tr.amount}" /></td>
							<td><c:out value="${tr.currency}" /></td>
							<td><c:out value="${tr.comments}" /></td>
							<td><c:out value="${tr.created}" /></td>

						</tr>
					</c:forEach>


				</tbody>

			</table>

		</c:otherwise>

	</c:choose>

</div>

