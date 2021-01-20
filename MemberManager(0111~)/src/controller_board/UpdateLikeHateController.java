package controller_board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.ModelAndView;
import service.BoardService;

public class UpdateLikeHateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String lh = request.getParameter("lh");
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		int count = BoardService.getInstance().addLikeHateBoardDTO(bno,lh);
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
