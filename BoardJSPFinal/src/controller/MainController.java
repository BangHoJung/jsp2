package controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO_mapper;
import dto.BoardDTO;
import model.ModelAndView;
import service.BoardService;
import vo.PagingVO;

public class MainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String param = "";
		if(request.getQueryString()!=null) {
			param += "?"+request.getQueryString();
		}
		session.setAttribute("last", request.getRequestURI()+param);
		session.setAttribute("lastBoard", request.getRequestURI()+param);
		System.out.println(session.getAttribute("last"));
		ModelAndView view = null;
		int currPage = 1;
		String sort="bno";
		if(request.getParameter("currPage") != null) {
			currPage = Integer.parseInt(request.getParameter("currPage"));
			sort = request.getParameter("sort");
			view = new ModelAndView("main.jsp?currPage="+currPage+"&sort="+sort, false);
		}
		else {
			view = new ModelAndView("main.jsp?currPage=1&sort=bno", false);
			//response.sendRedirect("index.jsp?currPage=1&sort=bno");
		}
		System.out.println("currPage : "+currPage);
		
		List<BoardDTO> board_list = BoardService.getInstance().searchAllBoardDTO(currPage,sort);
		HashMap<Integer, Integer> map = BoardService.getInstance().countAllComment();
//		Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
//		while(it.hasNext()) {
//			Entry<Integer, Integer> itv = it.next();
//			System.out.println(itv.getKey() + " " + itv.getValue());
//		}
		int count = BoardDAO_mapper.getInstance().countAllBoard();
		PagingVO pageVO = new PagingVO(count,currPage);
		System.out.println(pageVO);
		
		request.setAttribute("board_list", board_list);
		request.setAttribute("map", map);
		request.setAttribute("pageVO", pageVO);
		
		
		System.out.println("return : currPage="+currPage+"&sort="+sort);
		return view;
		
	}

}
