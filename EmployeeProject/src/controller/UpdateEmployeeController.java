package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;

public class UpdateEmployeeController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String eno = request.getParameter("eno");
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		int position = Integer.parseInt(request.getParameter("position"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		int count = EmployeeService.getInstance().updateEmployee(eno,name,department,position,salary);
		
		if(count == 0) {
			try {
				response.getWriter().append("<script>alert('수정실패');history.back();</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(count == 1) {
			try {
				response.getWriter().append("<script>alert('수정 성공');history.back();</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
