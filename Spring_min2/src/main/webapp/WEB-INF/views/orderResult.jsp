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
<div id="logbox">
<table border="1">

<tr><td>주문자</td><td>${result.uid }</td></tr>
<tr><td>상품</td><td>${result.name }</td></tr>
<tr><td>가격</td><td>${result.price }</td></tr>
<tr><td>주소</td><td>${result.uaddress }</td></tr>
<tr><td>전화번호</td><td>${result.uphone }</td></tr>

</table>
			
</div>
</body>
</html>














































