<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/register.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class="container-fluid">
  <div class="container">

    <div class="col-lg-4 form">
      <h3><b>Register</b></h3>
      <form action="#">
        <div class="username"><input type="text" name="username" placeholder="Enter username"></div>
        <div class="password"><input type="password" name="password" placeholder="Enter password"></div>
        <div class="password"><input type="password" name="repassword" placeholder="Renter password"></div>
        <button type="button" name="button" class="btn btn-warning"><b>SIGN UP</b></button>
        <p style="color: red">This function is on maintenance! Try again later.</p>
        <a href="${pageContext.request.contextPath}/home"><i class="fa fa-arrow-left"></i> Back Home</a>
      </form>
    </div>
    <div class="col-lg-4 info">
      <h3>Your first time here?</h3>
      <p>Sign up to keep in touch with us.</p>
    </div>

  </div>
</div>

</body>
</html>
    