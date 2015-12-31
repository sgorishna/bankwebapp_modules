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

				<img alt="" src="showImage.php?=${CURRENT_SESSION_ACCOUNT.idCustomer} "
					height="250" width="190">
					
					

			</div>
			
			

		</td>


		<td >
		<div class="col-xs-12" "></div>
		</td>
		<td>



			<div class="form-group">
			
			

				<div class="form-group">

					<label class="control-label"><fmt:message key="NAME" /></label>
					: <div class="col-xs-12" "></div>
					<c:out value="${CURRENT_SESSION_ACCOUNT.name}" />

				</div>

				<div class="form-group">
					<label class="control-label"><fmt:message key="LOGIN" /></label>
					: <div class="col-xs-12" "></div>
					<c:out value="${CURRENT_SESSION_ACCOUNT.login}" />
				</div>


				<div class="form-group">

					<label class="control-label"><fmt:message key="PASSWORD" /></label>
					: <div class="col-xs-12" "></div>
					<c:out value="${CURRENT_SESSION_ACCOUNT.password}" />
				</div>

				<div class="form-group">

					<label class="control-label"><fmt:message key="EMAIL" /></label>
					: <div class="col-xs-12" "></div>
					<c:out value="${CURRENT_SESSION_ACCOUNT.email}" />
				</div>

				<div class=" form-group">

					<label class="control-label"><fmt:message key="GENDER" />
						: </label>

					<c:choose>

						<c:when test="${CURRENT_SESSION_ACCOUNT.gender == 'male'}">


							<fmt:message key="MALE" />


						</c:when>
						<c:otherwise>


							<fmt:message key="FEMALE" />


						</c:otherwise>
					</c:choose>

				</div>

				<div class=" form-group">

					<label class="control-label"><fmt:message key="ROLE" /> :
					</label>

					<c:choose>

						<c:when test="${CURRENT_SESSION_ACCOUNT.idRole == '1'}">


							<fmt:message key="ADMIN" />


						</c:when>

						<c:otherwise>




							<fmt:message key="CUSTOMER" />
						</c:otherwise>

					</c:choose>

				</div>

				<div class="form-group">

					<label class="control-label"><fmt:message key="ACTIVE" />
						: </label>




					<c:choose>
						<c:when test="${CURRENT_SESSION_ACCOUNT.active == '1'}">


							<fmt:message key="YES" />


						</c:when>

						<c:otherwise>


							<fmt:message key="NO" />

						</c:otherwise>
					</c:choose>


				</div>
		</td>

	</tr>
</table>
