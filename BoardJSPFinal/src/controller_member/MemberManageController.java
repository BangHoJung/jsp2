package controller_member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.ModelAndView;

public class MemberManageController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session.getAttribute("login") == null || !session.getAttribute("grade").equals("master")) {
			try {
				response.getWriter().write("<script>alert('권한이 없습니다.');location.href='main.do';</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String param = "";
		if(request.getQueryString()!=null) {
			param += "?"+request.getQueryString();
		}
		session.setAttribute("last", request.getRequestURI()+param);
		
		return new ModelAndView("manage/member_manage.jsp", false);
	}

}
