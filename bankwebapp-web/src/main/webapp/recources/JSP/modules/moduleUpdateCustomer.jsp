<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table >
  <tr>
    <td colspan = "2"></td>
    <td ></td>
    
  </tr>
  <tr>
    <td>
    
    <form action="">
    
    <div class="form-group">
    
    <img alt="" src="showImage.php?IdCustomer=${customer.idCustomer} " height="250" width="190">

<img alt="" src="<c:url value = "C:\Users\Sunny\Documents\workspace-sts-3.4.0.RELEASE\bankwebapp-parent\bankwebapp-web\src\main\webapp\recources\photos\1.JPG" > </c:url>" height="250" width="190">

</div>

<div class="form-group"> 
    <label class="control-label" for="exampleInputFile">Change photo</label>     

    <input type="file" id="exampleInputFile"> 
    <p class="help-block">Only *jpg, *png, *jpeg files allowed</p> 
</div>

<button type="submit" class="btn  btn-primary" value="Submit">Submit</button>
</form>

</td>
    
    
    <td >  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp</td>
    <td> 
    
    <form role="form" method="POST" action='registerCustomer.php'> 
<div class="form-group">

<div class="form-group">

 <label class="control-label" for="name"><fmt:message key="NAME" /></label>
 <input type="text" class="form-control" name="name" placeholder="Input a name"  required > 

</div>


 <label class="control-label" for="login"><fmt:message key="LOGIN" /></label>
 &nbsp<span id="checkLogin"> </span>
 <input type="text" class="form-control" name="login" placeholder="Pick up a login" id = "login" onkeyup="checkLogin()" required> 
</div>
 

<div class="form-group">

 <label class="control-label" for="password"><fmt:message key="PASSWORD" /></label>
 <input type="password" class="form-control" name="password" placeholder="Input a password" required> 
</div>

<div class="form-group">

 <label class="control-label" for="email"><fmt:message key="EMAIL" /></label>
 &nbsp<span id="checkEmail"> </span>
 <input type="text" class="form-control" name="email" id = "email" onkeyup="checkEmail()" placeholder="Input an email" required> 
</div>

<div class="radio, form-group"> 

<label class="control-label" ><fmt:message key="GENDER" /> : </label>  

<input type="radio" name="gender" value="male" checked > <fmt:message key="MALE" />

<input type="radio" name="gender" value="female" > <fmt:message key="FEMALE" />
</div>

<div class="radio, form-group"> 

<label class="control-label" ><fmt:message key="ROLE" />        :  </label>

<input type="radio" name="role" VALUE="1" CHECKED  > <fmt:message key="ADMIN" />

<input type="radio" name="role" VALUE="2" > <fmt:message key="CUSTOMER" />
</div>

<div class="radio, form-group"> 

<label class="control-label" ><fmt:message key="ACTIVE" />        :  </label>

<input type="radio" name="active" VALUE="1" CHECKED  > <fmt:message key="YES" />

<input type="radio" name="active" VALUE="0" > <fmt:message key="NO" />
</div>



<button type="submit" class="btn  btn-primary" value="Submit">Submit</button>
</form>
    
    
    </td>
  
  </tr>
</table>
