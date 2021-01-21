package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import config.SQLMapper;
import dto.EmployeeDTO;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private SqlSession session;	
	private SQLMapper mapper;
	private EmployeeDAO() {
		session = DBManager.getInstance().getSqlSession();
		mapper = session.getMapper(SQLMapper.class);
	}
	
	public static EmployeeDAO getInstance() {
		if(instance == null) instance = new EmployeeDAO();
		return instance;
	}
	
	public List<EmployeeDTO> selectAllEmployee() {
		return mapper.selectAllEmployee();
	}

	public int selectEmployeeCount() {
		return mapper.selectEmployeeCount();
	}

	public List<EmployeeDTO> selectEmployee_position(int position) {
		return mapper.selectEmployee_position(position);
	}

	public List<EmployeeDTO> selectEmployee_positionArea(int f, int e) {
		return mapper.selectEmployee_positionArea(f,e);
	}

	public void insertEmployee(EmployeeDTO dto) throws Exception{
		mapper.insertEmployee(dto);
	}

	public void updateEmployee(String eno, String name, String department, int position) throws Exception{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("eno", eno);
		map.put("name", name);
		map.put("department", department);
		map.put("position", position);
		throw new Exception(""+mapper.updateEmployee(map));
	}

	public List<EmployeeDTO> selectEmployee_name(String name) {
		return mapper.selectEmployee_name(name);
	}
}

