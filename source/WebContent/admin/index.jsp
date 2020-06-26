<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dash board</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/index.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

  <div class="container-fluid">
 	<!-- Welcome Messages -->
	<div class="welcome"><%=session.getAttribute("welcomemessage") %>
		<!-- Logout Button -->
		<div class="logout"><a href="<%= request.getContextPath() %>/logout?action=logout"><button class="btn btn-danger"><i class="fa fa-sign-out"></i> Logout</button></a></div>
    </div>
	
	<c:set var="welcome" scope="request" value="${welcomemessage}"></c:set>
	<c:if test="${welcome == null}">
		<c:redirect url="/home"/>
	</c:if>
	
    <!-- Control Panel -->
    <div class="col-xl-2 col-lg-2 col-md-4 panel">
      <h5>PRJ321x</h5>
      <div class="hr"></div>
      <ul>
      	<li class="item"><a href="${pageContext.request.contextPath}/admin/index.jsp"><i class="fa fa-th"></i> Dashboard</a></li>
        <li class="item"><a href="${pageContext.request.contextPath}/listproduct"><i class="fa fa-list-ul"></i> List of products</a></li>
        <li class="item"><a href="${pageContext.request.contextPath}/listorder"><i class="fa fa-list-ul"></i> Order Information</a></li>
        <li class="item"><a href="#"><i class="fa fa-user"></i> Staff Manager</a></li>
      </ul>
    </div>
	
	<!-- Dash board content -->
    <div class="col-xl-10 col-lg-10 col-md-8 content">
      <div class="row content-table">
        <h3>Chào mừng tới với dashboard quản trị!</h3>
        <p>Để sử dụng các chức năng vui lòng nhấn vào các items tại thanh panel bên trái!</p>
      </div>
      
      <div class="row content-banner"></div>
    </div> <!-- End Dash board -->

  </div>

</body>
</html>