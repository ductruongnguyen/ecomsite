<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:import url="/WEB-VIEW/header.jsp"></c:import>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Product Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/productDetail.css">
</head>
<body>
    
    <div class="container product-detail">

        <div class="row">
            <h2>${product.getName()}</h2>
        </div>
        <hr>
        <div class="row">
            <div class="left col-lg-4">
                <img src="${product.getSrc()}" alt="iPhone">
            </div>
            <div class="right col-lg-8">
            <c:set var="price" scope="request" value="${product.getPrice()}"></c:set>
                <h3 class="product-price"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${price}" />đ</h3>
                <c:set var="string" value="${product.getDescription()}"></c:set>
                <c:set var="lines" value="${fn:split(string,';')}"></c:set>
                
                <c:forEach var="line" items="${lines}">
                	<p>${line}</p>
                </c:forEach>
                              
               	<a href="${pageContext.request.contextPath}/addtocart?action=add&id=${product.id}"><button class="btn btn-warning">Add to cart</button></a>
              
            </div>
        </div>
        
    </div>
    
</body>
</html>
<c:import url="/WEB-VIEW/footer.jsp"></c:import>