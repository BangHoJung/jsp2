package controller_board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.ModelAndView;
import service.BoardService;

public class UpdateCommentLikeHateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String lh = request.getParameter("lh");
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		int count = BoardService.getInstance().addLikeHateCommentDTO(cno,lh);
		System.out.print(count+"\n");
		try {
			response.getWriter().write(""+count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
