<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>Add new customer</title>
</head>
<body>
  

    <form method="POST" action='registerCustomer.php' name="formAddCustomer" >
      
             Login : <input
            type="text" name="login"
             /> <br />
             Password : <input
            type="password" name="password"
             /> <br /> 
         Name : <input
            type="text" name="name"
            /> <br /> 
        Gender :  <input TYPE="radio" NAME="gender" VALUE="male" CHECKED>
             Male
            <br>
            <INPUT TYPE="radio" NAME="gender" VALUE="female">
             Female
            <br>
        
        Role :  <input TYPE="checkbox" NAME="role" VALUE="1" CHECKED>
            ADMIN
            <br>
            <INPUT TYPE="checkbox" NAME="role" VALUE="2">
             CUSTOMER
            <br>
        
         <br /> 
         
         <input
            type="submit" value="Submit" />
    </form>
</body>
</html>