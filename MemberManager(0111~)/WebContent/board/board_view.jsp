<%@page import="dto.CommentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="dto.BoardDTO"%>
<%@page import="service.BoardService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		$(".btn_like_hate").click(function() {
			<%
			if(session.getAttribute("login") == null || (boolean) session.getAttribute("login")==false){
				%>
				alert("로그인이 필요합니다.");
				location.href="<%=request.getContextPath()%>/member/login.jsp";
				<%
			}
			else {
			%>
				var data = "bno=<%=request.getParameter("bno")%>&id=" + $(this).attr("id");
				var obj = $(this);
				$.ajax({
					url : "process/board_like_hate_process.jsp",
					data : data,
					method : 'get',
					success : function(d) {
						d = d.trim();
						console.log(d);
						$(obj).children("span").html(d);
					},
					error:function(request, status, error) {
						console.log("error_code ="+request.status);
						console.log("message ="+request.responseText);
						console.log("error ="+error);
						console.log("status="+status);
						<%-- location.href = "<%=session.getAttribute("last")%>"; --%>
					}
				});
			<%
			}
			%>
		});
		
		$("textarea").keyup(function() {
			$(".length").html( $(this).val().length+"/500");
		});
		
		
		$("#comment_write a").click(function() {
			var data = $("#comment").serialize();
			console.log(data);
			$.ajax({
				url:'process/comment_insert_process.jsp',
				data:data,
				method:'get',
				success: function(d) {
					alert("댓글 등록 성공 : " + d);
					location.reload();
				}
			});
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
	}
	
	nav {
		margin:0 auto;
		margin-top:20px;
		margin-bottom:20px;
		width:800px;
	}
	
	nav table{
		width:800px;
		border-collapse: collapse;
		margin:0 auto;
	}
	nav th{
		width:100px !important;
		text-align: right;
		padding:5px;
	}
	nav td{
		width: 500px;
		padding:5px;
		height: 40px;
	}
	nav td > input{
		width: 100%;
		height:40px;
		box-sizing:border-box;
		border-width : 1px;
		border-radius: 5px;
	}
	h2{
		text-align: center;
	}
	.btn{
		text-decoration: none;
		background-color: #e8e8e8;
		display: inline-block;
		margin:5px 10px;
		padding:5px 20px;
		font-weight:normal;
		border : 1px solid #585858;
		text-align:center;
		color : black;
		font-size:14px;
		box-sizing: border-box;
	}
	.btn:hover{
		background-color: #282828;
		color:#FFFFFF
	}
	td > div {
		width:100%;
		height: 300px;
		resize: none;
		box-sizing: border-box;
	}
	
	td img {
		width:30px;
		height: 30px;
		flaot:left;
		padding-right:10px;
	}
	
	td span {
		float:right;
		font-size:20px;
		padding:0px 15px;
	}
	
	#delete {
		float:right;
	}
	
	#update {
		float:right;
	}
	
		
	.btn_like_hate {
		text-decoration: none;
		display: inline-block;
		margin:5px 10px;
		padding:5px 10px;
		font-weight:normal;
		text-align:center;
		color : black;
		font-size:14px;
		box-sizing: border-box;
		border-radius: 10px;
		background-color: white;
		margin-left:15%;
	}
	
	#like {
		color: blue;
		border:2px solid blue;
	}
	
	#hate {
		color: red;
		border:2px solid red;
	}

	
	#prev {
		float: left;
	}
	
	#next {
		float: right;
	}
	
	#list {
		float:left;
		margin-left:30%;
	}
	
	#comment_write {
		border:1px solid gray;
		margin:0 auto;
		width:800px;
		padding:20px;
		padding-bottom:0px;
		box-sizing: border-box;
	}
	
	#comment_write textarea {
		width:100%;
		height: 80px;
		border:none;
		outline:none;
		resize: none;
		box-sizing: border-box;
		font-size:14px;
		
		
	}
	
	#comment_write a {
		border:1px solid #2CDC00;
		box-sizing: border;
		width: 80px;
		height: 40px;
		font-weight: bold;
		padding-top:10px;
		display:inline-block;
	}
	
	#comment_write a:link,#comment_write a:visited{
		text-decoration: none;
		background-color: #2CDC00;
		color:white;
		font-size:20px;
		text-align: center;
	}
	
	#comment_write a:hover {
		border:1px solid green;
	}
	
	.length {
		text-align: right;
		padding-right:20px;
	}
	
	#comment_view {
		width:800px;
		margin:0 auto;
		margin-top:20px;
		margin-bottom:20px;
	}
	
	#comment_view > div {
		margin: 10px 0px;
		padding:20px;
	}
	
	#comment_view p:first-of-type {
		margin:0;
		padding:0;
		font-size:12px;
		color:silver;
		font-style: italic;
	}
	
	#comment_view h3{
		text-align: left;
		
	}
	
	#comment_view p {
		font-size:14px;
		color:black;
		margin:10px 0px;
	}
	
	#comment_view a {
		font-size:12px;
		text-decoration: none;
	}
	
	#comment_view .like_hate {
		float:right;
		margin:0px 20px;
		font-size:14px;
		text-decoration: none;
		text-align: center;
		display: inline-block;
		
	}
	
	
	#comment_view img {
		width:13px;
		height: 13px;
		margin-right:10px;
		margin-top:5px;
	}
	
	
</style>
</head>
<body>
	<%-- <%
		
		BoardDTO dto = null;
		int bno = 0;
		
		bno = Integer.parseInt(request.getParameter("bno"));
		dto =  BoardService.getInstance().searchBoardDTO(bno);
		ArrayList<CommentDTO> comment_list = BoardService.getInstance().searchAllCommentDTO(bno);
		for(int i=0;i<comment_list.size();i++) {
			System.out.println(comment_list.get(i));
		}

		//application.setAttribute("last", request.getRequestURI()+"?bno="+request.getParameter("bno"));
		String param = "";
		if(request.getQueryString()!=null) {
			param += "?"+request.getQueryString();
		}
		session.setAttribute("last", request.getRequestURI()+param);
		
	%> --%>
	
	<c:choose>
		<c:when test="${pageContext.request.queryString != null }">
			<c:set var="last" value="${pageContext.request.requestURI}?${pageContext.request.queryString }" scope="session" />
		</c:when>
		<c:otherwise>
			<c:set var="last" value="${pageContext.request.requestURI}" scope="session" />
		</c:otherwise>
	</c:choose>
	<c:out value="last:${last}"/>
	
	<div id="container">
		<jsp:include page="/template/header.jsp" flush="false"></jsp:include>
		
		<nav>
			<h2>작성글 조회</h2>
			<form action="/process/board_write_process" method="post">
				<table>
					<c:if test="${sessionScope.login == null or sessionScope.login == false }">
						<c:if test="${requestScope.dto.writer eq sessionScope.id }">
							<tr>
								<th></th>
								<td>
									<a href="#" id="update" class="btn">수정</a>
									<a href="#" id="delete" class="btn">삭제</a>
								</td>
								
							</tr>
						</c:if>
					</c:if>
					<%-- <%
						if(session.getAttribute("login")!=null && (boolean)session.getAttribute("login")) {
							if(dto.getWriter().equals(session.getAttribute("id"))) {
					%>
					<tr>
						<th></th>
						<td>
							<a href="#" id="update" class="btn">수정</a>
							<a href="#" id="delete" class="btn">삭제</a>
						</td>
						
					</tr>
					<%
							}
						}
					%> --%>
					<tr>
						<th>작성일</th>
						<td>${requestScope.dto.date}</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>${requestScope.dto.count}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="hidden" name="title" value="${requestScope.dto.title}">
							${requestScope.dto.title}
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<input type="hidden" name="writer" value="${requestScope.dto.writer}">
							${requestScope.dto.writer}					
						</td>
					</tr>
					<tr>
						<th style="vertical-align: top;">내용</th>
						<td>
							<div style="white-space:pre;">${requestScope.dto.content}</div>
						</td>
					</tr>
					<tr>
						<th>
						</th>
						<td>
							<a href="#" id="like" class="btn_like_hate">
								<img src="${pageContext.request.contextPath}/img/like.png"> 
								 <span>${requestScope.dto.like}</span>
							</a> 
							<a href="#" id="hate" class="btn_like_hate">
								<img src="${pageContext.request.contextPath}/img/hate.png"> 
								<span>${requestScope.dto.hate}</span>
							</a> 
						</td>
					</tr>
					<tr>
						<td colspan="2"><hr></td>
					</tr>
					<tr>
						<th>
							<a href="#" class="btn" id="prev">이전글</a>
						</th>
						<td>
							<a href="${sessionScope.lastBoard}" class="btn" id="list">목록으로</a>
							<a href="#" class="btn" id="next">다음글</a>
						</td>
					</tr>
				</table>
			</form>
			<c:if test="${sessionScope.login != null and sessionScope.login == true }">
				<div id="comment_write">
					<form id="comment">
						<input type="hidden" name="bno" value="${requestScope.dto.bno}">
						<input type="hidden" name="writer" value="${sessionScope.id }">
						<span>${sessionScope.id }</span><br><hr>
						<textarea placeholder="댓글을 입력하세요" maxlength="500" name="content"></textarea>
						<p class="length">0/500</p><hr>
						<p style="text-align: right"><a href="#">등 록</a></p>
					</form>
				</div>
			</c:if>
			<div id="comment_view">
			
				<c:forEach var="list" items="${requestScope.comment_list }">
					<div>
					<h3>${list.writer}</h3>
					<p>${list.date}</p>
					<p>${list.content}</p>
					<c:if test="${sessionScope.login != null and sessionScope.login == true }">
						<c:if test="${list.writer == sessionScope.id}">
							<a href="#">수정</a> / <a href="#">삭제</a>
						</c:if>
						
					</c:if>
					<a href="#" class="like_hate"><img src="${pageContext.request.contextPath}/img/hate.png"><span>${list.hate}</span></a>
					<a href="#" class="like_hate"><img src="${pageContext.request.contextPath}/img/like.png"><span>${list.like}</span></a>
				</div>
				</c:forEach>
			</div>
		</nav>
		
		<jsp:include page="/template/footer.jsp" flush="false"></jsp:include>
		
	</div>
</body>
</html>