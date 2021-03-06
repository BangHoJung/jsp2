package service;

import java.util.ArrayList;

import dao.MemberDAO;
import exception.MemberException;
import vo.MemberVO;

public class MemberService {
	private static MemberService instance = new MemberService();
	
	private MemberService() {
		
	}
	
	public static MemberService getInstance() {
		if(instance == null) instance = new MemberService();
		return instance;
	}
	
	public void insertMemberVO(MemberVO vo) throws MemberException {
		if(vo.getId().length() < 1) {
			throw new MemberException("아이디를 입력하세요");
		}
		else if(vo.getPass().length() < 4) {
			throw new MemberException("비밀번호를 4자이상 입력하세요");
		}
		else if(vo.getName().length()<1) {
			throw new MemberException("이름을 입력하세요");
		}
		else if(vo.getAge() < 0 || vo.getAge() > 100) {
			throw new MemberException("나이를 올바르게 입력하세요");
		}
		else if(MemberDAO.getIntance().searchMemberVO(vo.getId()) != null) {
			throw new MemberException("해당 멤버 이미 존재");
		}
		else {
			MemberDAO.getIntance().insertMemberVO(vo);
		}
		
	}
	
	public MemberVO searchMemberVO(String id) {
		
		 return MemberDAO.getIntance().searchMemberVO(id);
		 		
	}
	
	public void searchMemberVO(String id, String name) throws MemberException {
		
		 MemberVO vo = MemberDAO.getIntance().searchMemberVO(id);
		 if(vo == null) {
			 throw new MemberException("해당 아이디가 없습니다");
		 }
		 else if(!vo.getName().equals(name)) {
			 throw new MemberException("이름이 일치하지 않습니다");
		 }
		
	}
	
	public void updatePass(String id, String pass) throws MemberException {
		
		MemberDAO.getIntance().updatePass(id, pass);
	}
	
	public MemberVO checkLoginMember(String id, String pass) {
		
		return MemberDAO.getIntance().searchMemberVO(id,pass);
	}
	
	public void updateMemberVO(MemberVO vo) throws MemberException {
		if(vo.getId().length() < 1) {
			throw new MemberException("아이디를 입력하세요");
		}
		else if(vo.getPass().length() < 4) {
			throw new MemberException("비밀번호를 4자이상 입력하세요");
		}
		else if(vo.getName().length()<1) {
			throw new MemberException("이름을 입력하세요");
		}
		else if(vo.getAge() < 0 || vo.getAge() > 100) {
			throw new MemberException("나이를 올바르게 입력하세요");
		}
		else {
			MemberDAO.getIntance().updateMemberVO(vo);
		}
	}
	
	public ArrayList<MemberVO> searchAllMemberVO() {
		
		return MemberDAO.getIntance().searchAllMemberVO("");
		
	}
	
	public ArrayList<MemberVO> searchNameMemberVO(String name) {
		
		return MemberDAO.getIntance().searchAllMemberVO(name);
	}
	
	public boolean updateManageMemberVO(MemberVO vo) {
		try {
			MemberDAO.getIntance().updateMemberVO(vo);
			return true;
		} catch (MemberException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteManageMemberVO(String id) {
		try {
			MemberDAO.getIntance().deleteMemberVO(id);
			return true;
		} catch (MemberException e) {
			e.printStackTrace();
			return false;
		}
	}
}
