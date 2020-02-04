<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script type="text/javascript" src="../resources/js/button.js"></script>

</head>
<body>
<h1>${bom.no }디테일 페이지입니다.</h1>

<form method="get" id="form1">
<table border="1">
	<tr> 
		<td>글번호</td><td><input type="text" value="${bom.no}" readonly="readonly"></td>
	</tr>
	<tr> 
		<td>제목</td><td><input type="text" value="${bom.subject}" readonly="readonly"></td>
	</tr>
	<tr> 
		<td>내용</td><td><textarea rows="50px" cols="100px" name="content" readonly="readonly">${bom.content}</textarea></td>
	</tr>
	<tr> 
		<td>작성자</td><td><input type="text" value="${bom.writer}" readonly="readonly"></td>
	</tr>
	<tr> 
		 <!-- <td colspan="2"><input type="submit" value="수정" onclick="bm_click('modify')"><input type="submit" value="삭제" onclick="bm_click('delete')"></td> --> 
 		<!-- <td colspan="2"><input type="submit" value="수정" id="modify"><input type="submit" value="삭제" id="delete"></td> -->
 		<td colspan="2"><a href="modify?bnum=${bom.no }">수정</a>  <a href="delete?bnum=${bom.no }">삭제</a></td>
	</tr>
</table>
</form>

</body>
</html>