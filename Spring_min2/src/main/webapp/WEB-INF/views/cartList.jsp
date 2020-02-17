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

<form action="cartList" method="post" >

<table border="1">
	<tr><td colspan="4"></td><td><input type="button" value="delete" id="delete"></td></tr>
		<c:set var="num" value="0"></c:set>
			<c:forEach items="${cart }" var="cart">
			<input type="hidden" value="${num }" id="num">
				<tr>
					<td></td><td>제품 명</td><td>수량</td><td>가격</td><td>선택</td>
				</tr>
				<tr>
					<td><img src="display?filename=${cart.file }" width='300' height='300'></td><td>${cart.name }</td>
					<td>${cart.cartStock }</td><td>${cart.price }</td>
					<td><input type="checkbox" name="chBox" class="chBox" data-cartnum="${cart.cartnum }" 
						data-cartStock="${cart.cartStock }" data-price="${cart.price }" value="${cart.name }"></td>
				</tr>
			<c:set var="num" value="${num+1}"></c:set>
		</c:forEach>
	

	<tr><td colspan="4"><div class="price"></div></td><td><input type="button" value="구매 정보 입력" id="buy"></td></tr>
	<tr>
		<td><input type="hidden" name="uid" value="${vo.uid}">${vo.uid}</td>
		<td>주소:<input type="text" name="uaddress" value="${vo.uaddress }"></td>
		<td>tel:<input type="text" name="uphone" value="${vo.uphone }"></td>
		<td><input type="submit" value="구매"></td>
	</tr>
	

	</table>
	
	<script>
	
		$("#buy").click(function(){
			$(".orderInfo").slideDown();
		})
		
		$(document).ready(function(){
			$("#buy").click(function(){
				
				if(confirm("제품을 구매 하시겠습니까?")){
					var checkArr = new Array();
					var price = 0;
					var name = "";
					var str1="";
					var str2="";
					
					$("input[class='chBox']:checked").each(function(){
						price = price + parseInt($(this).attr("data-price")*$(this).attr("data-cartStock"));
						name = name +"/"+ $(this).val();
						str1 = "<input type='text' value='"+price+"' name='price' readonly>원";
						str2 = "<input type='hidden' value='"+name+"' name='name'>"
						
					});
					$(".price").append(str1);
					$(".name").append(str2);

				}
			});
		});
		
	</script>
	<div class="name"></div>
</form>
</body>
</html>