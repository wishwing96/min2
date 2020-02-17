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
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="resources/js/main_detail.js"></script>
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

<form method="post" name="form1">
<c:forEach items="${file}" var="file" varStatus="status">

	<input type="hidden" value="${file.uploadPath }" id="path${status.count}">
	<input type="hidden" value="${file.uuid }" id="uuid${status.count}">
	<input type="hidden" value="${file.filename}" id="filename${status.count}">

</c:forEach>

<input type="hidden" value="${num }" id="num">

<div class="img"></div>
	<div id="a">
	<table>
	<tr><td>꽃 종류</td><td>${us.name}</td></tr>
	<tr><td>가격</td><td>${us.price }원</td></tr>
	<tr><td>설명</td><td>${us.proexplain }</td></tr>

	<tr><th colspan="2"><a href="order?no=${us.no}">구매하기</a>||<input type="button" value="장바구니" id="cart"></th></tr>
	<tr><td colspan="2"><div class="replies"></div></td></tr>
	</table>
</div>

	<c:if test="${vo==null}">
		<p>댓글 남기려면 <a href="login">로그인</a>하러가기</p>
	</c:if>
	
	<c:if test="${vo!=null}">
		<input type="hidden" name="gdsnum" id="gdsnum" value="${us.no}">
		<input type="hidden" name="uid" id="uid" value="${vo.uid}">
		<table>
		
			<tr><td><textarea name="repcon" id="repcon"></textarea></td>
			<td><input type="button" id="reply" value="reply" ></td></tr>
			
		</table>
	</c:if>

</form>
</body>
</html>






























