<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="resources/js/cartList.js"></script>
</head>
<body>

<table border="1">
<tr><td colspan="4"></td><td><input type="button" value="delete" id="delete"></td></tr>
<c:set var="num" value="0"></c:set>
<c:forEach items="${cart }" var="cart">



<tr>
	<td></td><td>제품 명</td><td>수량</td><td>가격</td><td>선택</td>
</tr>
<tr>
	<td><img src="display?filename=${cart.file }" width='300' height='300'></td><td>${cart.name }</td>
	<td>${cart.cartStock }</td><td>${cart.price }</td><td><input type="checkbox" name="chBox" class="chBox" data-cartNum="${cart.cartnum }"></td>
</tr>



<c:set var="num" value="${num+1}"></c:set>
</c:forEach>

<tr><td colspan="4"></td><td><input type="button" value="buy" id="buy"></td></tr>

</table>

</body>
</html>