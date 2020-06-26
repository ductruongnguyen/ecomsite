<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
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
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/header.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/search.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/footer.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/product.css">
</head>
<body>

<!-- Header & Logo -->
  <div class="container-fluid header">
    <div class="container">
      <div class="row">

        <div class="col-xl-2 col-lg-3 logo">
          <h1>BRAND</h1>
          <p>Welcome to S-mobile</p>
        </div>

        <div class="col-xl-7 col-lg-6">
          <select class="search-tag">
            <option>Categories</option>
            <option value="iphone11">CELL PHONE</option>
            <option value="iphonex">TABLET</option>
            <option value="iphonexs">LAPTOP</option>
          </select>
          <form method="GET" action="${pageContext.request.contextPath}/search">
	          <input name="keyword" class="search-bar" type="text" placeholder="What are your looking for...">
	          <a href="${pageContext.request.contextPath}/search"><button type="submit" class="search-btn"><i class="fa fa-search"></i></button></a>
          </form>
        </div>

        <div class="col-xl-3 col-lg-3 login">
          <a href="<%= request.getContextPath() %>/login?action=login"><button id="login-btn" type="button" class="btn btn-primary"><i class="fa fa-user"></i> Login</button></a>
          <a href="<%= request.getContextPath() %>/login?action=register"><button id="register-btn" type="button" class="btn btn-warning">Register</button></a>
        </div>
      </div>
    </div>
  </div>

<!-- Navigation Bar -->
  <div class="container-fluid nav-bar">
    <div class="container nav-bar-child">
      <a href="/ASM3-PRJ321x/home">Home</a>
      <a href="/ASM3-PRJ321x/home">Product</a>
      <a href="#">About us</a>
      <div class="right">
    	<a href="${pageContext.request.contextPath}/WEB-VIEW/cart.jsp"><i class="fa fa-shopping-cart"></i></a>
    	<c:set var="products" scope="session" value="${cart.getItems()}"></c:set>
    	<c:set var="size" value="${products.size()}"></c:set>
    	<c:if test="${size > 0}"><p id="total">${size}</p></c:if>
    </div>
    </div>
  </div>