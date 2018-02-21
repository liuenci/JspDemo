package cn.test;

import java.util.Scanner;

public class ListNum {
	int[] list = null;
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		System.out.println("请输入数组大小：");
		int num = input.nextInt();
		int[] list = new int[num];
		for (int i = 0; i < list.length; i++) {
			System.out.println("请输入第"+(i+1)+"个数:");
			list[i] = input.nextInt();
		}
		ListNum.sortMethod(list);
		input.close();
	}
	public static void sortMethod(int[] list) {
		for(int i=0;i<list.length-1;i++) {
			for(int j=0;j<list.length-i-1;j++) {
				if(list[j]>list[j+1]) {
					int temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i]+"\t");
		}
	}

}
