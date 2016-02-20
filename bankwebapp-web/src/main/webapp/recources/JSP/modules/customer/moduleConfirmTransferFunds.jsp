<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>




			

			<form role="form" name = "form" method="POST" action='transferFunds.php?IdAccount=${account.idAccount}'>
				<div class="form-group">

					<div class="form-group">

						<label class="control-label" for="sender"><fmt:message
								key="FROM_ACCOUNT" /></label> <c:out value="${requestScope.sender}" />

					</div>


					<label class="control-label" for="receiver"><fmt:message
							key="TO_ACCOUNT" /></label>  <c:out value="${requestScope.receiver}" /> 
						
						
				</div>


				<div class="form-group">

					<label class="control-label" for="amount"><fmt:message
							key="AMOUNT" />   <c:out value="${requestScope.amount}" />
							
							</label> 
				</div>

				<div class="form-group">

					<label class="control-label" for="comment"><fmt:message
							key="COMMENTS" /></label> <c:out value="${requestScope.comments}" />  
							
				</div>

				
			

	
				<button type="submit" class="btn  btn-primary" value="Submit">Confirm</button>
			</form>


		
