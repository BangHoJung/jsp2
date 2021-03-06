package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EmployeeDTO;
import service.EmployeeService;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String eno = request.getParameter("eno");
		EmployeeDTO dto = EmployeeService.getInstance().loginEmployee(eno,name);
		
		if(dto == null) {
			try {
				response.getWriter().write("<script>alert('입력하신 정보를 확인하세요');location.href='login.jsp';</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			request.getSession().setAttribute("dto", dto);
			request.getSession().setAttribute("pos_name", EmployeeService.getInstance().getPositionName(dto.getPosition()));
			try {
				request.getRequestDispatcher("employee_manage.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
