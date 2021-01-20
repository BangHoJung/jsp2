package controller_qna;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.ModelAndView;

public class QnaViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		//관리자인 경우에는 모든 사용자의 문의목록 읽어옴.
		HttpSession session = request.getSession();
		if(session.getAttribute("login") == null || !(boolean)session.getAttribute("login")) {
			try {
				response.getWriter().write("<script>alert('로그인이 필요합니다');location.href='"+session.getAttribute("lastBoard")+"';</script>");
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String param = "";
		if(request.getQueryString()!=null) {
			param += "?"+request.getQueryString();
		}
		session.setAttribute("last", request.getRequestURI()+param);
		
		String grade = (String) session.getAttribute("grade");
		ModelAndView view = null;
		if(grade.equals("master")) {
			view = new ModelAndView("member/qna_master.jsp", false);
		}
		else {
			view = new ModelAndView("member/qna.jsp", false);
		}

		return view;
	}
	

}
