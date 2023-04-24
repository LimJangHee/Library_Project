package kr.ac.kpo.ui;

import java.util.Scanner;

public class MyPageUI extends LibUI{
	
	private int menu() {
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("\t 해당되는 항목을 선택하세요");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("1. 계정 정보");
		System.out.println("2. 비밀번호수정");
		System.out.println("3. 계정탈퇴");
		System.out.println("4. 대여중인 도서목록");
		System.out.println("0. 이전화면으로");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();
		
		return type;
	}
	
	@Override
	public void execute() throws Exception {
		
		if(LibUI.isLogin == false) {
			System.out.println("-----------------------------------------------");
			System.out.println("로그인이 되어있지 않아 로그인 페이지로 이동합니다.");
			ILibUI ui = new LoginUI();
			ui.execute();
			}
		
		while(true) {
			int type = menu();
			ILibUI ui = null;
			switch (type) {
			
			case 1:
				ui = new UserInfoUI();
				break;
			case 2:
				ui = new UserUpdateUI();
				break;
			case 3:
				ui = new UserDeleteUI();
				break;
			case 4:
				ui = new UserRentalUI();
				break;
			case 0:
				super.execute();
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