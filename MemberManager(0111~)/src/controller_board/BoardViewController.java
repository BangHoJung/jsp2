package controller_board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dto.BoardDTO;
import dto.CommentDTO;
import model.ModelAndView;
import service.BoardService;

public class BoardViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String param = "";
		if(request.getQueryString()!=null) {
			param += "?"+request.getQueryString();
		}
		session.setAttribute("last", request.getRequestURI()+param);
		System.out.println("last : " + session.getAttribute("last"));
		BoardDTO dto = null;
		int bno = 0;
		
		bno = Integer.parseInt(request.getParameter("bno"));
		dto =  BoardService.getInstance().searchBoardDTO(bno);
		ArrayList<CommentDTO> comment_list = BoardService.getInstance().searchAllCommentDTO(bno);
		
		request.setAttribute("dto", dto);
		request.setAttribute("comment_list", comment_list);

		//application.setAttribute("last", request.getRequestURI()+"?bno="+request.getParameter("bno"));
		return new ModelAndView("board/board_view.jsp", false);
	}

}
