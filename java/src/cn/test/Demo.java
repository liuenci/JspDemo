package cn.test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {

	public int getNum(int num) {
		if(num>=90&&num<100) {
			return 5;
		}else if(num>=80&&num<=89) {
			return 4;
		}else if(num>70&&num<=79) {
			return 3;
		}else if(num>60&&num<=69) {
			return 2;
		}else{
			return 1;
		}
		
	}
	public static void main(String[] args) {
		Scanner input =null;
		try {
			input = new Scanner(System.in);
			System.out.print("������һ��0��100������:");
			System.out.println("���ĵȼ�Ϊ:"+new Demo().getNum(input.nextInt()));
		}catch(InputMismatchException e) {
			System.out.println("��������ȷ������");
			System.out.print("������һ��0��100������:");
			input = new Scanner(System.in);
			System.out.println("���ĵȼ�Ϊ:"+new Demo().getNum(input.nextInt()));
		}
		
	}

}
