package main;

import java.util.List;
import java.util.Scanner;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDAO dao = EmployeeDAO.getInstance();
		Scanner sc = new Scanner(System.in);
		
		selectAllEmployee(dao);
		selectEmployeeCount(dao);
		//selectEmployee_position(dao,5);
		//selectEmployee_positionArea(dao,1,4);
		try {
			//insertEmployee(dao,sc);
		}catch(Exception e) {
			if(e.getMessage() == null) System.out.println("타입 에러");
			else if(e.getMessage().contains("unique constraint")) System.out.println("사원 번호 중복 에러");
			else System.out.println(e.getMessage());
		}
		try {
			//updateEmployee(dao,sc);
		}catch(Exception e) {
			if(e.getMessage() == null) System.out.println("타입 에러");
			else if(e.getMessage().equals("0")) System.out.println("사원정보 변경 실패 : 사원 없음");
			else System.out.println(e.getMessage());
		}
		try {
			selectEmployee_name(dao,sc);
		}catch(Exception e) {
			if(e.getMessage() == null) System.out.println("타입 에러");
			else System.out.println(e.getMessage());
		}
	}
	
	private static void selectEmployee_name(EmployeeDAO dao, Scanner sc) {
		System.out.println("selectEmployee_name");
		System.out.print("검색할 사원 이름 : "); String name = sc.nextLine();
		List<EmployeeDTO> list =  dao.selectEmployee_name(name);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("---------------------------------------");
	}

	private static void updateEmployee(EmployeeDAO dao, Scanner sc) throws Exception {
		System.out.println("updateEmployee");
		System.out.print("사원 번호 : "); String eno = sc.nextLine();
		System.out.print("사원 이름 : "); String name = sc.nextLine();
		System.out.print("사원 직무 : "); String department = sc.nextLine();
		System.out.print("사원 등급 : "); int position = sc.nextInt(); sc.nextLine();
		dao.updateEmployee(eno,name,department,position);
		System.out.println("사원 정보 변경 성공");
	}

	private static void insertEmployee(EmployeeDAO dao, Scanner sc) throws Exception{
		System.out.println("insertEmployee");
		System.out.print("사원 번호 : "); String eno = sc.nextLine();
		System.out.print("사원 이름 : "); String name = sc.nextLine();
		System.out.print("사원 직무 : "); String department = sc.nextLine();
		System.out.print("사원 등급 : "); int position = sc.nextInt(); sc.nextLine();
		dao.insertEmployee(new EmployeeDTO(eno, name, department, position));
		System.out.println("사원 등록 성공");
	}

	private static void selectEmployee_positionArea(EmployeeDAO dao, int f, int e) {
		List<EmployeeDTO> list =  dao.selectEmployee_positionArea(f,e);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("---------------------------------------");
		
	}

	private static void selectEmployee_position(EmployeeDAO dao, int position) {
		List<EmployeeDTO> list =  dao.selectEmployee_position(position);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("---------------------------------------");
	}

	private static void selectEmployeeCount(EmployeeDAO dao) {
		System.out.println("All Employee Count : " + dao.selectEmployeeCount());		
		System.out.println("---------------------------------------");
	}

	private static void selectAllEmployee(EmployeeDAO dao) {
		List<EmployeeDTO> list =  dao.selectAllEmployee();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("---------------------------------------");
		
	}


}
