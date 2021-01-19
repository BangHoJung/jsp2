<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 폼</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function () {
		var index = 1;
		$(document).on("click","#plus", function() {
			if(index == 5) return;
			index++;
			$("div").append("<p><input type='file' name='file"+index+"'></p>");
			
		});
		
		$(document).on("click","#minus", function() {
			if(index == 1) return;
			$(this).parent().parent().children("p").last().remove();
			index--;
			
		});
	});
</script>
</head>
<body>
	<form action="upload.do" enctype="multipart/form-data" method="post">
		사용자 : <input type="text" name="user"><br>
		<div>
			<p><input type="file" name="file1"><button id="plus" type="button">+</button><button id="minus" type="button">-</button></p>
		</div>
		<button>업로드</button>
	</form>
</body>  
</html>