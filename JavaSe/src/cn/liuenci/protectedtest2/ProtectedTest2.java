package cn.liuenci.protectedtest2;

import cn.liuenci.protectedtest1.ProtectedTest1;

public class ProtectedTest2 extends ProtectedTest1{
	ProtectedTest1 p;
	public ProtectedTest2() {
		p = new ProtectedTest1();
		System.out.println(super.a);
		System.out.println(p.b);
	}
	public static void main(String[] args) {
		new ProtectedTest2();
	}
}
