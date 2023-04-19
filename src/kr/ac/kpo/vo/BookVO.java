package kr.ac.kpo.vo;

public class BookVO {
	
	private String name;
	private String writer;
	private String publisher;
	
	
	public BookVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BookVO(String name, String writer, String publisher) {
		super();
		this.name = name;
		this.writer = writer;
		this.publisher = publisher;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	@Override
	public String toString() {
		return "BookVO [name=" + name + ", writer=" + writer + ", publisher=" + publisher + "]";
	}
	
	

}