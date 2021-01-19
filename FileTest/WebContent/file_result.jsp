<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- ${requestScope.file0 } <br>
	<a href="file_download.jsp?file=${requestScope.fileName0 }" >파일 다운로드</a><br>
	<c:choose>
		<c:when test="${requestScope.dto0.type == 'image' }">
			<img src="${requestScope.dto0.path }">
		</c:when>
		<c:otherwise>
			<a href="file_download.jsp?file=${requestScope.dto0.fileName }">파일 다운로드</a>
		</c:otherwise>
	</c:choose>
	${requestScope.file1 } <br>
	<a href="${requestScope.file1 }" download>파일 다운로드</a><br> --%>
	
	<c:forEach var="dto" items="${requestScope.list }">
		${dto.path},${dto.fileName },${dto.type }, ${requsetScope.user } <br>
		<%-- <a href="file_download.jsp?file=${dto.fileName}" >파일 다운로드</a><br> --%>
		<a href="file_download.jsp?fileName=${dto.fileName }&user=${requestScope.user}">파일 다운로드</a>
		<c:choose>
			<c:when test="${dto.type == 'image' }">
				<img src="${dto.path}">
			</c:when>
		</c:choose>
	</c:forEach>
</body>
</html>