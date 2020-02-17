<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join page</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="resources/css/join.css">

</head>
<body>


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
					<td><a>${vo.uname}님 환영합니다.</a></td>
					<td><a href="logout">logout</a></td>
					<td><a href="register">register</a></td>
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
				<td>주문자</td>
				<td>주문상품</td>
				<td>결제금액</td>
				<td>상품수량</td>
				<td>주소확인</td>
				<td>전화확인</td>
				<td>주문상태</td>
			</tr>
<c:forEach items="${check }" var="check">
			<tr>
				<td>${check.uid }</td>
				
				<td>${check.name }</td>
				
				<td>${check.price }원</td>
				
				<td>${check.stock }개</td>
				
				<td>${check.address1 } ${check.address2 } ${check.address3 }</td>
				
				<td>${check.uphone }</td>
				
				<td>${check.msg }</td>
			</tr>
</c:forEach>
		</table>

	</div>

</div>

</body>
</html>

















































