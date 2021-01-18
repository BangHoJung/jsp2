package controller_board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dto.BoardDTO;
import exception.BoardException;
import model.ModelAndView;
import service.BoardService;

public class InsertBoardController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
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
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		ModelAndView view = null;
		
		BoardDTO board = new BoardDTO(title,writer,content);
		int bno = 0;
		try {
			bno = BoardService.getInstance().insertBoardDTO(board);
		} catch (BoardException e) {
			try {
				response.getWriter().write("<script>alert('"+e.getMessage()+"');history.back();</script>");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		String param = "";
		if(request.getQueryString()!=null) {
			param += "?"+request.getQueryString();
		}
		session.setAttribute("last", request.getRequestURI()+param);
		System.out.println("last : " + session.getAttribute("last"));
		//게시글 조회 페이지 board_view.jsp 게시글 번호
		view = new ModelAndView("board_view.do?bno="+bno, false);
		return view;
	}

}
