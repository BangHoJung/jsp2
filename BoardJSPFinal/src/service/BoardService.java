package service;

import java.util.List;
import java.util.HashMap;

import dao.BoardDAO_mapper;
import dto.BoardDTO;
import dto.CommentDTO;
import dto.FileDTO;
import dto.QnaDTO;
import exception.BoardException;

public class BoardService {

	private static BoardService instance = new BoardService();
	
	private BoardDAO_mapper dao = null;
	private BoardService() {
		dao = BoardDAO_mapper.getInstance();
	}
	
	public static BoardService getInstance() {
		if(instance == null) instance = new BoardService();
		return instance;
	}
	
	public int insertBoardDTO(BoardDTO board) throws BoardException {
		if(board.getTitle().length()<1) {
			throw new BoardException("제목을 입력하세요");
		}
		else if(board.getWriter().length()<1) {
			throw new BoardException("아이디가 올바르지 않습니다");
		}
		else if(board.getContent().length()<1) {
			throw new BoardException("내용을 입력하세요");
		}
		else {
			return dao.insertBoardDTO(board);
		}
	}
	
	public BoardDTO searchBoardDTO(int bno) {
		try {
			dao.addBoardCount(bno);
		} catch (BoardException e) {
			e.getMessage();
		}
		return dao.searchBoardDTO(bno);
	}
	
	public int addLikeHateBoardDTO(int bno,String lh) {
		if(lh.equals("like")) {
			return dao.addLikeBoardDTO(bno);
		}
		else {
			return dao.addHateBoardDTO(bno);
		}
	}
	
	public List<BoardDTO> searchAllBoardDTO(int currPage, String sort) {
		return dao.searchAllBoardDTO(currPage,sort);
	}
	
	public int insertBoardComment(CommentDTO dto) {
		return dao.insertBoardComment(dto);
	}
	
	public  List<CommentDTO> searchAllCommentDTO(int bno) {
		return  dao.searchAllCommentDTO(bno);
	}
	
	public HashMap<Integer, Integer> countAllComment() {
		return dao.countAllComment();
	}

	public void insertQnaDTO(QnaDTO dto) throws BoardException {
		dao.insertQnaDTO(dto);
	}

	public  List<QnaDTO> searchQnaList(String writer, int currPage, String grade) {
		if(grade.equals("master")) {
			return dao.searchQnaMasterList(currPage);
		}
		else {
			return dao.searchQnaList(writer,currPage);
		}
	}

	public  List<QnaDTO> searchNoAnswerQnaList() {
		return dao.searchNoAnswerQnaList();
	}

	public QnaDTO searchQnaDTO(int qid,int status) {
		int count = dao.updateQnaStatus(qid, status);
		if(count == 0) {
			return null;
		}
		return dao.searchQnaDTO(qid);
	}

	public int updateQnaResponse(int qid, String answer,int status) {
		int count = dao.updateQnaResponse(qid,answer);
		if(count != 0) {
			count = dao.updateQnaStatus(qid, status);
		}
		return count;
	}

	public void insertFileList( List<FileDTO> fList) {
		// TODO Auto-generated method stub
		dao.insertFileList(fList);
	}

	public  List<FileDTO> searchFileList(int bno,String writer) {
		return dao.searchFileList(bno,writer);
	}

	public int addLikeHateCommentDTO(int cno, String lh) {
		if(lh.equals("clike")) {
			return dao.addLikeCommentDTO(cno);
		}
		else {
			return dao.addHateCommentDTO(cno);
		}
	}

	public int deleteBoardDTO(int bno) {
		return dao.deleteBoardDTO(bno);
	}


}
