package controller_board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import dto.BoardDTO;
import exception.BoardException;
import model.ModelAndView;
import service.BoardService;

public class InsertBoardController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
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
		
		//게시글 조회 페이지 board_view.jsp 게시글 번호
		view = new ModelAndView("board_view.do?bno="+bno, false);
		return view;
	}

}
