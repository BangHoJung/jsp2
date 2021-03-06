package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.EmployeeDTO;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private DBManager manager = null;
	private EmployeeDAO() {
		manager = DBManager.getInstance();
	}
	
	public static EmployeeDAO getInstance() {
		if(instance == null) instance = new EmployeeDAO();
		return instance;
		
	}

	public EmployeeDTO loginEmployee(String eno, String name) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT * FROM Employee WHERE eno=? AND name=?";
		EmployeeDTO dto = null;
		
		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setString(1, eno);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new EmployeeDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(pstmt, rs);
		}
		
		return dto;
	}
	
	public String getPositionName(int position) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT name FROM position_list WHERE pno = ?";
		String pos_name = "";
		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setInt(1, position);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pos_name = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(pstmt, rs);
		}
		
		return pos_name;
	}

	public ArrayList<EmployeeDTO> searchEmployeeName(String text) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		text = "%"+text+"%";
		String sql="SELECT e.eno,e.name,e.department,e.position,s.salary FROM employee e,employee_salary s WHERE e.name LIKE ? AND e.eno=s.eno";
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		
		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setString(1, text);
			rs = pstmt.executeQuery();
			
			while(rs.next() ) {
				list.add(new EmployeeDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(pstmt, rs);
		}
		
		return list;
	}

	public ArrayList<EmployeeDTO> searchEmployeeEno(String text) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		text = "%"+text+"%";
		String sql="SELECT e.eno,e.name,e.department,e.position,s.salary FROM employee e,employee_salary s WHERE e.eno LIKE ? AND e.eno=s.eno";
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		
		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setString(1, text);
			rs = pstmt.executeQuery();
			
			while(rs.next() ) {
				list.add(new EmployeeDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(pstmt, rs);
		}
		
		return list;
		
	}

	public ArrayList<EmployeeDTO> searchEmployeeDepartment(String text) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		text = "%"+text+"%";
		String sql="SELECT e.eno,e.name,e.department,e.position,s.salary FROM employee e,employee_salary s WHERE e.department LIKE ? AND e.eno=s.eno";
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		
		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setString(1, text);
			rs = pstmt.executeQuery();
			
			while(rs.next() ) {
				list.add(new EmployeeDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(pstmt, rs);
		}
		
		return list;
		
	}

	public int insertEmployee(String eno, String name, String department, int position, int salary) {
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employee VALUES(?,?,?,?)";
		int count = 0;
		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setString(1, eno);
			pstmt.setString(2, name);
			pstmt.setString(3, department);
			pstmt.setInt(4, position);
			count = pstmt.executeUpdate();
			
			if(count == 0) return -1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(pstmt, null);
		}
		
		PreparedStatement pstmt2 = null;
		String sql2 = "INSERT INTO employee_salary VALUES(?,?)";
		
		try {
			pstmt2 = manager.getConn().prepareStatement(sql2);
			pstmt2.setString(1, eno);
			pstmt2.setInt(2, salary);
			count = pstmt2.executeUpdate();
			
			if(count == 0) return -1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(pstmt2, null);
		}
		
		
		return 1;
	}

	public int updateEmployee(String eno, String name, String department, int position, int salary) {
		PreparedStatement pstmt = null;
		String sql="UPDATE employee SET name=?,department=?,position=? WHERE eno=?";
		int count=0;
		
		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, department);
			pstmt.setInt(3, position);
			count = pstmt.executeUpdate();
			if(count == 0) return 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			manager.close(pstmt, null);
		}
		
		PreparedStatement pstmt2 = null;
		String sql2="UPDATE employee_salary SET salary=? WHERE eno=?";
		
		try {
			pstmt2 = manager.getConn().prepareStatement(sql2);
			pstmt2.setInt(1, salary);
			pstmt2.setString(2, eno);
			count = pstmt2.executeUpdate();
			if(count == 0) return 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			manager.close(pstmt2, null);
		}
		return 1;
		
		
	}
}

