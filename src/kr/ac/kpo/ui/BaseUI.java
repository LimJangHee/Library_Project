package kr.ac.kpo.ui;

import java.util.Scanner;

public abstract class BaseUI implements ILibUI {

	private Scanner sc;
	
	public BaseUI() {
		sc = new Scanner(System.in);
	}
	
	public int scanInt(String msg) {
		System.out.print(msg);
		int num = Integer.parseInt(sc.nextLine());
		return num;
	}
	
	public String scanStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
}
