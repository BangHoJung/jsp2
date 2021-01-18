package controller_board;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.ModelAndView;

public class WriteBoardViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("board/board_write_view.jsp", false);
		return view;
	}

}
