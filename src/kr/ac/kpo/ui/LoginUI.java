package kr.ac.kpo.ui;

import java.util.Scanner;

public class LoginUI extends LibUI{
	
	
	private int menu() {
		System.out.println("------------------------------------------");
		System.out.println("\t 해당되는 항목을 선택하세요");
		System.out.println("------------------------------------------");
		System.out.println("1. 일반회원 로그인");
		System.out.println("2. 관리자 로그인");
		System.out.println("0. 이전화면으로");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();
		
		return type;
	}

	@Override
	public void execute() throws Exception {
		
		while(true) {
			int type = menu();
			ILibUI ui = null;
			switch (type) {
			
			case 1:
				ui = new UserLoginUI();
				break;
			case 2:
//				ui = new AdminLoginUI();
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