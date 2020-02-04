/**
 * 
 */

function checkImageType(fileName){
	var pattern = /jpg|gif|png|jpeg/i;
	return fileName.match(pattern);
}

function getImageLink(fileName){
	if(!checkImageType(fileName)){
		return;
	}
	var front = fileName.substr(0,12);
	var end = fileName.substr(14);
	
	alert ("front="+front);
	alert ("end="+end);
	
	return front+end;
}

function getOriginalName(fileName){
	alert("fileName="+fileName);
	return fileName;
}

$("#file").on("click", function(event){
	event.preventDefault();
})

$("#file").on("click", function(event){
	alert("aaa");
	event.preventDefault();
	
	var files = $("#files").val();
	alert(files);
	var file = files[0];
	
	//console.log(file);
	
	var formData = new FormData();
	
	formData.append("file", file)

	$.ajax({
		url:"ajaxtest",
		data: formData,
		dataType: "text",
		processData: false,
		contentType: false,
		type: "POST",
		success: function(data){

			var str="";
			
			if(checkImageType(data)){
			str="<div>"
				+ "<img src='file?fileName="+getImageLink(data)+"'/>" 
				+ "<small data-src=\'"+data+"\'>x</small>" + "</div>";
			}else{
				str = "<div><a href='file?fileName="
					+ getOriginalName(data) +"'>"+data+
					+"</a></div>";
			}
			
			$(".uploadedList").append(str);
			
			console.log(data);
			alert(data);
		}
	});
	
});//drop end






















































