<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-VIEW/header.jsp"></c:import>

  <div class="container-fluid">
    <div class="container">
		
		<p style="margin:20px;text-align:center">${message}</p>
		
      <div class="row product-row">
      	<c:forEach items="${results}" var="product">
	        <div class="col-lg-3 col-lg-3 col-md-6 col-sm-12 product">
	          <a href="${pageContext.request.contextPath}/informationProduct?id=${product.id}"><img src= "${product.src}"></a>
	          <h6 class="product-cat"><a href="#">${product.type}</a></h6>
	          <h5 class="product-title"><a href="${pageContext.request.contextPath}/informationProduct?id=${product.id}">${product.name}</a></h5>
	          <p class="product-price"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${product.price}" />đ</p>
	        </div>
		</c:forEach>
      </div> <!-- end row -->
      
    </div> <!-- end container -->
  </div> <!-- end container-fluid -->

<c:import url="/WEB-VIEW/footer.jsp"></c:import>