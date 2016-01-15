<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
        <%@include file="/recources/css/style.css" %>
        <%@include file="/recources/css/bootstrap.css" %>
         <%@include file="/recources/css/dashboard.css" %>
</style>


<title>Remind credentials</title>
</head>
<body>


 <nav class="navbar navbar-inverse-blue navbar-fixed-top " >
            <div class="container-fluid">
                <div class="navbar-header">
                  
                    <a class="navbar-brand" >MyBank</a>
                    <img  src="image"
                   >
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    
                    
                </div>
            </div>
        </nav>


   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h2 class="sub-header" ><fmt:message key="REMIND_CREDENTIALS" /></h2>
                
                </div>
  

 <c:choose>
 
 <c:when test="${requestScope.success != null}">
  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
   <h4 class="text" >${requestScope.success}</h4> 
   
    <a href="login.php" class="text-left new-account">Back to Login  </a> 
 </div>
 

 </c:when>
 
 <c:otherwise>
 
 
 <div class="col-sm-7 col-sm-offset-2 col-md-10 col-md-offset-2 main">
               <c:choose>
               <c:when test="${requestScope.error != null}">
                    <h4 style="color: red" >${requestScope.error}</h4> </c:when> 
                   
                   </c:choose>  

<form  action="RemindCredentials " method="post"> 

<table cellspacing="50" >
<tr>

<td>

 <label class="col-sm-1" for="email"><fmt:message key="EMAIL" /></label>
 

</td>

<td colspan="5"> 
<input type="text" class="form-control" name="email" id = "email" placeholder="Input an email" required>

 </td>


</tr>

<tr>

<td><p></td>
<td><p></td>
</tr>

<tr>

<td></td>

<td>

<button type="submit" class="btn btn-primary" >Email credentials</button>

</td>

</tr>

<tr>

<td>


</td>

<td>
<a href="login.php" class="text-left new-account">Back to Login  </a> 

</td>

</tr>

</table>

  
    </form>
 
 </div>
 
 </c:otherwise>
 
 </c:choose>
 
  
 


</body>
</html>