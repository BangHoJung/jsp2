package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	
	public static BoardDAO_mapper getInstance() {
		if(instance == null) instance = new BoardDAO_mapper();
		return instance;
	}
	
	public int insertBoardDTO(BoardDTO board) throws BoardException {
		int bno = session.selectOne("mapper.BoardMapper.searchNextBno");
		board.setBno(bno);
		int count = session.insert("mapper.BoardMapper.insertBoardDTO",board);
		if(count == 1) return bno;
		else return 0;
	}
	
	public BoardDTO searchBoardDTO(int bno) {
		return session.selectOne("mapper.BoardMapper.searchBoardDTO",bno);
	}
	
	public List<BoardDTO> searchAllBoardDTO(int currPage, String sort) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PagingVO page = new PagingVO(countAllBoard(), currPage);
		map.put("page", page.getCountPageContent());
		map.put("currPage", currPage);
		map.put("sort", sort);
		return session.selectList("mapper.BoardMapper.searchAllBoardDTO",map);
	}
	
	public int countAllBoard() {
		return (int)session.selectOne("mapper.BoardMapper.countAllBoard");
	}
	
	public void addBoardCount(int bno) throws BoardException {
		int count = session.update("mapper.BoardMapper.addBoardCount",bno);
		if(count == 0) throw new BoardException("아이디가 올바르지 않습니다.");
	}
	
	public int addLikeBoardDTO(int bno) {
		int result = session.selectOne("mapper.BoardMapper.searchLikeBoard",bno);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("bno", bno);
		map.put("result", result+1);
		int count = session.update("mapper.BoardMapper.updateLikeBoard",map);
		if(count == 1) return result+1;
		else return result;
		
	}
	
	public int addHateBoardDTO(int bno) {
		int result = session.selectOne("mapper.BoardMapper.searchHateBoard",bno);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("bno", bno);
		map.put("result", result+1);
		int count = session.update("mapper.BoardMapper.updateHateBoard",map);
		if(count == 1) return result+1;
		else return result;
		
	}
	
	public void insertFileList(List<FileDTO> fList) {
		for(int i=0;i<fList.size();i++) {
			session.insert("mapper.BoardMapper.insertFileList",fList.get(i));		}
	}
	
	public List<FileDTO> searchFileList(int bno,String writer) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("writer",writer);
		return session.selectList("mapper.BoardMapper.searchFileList",map);
	}
	
	public int deleteBoardDTO(int bno) {
		return session.delete("mapper.BoardMapper.deleteBoardDTO",bno);
	}
	
	public BoardDTO prevBoardDTO(int bno) {
		return session.selectOne("mapper.BoardMapper.prevBoardDTO",bno);
	}
	
	public BoardDTO nextBoardDTO(int bno) {
		return session.selectOne("mapper.BoardMapper.nextBoardDTO",bno);
	}

	
//	Comment
	
	public int insertBoardComment(CommentDTO dto) {
		return session.insert("mapper.CommentMapper.insertBoardComment",dto);
	}
	
	public List<CommentDTO> searchAllCommentDTO(int bno) {
		return session.selectList("mapper.CommentMapper.searchAllCommentDTO",bno);
	}
	

	public HashMap<Integer, Integer> countAllComment() {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		//return (HashMap<Integer, Integer>) session.selectList("mapper.CommentMapper.countAllComment");
//		 for(int i=0; i<list.size();i++) {
//			Iterator<Map.Entry<Integer, Integer>> it = list.get(i).entrySet().iterator();
//			while(it.hasNext()) {
//				Entry<Integer, Integer> itv = it.next();
//				map.put(itv.getKey(), itv.getValue());
//			}
//		 }
		List<Map<String, Object>> list = session.selectList("mapper.CommentMapper.countAllComment");
		for(int i=0;i<list.size();i++) {
			map.put(Integer.parseInt(list.get(i).get("BNO").toString()),Integer.parseInt(list.get(i).get("CNT").toString()));
		}
		
		 return map;
	}
	
	public int addLikeCommentDTO(int cno) {
		int result = session.selectOne("mapper.CommentMapper.searchLikeComment",cno);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("cno", cno);
		map.put("result", result+1);
		int count = session.update("mapper.CommentMapper.updateLikeComment",map);
		if(count == 1) return result+1;
		else return result;
		
	}
	
	public int addHateCommentDTO(int cno) {
		int result = session.selectOne("mapper.CommentMapper.searchHateComment",cno);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("cno", cno);
		map.put("result", result+1);
		int count = session.update("mapper.CommentMapper.updateHateComment",map);
		if(count == 1) return result+1;
		else return result;
		
	}
	
//	QNA
	
	public void insertQnaDTO(QnaDTO dto) throws BoardException {
		int count = session.insert("mapper.QnaMapper.insertQnaDTO",dto);
		if(count == 0) {
			throw new BoardException("문의 등록이 실패했습니다");
		}
	}
	
	public List<QnaDTO> searchQnaList(String writer, int currPage) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("writer", writer);
		map.put("currPage", currPage);
		return session.selectList("mapper.QnaMapper.searchQnaList",map);
	}
	
	public List<QnaDTO> searchQnaMasterList(int currPage) {
		return session.selectList("mapper.QnaMapper.searchQnaMasterList",currPage);
	}
	
	public List<QnaDTO> searchNoAnswerQnaList() {
		return session.selectList("mapper.QnaMapper.searchNoAnswerQnaList");
	}
	
	public QnaDTO searchQnaDTO(int qid) {
		return session.selectOne("mapper.QnaMapper.searchQnaDTO",qid);
	}
	
	public int updateQnaResponse(int qid, String answer) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("qid", qid);
		map.put("answer", answer);
		int count = session.update("mapper.QnaMapper.updateQnaResponse",map);
		if(count == 1) {
			HashMap<String, Integer> map2 = new HashMap<String, Integer>();
			map2.put("qid", qid);
			map2.put("status", 2);
			return session.update("mapper.QnaMapper.updateQnaStatus",map2);
		}
		else return 0;
	}
	
	public int updateQnaStatus(int qid,int status) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("qid", qid);
		map.put("status", status);
		return session.update("mapper.QnaMapper.updateQnaStatus",map);
	}



	

	
	
	
	
	
	
	
}
