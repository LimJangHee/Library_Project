package kr.ac.kpo.vo;

import java.time.LocalDate;

public class RentalBookVO {
	
	private int rental_no;
	private String user_id;
	private String book_name;
	private LocalDate rental_date;
	private LocalDate return_date;
	
	
	public RentalBookVO() {
		super();
	}


	public RentalBookVO(int rental_no, String user_id, String book_name, LocalDate rental_date, LocalDate return_date) {
		super();
		this.rental_no = rental_no;
		this.user_id = user_id;
		this.book_name = book_name;
		this.rental_date = rental_date;
		this.return_date = return_date;
	}


	public int getRental_no() {
		return rental_no;
	}


	public void setRental_no(int rental_no) {
		this.rental_no = rental_no;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getBook_name() {
		return book_name;
	}


	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}


	public LocalDate getRental_date() {
		return rental_date;
	}


	public void setRental_date(LocalDate rental_date) {
		this.rental_date = rental_date;
	}


	public LocalDate getReturn_date() {
		return return_date;
	}


	public void setReturn_date(LocalDate return_date) {
		this.return_date = return_date;
	}
	
	
	
	
	
	

}
