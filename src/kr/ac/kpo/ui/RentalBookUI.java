package kr.ac.kpo.ui;

import java.time.LocalDate;

import kr.ac.kpo.service.LibService;

public class RentalBookUI extends LibUI {
	
	private LibService libService;
	
	
	public RentalBookUI() {
		libService = new LibService();
		
	}
	
	@Override
	public void execute() throws Exception {
		
		if(LibUI.isLogin == false) {
			System.out.println("로그인이 되어있지 않아 로그인 페이지로 이동합니다.");
			ILibUI ui = new LoginUI();
			ui.execute();
			}
		
		LocalDate date = LocalDate.now();
		int no = scanInt("대여할 책 번호를 입력하세요 : ");
		
		LocalDate returndate = libService.rentalBook(no,date);
		System.out.println("대여 완료" + returndate +"까지 반납해주세요");
		
		
		
	}
}