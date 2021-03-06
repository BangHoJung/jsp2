package service;

import java.util.ArrayList;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class EmployeeService {
	private static EmployeeService instance = new EmployeeService();
	private EmployeeDAO dao;
	private EmployeeService() {
		dao = EmployeeDAO.getInstance();
	}
	
	public static EmployeeService getInstance() {
		if(instance == null) instance = new EmployeeService();
		return instance;
	}

	public EmployeeDTO loginEmployee(String eno, String name) {
		return dao.loginEmployee(eno,name);
	}

	public Object getPositionName(int position) {
		return dao.getPositionName(position);
	}

	public ArrayList<EmployeeDTO> searchEmployee(String kind, String text) {
		if(kind.equals("name")) {
			return dao.searchEmployeeName(text);
		}
		else if(kind.equals("eno")) {
			return dao.searchEmployeeEno(text);
		}
		else {
			return dao.searchEmployeeDepartment(text);
		}
		
	}

	public int insertEmployee(String eno, String name, String department, int position, int salary) {
		if(eno.length()<4) return -1;
		else if(name.length()<1) return -1;
		else if(department.length()<1) return -1;
		else if(salary<1) return -1;
		else {
			return dao.insertEmployee(eno,name,department,position,salary);
		}
	}

	public int updateEmployee(String eno, String name, String department, int position, int salary) {
		// TODO Auto-generated method stub
		if(eno.length()<4) return -1;
		else if(name.length()<1) return -1;
		else if(department.length()<1) return -1;
		else if(salary<1) return -1;
		else {
			return dao.updateEmployee(eno,name,department,position,salary);
		}
	}
	
}
