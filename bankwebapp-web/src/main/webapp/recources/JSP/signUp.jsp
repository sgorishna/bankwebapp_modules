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

 <script type="text/javascript" >

      <%@include file="/recources/js/checkLoginAvailability.js" %>
      <%@include file="/recources/js/checkEmailAvailability.js" %>
      
</script>  

<title>Sign Up</title>
</head>
<body>


 <nav class="navbar navbar-inverse-blue navbar-fixed-top " >
            <div class="container-fluid">
                <div class="navbar-header">
                  
                    <a class="navbar-brand" >MyBank</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    
                    
                </div>
            </div>
        </nav>

<!--  <div class="container" style="margin-top: 20px; margin-bottom: 40px">
      <div class="row"><h2 align="center" >Sign Up</h2>
  </div> -->
  
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h2 class="sub-header" ><fmt:message key="SIGN_UP" /></h2>
                
                </div>
  

 
  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
               <c:choose>
               <c:when test="${requestScope.error != null}">
                    <h2 class="sub-header" >${requestScope.error}</h2> </c:when> 
                   
                   </c:choose>  

<form class="form-horizontal" action="signUp.php " method="post"> 

<div class="form-group">
        <label for="name" class="col-md-2">Name</label>
        <div class="col-xs-6">
            <input type="name" class="form-control" name="name" id="name" placeholder="Name" required>
        </div>
    </div>
    
    <div class="form-group">

 <label class="col-md-2" for="email"><fmt:message key="EMAIL" /></label>
 &nbsp<span id="checkEmail"> </span>
 
 <div class="col-xs-6"><input type="text" class="form-control" name="email" id = "email" onkeyup="checkEmail()" placeholder="Input an email" required> 
</div></div>
    
    
    <div class="form-group">
        <label for="login" class="col-md-2">Login</label>
        
         &nbsp<span id="checkLogin"> </span>
        <div class="col-xs-6">
            <input type="login" class="form-control" id="login" name="login"  placeholder="Login" onkeyup="checkLogin()" required>
        </div>
    </div>
    
    <div class="form-group">
        <label for="password" class="col-md-2">Password</label>
        <div class="col-xs-6">
            <input type="password" class="form-control" name="password" id="password" placeholder="Password" required>
        </div>
    </div>

 <div class="form-group">
      <label for="gender" class="col-md-2">
        Gender:
      </label>
      <div class="col-xs-6">
        <label class="radio">
          <input type="radio" name="gender" id="gender" value="male" checked>
          Male
        </label>
        <label class="radio">
          <input type="radio" name="gender" id="gender" value="female">
          Female
        </label>
      </div>
 
 
    </div>

<div class = "form-group"></div>

  <div class="row, col-lg-5" align="right"> 
   <button type="submit" class="btn btn-primary" >Sign up</button>
   
   </div>
 
  </form>
   
  
  
   <div class="row, col-lg-1" align = "center"> 
   
   <form class="form-horizontal" action = "login.php" method = "get" >
   
    <button type="submit" class="btn btn-primary">Cancel</button>
  
  </form>
   </div>
   
   
   </div> 
  
    



</body>
</html>