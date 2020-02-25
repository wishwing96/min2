<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="resources/css/join.css">
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="resources/js/adminOrder.js"></script>
</head>
<body>
		<!-- Header -->
			<header id="header" class="alt">
				<div class="inner">
						<c:if test="${vo==null}">
			<table>
				<tr>
					<td><a href="login">login</a></td>
					<td><a href="join">join</a></td>
					<td><a href="login">cart</a></td>
					<td><a href="board_list">board</a></td>
				</tr>
			</table>
		</c:if>
		<c:if test="${vo!=null && vo.uid.equals('admin')==false}">
			<table>
				<tr>
					<td><a href="information">${vo.uname}님 환영합니다.</a></td>
					<td><a href="logout">logout</a></td>
					<td><a href="cartList">cart</a></td>
					<td><a href="board_list">board</a></td>
				</tr>
			</table>
		</c:if>
		<c:if test="${vo.uid.equals('admin')}">

			<table>
				<tr>
					<td><a href="register">${vo.uname}님 환영합니다.</a></td>
					<td><a href="logout">logout</a></td>
					<td><a href="board_list">board</a></td>
					<td><a href="adminOrder">order</a></td>
				</tr>
			</table>
	
		</c:if>
					<h1><a href="main">이달의 꽃</a></h1>
					<p>A free responsive site template by</p>
				</div>
			</header>
<div id="all">

	<div id="top">
		<h1>주문조회</h1>
	</div>
	<div id="middle">
		<table>

			<tr>
				<td>주문번호</td>
				<td>상품</td>
				<td>주문자</td>
				<td>옵션</td>
				<td>주소</td>
				<td>전화</td>
				<td>배송상태</td>
			</tr>
			<c:set var="num" value="0"></c:set>
			<c:forEach items="${order}" var="order">
			
			<tr>
				<td>
					<input type="hidden" value="${order.orderno}" id="orderno${num}">
					${order.orderno }</td>
				<td>${order.name }</td>
				<td>${order.uid }</td>
				<td>${order.stock }</td>
				<td>우편 번호:${order.address1 }<br>
					주소: ${order.address2 }<br>
					상세 주소: ${order.address3 }</td>
				<td>${order.uphone }</td>
				<td>${order.msg }</td>
			</tr>
			
			<tr><th colspan="7"><input type="button" value="발송" id="post${num}"><input type="button" value="발송완료" id="completion${num}"></th></tr>
				<script>
			
				$("#post${num}").click(function(){	
					   var orderno = $("#orderno${num}").val();
						alert(orderno);
						var state = 1;
						$.ajax({
							type : "put",
							url : "state/"+orderno,
							contentType : "application/json",
							dataType : "text",
							data : JSON.stringify({state:state}),
							success	: function(data){
								alert("ok");
							},
							error : function(err){
								alert("error");
							}
						})
				})
				
				$("#completion${num}").on("click", function(){
				var orderno = $("#orderno${num}").val();
				alert(orderno);
				var state = 2;
				$.ajax({
					type : "put",
					url : "state/"+orderno,
					contentType : "application/json",
					dataType : "text",
					data : JSON.stringify({state:state}),
					success	: function(data){
						alert("ok");
					},
					error : function(err){
						alert("error");
					}
				})
			})
			
			</script>
			<c:set var="num" value="${num+1}"></c:set>
			
			
			</c:forEach>

			
		
		
			
		</table>

	</div>

</div>

</body>
</html>




































