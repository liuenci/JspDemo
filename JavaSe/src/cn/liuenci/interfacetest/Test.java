package cn.liuenci.interfacetest;

public interface Test {
	public int a = 1;
	public static void print1() {
		System.out.println("a");
	}
	public default void print2() {
		System.out.println("b");
	}
	void print3();
}
