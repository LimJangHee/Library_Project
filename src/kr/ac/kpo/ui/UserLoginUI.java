package kr.ac.kpo.ui;

import kr.ac.kpo.service.LibService;

public class UserLoginUI extends LibUI{
	
	private LibService libService;
	
	
	public UserLoginUI() {
		libService = new LibService();
		
	}
	
	@Override
	public void execute() throws Exception {
		
		while(true) {
			System.out.println("----------------------------------------------");
			String id = scanStr("ID를 입력해주세요 : ");
			System.out.println("----------------------------------------------");
			String password = scanStr("비밀번호를 입력해주세요 :");
			int no = libService.login(id, password);
			
			
			if( no == 0 ) {
				System.out.println("----------------------------------------------");
				System.out.println("잘못입력하셨습니다 다시입력해주세요");
			} else {
				System.out.println("----------------------------------------------");
				System.out.println("\t*** 로그인 되었습니다 ***");
				System.out.println("----------------------------------------------");
				LibUI.isLogin = true;
				LibUI.userID = id;

				break;
			}
		}
		
		super.execute();
		
		
		
	}

}