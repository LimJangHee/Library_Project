package kr.ac.kpo.ui;

import java.util.List;

import kr.ac.kpo.service.LibService;
import kr.ac.kpo.vo.BookVO;
import kr.ac.kpo.vo.RentalBookVO;

public class UserRentalUI extends LibUI {

	private LibService libService;

	public UserRentalUI() {
		libService = new LibService();

	}

	@Override
	public void execute() throws Exception {
		
		List<RentalBookVO> bookList = libService.userRental(LibUI.userID);
		
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.printf("|\t%-11s%-15s%-16s%-14s%-6s\t|\n", "대출번호", "사용자 아이디", "책명", "대여 날짜", "반납 날짜"); 
		System.out.println("-----------------------------------------------------------------------------------------");
		
		if(bookList == null || bookList.size() == 0) {
			System.out.println("\t대여한 책이 없습니다.");
		} else {
			for(RentalBookVO book : bookList) {
				System.out.println("|\t"
						+ book.getRental_no() + "\t" + "\t" 
						+ book.getUser_id()   + "\t" + "\t"
						+ book.getBook_name() +"\t" + "\t"
						+ book.getRental_date() + "\t"						
						+ book.getReturn_date() +"\t|"
						);
			}
		}

		System.out.println("-----------------------------------------------------------------------------------------");	
		}

}