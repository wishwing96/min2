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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/resources/js/addressapi.js"></script>

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
		<h1>join</h1>
		<p>이달의 꽃은 고객님의 소중한 개인정보를 보호하기위해, 주민등록번호를 수집하지 않습니다.</p>
	</div>
<form method="post" name="form1">	
	<div id="middle">
		<table>
			<tr><td>이름(필수)</td>
			<td><input type="text" id="uname" name="uname"></td></tr>
			<tr><td>아이디(필수)</td>
			<td><input type="text" id="uid" name="uid"><input type="button" value="중복확인" id="IdCheck">
			<label id="a">아이디는 8자 이상 12자 이하로 입력하셔야 합니다.</label></td></tr>
			<tr><td>비밀번호(필수)</td>
			<td><input type="password" id="upassword" name="upw">
			<label id="b">비밀번호는 8자이상 12자 이하로 입력하셔야합니다.</label></td></tr>
			<tr><td>비밀번호확인(필수)</td>
			<td><input type="password" id="pwcheck">
			<input type="button" value="확인" id="pw2check">
			<label id="c"></label></td></tr>
			<tr><td>이메일(필수)</td>
			<td><input type="text" id="uemail1">@<input type="text" id="uemail2"><input type="hidden" name="uemail" id="uemail">
			<select name="email">
			<option value="1">직접입력</option>
			<option value="naver.com">naver.com</option>
			<option value="daum.net">daum.net</option>
			<option value="google.com">google.com</option>
			</select>
			<input type="button" value="발송하기" id = "emailcheck">
			</td></tr>
			<tr><td>인증번호</td>
			<td>
			<input type="text" id="emailcheck1">
			<span id="code" style="display:none;"></span>
			<input type="button" value="인증하기"  id="emailcheck2" >
			<span id="mailMsg"></span> 
			</td></tr>
			<tr><td>성별</td><td><input type="radio" id="ugender" name="ugender" value="남">남<input type="radio" id="ugender" name="ugender" value="여">여</td></tr>
			<tr><td>주소(필수)</td><td>
				<table>
				
					<tr>
						<td><input type="text" placeholder="우편번호" id="addr1" name="address1" readonly="readonly" ></td>
						<td><button type="button" id="address">
							<i class="fa fa-search"></i> 
						우편번호 찾기</button></td>
					</tr>
					
					<tr>
					
						<td colspan="2"> <input placeholder="도로명 주소" id="addr2" name="address2" type="text" readonly="readonly" /></td>
					
					</tr>
					
					<tr>
					
						<td colspan="2">
							<input class="form-control" placeholder="상세주소" id="addr3" name="address3" type="text"  />					
						</td>
					
					</tr>
				
				</table>
			</td></tr>
			<tr><td>생년월일</td><td>
				<select id="year">
					<option>년</option>
					<option value="1996">1996</option>
					<option value="1997">1997</option>
					<option value="1998">1998</option>
					<option value="1999">1999</option>
					<option value="2000">2000</option>
				</select>
				<select id="month">
					<option>월</option>
					<option value="01">01</option>
					<option value="02">02</option>
					<option value="03">03</option>
					<option value="04">04</option>
					<option value="05">05</option>
				</select>
				
				<select id="day">
					<option>일</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
				</select>
				<input type="hidden" id="birth" name="ubirth">
			</td></tr>
			<tr><td>휴대폰(필수)</td><td>
			<select id="phone1">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="012">012</option>
			</select>
			<input type="text" maxlength="4" id="phone2" numberOnly>
			-<input type="text" maxlength="4" id="phone3" numberOnly>
			<input type="hidden" id="phone" name="uphone">
			</td></tr>
			<tr><th colspan="3"><input type="submit" value="가입" id="member" onclick="btn_click('join')"></th></tr>
		</table>
	</div>
</form>
</div>

<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="resources/js/join.js"></script>
</body>
</html>

















































