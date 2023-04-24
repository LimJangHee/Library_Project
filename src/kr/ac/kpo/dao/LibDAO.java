package kr.ac.kpo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kpo.ui.AdminLoginUI;
import kr.ac.kpo.ui.LibUI;
import kr.ac.kpo.util.ConnectionFactory;
import kr.ac.kpo.vo.BookVO;
import kr.ac.kpo.vo.MemberVO;
import kr.ac.kpo.vo.RentalBookVO;

public class LibDAO {

	public LibDAO() {

	}

	public void insertLibMember(MemberVO member) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_member(id, password, name, birth, email, phone) ");
		sql.append(" values(?, ?, ?, ?, ?, ? ) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhone());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean equalsID(String id) {

		StringBuilder sql = new StringBuilder();
		String id1 = null;
		sql.append("select id from t_member ");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				id1 = rs.getString("id");
				if (id1.equals(id)) {
					return true;

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean equalsEmail(String email) {

		StringBuilder sql = new StringBuilder();
		String email1 = null;
		sql.append("select email from t_member ");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				email1 = rs.getString("email");
				if (email1.equals(email)) {
					return true;

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean equalsPhone(String phone) {

		StringBuilder sql = new StringBuilder();
		String phone1 = null;
		sql.append("select phone from t_member ");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				phone1 = rs.getString("phone");
				if (phone1.equals(phone)) {
					return true;

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int login(String id, String password) {

		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) as cnt from t_member where id = ? and password = ?");

		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int cnt = rs.getInt("cnt");
				if(cnt > 0 ) {
					return 1;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public void updatePassword(String id, String password2) {

		StringBuilder sql = new StringBuilder();
		sql.append("update t_member set password = ? where id = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, password2);
			pstmt.setString(2, id);

			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String id) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_member where id = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, id);

			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void insertLibBook(BookVO book) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_book(name, writer, publisher ) ");
		sql.append(" values(?, ?, ? ) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getWriter());
			pstmt.setString(3, book.getPublisher());
			
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public List<BookVO> searchBook(String search, String detail) {

		List<BookVO> bookList = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		
		if (search.equals("all")) {
			sql.append("select * from t_book ");
		} else {
		
				sql.append(
						"select * from t_book where instr(");
				sql.append(search);
				sql.append(", ?) != 0 ");
		}

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
				
				ResultSet rs = null;
				if(search.equals("all")) {
					rs = pstmt.executeQuery();
				} else {
					pstmt.setString(1, detail);
					rs = pstmt.executeQuery();
				}
				
			while (rs.next()) {
				
				String name = rs.getString("name");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				

				BookVO book = new BookVO(name, writer, publisher);


				bookList.add(book);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}
	
	public LocalDate rentalBook(String name, LocalDate date) throws Exception {
		
		
		
		StringBuilder sql = new StringBuilder();
	    sql.append("insert into t_rental_list(rental_no, user_id, book_name, rental_date, return_date) ");
	    sql.append("values(seq_t_rental_list.nextval, '");
	    sql.append(LibUI.userID);
	    sql.append("', '");
	    sql.append(name);
	    sql.append("', '");
	    sql.append(date);
	    sql.append("', '");
	    sql.append(date.plusWeeks(2));
	    sql.append("')");

	    try (Connection conn = new ConnectionFactory().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
	        pstmt.executeUpdate();
	    } catch (Exception e) {
	    	
	    	
	    	System.out.println("----------------------------------------------");
	    	System.out.println("\t   이미 대여중이거나 존재하지 않는 책입니다.");
	    	System.out.println("----------------------------------------------");
	    	LibUI libui = new LibUI();
	        libui.execute();
	    }

	    return date.plusWeeks(2);
	}
	
	public void returnBook(String name) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_rental_list where user_id = ? and book_name = ?");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())
				){
			pstmt.setString(1, LibUI.userID);
			pstmt.setString(2, name);
			
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				System.out.println("----------------------------------------------");
				System.out.println("\t*** 도서 반납이 완료되었습니다. ***");
				System.out.println("----------------------------------------------");
				
			} else {
				
				System.out.println("----------------------------------------------");
				System.out.println("\t 대여하지 않은 책입니다.");
				System.out.println("----------------------------------------------");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public List<RentalBookVO> userRental(String id) {

		List<RentalBookVO> bookList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		
		if(id.equals("manager")) {
			sql.append("select * from t_rental_list");
		} else {
			sql.append("select * from t_rental_list where user_id = ?");
		}

		
		
		

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
				
				ResultSet rs = null;
				
				if(id.equals("manager")) {
					rs = pstmt.executeQuery();					
				} else {
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
				}
			
								
			while (rs.next()) {
				
				 int rental_no = rs.getInt("rental_no");
				 String user_id = rs.getString("user_id");
				 String book_name = rs.getString("book_name");
				 java.sql.Date localrental_date = rs.getDate("rental_date");
				 LocalDate rental_date = localrental_date.toLocalDate();
				 java.sql.Date localreturn_date = rs.getDate("return_date");
				 LocalDate return_date = localreturn_date.toLocalDate();
				

				RentalBookVO book = new RentalBookVO(rental_no, user_id, book_name, rental_date, return_date);


				bookList.add(book);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}
	
	public List<MemberVO> userInfo(String id) {

		List<MemberVO> memberList = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		
		if(id.equals("manager")) {
			sql.append("select * from t_member");
		} else {
		sql.append("select * from t_member where ID = ?");
		}

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
				
				ResultSet rs = null;
			
				if(id.equals("manager")) {
					rs = pstmt.executeQuery();					
				} else {
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
				}
				
				
			while (rs.next()) {
				
				 String ID = rs.getString("ID");
				 String password = rs.getString("password");
				 String name = rs.getString("name");
				 String birth = rs.getString("birth");
				 String email = rs.getString("email");
				 String phone = rs.getString("phone");
					 

				MemberVO member = new MemberVO(ID, password, name, birth, email, phone);


				memberList.add(member);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return memberList;
	}
	
	public void deleteBook(String name) {

		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_book where name = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, name);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public boolean deleteEqualsID(String id) {

		StringBuilder sql = new StringBuilder();
		String id1 = null;
		sql.append("select user_id from t_rental_list where user_id = ? ");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				id1 = rs.getString("user_id");
				if (id1.equals(id)) {
					return true;

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}	