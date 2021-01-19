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
	${requestScope.file0 } <br>
	<%-- <a href="${requestScope.file0 }" download>파일 다운로드</a><br> --%>
	<a href="file_download.jsp?file=${requestScope.fileName0 }" >파일 다운로드</a><br>
	<c:if test="${requestScope.item0.contentType.split('/')[0] == 'image' }">
		<span><img src="${requestScope.file0 }"></span><br>
	</c:if>
	${requestScope.file1 } <br>
	<a href="${requestScope.file1 }" download>파일 다운로드</a><br>
</body>
</html>