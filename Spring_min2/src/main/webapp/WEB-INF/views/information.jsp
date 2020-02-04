<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="resources/css/join.css">
<link rel="stylesheet" type="text/css" href="resources/css/login.css">
</head>
<body>

<header id="header" class="alt">
	<div class="inner">
		<table>
			<tr>
				<td>${vo.uname}님 환영합니다.</td>
				<td><a href="logout">logout</a></td>
				<td><a>cart</a></td>
				<td><a href="board_list">board</a></td>
			</tr>
		</table>
			<h1><a href="main">이달의 꽃</a></h1>
				<p>A free responsive site template by</p>
		</div>
</header>
<form action="information" method="post">
<div id="all">
	<div id="top">
		<h1>information</h1>
		<p>이달의 꽃은 고객님의 소중한 개인정보를 보호하기위해, 주민등록번호를 수집하지 않습니다.</p>
	</div>
	
	<div id="middle">
		<table>
			<tr><td>이름(필수)</td>
			<td><input type="text" id="uname" name="uname" value="${vo.uname }"></td></tr>
			<tr><td>아이디(필수)</td>
			<td><input type="text" id="uid" name="uid" value="${vo.uid }" >
			<tr><td>비밀번호(필수)</td>
			<td><input type="password" id="upassword" name="upw" value="${vo.upw}">
			<label id="b">비밀번호는 8자이상 12자 이하로 입력하셔야합니다.</label></td></tr>
			<tr><td>비밀번호확인(필수)</td>
			<td><input type="password" id="pwcheck" >
			<input type="button" value="확인" id="pw2check">
			<label id="c"></label></td></tr>
			<tr><td>이메일</td>
			<td><input type="text" id="uemail" name="uemail"value="${vo.uemail}" readonly>@<input type="text" id="uemail" name="uemail"></td></tr>
			
			<tr><td>주소</td><td>
				<textarea id="uaddress" name="uaddress" >${vo.uaddress}</textarea>
			</td></tr>
			<tr><td>휴대폰</td><td>
			<select>
				<option>010</option>
				<option>011</option>
				<option>012</option>
			</select>
			<input type="text" id="uphone" name="uphone" value="${vo.uphone}">
			<input type="button" value="인증번호발송"id="phone">
			</td></tr>
			<tr><td>인증번호입력</td><td>
			<input type="text" id="numcheck">
			<input type="button" value="확인" id="number">
			</td></tr>
			<tr><td>my point</td><td>${vo.upoint}p</td></tr>
			<tr><td colspan="3">
			<input type="checkbox" id="no">개인정보 수집에 동의합니다.
			</td></tr>
			<th colspan="3"><input type="submit" value="수정"></th>
		</table>
	</div>

</div>
</form>
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="resources/js/join.js"></script>
</body>
</html>





































