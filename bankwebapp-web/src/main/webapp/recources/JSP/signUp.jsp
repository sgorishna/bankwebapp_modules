<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
        <%@include file="/recources/css/style.css" %>
        <%@include file="/recources/css/bootstrap.min.css" %>
</style>

<title>Sign Up</title>
</head>
<body>

 <div class="container" style="margin-top: 20px; margin-bottom: 40px">
      <div class="row"><h2 align="center" >Sign Up</h2>
  </div>
 <p>

<form class="form-horizontal"> 

<div class="form-group">
        <label for="name" class="col-md-2">Name</label>
        <div class="col-xs-6">
            <input type="name" class="form-control" id="name" placeholder="Name">
        </div>
    </div>
    
    <div class="form-group">
        <label for="login" class="col-md-2">Login</label>
        <div class="col-xs-6">
            <input type="login" class="form-control" id="login" placeholder="Login">
        </div>
    </div>
    
    <div class="form-group">
        <label for="password" class="col-md-2">Password</label>
        <div class="col-xs-6">
            <input type="password" class="form-control" id="password" placeholder="Password">
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


 <div class="form-group">
      <label for="uploadimage" class="col-md-2">
        Upload Image:
      </label>
      <div class="col-md-10">
        <input type="file" name="uploadimage" id="uploadimage">
        <p class="help-block">
          Allowed formats: jpeg, jpg, gif, png
        </p>
      </div>
</div>

<div class="col-xs-6">
    <button type="submit" class="btn btn-primary" >Sign up</button>
   </div> 
    </form>

</body>
</html>