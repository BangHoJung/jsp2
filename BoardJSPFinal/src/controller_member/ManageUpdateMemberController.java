package controller_member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.ModelAndView;
import service.MemberService;
import vo.MemberVO;

public class ManageUpdateMemberController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		boolean result = false;
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String grade = request.getParameter("grade");
		
		MemberVO vo = new MemberVO(id,null,name,age,grade);
		
		result = MemberService.getInstance().updateManageMemberVO(vo);
		
		System.out.print(""+result);
		try {
			response.getWriter().write(""+result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
