package kr.ac.kpo.ui;

import kr.ac.kpo.service.LibService;

public class UserUpdateUI extends LibUI {
	
	private LibService libService;
	
	public UserUpdateUI() {
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
				System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
			} else {
				System.out.println("----------------------------------------------");
				String password2 = scanStr("변경하실 비밀번호를 입력해주세요 : ");
				// 여기서 개인정보 어떤걸 수정할지 클래스 만들고 타고들어가서 항목별로 클래스 만들면 다른정보도 수정가능
				libService.updatePassword(id, password2);
				System.out.println("----------------------------------------------");
				System.out.println("*** 비밀번호 수정이 완료되었습니다. 마이페이지로 이동합니다. ***");
				System.out.println("----------------------------------------------");
				
				break;
			}
		}
		
		MyPageUI mp = new MyPageUI();
		mp.execute();
		
		
		
		
	}

}
