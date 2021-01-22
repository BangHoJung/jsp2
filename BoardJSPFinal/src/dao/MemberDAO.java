package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import exception.MemberException;
import vo.MemberVO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private SqlSessionFactory factory;
	private SqlSession session;
	
	private MemberDAO() {
		String resource = "/config/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			session = factory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getIntance() {
		if(instance == null) instance = new MemberDAO();
		return instance;
	}

	public void insertMemberVO(MemberVO vo) throws MemberException{
		
		int count = session.insert("mapper.MemberMapper.insertMemberVO",vo);
		if(count == 0) throw new MemberException("멤버 등록 실패");
			
	}
	
	public MemberVO searchMemberVO(String id) {
		return session.selectOne("mapper.MemberMapper.searchMemberVO",id);
	}

	public void updatePass(String id, String pass) throws MemberException {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pass", pass);
		int count = session.update("mapper.MemberMapper.updatePass",map);
		if(count == 0) {
			throw new MemberException("암호수정에 실패했습니다.");
		}
		
	}

	public MemberVO searchMemberVO(String id, String pass) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pass", pass);
		return session.selectOne("mapper.MemberMapper.searchMemberVOPass",map);
	}

	public void updateMemberVO(MemberVO vo) throws MemberException {
			
		int count = session.update("mapper.MemberMapper.updateMemberVO",vo);
		if(count == 0) {
			throw new MemberException("멤버 정보 변경에 실패했습니다.");
		}
	}
	
	
	
	public List<MemberVO> searchAllMemberVO(String name) {
		return session.selectList("mapper.MemberMapper.searchAllMemberVO",name);
		
	}

	public void deleteMemberVO(String id) throws MemberException {
		System.out.println("manageDeleteDAO");
		int count = session.delete("mapper.MemberMapper.deleteMemberVO",id);
		if(count == 0) {
			throw new MemberException("삭제된 데이터가 없습니다.");
		}
	}

	public List<MemberVO> manageSearchMember(String kind, String search) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("kind", kind);
		map.put("search", search);
		return session.selectList("mapper.MemberMapper.manageSearchMember",map);
	}
}
