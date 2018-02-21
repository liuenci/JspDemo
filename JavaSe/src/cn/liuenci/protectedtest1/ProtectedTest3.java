package cn.liuenci.protectedtest1;

public class ProtectedTest3 {
	ProtectedTest1 p;

	public ProtectedTest3() {
		p = new ProtectedTest1();
		System.out.println(p.a);
		System.out.println(p.b);
		System.out.println(p.c);
	}

	public static void main(String[] args) {
		new ProtectedTest3();
	}
}
