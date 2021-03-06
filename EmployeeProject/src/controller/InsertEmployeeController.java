package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;

public class InsertEmployeeController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String eno = request.getParameter("eno");
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		int position = Integer.parseInt(request.getParameter("position"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		int count = EmployeeService.getInstance().insertEmployee(eno,name,department,position,salary);
		
		if(count==-1) {
			try {
				response.getWriter().append("<script>alert('사원 정보 등록 실패 입력하신 정보를 확인하세요');history.back();</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(count==1) {
			try {
				response.getWriter().append("<script>alert('사원 정보 등록 성공');history.back();</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
