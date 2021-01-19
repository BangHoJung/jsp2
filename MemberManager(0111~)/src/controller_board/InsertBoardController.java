package controller_board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import controller.Controller;
import dto.BoardDTO;
import dto.FileDTO;
import exception.BoardException;
import model.ModelAndView;
import service.BoardService;

public class InsertBoardController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String title = null;
		String writer = null;
		String content = null;
		
		String path="C:\\fileupload";
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(path)); // 업로드될 폴더
		factory.setSizeThreshold(1024 * 1024); // 1MB
		ServletFileUpload upload = new ServletFileUpload(factory);
		ArrayList<FileDTO> fList = new ArrayList<FileDTO>();
		try {
			List<FileItem> list = upload.parseRequest(request); 
			for(int i=0;i<list.size();i++) { 
				FileItem item = list.get(i);
				if(item.isFormField()) {
					//받은 내용중 파일이 아닌경우
					switch(item.getFieldName()) {
					case "title":
						title = item.getString("utf-8");
						break;
					case "writer":
						writer = item.getString("utf-8");
						break;
					case "content":
						content = item.getString("utf-8");
						break;
					}
					System.out.println(item.getFieldName() + " : " + item.getString("utf-8"));
				}
				else {
					//받은 내용중 파일인 경우
					System.out.println("매개변수 명 : " + item.getFieldName());
					System.out.println("파일 명 : " + item.getName());
					System.out.println("파일 크기 : " + item.getSize());
					System.out.println("파일 타입 : " + item.getContentType());
					
					if(item.getSize() > 0) {
						int idx = item.getName().lastIndexOf("\\");
						if(idx==-1) {
							idx = item.getName().lastIndexOf("/");
						}
						String fileName = item.getName().substring(idx+1);
						//파일 경로 완성
						File pathFile = new File(path +"\\"+writer+"\\"+fileName);
						if(!pathFile.getParentFile().exists()) {
							pathFile.getParentFile().mkdirs();
						}
						item.write(pathFile);
						System.out.println("셋팅된 전체 경로 : "+pathFile);
						fList.add(new FileDTO(0,writer,pathFile.getName()));
						
						/*
						 * request.setAttribute("file"+i, request.getContextPath() + "/upload/" +
						 * fileName); request.setAttribute("fileName"+i, fileName);
						 * request.setAttribute("item"+i, item); request.setAttribute("dto"+i, dto);
						 */
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BoardDTO board = new BoardDTO(title,writer,content);
		int bno = 0;
		try {
			bno = BoardService.getInstance().insertBoardDTO(board);
			if(fList.size()>0) {
				for(int i=0;i<fList.size();i++) {
					fList.get(i).setBno(bno);
				}
				BoardService.getInstance().insertFileList(fList);
			}
		} catch (BoardException e) {
			try {
				response.getWriter().write("<script>alert('"+e.getMessage()+"');history.back();</script>");
				return null;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		//게시글 조회 페이지 board_view.jsp 게시글 번호
		return new ModelAndView("board_view.do?bno="+bno, false);
	}

}
