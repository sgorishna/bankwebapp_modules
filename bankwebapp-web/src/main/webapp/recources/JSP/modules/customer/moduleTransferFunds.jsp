<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table>
	<tr>
		<td colspan="2"></td>
		<td></td>

	</tr>
	<tr>
	
	
	<td>



			<div class="form-group">

				<div class="form-group">

					<label class="control-label"><fmt:message key="NAME" /></label>
					:&nbsp
					<c:out value="${account.customerName}" />

				</div>
				
				<div class="form-group">

					<label class="control-label"><fmt:message key="ACCOUNT_NUMBER" /></label>
					:&nbsp
					<c:out value="${account.accountNumber}" />

				</div>
				
				<div class="form-group">

					<label class="control-label"><fmt:message key="BALANCE" /></label>
					:&nbsp
					<c:out value="${account.balance}" />

				</div>
				<div class="form-group">

					<label class="control-label"><fmt:message key="CURRENCY" /></label>
					:&nbsp
					<c:out value="${account.currency}" />

				</div>
				
				<div class="form-group">

					<label class="control-label"><fmt:message key="ACCOUNT_TYPE" /></label>
					:&nbsp
					<c:out value="${account.accountType}" />

				</div>
				
				
				<div class="form-group">

					<label class="control-label"><fmt:message key="ACTIVE" /></label>
					:&nbsp
					<c:choose>
                     <c:when test="${account.active==1}">
                     ACTIVE
                     </c:when>
                    <c:otherwise>
                   BLOCKED
                    
                    </c:otherwise>
                    </c:choose>

				</div>
				
			<div class="form-group">

					<label class="control-label"><fmt:message key="CREATED" /></label>
					:&nbsp
					<c:out value="${account.created}" />

				</div>
				
				<div class="form-group">

					<label class="control-label"><fmt:message key="UPDATED" /></label>
					:&nbsp
					<c:out value="${account.updated}" />

				</div>	
				

			</div>

		</td>
	
	
	
		<td>&nbsp &nbsp &nbsp &nbsp &nbsp</td>
		<td>&nbsp &nbsp &nbsp &nbsp &nbsp</td>
		<td>

			<form role="form" method="POST" action=''>
				<div class="form-group">

					<div class="form-group">

						<label class="control-label" for="sender"><fmt:message
								key="FROM_ACCOUNT" /></label> <input type="text" class="form-control"
							name="name" value="<c:out value="${accountNumber}" />" disabled="disabled">

					</div>


					<label class="control-label" for="receiver"><fmt:message
							key="TO_ACCOUNT" /></label>  </span> <input
						type="text" class="form-control" name="receiver"
						
						 required>
				</div>


				<div class="form-group">

					<label class="control-label" for="amount"><fmt:message
							key="AMOUNT" /></label> <input type="text" class="form-control"
						name="amount"  />
						
				</div>

				<div class="form-group">

					<label class="control-label" for="comment"><fmt:message
							key="COMMENTS" /></label>  
							<textarea class="form-control" rows="3" name = "comment"></textarea>
				</div>

				
			

	
				<button type="submit" class="btn  btn-primary" value="Submit">Submit</button>
			</form>


		</td>

	</tr>
</table>
