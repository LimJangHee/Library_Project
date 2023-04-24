package kr.ac.kpo.ui;

import kr.ac.kpo.service.LibService;

public class DeleteBookUI extends LibUI {

	private LibService libService;

	public DeleteBookUI() {
		libService = new LibService();
		
	}

	@Override
	public void execute() throws Exception {

		System.out.println("-----------------------------------------------");
		String name = scanStr("삭제할 책명을 입력하세요 : ");
		
		libService.deleteBook(name);

		System.out.println("*** [" + name + "] 책 삭제를 완료했습니다. ***");

	}
}