package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.EmployeeDTO;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private SqlSessionFactory factory;
	private SqlSession session;
	
	private EmployeeDAO() {
		String resource = "db/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			session = factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static EmployeeDAO getInstance() {
		if(instance == null) instance = new EmployeeDAO();
		return instance;
	}
	
	public int searchEmployeeAllCount() {
		int count = 0;
		count = session.selectOne("db.SqlMapper.selectEmployeeAllCount");
		
		return count;
	}
	
	public List<EmployeeDTO> searchAllEmployee() {
		List<EmployeeDTO> list = session.selectList("db.SqlMapper.selectAllEmployee");
		return list;
	}
	
	public List<EmployeeDTO> searchEmployee_positionUnder(int no) {
		List<EmployeeDTO> list = session.selectList("db.SqlMapper.selectEmployee_positionUnder",no);
		return list;
	}

	public List<EmployeeDTO> searchEmployee_positionArea(int start, int end) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		return session.selectList("db.SqlMapper.selectEmployee_positionArea",map );
	}
}
