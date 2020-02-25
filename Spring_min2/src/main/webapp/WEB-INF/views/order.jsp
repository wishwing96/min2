<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="resources/css/join.css">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="resources/js/order.js"></script>
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
			
<form action="order1" method="post">
<div id="middle">
<table>
	<tr><td>상품</td><td><input type="hidden" name="name" value="${order.name }">${order.name }</td></tr>
	<tr><td>가격</td><td>	<input type="text" id="price" name="price" value="${order.price }" readonly="readonly">원</td></tr>
	<tr><td>상품수량</td><td><input type="text" id="stock" name="stock" value="1">개</td></tr>
	<tr><td>사용 가능한 포인트</td><td><input type="hidden" id="point" value="${vo.upoint }">${vo.upoint }p</td><tr>
	<tr><td>포인트 사용하기</td><td><input type="text" id="upoint" name="upoint" value="0" numberOnly>p</td></tr>
	<tr><td>적립 포인트</td><td><input type="text" id="getpoint" name="point" readonly="readonly"></td></tr>
	<tr><td>구매자</td><td><input type="hidden" name="uid" value="${vo.uid }">${vo.uid }</td></tr>
	<tr><td>주소</td><td>				
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
				
			</table></td></tr>
	<tr><td>번호</td><td><input type="text" id="uphone" name="uphone" value="${vo.uphone }"></td></tr>
	<tr><td colspan="2"><input type="submit" id="order" value="구매하기"></td></tr>
</table>
</div>
<script>
var price = $("#price").val();

$(document).ready(function(){
	var point1 = price * 0.01;
	
	$("#getpoint").val(point1);
})

$(document).ready(function(){
	$("#stock").on("propertychange change keyup paste input", function(){
		var stock = $("#stock").val();
		var total = stock * price;
		var getpoint =  total * 0.01;
		
		$("#getpoint").val(getpoint);
		$("#price").val(total);
	});
})


$("#order").on("click", function(){
	if($("#addr1").val()==""){
		alert("주소를 입력하세요.");
		return false;
	}
	if($("#addr3").val()==""){
		alert("상세주소를 입력하세요.");
		return false;
	}
	if($("#uphone").val()==""){
		alert("휴대폰 번호를 입력하세요.");
		return false;
	}
	var upoint = $("#upoint").val();
	var point = $("#point").val();

	
	
	if(point<upoint){
		alert("포인트 초과입니다.");
		return false;
	}

})

$("#upoint").keyup(function(){
	var upoint = $("#upoint").val();
	var point = $("#point").val();
	var total = price - upoint;
	$("#price").val(total);
	
	$("input:text[numberOnly]").on("keyup", function() {
	    $(this).val($(this).val().replace(/[^0-9]/g,""));
	});

})

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
</form>

</body>
</html>






























