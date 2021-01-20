package main;

import java.util.List;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class MyBatisMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDAO dao = EmployeeDAO.getInstance();
		int count = dao.searchEmployeeAllCount();
		System.out.println("현재 사원 인원수:" + count);
		System.out.println("--------------------------------------------");
		List<EmployeeDTO> list = dao.searchAllEmployee();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("--------------------------------------------");
		list = dao.searchEmployee_positionUnder(4);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("--------------------------------------------");
		list = dao.searchEmployee_positionArea(1,3);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}

}
