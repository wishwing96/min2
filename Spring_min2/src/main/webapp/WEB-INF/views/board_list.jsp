<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="org.springframework.web.servlet.mvc.support.RedirectAttributes"  %>  


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board page</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="resources/css/join.css">
<link rel="stylesheet" type="text/css" href="resources/css/login.css">
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
							<td>${vo.uname}님 환영합니다.</td>
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

<table>

<tr>
	<td>번호</td>
	<td>제목</td>
	<td>후기</td>
	<td>글쓴이</td>
	<td>작성일자</td>
</tr>
<c:forEach items="${list}" var="board">
<tr>
	<td>${board.no }</td>
	<td><a href="board_detail?no=${board.no}">${board.subject}</a></td>
	<td>${board.content}</td>
	<td>${board.uid}</td>
	<td>${board.write_date}</td>
</tr>
</c:forEach>

<c:if test="${vo!=null}">
<tr><td colspan="4"><a href="board_write">글작성</a></tr></td>
</c:if>

<tr><td colspan="4">
<form action="board_list" method="get">
	<input type="hidden" name="pagenum" value="${page.rec.getpagenum()}">
	<input type="hidden" name="amount" value="${page.rec.getamount()}">
<input type="text" name="keyword">
<input type="submit" value="검색">
</form>

<c:if test="${page.prev}">
     <a href="board_list?pagenum=${page.startPage-1}&amount=${page.rec.amount}&keyword=${page.rec.keyword}">이전</a>
</c:if>

     <c:forEach var="num" begin="${page.startPage}" end="${page.endPage}" >
       <a href="board_list?pagenum=${num}&amount=${page.rec.amount}&keyword=${page.rec.keyword}">${num}</a>
     </c:forEach>
     <c:if test="${page.next}">
       <a href="board_list?pagenum=${page.endPage+1}&amount=${page.rec.amount}&keyword=${page.rec.keyword}">다음</a>
     </c:if>

     
</td></tr>

</table>


</body>
</html>










































