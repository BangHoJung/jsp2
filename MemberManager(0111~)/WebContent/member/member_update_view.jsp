<%@page import="service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.MemberVO" %>
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
		width:100%;
		text-align: center;
	}
	
	nav {
		padding-top:200px;
		height: 400px;
	}
	
	button {
		display: inline-block;
	}
</style>
</head>
<body>
	<%
		if(session.getAttribute("login") == null || !(boolean)session.getAttribute("login")) {
			session.setAttribute("login", false);
			%>
    		<script>
    			alert("로그인 세션이 만료되었습니다.");
    		</script>
    		<%
    		response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		%>
		<div id="container">
			<jsp:include page="/template/header.jsp" flush="false"></jsp:include>
			
			<nav>
				<form action="<%=request.getContextPath() %>/update_member.do" method="post">
					아이디 : <input type="text" name="id" readonly value="${requestScope.vo.id }"> <br>
					변경할 비밀번호 : <input type="password" name="pass"><br>
					변경할 이름 : <input type="text" name="name" value="${requestScope.vo.name }"><br>
					변경할 나이 : <input type="text" name="age" value="${requestScope.vo.age }"><br>
					<button type="submit">제출</button>
				</form>
			</nav>
			
			<jsp:include page="/template/footer.jsp" flush="false"></jsp:include>
			
		</div>

	
</body>
</html>