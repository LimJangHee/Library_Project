package kr.ac.kpo.ui;

import java.util.List;
import java.util.Scanner;

import kr.ac.kpo.service.LibService;
import kr.ac.kpo.vo.BookVO;

public class SearchBookUI extends LibUI{
	
private LibService libService;
private String search;
private String detail;
	
	public SearchBookUI() {
		libService = new LibService();
	}
	
	private int menu() {
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("\t< 도서검색 프로그램을 실행합니다 >");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("1.제목으로 검색");
		System.out.println("2.저자로 검색");
		System.out.println("3.출판사로 검색");
		System.out.println("4.전체 도서 검색");
		System.out.println("0.이전화면으로");
		System.out.print("원하는 항목을 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();

		return type;

	}
	
	@Override
	public void execute() throws Exception {
		
		while(true) {
			int type = menu();
			switch(type) {
			
			case 1:
				search = "name";
				System.out.println("-----------------------------------------------");
				detail = scanStr("검색할 제목을 입력하세요 : ");
				break;
			case 2:
				search = "writer";
				System.out.println("-----------------------------------------------");
				detail = scanStr("검색할 저자를 입력하세요 : ");
				break;
			case 3:
				search = "publisher";
				System.out.println("-----------------------------------------------");
				detail = scanStr("검색할 출판사를 입력하세요 : ");
				break;
			case 4:
				search = "all";
				detail = "1";
				break;
			case 0:
				if(LibUI.userID == "manager") {
					new ManagerUI().execute();
				} else {
					super.execute();
				}
				
				break;
				
			}
			List<BookVO> bookList = libService.searchBook(search, detail);
			
			System.out.println("---------------------------------------------------------");
			System.out.printf("|\t%-16s%-14s%-10s\t|\n", "제목", "저자", "출판사"); 
			System.out.println("---------------------------------------------------------");
			
			if(bookList == null || bookList.size() == 0) {
				System.out.println("\t검색하신 책이 존재하지 않습니다");
			} else {
				for(BookVO book : bookList) {
					System.out.println("|\t"
							+ book.getName() + "\t" + "\t" 
							+ book.getWriter() + "\t" + "\t"
							+ book.getPublisher() +"\t" +"\t|"
							);
				}
			}
			System.out.println("---------------------------------------------------------");		}
		
	
	}

}