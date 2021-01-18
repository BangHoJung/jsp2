package controller_qna;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import controller.Controller;
import dto.QnaDTO;
import model.ModelAndView;
import service.BoardService;
import service.MemberService;

public class QnaMasterViewController implements Controller {

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
		
		int qid = Integer.parseInt(request.getParameter("qid"));
		int status = Integer.parseInt(request.getParameter("status"));
		if(status == 0) status = 1;
		QnaDTO dto = BoardService.getInstance().searchQnaDTO(qid,status);
		
		ModelAndView view = null;
		
		if(dto != null) {
			request.setAttribute("dto", dto);
			view = new ModelAndView("member/qna_master_view.jsp", false);
			String param = "";
			if(request.getQueryString()!=null) {
				param += "?"+request.getQueryString();
			}
			session.setAttribute("last", request.getRequestURI()+param);
			System.out.println("last : " + session.getAttribute("last"));
		}
		else {
			try {
				response.getWriter().write("<script>alert('해당 문의글을 찾을 수 없습니다.');history.back();</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return view;
	}

}
