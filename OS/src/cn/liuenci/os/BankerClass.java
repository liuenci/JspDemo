package cn.liuenci.os;

import java.util.Scanner;

public class BankerClass {
	int[] Available = { 1, 5, 2, 0 }; // 现有资源
	int[][] Max = new int[5][4]; // 资源最大申请量
	int[][] Alloction = new int[5][4]; // 资源分配
	int[][] Need = new int[5][4]; // 还需要的资源
	int[][] Request = new int[5][4]; // 资源请求
	int[] Work = new int[5];

	int num = 0;// 进程编号
	Scanner in = new Scanner(System.in);

	public BankerClass() {
		// Max={{6,3,2},{5,6,1},{2,3,2}};

	}

	public void setSystemVariable() {// 设置各初始系统变量，并判断是否处于安全状态。
		setMax();
		setAlloction();
		printSystemVariable();
		SecurityAlgorithm();
	}

	public void setMax() {// 设置Max矩阵
		System.out.println("----------各进程的最大需求矩阵Max----------");
		for (int i = 0; i < Max.length; i++) {
			System.out.println("请输入进程P" + (i + 1) + "的最大资源需求量:");
			for (int j = 0; j < Max[i].length; j++) {
				Max[i][j] = in.nextInt();
			}
		}
	}

	public void setAlloction() {// 设置已分配矩阵Alloction
		System.out.println("----------各进程分配矩阵Alloction----------");
		for (int i = 0; i < Max.length; i++) {
			System.out.println("请输入进程P" + (i + 1) + "的分配资源量:");
			for (int j = 0; j < Max[i].length; j++) {
				Alloction[i][j] = in.nextInt();
			}
		}
		System.out.println("Available = Available-Alloction");
		System.out.println("Need = Max - Alloction");
		for (int i = 0; i < Max.length; i++) {// 设置Alloction矩阵
			for (int j = 0; j < Max[i].length; j++) {
				Available[j] = Available[j] - Alloction[i][j];
			}
		}
		for (int i = 0; i < 5; i++) {// 设置Need矩阵
			for (int j = 0; j < 4; j++) {
				Need[i][j] = Max[i][j] - Alloction[i][j];
			}
		}
	}

	public void printSystemVariable() {
		System.out.println("此时资源分配量如下:");
		System.out.println("进程  " + "   Max   " + "   Alloction " + "    Need  " + "     Available ");
		for (int i = 0; i < Max.length; i++) {
			System.out.print("P" + (i + 1) + "|  ");
			for (int j = 0; j < Max[i].length; j++) {
				System.out.print(Max[i][j] + "  ");
			}
			System.out.print("|  ");
			for (int j = 0; j < Max[i].length; j++) {
				System.out.print(Alloction[i][j] + "  ");
			}
			System.out.print("|  ");
			for (int j = 0; j < Max[i].length; j++) {
				System.out.print(Need[i][j] + "  ");
			}
			System.out.print("|  ");
			if (i == 0) {
				for (int j = 0; j < Max[i].length; j++) {
					System.out.print(Available[j] + "  ");
				}
			}
			System.out.println();
		}
	}

	public void setRequest() {// 设置请求资源量Request

		System.out.println("请输入请求资源的进程编号:");
		num = in.nextInt();// 设置全局变量进程编号num
		System.out.println("请输入请求各资源的数量:");
		for (int j = 0; j < 4; j++) {
			Request[num][j] = in.nextInt();
		}
		System.out.println("即进程P" + (num + 1) + "对各资源请求Request:(" + Request[num][0] + "," + Request[num][1] + ","
				+ Request[num][2] + Request[num][3] + "," + ").");

		BankerAlgorithm();
	}

	public void BankerAlgorithm() {// 银行家算法
		boolean T = true;

		if (Request[num][0] <= Need[num][0] && Request[num][1] <= Need[num][1] && Request[num][2] <= Need[num][2]
				&& Request[num][3] <= Need[num][3]) {// 判断Request是否小于Need
			if (Request[num][0] <= Available[0] && Request[num][1] <= Available[1] && Request[num][2] <= Available[2]
					&& Request[num][3] <= Available[3]) {// 判断Request是否小于Alloction
				for (int i = 0; i < 5; i++) {
					Available[i] -= Request[num][i];
					Alloction[num][i] += Request[num][i];
					Need[num][i] -= Request[num][i];
				}

			} else {
				System.out.println("当前没有足够的资源可分配，进程P" + num + "需等待。");
				T = false;
			}
		} else {
			System.out.println("进程P" + num + "请求已经超出最大需求量Need.");
			T = false;
		}

		if (T == true) {
			printSystemVariable();
			System.out.println("现在进入安全算法:");
			SecurityAlgorithm();
		}
	}

	public void SecurityAlgorithm() {// 安全算法
		boolean[] Finish = { false, false, false, false, false };// 初始化Finish
		int count = 0;// 完成进程数
		int circle = 0;// 循环圈数
		int[] S = new int[5];// 安全序列
		for (int i = 0; i < 4; i++) {// 设置工作向量
			Work[i] = Available[i];
		}
		boolean flag = true;
		while (count < 5) {
			if (flag) {
				System.out.println("进程  " + "   Work  " + "   Alloction " + "    Need  " + "     Work+Alloction ");
				flag = false;
			}
			for (int i = 0; i < 5; i++) {

				if (Finish[i] == false && Need[i][0] <= Work[0] && Need[i][1] <= Work[1] && Need[i][2] <= Work[2]
						&& Need[i][3] <= Work[3]) {// 判断条件
					System.out.print("P" + (i + 1) + "  ");
					for (int k = 0; k < 4; k++) {
						System.out.print(Work[k] + "  ");
					}
					System.out.print("|  ");
					for (int j = 0; j < 4; j++) {
						Work[j] += Alloction[i][j];
					}
					Finish[i] = true;// 当当前进程能满足时
					S[count] = i;// 设置当前序列排号

					count++;// 满足进程数加1
					for (int j = 0; j < 4; j++) {
						System.out.print(Alloction[i][j] + "  ");
					}
					System.out.print("|  ");
					for (int j = 0; j < 4; j++) {
						System.out.print(Need[i][j] + "  ");
					}
					System.out.print("|  ");
					for (int j = 0; j < 4; j++) {
						System.out.print(Work[j] + "  ");
					}
					System.out.println();
				}

			}
			circle++;// 循环圈数加1

			if (count == 5) {// 判断是否满足所有进程需要
				System.out.print("此时存在一个安全序列:");
				for (int i = 0; i < 5; i++) {// 输出安全序列
					System.out.print("P" + S[i] + " ");
				}
				System.out.println("故当前可分配！");
				break;// 跳出循环
			}
			if (count < circle) {// 判断完成进程数是否小于循环圈数
				count = 5;
				System.out.println("当前系统处于不安全状态，故不存在安全序列。");
				break;// 跳出循环
			}
		}
	}

}