package kr.ac.kpo.ui;

import kr.ac.kpo.service.LibService;
import kr.ac.kpo.vo.BookVO;

public class AddNewBookUI extends LibUI{
	
private LibService libService;
	
	
	public AddNewBookUI() {
		libService = new LibService();
		
	}
	
	@Override
	public void execute() throws Exception {
		
		String name = scanStr("등록할 책 제목을 입력하세요 : ");
		String writer = scanStr("글쓴이를 입력하세요 : ");
		String publisher = scanStr("출판사를 입력하세요 : ");

		BookVO book = new BookVO();
		book.setName(name);
		book.setWriter(writer);
		book.setPublisher(publisher);
		
		
		libService.insertLibBook(book);
		
		System.out.println("새 책을 등록을 완료했습니다");
		
		
	}

}