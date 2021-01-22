package controller_board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import dto.BoardDTO;
import dto.FileDTO;
import model.ModelAndView;
import service.BoardService;

public class UpdateBoardViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String writer = request.getParameter("writer");
		BoardDTO dto = BoardService.getInstance().searchBoardDTO(bno);
		List<FileDTO> fList = BoardService.getInstance().searchFileList(bno, writer);
		
		request.setAttribute("dto", dto);
		request.setAttribute("file_list", fList);
		ModelAndView view = new ModelAndView("board/board_update_view.jsp", false);
		return view;
	}

}
