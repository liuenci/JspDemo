package cn.liuenci.protectedtest1;

public class ProtectedTest1 {
	protected int a;
	public int b;
	int c;
	private int d;
	public ProtectedTest1() {
		a = 1;
		b = 2;
		c = 3;
		d = 4;
		new ProtectedTest4();
	}
	class ProtectedTest4{
		private int d;
		public ProtectedTest4() {
			d = 6;
			System.out.println("内部类中的:"+a);
			System.out.println("内部类中的:"+b);
			System.out.println("内部类中的:"+c);
			System.out.println("内部类中的:"+d);
			//new ProtectedTest5();
		}
	}
	class ProtectedTest5 extends ProtectedTest4{
		public ProtectedTest5() {
			System.out.println(super.d);
		}
	}
	public static void main(String[] args) {
		new ProtectedTest1().new ProtectedTest5();
	}
}
