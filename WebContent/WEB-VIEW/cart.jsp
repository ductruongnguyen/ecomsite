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
    <title>Cart Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/cart.css">
</head>
<body>

<div class="container">

    <div class="row cart-row">
        <table class="product-info">
        <c:set var="products" scope="session" value="${cart.getItems()}"></c:set>
            <tr>
                <th>Product in cart: <span>${products.size()}</span></th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Amount</th>
            </tr>
            <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.name} <br><span>ID: ${product.id}</span><br>
                <a href="${pageContext.request.contextPath}/addtocart?action=remove&id=${product.id}"><span style="color:red;font-size:14px"><i class="fa fa-times"></i> remove</span></a>
                </td>
                <td>(đ) <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${product.price}" /></td>
                <td>${product.number}</td>
                <td>(đ) <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${product.number*product.price}" /></td>
            </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <c:set var="amount" scope="session" value="${cart.getAmount()}" ></c:set>
                <td>Total: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${amount}" />đ</td>
            </tr>
        </table>
    </div>

    <div class="row cart-row">
        <div class="left col-lg-4">
            <p>Customer name:</p>
            <p>Customer address:</p>
            <p>Discount code (If any):</p>
        </div>
        <div class="right col-lg-5">
        <form action="${pageContext.request.contextPath}/payment" method="POST">
            <input class="customer-detail" type="text" name="customername" required>
            <input class="customer-detail" type="text" name="address" required>
            <input class="customer-detail" type="text" name="discount">
            <button type="submit" class="btn btn-warning">Submit</button>
            <span style="color:red;font-size:16px">${msg}</span>
            <br>
        </form>    
        </div>
        
    </div>
    
</div>
    
</body>
</html>

<c:import url="/WEB-VIEW/footer.jsp"></c:import>
