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
			String id = scanStr("ID를 입력하세요 : ");
			String password = scanStr("비밀번호를 입력하세요 :");
			int no = libService.login(id, password);
			
			
			if( no == 0 ) { 
				System.out.println("잘못입력하셨습니다 다시입력하세요");
			} else {
				
				System.out.println("로그인 되었습니다");
				LibUI.isLogin = true;
				LibUI.userID = id;

				break;
			}
		}
		
		super.execute();
		
		
		
	}

}