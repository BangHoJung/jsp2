package controller_board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import dto.FileDTO;
import model.ModelAndView;
import service.BoardService;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String writer = request.getParameter("writer");
		
		ArrayList<FileDTO> list = BoardService.getInstance().searchFileList(bno, writer);
		for(int i=0;i<list.size();i++) {
			File file = new File("C:\\fileupload\\" + list.get(i).getWriter() + "\\" + list.get(i).getFileName());
			System.out.println(file.exists());
			System.out.println(file.getAbsolutePath());
			file.delete();
		}
		
		int count = BoardService.getInstance().deleteBoardDTO(bno);
		ModelAndView view = null;
		if(count == 0) {
			try {
				response.getWriter().write("<script>alert('삭제중 오류가 발생했습니다.');history.back();</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			view = new ModelAndView("main.do", true);
		}
		
		return view;
	}

}
