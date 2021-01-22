<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.MemberVO"%>
<%@page import="service.MemberService"%>
<%@ page errorPage="/error/error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

	$(document).on("click",".update",function() {
		var data="";
		$.each($(this).parent().siblings().children() , function(i,o) {
			console.log(i,$(o).val());
			data += $(o).attr("name") + "=" + $(o).val() + "&";
		});
		console.log(data);
		$.ajax({
			url:"manage_update_member.do",
			data : data,
			method : 'get',
			success : function result(data) {
				if(data.indexOf("true")!=-1) {
					$("#search")[0].reset();
					$("#btn_submit").click();
				}
				else {
					alert("업데이트에 실패 했습니다");
				}
			}
		});
	});
	
	$(document).on("click",".delete", function() {
		var data = "id=" + $(this).parent().siblings().children().first().val();
		console.log(data);
		$.ajax({
			url:"manage_delete_member.do",
			data : data,
			method : 'get',
			success : function result(data) {
				alert(data);
				if(data.indexOf("true")!=-1) {
					$("#search")[0].reset();
					$("#btn_submit").click();
				}
				else {
					alert("업데이트에 실패 했습니다");
				}
			}
		});
	});
	
	
	
	$(function () {
		$("#btn_submit").click(function(e) {
			var data = $("#search").serialize();
			$.ajax({
				url: "manage_search_member.do",
				data : data,
				method : 'get',
				success : function result(data) {
					
					var json = JSON.parse(data);
					console.log(json);
					var result = "<table>";
					for(i=0;i<json.result.length;i++) {
						result += "<tr>";
						result += "<td>"+ json.result[i].id+"<input type='hidden' value = '"+json.result[i].id+"' name='id'></td>";
						result += "<td><input type='text' value='"+json.result[i].name+"' name='name'></td>";
						result += "<td><input type='text' value='"+json.result[i].age+"' name='age'></td>";
						result += "<td><input type='text' value='"+json.result[i].grade+"' name='grade'></td>";
						result += "<td><a href='#' class='update' >수정</a> / <a href='#' class='delete' >삭제</a></td> </tr>";
					}
					result += "</table>";
					$("#content_area").html(result);
					
				}
				
			});
		});
		
		$("input[name=search]").keyup(function() {
			$("#btn_submit").click();
		});
		
		$("select").change(function () {
			$("input[name=search]").val("");
			$("#btn_submit").click();
		});
		
		$("#btn_submit").click();
	});

	
</script>
<style type="text/css">
	* {
		margin:0;
		padding:0;
	}
	
	#container {
		width:100%;
	}
	
	nav {
		padding-top:30px;
	}
	
	button {
		display: inline-block;
	}
	
	#menu_bar {
		width:100%;
		box-sizing: border-box;
		text-align: center;
		font-size:20px;
		margin-bottom:10px;
	}
	
	#menu_bar select {
		width:120px;
		padding: 5px;
		margin-right:5px;		
	}
	#menu_bar input {
		width: 250px;
		padding:5px;
		margin-right:5px;
	}
	#menu_bar button {
		width:100px;
		padding:5px;
	}
	
	#content > ul {
		font-size:0px;
	}
	
	#content > ul > li{
		width:230px;
		display: inline-block;
		font-size:16px;
		text-align: center;
		font-weight: bold;
		padding: 10px;
		box-sizing: border-box;
	}
	
	table {
		border-collapse: collapse;
		margin:0 auto;
		font-size:0px;
	}
	
	td {
		width:230px;
		font-size:16px;
		padding:10px;
		box-sizing: border-box;
		text-align: center;
	}
</style>
</head>
<body>
	
	<div id="container">
		<jsp:include page="/template/header.jsp" flush="false"></jsp:include>
		
		<nav>
			<div id="menu_bar">
				<form action="" id="search">
					<select name="kind">
						<option value="id" selected>아이디</option>
						<option value="name">이름</option>
						<option value="grade">등급</option>
					</select>
					<input type="text" name="search">
					<button id="btn_submit" type="button">검색</button>
				</form>
			</div>
			<hr>
			<div id="content">
				<ul>
					<li>아이디</li>
					<li>이름</li>
					<li>나이</li>
					<li>등급</li>
					<li>비고</li>
				</ul>
				<hr>
				<div id="content_area">
					
				</div>
			</div>
			
		</nav>
		
		<jsp:include page="/template/footer.jsp" flush="false"></jsp:include>
		
	</div>
</body>
</html>