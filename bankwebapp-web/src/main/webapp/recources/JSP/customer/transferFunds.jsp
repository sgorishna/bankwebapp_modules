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

    
      <%@include file="/recources/js/checkIsOnlyNumbers.js" %>
      <%@include file="/recources/js/checkAmount.js" %>

</script>  
      
       
    </head>
    <body>
        <nav class="navbar navbar-inverse-blue navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                  
                    <a class="navbar-brand" >MyBank</a>
                      <img class="profile-img" src="../image"
                   >
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        
                        <li>
                            <a href="../logout"><fmt:message key="LOGOUT" /></a>
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
                         <li >
                         
                            <a href="MyProfile.php"><fmt:message key="MY_PROFILE" /> <span class="sr-only">(current)</span></a>
                        </li>
                        
                        <li >
                            <a href="myAccounts.php"><fmt:message key="MY_ACCOUNTS" /></a>
                        </li>
                        
                    </ul>
                   
                  
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h2 class="sub-header" ><fmt:message key="TRANSFER_FUNDS" /></h2>
                    
                      <ol class="breadcrumb">
    <li><a href="MyProfile.php"><fmt:message key="MY_PROFILE" /></a>
    </li>
    
    <li><a href="myAccounts.php"><fmt:message key="MY_ACCOUNTS" /></a>
    </li>
    
    <li><a href="transactions.php"><fmt:message key="MY_TRANSACTIONS" /></a>
    </li>
   
    
    
</ol>
             <jsp:include page="../modules/resultMsg.jsp"></jsp:include>    
           <jsp:include page="../modules/customer/moduleTransferFunds.jsp"></jsp:include>   
                </div>
                
               
            </div>
        </div>
       
    </body>
</html>
