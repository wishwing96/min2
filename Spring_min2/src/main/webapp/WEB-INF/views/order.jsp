<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
<link rel="stylesheet" type="text/css" href="resources/css/main_detail.css">
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
			
<form action="order" method="post">

<table>

	<tr><td>상품</td><td><input type="hidden" name="name" value="${order.name }">${order.name }</td></tr>
	<tr><td>가격</td><td><input type="hidden" name="price" value="${order.price }">${order.price }</td></tr>
	<tr><td>옵션</td><td><input type="text" name="opt" value="" readonly></td></tr>
	<tr><td>구매자</td><td><input type="hidden" name="uid" value="${vo.uid }">${vo.uid }</td></tr>
	<tr><td>주소</td><td><textarea name="uaddress">${vo.uaddress }</textarea></td></tr>
	<tr><td>번호</td><td><input type="text" name="uphone" value="${vo.uphone }"></td></tr>
	<tr><td colspan="2"><input type="submit" value="구매하기"></td></tr>
</table>

</form>

</body>
</html>






























