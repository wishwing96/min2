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
		<td>상품 수량</td>
		<td>상품가격</td>
		<td>선택</td>
	</tr>

<c:forEach items="${list}" var="list" varStatus="status">

	<input type="hidden" value="${list.uploadPath }" id="path${status.count}">
	<input type="hidden" value="${list.uuid }" id="uuid${status.count}">
	<input type="hidden" value="${list.filename}" id="filename${status.count}">
	
	<tr>
		<td><div class="img${status.count}"></div></td>
		<td>${list.name }</td>
		<td>${list.proexplain }</td>
		<td>${list.amount }</td>
		<td>${list.price }</td>
		<td>
			<divclass="checkBox">
				<input type="checkbox" name="chBox" class="chBox" data-cartNum="${list.no}">
			</div>
		</td>
	</tr>

	<script>
	

	$(document).ready(function(){
		var str="";
		
			
			var file=$("#path${status.count}").val()+"/"+$("#uuid${status.count}").val()+"_"+$("#filename${status.count}").val();
			
			str = "<div>"+"<img src='display?filename="+file+"' width='100' height='100'>"+"<div>"
			
			$(".img${status.count}").append(str);
		
	});
	
	</script>

</c:forEach>

<tr><td colspan="5"><a href="adminpage">상품등록</a></td><td><input type="button" class="selectDelete_btn" value="삭제"></td></tr>

</table>
</form>
</body>
</html>