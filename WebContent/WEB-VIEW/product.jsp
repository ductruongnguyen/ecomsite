<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!-- Body and Products Part -->

<div class="container-fluid">
  <div class="container">

    <div class="row product-row">
    	<c:forEach items="${listProduct}" var="product">
       <div class="col-lg-3 col-lg-3 col-md-6 col-sm-12 product">
         <a href="${pageContext.request.contextPath}/informationProduct?id=${product.id}"><img src= "${product.src}"></a>
         <h6 class="product-cat"><a href="#">${product.type}</a></h6>
         <h5 class="product-title"><a href="${pageContext.request.contextPath}/informationProduct?id=${product.id}">${product.name}</a></h5>
         <p class="product-price"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${product.price}" />đ</p>
       </div>
</c:forEach>
    </div> <!-- end row -->
    
    <div class="pagina">
    	<c:set var="current" value="${currentPage}"></c:set>
    	<c:set var="max" value="${max}"></c:set>
    	
    	<c:if test="${current > 1}">
    		<a href="${pageContext.request.contextPath}/home?page=${current - 1}"><div class="page-num"><i id="arrow" class="fa fa-angle-double-left"></i></div></a>
      </c:if>
      
      <c:forEach var="j" begin="1" end="${page}">
      	<a href="${pageContext.request.contextPath}/home?page=${j}"><div class="page-num">${j}</div></a>
      </c:forEach>
      
      <c:if test="${current < max}">
      <a href="${pageContext.request.contextPath}/home?page=${current + 1}"><div class="page-num"><i id="arrow" class="fa fa-angle-double-right"></i></div></a>
    	</c:if>
    </div>
    
  </div> <!-- end container -->
</div> <!-- end container-fluid -->