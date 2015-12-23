<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<form role="form" method="POST" action='addAccount.php?IdCustomer=${customer.idCustomer}'> 
<div class="form-group">

<div class="form-group">

 <label class="control-label" for="name"><fmt:message key="NAME" /></label>
 <input type="text" class="form-control" name="name" value="<c:out value="${customer.name}" />"  readonly="readonly" > 

</div>


 <label class="control-label" for="account_number"><fmt:message key="ACCOUNT_NUMBER" /></label>
  <div class="col-xs-12" "></div><span id="checkAccountNumber"> </span>
 <input type="text" class="form-control" name="accountNumber" value="<c:out value="${account.accountNumber}" />" id = "accountNumber" onkeyup="checkAccountNumber()" required> 
</div>
 


<div class="radio, form-group"> 

<label class="control-label" ><fmt:message key="ACCOUNT_TYPE" />        :  </label>

<input type="radio" name="accountType" VALUE="1" CHECKED  > <fmt:message key="DEBIT" />

<input type="radio" name="accountType" VALUE="2" > <fmt:message key="CREDIT" />
</div>

<div class="radio, form-group"> 

<label class="control-label" ><fmt:message key="CURRENCY" />        :  </label>

<input type="radio" name="currency" VALUE="1" CHECKED  > <fmt:message key="EUR" />

<input type="radio" name="currency" VALUE="2" > <fmt:message key="USD" />
</div>




<button type="submit" class="btn  btn-primary" value="Submit">Submit</button>
</form>