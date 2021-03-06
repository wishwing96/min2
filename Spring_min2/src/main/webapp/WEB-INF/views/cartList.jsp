<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="resources/js/cartList.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/resources/js/addressapi.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
<link rel="stylesheet" type="text/css" href="resources/css/login.css">

<style>
	.orderOpne { float:right; width:45%; text-align:right; }
	.orderOpne button { font-size:18px; padding:5px 10px; border:1px solid #999; background:#fff;}
	
	.orderInfo { border:5px solid #eee; padding:20px; display:none ; }
	#addr2, #addr3 { width:250px; }
	.cartStock {width:10px; }
</style>

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
					<td><a href="ordercheck">orderCheck</a></td>
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

<form action="cartList" method="post" >
<div class="cartnum"></div>
<table>
	<tr><td colspan="5"><input type="button" value="delete" id="delete"></td></tr>
		<c:set var="num" value="0"></c:set>
			<c:forEach items="${cart }" var="cart">
			<input type="hidden" value="${num }" id="num">
				<tr>
					<td></td><td>제품 명</td><td>수량</td><td>가격</td><td>선택</td>
				</tr>
				<tr>
					<td><img src="display?filename=${cart.file }" width='300' height='300'></td><td>${cart.name }</td>
					<td><input type="hidden" value=${cart.cartStock } name="cartStock">${cart.cartStock }</td>
					<td>${cart.price }</td>
					<td><input type="checkbox" name="chBox" class="chBox" data-cartnum="${cart.cartnum }" 
						data-cartStock="${cart.cartStock }" data-price="${cart.price }" value="${cart.name }"></td>
				</tr>
			<c:set var="num" value="${num+1}"></c:set>
		</c:forEach>
	
	<tr><td colspan="4"><div class="price"></div></td><td>
	
	<div class="orderOpen">
		<c:if test="${count != 0 }"><input type="button" value="구매 정보 입력" id="buy"></c:if>
	</div></td></tr></table>
	
<div class="orderInfo">
<table>
	<tr>
		<td><input type="hidden" name="uid" value="${vo.uid}">${vo.uid}</td>
	</tr>
	<tr>
		<td><input type="hidden" value="${vo.upoint }" id="point">${vo.upoint}p</td>
	</tr>
	<tr>
		<td><input type="text" name="upoint" value="0" id="upoint" >p</td>
	</tr>
	<tr>
		<td><input type="text" name="point" id="getpoint" readonly>p</td>
	</tr>
				
	<tr>
		<td><input type="text" value="${vo.address1 }" id="addr1" name="address1" readonly="readonly" >
			<button type="button" id="address">
				<i class="fa fa-search"></i> 
					우편번호 찾기</button></td>
	</tr>
					
	<tr>
					
		<td> <input value="${vo.address2 }" id="addr2" name="address2" type="text" readonly="readonly" /></td>
					
	</tr>
					
	<tr>
		<td>
			<input class="form-control" value="${vo.address3 }" id="addr3" name="address3" type="text" width="300" />
			<input type="hidden" id="uaddress" name="uaddress">						
		</td>
					
	</tr>
				
			
	<tr>
		<td>tel:<input type="text" name="uphone" value="${vo.uphone }"></td>
	</tr>
	<tr>
		<td><input type="submit" id="order" value="구매"></td>
	</tr>
</table></div>
<div class="name"></div>
</form>

	
	<script>
	
	 $("#buy").click(function(){
		  $(".orderInfo").slideDown();
		 });      
	
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
		
		$(document).ready(function(){
			var price = 0;
			var upoint = 0;
			var point = parseInt($("#point").val());
			$("#buy").click(function(){
				
				if(confirm("제품을 구매 하시겠습니까?")){
					var cartnum = "";
					var name = "";
					var str1="";
					var str2="";
					var str3="";
					
					$("input[class='chBox']:checked").each(function(){
						price = price + parseInt($(this).attr("data-price")*$(this).attr("data-cartStock"));
						name = name +"/"+ $(this).val();
						
						cartnum = $(this).attr("data-cartnum");
						
						str1 = "<input type='text' value='"+price+"' id='price' name='price' readonly>원";
						str2 = "<input type='hidden' value='"+name+"' name='name'>"
						str3 += "<input type='hidden' value='"+cartnum+"' name='cartnum'>"
					});
					
					$(".price").append(str1);
					$(".name").append(str2);
					$(".cartnum").append(str3);
					var point1 = price * 0.01;
					
					$("#getpoint").val(point1);
					
					$("#upoint").on("propertychange change keyup paste input", function(){
						upoint = parseInt($("#upoint").val());
						var total = price - upoint;
						$("#price").val(total);
						
						$("input:text[numberOnly]").on("keyup", function() {
						    $(this).val($(this).val().replace(/[^0-9]/g,""));
						});

					})
				}
			});
			$("#order").on("click", function(){
				
				if(upoint>point){

					alert("포인트 초과입니다.");
					return false;
				}
				
			})
		});
		
	</script>
	
</body>
</html>