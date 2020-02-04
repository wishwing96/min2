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
				<td>주문자</td>
				<td>주문상품</td>
				<td>결제금액</td>
				<td>옵션확인</td>
				<td>주소확인</td>
				<td>전화확인</td>
			</tr>
<c:forEach items="${check }" var="check">
			<tr>
				<td>${check.uid }</td>
				
				<td>${check.name }</td>
				
				<td>${check.price }</td>
				
				<td>${check.opt }</td>
				
				<td>${check.uaddress }</td>
				
				<td>${check.uphone }</td>
			</tr>
</c:forEach>
		</table>

	</div>

</div>

</body>
</html>

















































