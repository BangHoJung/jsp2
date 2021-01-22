package controller_member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.ModelAndView;
import service.MemberService;

public class ManageDeleteMemberController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("manageDelete");
		String id = request.getParameter("id");
		boolean result = MemberService.getInstance().manageDeleteMemberVO(id);
		System.out.println("result : "+result);
		try {
			response.getWriter().write(""+result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
