package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EmployeeDTO;

import service.EmployeeService;

public class SearchEmployeeController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String kind = request.getParameter("kind");
		String text = request.getParameter("search");
		
		ArrayList<EmployeeDTO> list =  EmployeeService.getInstance().searchEmployee(kind,text);
		
		request.setAttribute("list", list);
		try {
			request.getRequestDispatcher("employee_manage.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
