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

				<img alt="" src="showImage.php?IdCustomer=${customer.idCustomer} "
					height="250" width="190">

			</div>

		</td>


		<td>&nbsp &nbsp &nbsp &nbsp &nbsp</td>
		<td>



			<div class="form-group">

				<div class="form-group">

					<label class="control-label"><fmt:message key="NAME" /></label>
					:&nbsp
					<c:out value="${customer.name}" />

				</div>

				<div class="form-group">
					<label class="control-label"><fmt:message key="LOGIN" /></label>
					:&nbsp
					<c:out value="${customer.login}" />
				</div>


				<div class="form-group">

					<label class="control-label"><fmt:message key="PASSWORD" /></label>
					:&nbsp
					<c:out value="${customer.password}" />
				</div>

				<div class="form-group">

					<label class="control-label"><fmt:message key="EMAIL" /></label>
					:&nbsp
					<c:out value="${customer.email}" />
				</div>

				<div class=" form-group">

					<label class="control-label"><fmt:message key="GENDER" />
						: </label>

					<c:choose>

						<c:when test="${customer.gender == 'male'}">


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

						<c:when test="${customer.idRole == '1'}">


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
						<c:when test="${customer.active == '1'}">


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
