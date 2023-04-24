package kr.ac.kpo.ui;

import java.util.Scanner;

public class ManagerUI extends LibUI{
	
	private int menu() {
		System.out.println("-----------------------------------------------");
		System.out.println("\t< 관리자 프로그램 메뉴를 실행합니다 >");
		System.out.println("-----------------------------------------------");
		System.out.println("1.회원 정보 확인");
		System.out.println("2.도서 검색");
		System.out.println("3.대여중인 도서 목록");
		System.out.println("4.도서등록");
		System.out.println("5.도서삭제");
		System.out.println("0.프로그램종료 및 로그아웃");
		System.out.println("-----------------------------------------------");
		System.out.print("원하는 항목을 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();

		return type;

	}
	
	@Override
	public void execute() throws Exception {

		while (true) {
			int type = menu();
			ILibUI ui = null;
			switch (type) {
			case 1:
				ui = new UserInfoUI();
				break;
			case 2:
				ui = new SearchBookUI();
				break;
			case 3:
				ui = new UserRentalUI();
				break;
			case 4:
				ui = new AddNewBookUI();
				break;
			case 5:
				ui = new DeleteBookUI();
				break;
			case 0:
				ui = new ExitUI();
				break;

			}
			if(ui != null) {
				ui.execute();
			}else {
				System.out.println("잘못입력하셨습니다");
			}

		}

	}


}
