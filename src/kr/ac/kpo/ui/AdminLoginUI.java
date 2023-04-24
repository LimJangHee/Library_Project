package kr.ac.kpo.ui;

public class AdminLoginUI extends LibUI{
	
	public static String adminID = "manager";
	public static String adminPW = "manager";
	
	@Override
	public void execute() throws Exception {
		
		while(true) {
			System.out.println("-----------------------------------------------");
			String id = scanStr("관리자 ID를 입력해주세요 : ");
			System.out.println("-----------------------------------------------");
			String password = scanStr("관리자 비밀번호를 입력해주세요 :");
			
			if(!id.equals(adminID) || !password.equals(adminPW)) {
				System.out.println("-----------------------------------------------");
				System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
			} else {
				System.out.println("-----------------------------------------------");
				System.out.println("\t*** 관리자 권한으로 로그인 되었습니다 ***");
				System.out.println("-----------------------------------------------");
			}
			
			LibUI.userID = "manager";
				break;
			}
			new ManagerUI().execute();
		}
		
		
}
