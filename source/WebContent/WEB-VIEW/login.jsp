<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
</head>
<body>

<div class="container-fluid">
  <div class="container">

    <div class="col-lg-4 form">
      <h3><b>Sign in</b></h3>
      <form action="${pageContext.request.contextPath}/login" method="post">
      	<input type="hidden" name="action" value="dologin">
      	
      	<% String outmsg = (String)request.getAttribute("msg");
      		
      		if(outmsg == null){
      			outmsg = "";
      		}
      	
      	%>
      	<p style="color:red"><%=outmsg %></p>
      	
      	<%@ page import="model.*" %>
      	
      	<%
      		//If cookies == null set input equal session account Obj
			String emailC = "";
			String pwdC = "";
			
			Account account = (Account)session.getAttribute("account");
			
			emailC = account.getEmail();
			pwdC = account.getPassword();

			//Autocomplete fileds if checked 'Remember me'
			Cookie[] cookies = request.getCookies();
			
			if(cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					
					if(cookie.getName().equals("email")) {
						emailC = cookie.getValue();
					} else if(cookie.getName().equals("password")) {
						pwdC = cookie.getValue();
					}
					
				}
					
			}

      	
      	%>
      	
        <div class="username"><input type="text" name="email" value="<%=emailC %>" placeholder="Enter email"></div>
        <div class="password"><input type="password" name="password" value="<%=pwdC %>" placeholder="Enter password"></div>
        
        <p><a href="#">Forgot your password?</a></p>
        
		<p style="color:red"><%=request.getAttribute("message") %></p>
        
        <input type="checkbox" name="rememberme" value="yes">
		<label for="rememberme"> Remember me</label><br>
        
        <button type="submit" name="button" class="btn btn-warning"><b>LOGIN</b></button>
      </form>
    </div>
    <div class="col-lg-4 info">
      <h3>Welcome Back!</h3>
      <p>To keep connected with us please login your personal info</p>
    </div>

  </div>
</div>

</body>
</html>