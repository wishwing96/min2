/**
 * 
 */

var pattern_spc = /[~!@#$%^&*()_+|<>?:{}]/;

$("#uid").keyup( function(){
	var id = $("#uid").val();
	if(id.length>=8 && id.length<=12){
		$("#a").html("사용가능한 아이디 입니다.");
	}else{
		$("#a").html("아이디는 8자 이상 12자 이하로 입력하셔야 합니다.");
	}
})

$("#upassword").keyup(function(){
	var pw = $("#upassword").val();
	
	if(pw.length>=8 && pw.length<=12 && pattern_spc.test(pw)==true){
		$("#b").html("사용가능한 비밀번호 입니다.");
	}else if(pattern_spc.test(pw)==false){
		$("#b").html("특수문자를 1개 이상 넣어주세요.");
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
		
		if(incode == checkcode){
			$("#mailMsg").html("인증이 완료되었습니다.");
		}else if(incode == null){
			$("#mailMsg").html("인증번호를 입력해주세요.");
		} else{
			$("#mailMsg").html("인증 번호를 다시 확인해주세요.");;
		}
		
		
	});



$("#phone3").keyup(function(){
		var phone1 = $("#phone1").val();
		var phone2 = $("#phone2").val();
		var phone3 = $("#phone3").val();
		var phone = phone1+'-'+phone2+'-'+phone3;
		$("#phone").val(phone);
	})
	
var idck = 0;
var check = 0;
	
$("#IdCheck").on("click", function(){
	var uid = $("#uid").val();
	$.ajax({
		data:{uid:uid},
		url:"IdCheck",
		success : function(data){
			if(data=='0'){
				alert("사용가능한 아이디 입니다.");
				idck=1;
				check=1;
			}else{
				alert("이미 사용하고 있는 아이디 입니다.");
			}
		},
		error:function(error){
			alert(error);
		}
	})
})


$("#member").on("click", function(){
	if($("#uname").val() == ""){
		alert("이름을 입력하세요.");
	}
	if($("#emailcheck1").val()!=$("#code").html()){
		alert("이메일 인증을 확인하세요.");
		return false;
	}
	if($("#uid").val()==""){
		alert("아이디를 입력하세요.");
		return false;
	}
	if($("#uid").val().length<8 || $("#uid").val().length>12){
		alert("아이디를 확인하세요.");
		return false;
	}
	if(check!=1){
		alert("아이디 중복 확인을 해주세요.");
		return false;
	}
	var pw1 = $("#upassword").val();
	var pw2 = $("#pwcheck").val();
	if($("#upassword").val().length<8 || $("#upassword").val().length>12){
		alert("비밀번호를 확인하세요.");
		return false;
	}
	if(pattern_spc.test(pw1)==false){
		alert("비밀번호에 특수문자를 넣어주세요.");
	}
	if($("#upassword").val()==""){
		alert("비밀번호를 입력하세요.");
		return false;
	}
	if(pw1!=pw2){
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
	if($("#uemail").val()=="" ){
		alert("이메일를 입력 해주세요.");
		return false;
	}
	if($("#emailcheck1").val()==""){
		alert("이메일 인증을 해주세요.");
		return false;
	}
	if($("#addr1").val()==""){
		alert("주소를 입력해주세요.");
		return false;
	}
	if($("#addr3").val()==""){
		alert("상세주소를 입력해주세요.");
		return false;
	}
	if($("#phone").val()==""){
		alert("전화번호를 입력해주세요.");
		return false;
	}
	
})


$(document).ready(function(){
	
	$("input:text[numberOnly]").on("keyup", function() {
	    $(this).val($(this).val().replace(/[^0-9]/g,""));
	});

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


































