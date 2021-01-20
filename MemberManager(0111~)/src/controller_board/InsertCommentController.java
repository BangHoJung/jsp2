package controller_board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import dto.CommentDTO;
import model.ModelAndView;
import service.BoardService;

public class InsertCommentController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		System.out.print(bno + " , " + writer + " , " + content);
		
		int count = BoardService.getInstance().insertBoardComment(new CommentDTO(bno,content,writer));
		
		try {
			response.getWriter().write(""+count);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
