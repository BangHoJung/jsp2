package controller_member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import exception.MemberException;
import model.ModelAndView;
import service.MemberService;
import vo.MemberVO;

public class InsertMemberController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		MemberVO vo = new MemberVO(id,pass,name,age,null);
		
		ModelAndView view = null;
		try {
			MemberService.getInstance().insertMemberVO(vo);
			view = new ModelAndView("member/login.jsp", false);
		} catch (MemberException e) {
			try {
				response.getWriter().append("<script>alert('"+e.getMessage()+"');history.back();</script>");
				System.out.println(e.getMessage());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		return view;
	}

}
