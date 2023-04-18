package kr.ac.kpo.vo;

public class BookVO {
	
	private int no;
	private String name;
	private String writer;
	private String publisher;
	
	
	
	
	
	public BookVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public BookVO(int no, String name, String writer, String publisher) {
		super();
		this.no = no;
		this.name = name;
		this.writer = writer;
		this.publisher = publisher;
		
	}



	/**
	 * @return the writer
	 */
	public String getWriter() {
		return writer;
	}



	/**
	 * @param writer the writer to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}



	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}



	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}



	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	
	
	

}