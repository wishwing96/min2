/**
 * 
 */

$(document).ready(function(){
	
	$(".selectDelete_btn").click(function(){
		
		if(confirm("제품을 삭제 하시겠습니까?")){
			var checkArr = new Array();
			
			$("input[class='chBox']:checked").each(function(){
				checkArr.push($(this).attr("data-cartNum"));
			});
			
			$.ajax({
				url : "uploadDel",
				type : "post",
				data : {chbox : checkArr},
				success : function(result){
					if(result == 1){
						location.href="register";
					}else{
						alert("삭제 실패");
					}
				}
			});
			
		}
		
	});
	
	
});