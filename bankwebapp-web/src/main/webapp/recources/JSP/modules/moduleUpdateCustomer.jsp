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

			<form action="updateImage?IdCustomer=${customer.idCustomer}"
				method="POST" enctype="multipart/form-data">

				<div class="form-group">

					<img alt="" src="showImage.php?IdCustomer=${customer.idCustomer} "
						height="250" width="190"> 

				</div>

				<div class="form-group">
					<label class="control-label" for="exampleInputFile">Change
						photo</label> <input type="file" name="photo" required="required">
					<p class="help-block">Only *jpg, *png, *jpeg files allowed</p>
				</div>

				<button type="submit" class="btn  btn-primary" value="Submit">Submit</button>
			</form>

		</td>


		<td>&nbsp &nbsp &nbsp &nbsp &nbsp</td>
		<td>

			<form role="form" method="POST" action='updateCustomer.php?IdCustomer=${customer.idCustomer}'>
				<div class="form-group">

					<div class="form-group">

						<label class="control-label" for="name"><fmt:message
								key="NAME" /></label> <input type="text" class="form-control"
							name="name" value="<c:out value="${customer.name}" />" required>

					</div>


					<label class="control-label" for="login"><fmt:message
							key="LOGIN" /></label> &nbsp<span id="checkLogin"> </span> <input
						type="text" class="form-control" name="login"
						value="<c:out value="${customer.login}" />" id="login"
						onkeyup="checkLogin()" required>
				</div>


				<div class="form-group">

					<label class="control-label" for="password"><fmt:message
							key="PASSWORD" /></label> <input type="password" class="form-control"
						name="password" value="<c:out value="${customer.password}" />"
						required>
				</div>

				<div class="form-group">

					<label class="control-label" for="email"><fmt:message
							key="EMAIL" /></label> &nbsp<span id="checkEmail"> </span> <input
						type="text" class="form-control" name="email" id="email"
						onkeyup="checkEmail()" value="<c:out value="${customer.email}" />"
						required>
				</div>

				<div class="radio, form-group">

					<label class="control-label"><fmt:message key="GENDER" />
						: </label>

					<c:choose>

						<c:when test="${customer.gender == 'male'}">

							<input type="radio" name="gender" value="male" CHECKED>
							<fmt:message key="MALE" />

							<input type="radio" name="gender" value="female">
							<fmt:message key="FEMALE" />

						</c:when>
						<c:otherwise>

							<input type="radio" name="gender" value="female" CHECKED>
							<fmt:message key="FEMALE" />

							<input type="radio" name="gender" value="male">
							<fmt:message key="MALE" />
						</c:otherwise>
					</c:choose>

				</div>

				<div class="radio, form-group">

					<label class="control-label"><fmt:message key="ROLE" /> :
					</label> 
					
					<c:choose>
					
					<c:when test="${customer.idRole == '1'}">
					
					<input type="radio" name="idRole" value="1" CHECKED >
					<fmt:message key="ADMIN" />

					
					</c:when>
					
					<c:otherwise>
					
					

					<input type="radio" name="idRole" value="2" CHECKED >
					<fmt:message key="CUSTOMER" />
					</c:otherwise>
					
					</c:choose>
					
				</div>

				<div class="radio, form-group">

					<label class="control-label"><fmt:message key="ACTIVE" />
						: </label> 
						
						<c:choose>
						
						<c:when  test="${customer.idCustomer==sessionScope.CURRENT_SESSION_ACCOUNT.idCustomer}">
						
						
						
						<input type="radio" name="active" VALUE="1" CHECKED >
					<fmt:message key="YES" />

					
			
						</c:when>
						
						
						<c:otherwise>
						<c:choose>
						<c:when test="${customer.active == '1'}">
						
						<input type="radio" name="active" VALUE="1" CHECKED>
					<fmt:message key="YES" />

					<input type="radio" name="active" VALUE="0">
					<fmt:message key="NO" />
						</c:when>
						
						<c:otherwise>
						
						<input type="radio" name="active" VALUE="1" >
					<fmt:message key="YES" />

					<input type="radio" name="active" VALUE="0" CHECKED>
					<fmt:message key="NO" />
						
						</c:otherwise>
						</c:choose>
						</c:otherwise>
						</c:choose>
						
				</div>



				<button type="submit" class="btn  btn-primary" value="Submit">Submit</button>
			</form>


		</td>

	</tr>
</table>
