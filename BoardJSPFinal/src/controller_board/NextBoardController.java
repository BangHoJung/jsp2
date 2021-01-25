package controller_board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import dto.BoardDTO;
import model.ModelAndView;
import service.BoardService;

public class NextBoardController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardDTO dto = BoardService.getInstance().nextBoardDTO(bno);
		ModelAndView view=null;
		if(dto == null) {
			try {
				response.getWriter().write("<script>alert('더 이상 다음글이 없습니다');history.back();</script>");
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			view = new ModelAndView("board_view.do?bno="+dto.getBno(), false);
		}
		
		return view;
	}

}
