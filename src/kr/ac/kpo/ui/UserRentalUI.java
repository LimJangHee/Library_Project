package kr.ac.kpo.ui;

import java.util.List;

import kr.ac.kpo.service.LibService;
import kr.ac.kpo.vo.BookVO;

public class UserRentalUI extends LibUI {

	private LibService libService;

	public UserRentalUI() {
		libService = new LibService();

	}

	@Override
	public void execute() throws Exception {
		
		List<BookVO> bookList = libService.userRental();

	}

}