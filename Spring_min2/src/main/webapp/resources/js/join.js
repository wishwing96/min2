/**
 * 
 */

$("#uid").keyup( function(){
	var id = $("#uid").val();
	if(id.length>=8 && id.length<=12){
		$("#a").html("사용가능한 아이디 입니다.");
	}else{
		$("#a").html("사용불가능한 아이디 입니다.");
	}
})

$("#upassword").keyup(function(){
	var pw = $("#upassword").val();
	
	if(pw.length>=8 && pw.length<=12){
		$("#b").html("사용가능한 비밀번호 입니다.");
	}else{
		$("#b").html("사용불가능한 비밀번호 입니다.");
	}
})

$("#pw2check").on("click", function(){
	
	var pw = $("#upassword").val();
	var pw2 = $("#pwcheck").val();
	
	if(pw===pw2){
		$("#c").html("일치합니다.");
	}else{
		$("#c").html("다시 입력해주세요.");
	}
	
})
$(document).ready(function(){
	$("#day").blur(function(){
		var year = $("#year").val();
		var month = $("#month").val();
		var day = $("#day").val();
		var birth = year+'-'+month+'-'+day;
		
		$("#birth").val(birth);
	})

})


$("#uemail2").keyup(function(){
		var email1 = $("#uemail1").val();
		var email2 = $("#uemail2").val();
		var email = email1 +'@' + email2;
		alert(email);
		$("#uemail").val(email);
	})
	
function btn_click(result){
	if(result=="join"){
		form1.action=action ="join";
	}
}
	
$(document).ready(function(){
	$("#emailcheck").click(function(){
		var email = $("#uemail").val();
		var check = $("#emailcheck1").val();
		$.ajax({
			type:"GET",
			url:"email?uemail=" + email,
			success:function(data){
				console.log(typeof(data));
				console.log("data:"+data);
				
				$("#code").html(data);
			}
		})
		
	})
})

$("#emailcheck1").blur(function(){
		var incode = $("#emailcheck1").val();
		var checkcode = $("#code").html();
		alert(checkcode);
		
		if(incode == checkcode){
			$("#mailMsg").html("인증이 완료되었습니다.");
		} else{
			$("#mailMsg").html("인증번호를 다시 확인해주세요.")
		}
		
		
	});


$("#phone3").keyup(function(){
		var phone1 = $("#phone1").val();
		var phone2 = $("#phone2").val();
		var phone3 = $("#phone3").val();
		var phone = phone1+'-'+phone2+'-'+phone3;
		$("#phone").val(phone);
	})

$("#member").on("click", function(){
	if($("#uid").val()==""){
		alert("아이디를 입력하세요.");
		return false;
	}
	if($("#upassword").val()==""){
		alert("비밀번호를 입력하세요.");
		return false;
	}
	if($("#upassword").val().equals($("#pwcheck").val())){
		alert("비밀번호를 확인하세요");
		return false;
	}
	if($("#no").val().checked==false){
		alert("개인정보 수집에 체크하세요.");
		return false;
	}
})

var idck = 0;
	
$("#IdCheck").on("click", function(){
	var uid = $("#uid").val();
	$.ajax({
		data:{uid:uid},
		url:"IdCheck",
		success : function(data){
			if(data=='0'){
				alert("성공");
				idck=1;
			}else{
				alert("실패");
			}
		},
		error:function(error){
			alert(error);
		}
	})
})

$(document).ready(function(){

	$("#email").change(function(){

		$("#email option:selected").each(function() {

			if($(this).val()=="1"){

				$('#uemail2').val("");

			} else {

				$('#uemail2').val($(this).val());

			}

		});

	}); 

});


































