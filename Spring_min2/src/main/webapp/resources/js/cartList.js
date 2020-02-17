/**
 * 
 */
$(document).ready(function(){

	
	
	$("#delete").click(function(){
			
			if(confirm("제품을 삭제 하시겠습니까?")){
				var checkArr = new Array();
				
				$("input[class='chBox']:checked").each(function(){
					checkArr.push($(this).attr("data-cartNum"));
				});
				
				$.ajax({
					url : "cartDel",
					type : "post",
					data : {chbox : checkArr},
					success : function(result){
						if(result == 1){
							location.href="cartList";
						}else{
							alert("삭제 실패");
						}
					}
				});
				
			}
		
	});

});
