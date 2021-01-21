package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.BoardDTO;
import dto.CommentDTO;
import dto.FileDTO;
import dto.QnaDTO;
import exception.BoardException;
import vo.PagingVO;

public class BoardDAO_mapper {
	private static BoardDAO_mapper instance = new BoardDAO_mapper();
	private SqlSessionFactory factory;
	private SqlSession session;
	
//	BOARD
	
	private BoardDAO_mapper() {
		String resource = "db/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			session = factory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDAO_mapper getInstance() {
		if(instance == null) instance = new BoardDAO_mapper();
		return instance;
	}
	
	public int insertBoardDTO(BoardDTO board) throws BoardException {
		return session.insert("db.BoardMapper.insertBoardDTO",board);
	}
	
	public BoardDTO searchBoardDTO(int bno) {
		return session.selectOne("db.BoardMapper.searchBoardDTO",bno);
	}
	
	public List<BoardDTO> searchAllBoardDTO(int currPage, String sort) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PagingVO page = new PagingVO(countAllBoard(), currPage);
		map.put("page", page.getCountPageContent());
		map.put("currPage", currPage);
		map.put("sort", sort);
		return session.selectList("db.BoardMapper.searchAllBoardDTO",map);
	}
	
	public int countAllBoard() {
		return session.selectOne("db.BoardMapper.countAllBoard()");
	}
	
	public void addBoardCount(int bno) throws BoardException {
		int count = session.update("db.BoardMapper.addBoardCount",bno);
		if(count == 0) throw new BoardException("아이디가 올바르지 않습니다.");
	}
	
	public int addLikeBoardDTO(int bno) {
		int result = session.selectOne("db.BoardMapper.searchLikeBoard",bno);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("bno", bno);
		map.put("result", result+1);
		int count = session.update("db.BoardMapper.updateLikeBoard",map);
		if(count == 1) return result+1;
		else return result;
		
	}
	
	public int addHateBoardDTO(int bno) {
		int result = session.selectOne("db.BoardMapper.searchHateBoard",bno);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("bno", bno);
		map.put("result", result+1);
		int count = session.update("db.BoardMapper.updateHateBoard",map);
		if(count == 1) return result+1;
		else return result;
		
	}
	
//	Comment
	
	public int insertBoardComment(CommentDTO dto) {
		return session.insert("db.CommentMapper.insertBoardComment",dto);
	}
	
	public List<CommentDTO> searchAllCommentDTO(int bno) {
		return session.selectList("db.CommentMapper.searchAllCommentDTO",bno);
	}
	
	public HashMap<Integer, Integer> countAllComment() {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		return (HashMap<Integer, Integer>) session.selectList("db.CommentMapper.countAllComment");
	}
	
//	QNA
	
	public void insertQnaDTO(QnaDTO dto) throws BoardException {
		int count = session.insert("db.QnaMapper.insertQnaDTO",dto);
		if(count == 0) {
			throw new BoardException("문의 등록이 실패했습니다");
		}
	}
	
	public List<QnaDTO> searchQnaList(String writer, int currPage) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("writer", writer);
		map.put("currPage", currPage);
		return session.selectList("db.QnaMapper.searchQnaList",map);
	}
	
	public List<QnaDTO> searchQnaMasterList(int currPage) {
		return session.selectList("db.QnaMapper.searchQnaMasterList",currPage);
	}
	
	public List<QnaDTO> searchNoAnswerQnaList() {
		return session.selectList("db.QnaMapper.searchNoAnswerQnaList");
	}
	
	public QnaDTO searchQnaDTO(int qid) {
		return session.selectOne("db.QnaMapper.searchQnaDTO",qid);
	}
	
	public int updateQnaResponse(int qid, String answer) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("qid", qid);
		map.put("answer", answer);
		return session.update("db.updateQnaResponse",map);
	}
	
	public int updateQnaStatus(int qid,int status) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("qid", qid);
		map.put("status", status);
		return session.update("db.QnaMapper.updateQnaStatus",map);
	}
	
	public void insertFileList(ArrayList<FileDTO> fList) {
		
	}
	
	
	
	
	
	
	
}
