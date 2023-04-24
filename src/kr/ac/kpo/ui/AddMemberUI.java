package kr.ac.kpo.ui;

import java.util.Scanner;

public class AddMemberUI extends LibUI {
	
	private int menu() {
		System.out.println("-----------------------------------------------");
		System.out.println("\t 해당되는 항목을 선택하세요.");
		System.out.println("-----------------------------------------------");
		System.out.println("1. 회원가입");
		System.out.println("0. 이전화면으로");
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
				ui = new UserAddMemberUI();
				break;
			case 0:
				super.execute();
				break;

			}
			if (ui != null) {
				ui.execute();
			} else {
				System.out.println("잘못입력하셨습니다");

			}
		}
	}
}
