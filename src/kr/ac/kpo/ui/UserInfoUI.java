package kr.ac.kpo.ui;

import java.util.List;

import kr.ac.kpo.service.LibService;
import kr.ac.kpo.vo.MemberVO;

public class UserInfoUI extends LibUI {
	
	private LibService libService;

	public UserInfoUI() {
		libService = new LibService();

	}
	
	@Override
	public void execute() throws Exception {
		
		List<MemberVO> memberList = libService.userInfo(LibUI.userID);
				
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.printf("|\t%-8s%-8s%-9s%-16s%-24s%-9s\t|\n", "ID", "PW", "이름", "생일", "email", "phone");  
		System.out.println("-----------------------------------------------------------------------------------------");
		
		if(memberList == null || memberList.size() == 0) {
			System.out.println("\t회원이 존재하지 않습니다.");
		} else {
			for(MemberVO member : memberList) {
				System.out.println("|\t"
						+ member.getId() + "\t"  
						+ member.getPassword() + "\t" 
						+ member.getName() +"\t" 
						+ member.getBirth()	+"\t"+ "\t"
						+ member.getEmail() +"\t"+ "\t"
						+ member.getPhone() +"\t|" 
						);
			}
		}
		System.out.println("-----------------------------------------------------------------------------------------");	}
	
}

