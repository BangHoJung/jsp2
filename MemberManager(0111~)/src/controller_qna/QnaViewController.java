package controller_qna;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dto.QnaDTO;
import model.ModelAndView;
import service.BoardService;

public class QnaViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		//관리자인 경우에는 모든 사용자의 문의목록 읽어옴.
		HttpSession session = request.getSession();
		String grade = (String) session.getAttribute("grade");
		
		String param = "";
		if(request.getQueryString()!=null) {
			param += "?"+request.getQueryString();
		}
		session.setAttribute("last", request.getRequestURI()+param);
		
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
