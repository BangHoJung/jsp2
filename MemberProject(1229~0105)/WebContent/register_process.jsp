<%@page import="exception.MemberException"%>
<%@page import="service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<%@ page import="vo.MemberVO" %>

	<%
		request.setCharacterEncoding("utf-8"); // post일때 필수로 해야함.
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		MemberVO vo = new MemberVO(id,pass,name,age,"bronze");
		
		MemberService.getInstance().insertMemberVO(vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	%>
