<%@page import="com.webapp.dao.impl.AccountDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.webapp.model.Transaction"%>
<%@page import="com.webapp.model.Customer"%>
<%@page import="com.webapp.utils.WebappConstants"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>My accounts</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");

		long IdCustomer = 0L;

		try {
			Customer c = (Customer) request.getSession().getAttribute(WebappConstants.CURRENT_SESSION_ACCOUNT);
			IdCustomer = c.getIdCustomer();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	%>

	<jsp:useBean id="transactionList"
		class="com.webapp.dao.impl.TransactionDaoImpl" scope="page" />

	<table border=1>
		<thead>
			<tr>
				<th>Sender account number</th>
				<th>Sender name</th>
				<th>Receiver account number</th>
				<th>Receiver name</th>
				<th>Amount</th>
				<th>Currency</th>
				<th>Comments</th>
				<th>Created</th>
			</tr>
		</thead>
		<tbody>

			<%
				for (Transaction transaction : transactionList.findByIdCustomer(IdCustomer)) {
			%>

			<tr>
				<td><%=transaction.getSenderAccountNumber()%></td>

				<td><%=transaction.getSenderName() %></td>


				<td><%=transaction.getReceiverAccountNumber()%></td>
				<td><%=transaction.getReceiverName()%></td>

				<td><%=transaction.getAmount()%></td>

				<td><%=transaction.getCurrency()%></td>

				<td><%=transaction.getComments()%></td>
				<td><%=transaction.getCreated()%></td>


			</tr>


		</tbody>
		<%
			}
		%>
	</table>

</body>
</html>