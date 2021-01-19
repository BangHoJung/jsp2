package file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.jni.Directory;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/upload.do")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String encoding = "utf-8";
		String path="C:\\fileupload";
		File userPath = new File(path);
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(userPath); // 업로드될 폴더
		factory.setSizeThreshold(1024 * 1024); // 1MB
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> list = upload.parseRequest(request); 
			ArrayList<FileDTO> req_list = new  ArrayList<FileDTO>();
			String user="default";
			for(int i=0;i<list.size();i++) { 
				FileItem item = list.get(i);
				if(item.isFormField()) {
					//받은 내용중 파일이 아닌경우
					if(item.getFieldName().equals("user")) {
						user = item.getString(encoding);
					}
					System.out.println(item.getFieldName() + " : " + item.getString(encoding));
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
						File uploadFile = new File(userPath.getAbsolutePath() +"\\"+user+"\\"+fileName);
						if(!uploadFile.getParentFile().exists()) {
							uploadFile.getParentFile().mkdirs();
						}
						System.out.println("셋팅된 전체 경로 : "+uploadFile);
						item.write(uploadFile);
						
						req_list.add(new FileDTO(uploadFile));
						
						/*
						 * request.setAttribute("file"+i, request.getContextPath() + "/upload/" +
						 * fileName); request.setAttribute("fileName"+i, fileName);
						 * request.setAttribute("item"+i, item); request.setAttribute("dto"+i, dto);
						 */
					}
				}
			}
			request.setAttribute("user", user);
			request.setAttribute("list", req_list);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("file_result.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
