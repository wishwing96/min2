<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
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
			<td><input type="text" id="uemail" name="uemail"value="${vo.uemail}" readonly></td></tr>
			
			<tr>
				<td>주소</td>
				<td>				
				<table>
				
					<tr>
						<td><input type="text" value="${vo.address1 }" id="addr1" name="address1" readonly="readonly" ></td>
						<td><button type="button" id="address">
							<i class="fa fa-search"></i> 
						우편번호 찾기</button></td>
					</tr>
					
					<tr>
					
						<td colspan="2"> <input value="${vo.address2 }" id="addr2" name="address2" type="text" readonly="readonly" /></td>
					
					</tr>
					
					<tr>
					
						<td colspan="2">
							<input class="form-control" value="${vo.address3 }" id="addr3" name="address3" type="text"  />
							<input type="hidden" id="uaddress" name="uaddress">						
						</td>
					
					</tr>
				
				</table>
				</td>
			</tr>
			<tr><td>휴대폰</td><td><input type="text" id="uphone" name="uphone" value="${vo.uphone}">
			</td></tr>
			<tr><td>my point</td><td>${vo.upoint}p</td></tr>
			<th colspan="2"><input type="submit" value="수정"></th>
		</table>
	</div>
<script>

$("#address").on("click", function(){
	 new daum.Postcode({
        oncomplete: function(data) {

           var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
           var extraRoadAddr = ''; // 도로명 조합형 주소 변수

           if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
               extraRoadAddr += data.bname;
           }
           if(data.buildingName !== '' && data.apartment === 'Y'){
              extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
           }
           if(extraRoadAddr !== ''){
               extraRoadAddr = ' (' + extraRoadAddr + ')';
           }
           if(fullRoadAddr !== ''){
               fullRoadAddr += extraRoadAddr;
           }

           console.log(data.zonecode);
           console.log(fullRoadAddr);
           
           
           $("[id=addr1]").val(data.zonecode);
           $("[id=addr2]").val(fullRoadAddr);
           
       }
    }).open();
});

</script>
</div>
</form>
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="resources/js/join.js"></script>
</body>
</html>





































