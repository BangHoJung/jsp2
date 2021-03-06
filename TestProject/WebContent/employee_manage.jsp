<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".update").click(function() {
			var data="";
			$.each($(this).parent().siblings().children() , function(i,o) {
				console.log(i,$(o).val());
				data += $(o).attr("name") + "=" + $(o).val() + "&";
			});
			console.log(data);
			location.href="update_employee.do?"+data;
		});
		
		$(".delete").click(function() {
			var data="";
			$.each($(this).parent().siblings().children() , function(i,o) {
				console.log(i,$(o).val());
				data += $(o).attr("name") + "=" + $(o).val() + "&";
			});
			console.log(data);
			location.href="update_employee.do?"+data;
		});
	});
</script>
<style type="text/css">
	* {
		margin:0;
		padding:0;
	}
	
	#container {
		width:100%;
		text-align:center;
		margin:0 auto;
		display: inline-block;
	}
	
	#menu_bar {
		width:500px;
		margin:0 auto;
		display: inline-block;
		text-align:center;
		margin-bottom:30px;
	}
	
	#list {
		width:1000px;
		margin:0 auto;
		text-align: center;
	}
	
</style>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.dto.position >= 4 and sessionScope.dto.department == '인사'}">
			<h1>인사관리 시스템에 로그인 하셨습니다.</h1>
			로그인 정보 : ${sessionScope.dto.name } ${sessionScope.pos_name } <a href="logout.do">로그아웃</a> <br>
			<hr>
		
			<div id="container">
				<div id="menu_bar">
					<form action="search_employee.do" method="get">
						<select name="kind">
							<option value="name" selected>이름</option>
							<option value="eno">사번</option>
							<option value="department">부서</option>
						</select>
						<input type="text" name="search">
						<button >검색</button>
					</form>
				</div>
				<br>
				<div id="list">
					
						<table>
							<thead>
								<tr>
									<th>사번</th>
									<th>이름</th>
									<th>부서</th>
									<th>직급</th>
									<th>연봉</th>
									<th>비고</th>
								</tr>
								<tr>
									<form action="register_employee.do" method="get">
										<td><input type="text" name="eno" placeholder="사번입력"></td>
										<td><input type="text" name="name" placeholder="이름입력"></td>
										<td><input type="text" name="department" placeholder="부서입력"></td>
										<td>
											<select name="position">
												<option value="1">사원</option>
												<option value="2">주임</option>
												<option value="3">대리</option>
												<option value="4">과장</option>
												<option value="5">차장</option>
												<option value="6">부장</option>
												<option value="7">사장</option>
											</select>
										</td>
										<td><input type="text" name="salary" placeholder="연봉입력"></td>
										<td><button type="submit">사원등록</button></td>
									</form>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="emp" items="${list}" >
								<tr>
									<td><input type="text" name ="eno" value="${emp.eno }" readonly="readonly"></td>
									<td><input type="text" name = "name" value="${emp.name }" ></td>
									<td><input type="text" name = "department" value="${emp.department }" ></td>
									<td><select  name="position" >
											<option value="1">사원</option>
											<option value="2">주임</option>
											<option value="3">대리</option>
											<option value="4">과장</option>
											<option value="5">차장</option>
											<option value="6">부장</option>
											<option value="7">사장</option>
										</select>
									</td>
									<td><input type="text" name = "salary" value="${emp.salary }" ></td>
									<td><a href="#" class="update">수정</a> / <a href="#" class="delete">삭제</a></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					
				</div>
				
			</div>
		</c:when>
		
		<c:otherwise>
			권한이 없습니다. <a href="logout.do">로그아웃</a> <br>
			관리자 모드는 인사과 과장 이상들만 접근하실 수 있습니다.
		</c:otherwise>
	</c:choose>
		
</body>
</html>