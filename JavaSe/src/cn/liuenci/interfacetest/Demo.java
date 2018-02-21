package cn.liuenci.interfacetest;

public class Demo implements Test {
	public int a = 2;
	public static void main(String[] args) {
		System.out.println(new Demo().a);
	}
	@Override
	public void print3() {
		// TODO Auto-generated method stub
		
	}
}
