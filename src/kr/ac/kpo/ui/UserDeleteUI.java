package kr.ac.kpo.ui;

import java.util.Scanner;

import kr.ac.kpo.service.LibService;

public class UserDeleteUI extends LibUI {
	
private LibService libService;
	
	public UserDeleteUI() {
		libService = new LibService();

	}

	@Override
	public void execute() throws Exception {

		while (true) {
			System.out.println("----------------------------------------------");
			String id = scanStr("ID를 입력하세요 : ");
			System.out.println("----------------------------------------------");
			String password = scanStr("비밀번호를 입력하세요 :");
			int no = libService.login(id, password);

			if (no == 0) {
				System.out.println("----------------------------------------------");
				System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
			} else {
				System.out.println("----------------------------------------------");
				System.out.println("회원탈퇴하시겠습니까? ");
				System.out.println("1. 예 ");
				System.out.println("2. 아니요 ");
				Scanner sc = new Scanner(System.in);
				int type = sc.nextInt();
				if (type == 1) {
					libService.deleteUser(id);
					System.out.println("----------------------------------------------");
					System.out.println("\t *** 회원탈퇴가 완료되었습니다. ***");
					System.out.println("----------------------------------------------");
					LoginUI.isLogin = false;
					super.execute();
					break;
				} else {
					MyPageUI mp = new MyPageUI();
					mp.execute();
					break;
				}

			}
		}

	}

}