package controller_board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import dto.BoardDTO;
import dto.CommentDTO;
import model.ModelAndView;
import service.BoardService;

public class BoardViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
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
