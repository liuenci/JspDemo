package cn.liuenci.os;

import java.util.Scanner;

public class TestBankerClass {

	public static void main(String[] args) {
		boolean Choose = true;
		String C;
		Scanner in = new Scanner(System.in);
		BankerClass T = new BankerClass();
		System.out.println("����һ��5������,��ʼϵͳ����������ԴΪ{1,5,2,0}�����м��㷨:");

		T.setSystemVariable();
		while (Choose == true) {
			T.setRequest();
			System.out.println("���Ƿ�Ҫ��������:y/n?");
			C = in.nextLine();
			if (C.endsWith("n")) {
				Choose = false;
			}
		}
	}
}