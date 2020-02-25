<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="resources/js/register.js"></script>
</head>
<body>

<form method="post" id="form">
<table border="1">

	<tr>
		<td>상품 이미지</td>
		<td>상품 이름</td>
		<td>상품 설명</td>
		<td>상품가격</td>
		<td>선택</td>
	</tr>

<c:forEach items="${list}" var="list" varStatus="status">

	
	<tr>
		<td><img src='display?filename=${list.file }' width='300' height='300'></td>
		<td>${list.name }</td>
		<td>${list.proexplain }</td>
		<td>${list.price }</td>
		<td>
			<divclass="checkBox">
				<input type="checkbox" name="chBox" class="chBox" data-cartNum="${list.no}">
			</div>
		</td>
	</tr>


</c:forEach>

<tr><th colspan="4"><a href="adminpage">상품등록</a> || <a href="main">main</a></th><td><input type="button" class="selectDelete_btn" value="삭제"></td></tr>

</table>
</form>
</body>
</html>