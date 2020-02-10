<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="resources/css/join.css">
<link rel="stylesheet" type="text/css" href="resources/css/login.css">
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
							<td><a>cart</a></td>
							<td><a href="board_list">board</a></td>
						</tr>
					</table>
				</c:if>
				<c:if test="${vo!=null}">
					<table>
						<tr>
							<td><a href="information">${vo.uname}님 환영합니다.</a></td>
							<td><a href="logout">logout</a></td>
							<td><a>cart</a></td>
							<td><a href="board_list">board</a></td>
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
				<td><input type="checkbox" value="${num}" name="check"></td>
				<td><input type="hidden" value="${order.orderno}" id="orderno">
					${order.orderno }</td>
				<td>${order.name }</td>
				<td>${order.uid }</td>
				<td>${order.opt }</td>
				<td>${order.uaddress }</td>
				<td>${order.uphone }</td>
				<td>${order.msg }</td>
			</tr>
			
			<c:set var="num" value="${num+1}"></c:set>
			</c:forEach>

			<tr><th colspan="7"><input type="button" value="발송" id="post"><input type="button" value="발송완료" id="completion"></th></tr>
		
		</table>

	</div>

</div>

</body>
</html>




































