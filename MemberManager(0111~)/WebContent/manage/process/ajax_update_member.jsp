<%@page import="vo.MemberVO"%>
<%@page import="service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%
		boolean result = false;
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String grade_name = request.getParameter("grade_name");
		
		MemberVO vo = new MemberVO(id,null,name,age,grade_name);
		
		result = MemberService.getInstance().updateManageMemberVO(vo);
		
		System.out.print(""+result);
		out.write(""+result);
		
	%>