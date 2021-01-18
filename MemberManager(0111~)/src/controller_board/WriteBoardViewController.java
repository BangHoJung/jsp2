package controller_board;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.ModelAndView;

public class WriteBoardViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session.getAttribute("login") == null || !(boolean)session.getAttribute("login")) {
			try {
				response.getWriter().write("<script>alert('로그인이 필요합니다');location.href='"+session.getAttribute("last")+"';</script>");
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
		System.out.println("last : " + session.getAttribute("last"));
		
		ModelAndView view = new ModelAndView("board/board_write_view.jsp", false);
		return view;
	}

}
