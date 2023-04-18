package kr.ac.kpo.ui;

import kr.ac.kpo.service.LibService;
import kr.ac.kpo.dao.LibDAO;
import kr.ac.kpo.vo.MemberVO;

public class UserAddMemberUI extends LibUI{

	private LibService libService;
	
	public UserAddMemberUI() {
		libService = new LibService();
	}

	@Override
	public void execute() throws Exception {
		
		LibDAO libdao = new LibDAO();
		String id = scanStr("사용할 ID를 입력하세요 : ");
		while(libdao.equalsID(id)) { 
			System.out.println("입력하신 ID가 중복입니다 다른 ID를 입력해주세요");
			id = scanStr("사용할 ID를 입력하세요 : ");
		}
		String password = scanStr("사용할 비밀번호를 입력하세요 : ");
		String password2 = scanStr("입력한 비밀번호를 다시 입력하세요 : ");
		while(!password.equals(password2)) {
			System.out.println("입력하신 비밀번호가 틀렸습니다. 다시입력해주세요 ");
			password = scanStr("사용할 비밀번호를 입력하세요 : ");
			password2 = scanStr("입력한 비밀번호를 다시 입력하세요 : ");
		}
		
		String name = scanStr("이름을 입력하세요 : ");
		String birth = scanStr("생년월일 6자리를 -빼고 입력해주세요 : ");
		String email = scanStr("Email을 입력해주세요 : ");
		String phone = scanStr("전화번호를 -빼고 입력해주세요 : ");
		
		MemberVO member = new MemberVO();
		
		member.setId(id);
		member.setPassword(password2);
		member.setName(name);
		member.setBirth(birth);
		member.setEmail(email);
		member.setPhone(phone);
		
		libService.insertLibMember(member);
		
		System.out.println("회원가입을 완료했습니다.");
		
		super.execute();
		
		
		
		
	}
	
	


	
}