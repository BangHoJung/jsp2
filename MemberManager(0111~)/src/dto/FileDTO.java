package dto;

public class FileDTO {
	private int bno;
	private String writer;
	private String path;
	
	public FileDTO(int bno, String writer, String path) {
		super();
		this.bno = bno;
		this.writer = writer;
		this.path = path;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
