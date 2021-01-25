package controller_board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dto.BoardDTO;
import dto.CommentDTO;
import dto.FileDTO;
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
		BoardDTO dto = null;
		int bno = 0;
		
		bno = Integer.parseInt(request.getParameter("bno"));
		dto =  BoardService.getInstance().searchBoardDTO(bno);
		List<CommentDTO> comment_list = BoardService.getInstance().searchAllCommentDTO(bno);
		List<FileDTO> fList = BoardService.getInstance().searchFileList(dto.getBno(),dto.getWriter());
		
		request.setAttribute("dto", dto);
		request.setAttribute("comment_list", comment_list);
		request.setAttribute("file_list", fList);
		
		for(int i=0;i<fList.size();i++) {
			System.out.println(fList.get(i).getPath());
		}
		

		//application.setAttribute("last", request.getRequestURI()+"?bno="+request.getParameter("bno"));
		return new ModelAndView("board/board_view.jsp", false);
	}

}
