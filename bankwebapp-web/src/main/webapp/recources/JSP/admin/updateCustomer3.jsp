<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
       
        <title>Register new customer</title>
        <style>
        <!-- Bootstrap core CSS -->
         
         <%@include file="/recources/css/bootstrap.css" %>
        
        
        <!-- Custom styles for this template -->
         <%@include file="/recources/css/dashboard.css" %>
         
      </style>
      
      
      <script type="text/javascript" >

      <%@include file="/recources/js/checkLoginAvailability.js" %>
      <%@include file="/recources/js/checkEmailAvailability.js" %>

</script>  
       
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                  
                    <a class="navbar-brand" >MyBank</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        
                        <li>
                            <a href="#"><fmt:message key="LOGOUT" /></a>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-right">
</form>
                </div>
            </div>
        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar">
                        <li >
                            <a href="home.php"><fmt:message key="HOME" /> <span class="sr-only">(current)</span></a>
                        </li>
                        <li></li>
                        <li></li>
                        <li >
                            <a href="customerList.php"><fmt:message key="CUSTOMERS" /></a>
                        </li>
                        <li></li>
                        <li></li>
                         <li >
                            <a href="accountList.php"><fmt:message key="ACCOUNTS" /></a>
                        </li>
                        
                    </ul>
                    <ul class="nav nav-sidebar">
                        <li >
                            <a href="registerCustomer.php"><fmt:message key="REGISTER_NEW_CUSTOMER" /></a>
                      </li>   
                        
                    </ul>
                  
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h2 class="sub-header" ><fmt:message key="UPDATE_CUSTOMER_INFO" /></h2>
               
               <jsp:include page="../modules/moduleUpdateCustomer.jsp"></jsp:include>
                </div>
                
               
            </div>
        </div>
       
    </body>
</html>
