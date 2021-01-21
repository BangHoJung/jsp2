package config;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import dto.EmployeeDTO;

public interface SQLMapper {
	@Select("SELECT * FROM employee")
	public List<EmployeeDTO> selectAllEmployee();
	
	@Select("SELECT COUNT(*) FROM employee")
	public int selectEmployeeCount();

	@Select("SELECT * FROM employee WHERE position < #{position}")
	public List<EmployeeDTO> selectEmployee_position(int position);

	@Select("SELECT * FROM employee WHERE position BETWEEN #{f} AND #{e}")
	public List<EmployeeDTO> selectEmployee_positionArea(@Param("f")int f, @Param("e")int e);

	@Insert("INSERT INTO employee VALUES(#{eno},#{name},#{department},#{position})")
	public void insertEmployee(EmployeeDTO dto);

	@Update("UPDATE employee SET name=#{name}, department=#{department}, position=#{position} WHERE eno = #{eno}")
	public int updateEmployee(HashMap<String, Object> map);

	@Select("SELECT * FROM employee WHERE name LIKE '%'||#{name}||'%'")
	public List<EmployeeDTO> selectEmployee_name(String name);
}
