<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {
		margin:0;
		padding:0;
	}
	
	#container {
		width:500px;
		margin:0 auto;
		margin-top: 200px;
	}
	
</style>
</head>
<body>
	<div id="container">
		<h1>XX회사 인사관리시스템</h1>
		<form action="login.do">
			이름 : <input type="text" name="name"> <br>
			사번 : <input type="text" name="eno"> <br>
			<button>로그인</button>
		</form>
	</div>
</body>
</html>