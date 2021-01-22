package main;

import java.util.List;
import java.util.Scanner;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class MyBatisMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		EmployeeDAO dao = EmployeeDAO.getInstance();
		
		//searchAllEmployeeCount(dao);
		searchAllEmployee(dao);
		//searchEmplyee_positionUnder(dao);
		searchEmployee_positionArea(dao);
		//insertEmployee(dao,sc);
		//updateEmployee(dao,sc);
		//searchEmployeeName(dao,sc);
		//deleteEmployeePosition(dao,sc);
		
		
	}
	
	private static void deleteEmployeePosition(EmployeeDAO dao, Scanner sc) {
		System.out.println("--------------------------------------------");
		try {
			System.out.println("삭제할 등급 입력");
			System.out.println("등급 목록 : 1.사원 2.주임 3.대리 4.과장 5.차장 6.부장 7.사장");
			System.out.print("사원 등급 : "); int position = sc.nextInt(); sc.nextLine();
			dao.deleteEmployeePosition(position);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void searchEmployeeName(EmployeeDAO dao, Scanner sc) {
		System.out.println("--------------------------------------------");
		try {
			System.out.println("사원 조회");
			System.out.print("조회할 사원 이름 : ");  String name = sc.nextLine();
			List<EmployeeDTO> list = dao.searchEmployeeName("%"+name+"%");
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void updateEmployee(EmployeeDAO dao, Scanner sc) {
		System.out.println("--------------------------------------------");
		try {
			System.out.println("변경할 사원정보 입력");
			System.out.print("사원 번호 : ");  String eno = sc.nextLine();
			EmployeeDTO dto =  dao.searchEmployee(eno);
			System.out.print("사원 이름 : "); String name = sc.nextLine();
			System.out.print("사원 직무 : "); String department = sc.nextLine();
			System.out.println("등급 목록 : 1.사원 2.주임 3.대리 4.과장 5.차장 6.부장 7.사장");
			System.out.print("사원 등급 : "); int position = sc.nextInt(); sc.nextLine();
			dao.updateEmployee(eno,name,department,position);
			System.out.println("사원정보 변경에 성공했습니다.");
		} catch(Exception e) {
			if(e.getMessage() == null) {
				System.out.println("정보 입력중 타입 에러");
			}
			else if(e.getMessage().contains("NULL")) {
				System.out.println("해당번호의 사원 정보 없음");
			}
		}
		
	}

	private static void insertEmployee(EmployeeDAO dao, Scanner sc) {
		System.out.println("--------------------------------------------");
		try {
			System.out.println("사원정보 입력");
			System.out.print("사원 번호 : ");  String eno = sc.nextLine();
			System.out.print("사원 이름 : "); String name = sc.nextLine();
			System.out.print("사원 직무 : "); String department = sc.nextLine();
			System.out.println("등급 목록 : 1.사원 2.주임 3.대리 4.과장 5.차장 6.부장 7.사장");
			System.out.print("사원 등급 : "); int position = sc.nextInt(); sc.nextLine();
			dao.insertEmployee(eno,name,department,position);
			System.out.println("사원등록에 성공했습니다.");
		} catch(Exception e) {
			if(e.getMessage().contains("null")) {
				System.out.println("사원등록 실패 : 데이터 NULL");
			}
			else if(e.getMessage().contains("nextInt")) {
				System.out.println("사원등록 실패 : 타입 에러");
			}
			else if(e.getMessage().contains("unique constraint")) {
				System.out.println("사원등록 실패 : 사원번호 중복");
			}
			else {
				System.out.println("사원등록에 실패했습니다.");
			}
		}
		
	}

	private static void searchEmployee_positionArea(EmployeeDAO dao) {
		System.out.println("--------------------------------------------");
		List<EmployeeDTO> list = dao.searchEmployee_positionArea(1,3);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

	private static void searchEmplyee_positionUnder(EmployeeDAO dao) {
		System.out.println("--------------------------------------------");
		List<EmployeeDTO> list = dao.searchEmployee_positionUnder(4);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

	private static void searchAllEmployee(EmployeeDAO dao) {
		System.out.println("--------------------------------------------");
		List<EmployeeDTO> list = dao.searchAllEmployee();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

	private static void searchAllEmployeeCount(EmployeeDAO dao) {
		System.out.println("--------------------------------------------");
		int count = dao.searchEmployeeAllCount();
		System.out.println("현재 사원 인원수:" + count);
	}
	
}
