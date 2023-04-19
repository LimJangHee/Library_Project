package kr.ac.kpo.ui;

import kr.ac.kpo.service.LibService;

public class ReturnBookUI extends LibUI {

	private LibService libService;

	public ReturnBookUI() {
		libService = new LibService();
	}

	@Override
	public void execute() throws Exception {
		
		if(LibUI.isLogin == false) {
			System.out.println("로그인이 되어있지 않아 로그인 페이지로 이동합니다.");
			ILibUI ui = new LoginUI();
			ui.execute();
			}
		
		System.out.println("----------------------------------------------");
		String name = scanStr("반납할 책명을 입력해주세요 : ");
		libService.returnBook(name);
		
	}

}
