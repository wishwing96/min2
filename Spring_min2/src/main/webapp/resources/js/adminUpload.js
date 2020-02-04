
		//파일 형식 검사
		 var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
		 var maxSize = 10485760;
	
	  function checkExtension(fileName, fileSize){
		  if(fileSize >= maxSize){
			  alert("파일 사이즈 초과");
			  return false;
		  }
		  
		  if(regex.test(fileName)){
			  alert("해당 종류의 파일은 업로드할 수 없습니다.");
			  return false;
		  }
		  return true;
	  }// checkExtension 끝


$(document).ready(function(){
	
	$("input[type='file']").change(function(e){
		
		var formData = new FormData();
		
		var inputFile = $("input[name='uploadFile']");
		
		var files = inputFile[0].files;
		
		console.log(files);
		
		//add filedate to formdata
		for(var i = 0; i < files.length; i++){
			if(!checkExtension(files[i].name, files[i].size)){
				return false;
			}
			formData.append("uploadFile", files[i]);
		}	
		//alert("ajax전");
	
		$.ajax({
			url: 'ajax',
			processData: false,
			contentType: false,
			data: formData,
			type: 'POST',
			dataType:'json',
			success: function(data){
				console.log(data);
				showUploadedFile(data);
			}
		});
	});
	function showUploadedFile(uploadResultArr){
		 
		console.log(uploadResultArr);
		
		if(!uploadResultArr || uploadResultArr.length == 0){return;}
		
		var uploadResult = $(".uploadResult ul");
		
		var str = "";
		 
		 $(uploadResultArr).each(function(i, obj){

				 
				 str += "<input type='hidden' name='uploadvo[" + i + "].filename' value='" +obj.filename +"'>";
				 str += "<input type='hidden' name='uploadvo[" + i + "].uuid' value='" + obj.uuid +"'>";
				 str += "<input type='hidden' name='uploadvo[" + i + "].uploadPath' value='" +obj.uploadPath+"'>";
				 str += "<input type='hidden' name='uploadvo[" + i + "].image' value='" +obj.image+"'>";
				 
			 
		 })
		
		 uploadResult.append(str);
		 
	}//function showUploadedFile끝
	
	
});


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	