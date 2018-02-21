package cn.liuenci.os;

import java.util.Scanner;

public class BankerClass {
	int[] Available = { 1, 5, 2, 0 }; // ������Դ
	int[][] Max = new int[5][4]; // ��Դ���������
	int[][] Alloction = new int[5][4]; // ��Դ����
	int[][] Need = new int[5][4]; // ����Ҫ����Դ
	int[][] Request = new int[5][4]; // ��Դ����
	int[] Work = new int[5];

	int num = 0;// ���̱��
	Scanner in = new Scanner(System.in);

	public BankerClass() {
		// Max={{6,3,2},{5,6,1},{2,3,2}};

	}

	public void setSystemVariable() {// ���ø���ʼϵͳ���������ж��Ƿ��ڰ�ȫ״̬��
		setMax();
		setAlloction();
		printSystemVariable();
		SecurityAlgorithm();
	}

	public void setMax() {// ����Max����
		System.out.println("----------�����̵�����������Max----------");
		for (int i = 0; i < Max.length; i++) {
			System.out.println("���������P" + (i + 1) + "�������Դ������:");
			for (int j = 0; j < Max[i].length; j++) {
				Max[i][j] = in.nextInt();
			}
		}
	}

	public void setAlloction() {// �����ѷ������Alloction
		System.out.println("----------�����̷������Alloction----------");
		for (int i = 0; i < Max.length; i++) {
			System.out.println("���������P" + (i + 1) + "�ķ�����Դ��:");
			for (int j = 0; j < Max[i].length; j++) {
				Alloction[i][j] = in.nextInt();
			}
		}
		System.out.println("Available = Available-Alloction");
		System.out.println("Need = Max - Alloction");
		for (int i = 0; i < Max.length; i++) {// ����Alloction����
			for (int j = 0; j < Max[i].length; j++) {
				Available[j] = Available[j] - Alloction[i][j];
			}
		}
		for (int i = 0; i < 5; i++) {// ����Need����
			for (int j = 0; j < 4; j++) {
				Need[i][j] = Max[i][j] - Alloction[i][j];
			}
		}
	}

	public void printSystemVariable() {
		System.out.println("��ʱ��Դ����������:");
		System.out.println("����  " + "   Max   " + "   Alloction " + "    Need  " + "     Available ");
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

	public void setRequest() {// ����������Դ��Request

		System.out.println("������������Դ�Ľ��̱��:");
		num = in.nextInt();// ����ȫ�ֱ������̱��num
		System.out.println("�������������Դ������:");
		for (int j = 0; j < 4; j++) {
			Request[num][j] = in.nextInt();
		}
		System.out.println("������P" + (num + 1) + "�Ը���Դ����Request:(" + Request[num][0] + "," + Request[num][1] + ","
				+ Request[num][2] + Request[num][3] + "," + ").");

		BankerAlgorithm();
	}

	public void BankerAlgorithm() {// ���м��㷨
		boolean T = true;

		if (Request[num][0] <= Need[num][0] && Request[num][1] <= Need[num][1] && Request[num][2] <= Need[num][2]
				&& Request[num][3] <= Need[num][3]) {// �ж�Request�Ƿ�С��Need
			if (Request[num][0] <= Available[0] && Request[num][1] <= Available[1] && Request[num][2] <= Available[2]
					&& Request[num][3] <= Available[3]) {// �ж�Request�Ƿ�С��Alloction
				for (int i = 0; i < 5; i++) {
					Available[i] -= Request[num][i];
					Alloction[num][i] += Request[num][i];
					Need[num][i] -= Request[num][i];
				}

			} else {
				System.out.println("��ǰû���㹻����Դ�ɷ��䣬����P" + num + "��ȴ���");
				T = false;
			}
		} else {
			System.out.println("����P" + num + "�����Ѿ��������������Need.");
			T = false;
		}

		if (T == true) {
			printSystemVariable();
			System.out.println("���ڽ��밲ȫ�㷨:");
			SecurityAlgorithm();
		}
	}

	public void SecurityAlgorithm() {// ��ȫ�㷨
		boolean[] Finish = { false, false, false, false, false };// ��ʼ��Finish
		int count = 0;// ��ɽ�����
		int circle = 0;// ѭ��Ȧ��
		int[] S = new int[5];// ��ȫ����
		for (int i = 0; i < 4; i++) {// ���ù�������
			Work[i] = Available[i];
		}
		boolean flag = true;
		while (count < 5) {
			if (flag) {
				System.out.println("����  " + "   Work  " + "   Alloction " + "    Need  " + "     Work+Alloction ");
				flag = false;
			}
			for (int i = 0; i < 5; i++) {

				if (Finish[i] == false && Need[i][0] <= Work[0] && Need[i][1] <= Work[1] && Need[i][2] <= Work[2]
						&& Need[i][3] <= Work[3]) {// �ж�����
					System.out.print("P" + (i + 1) + "  ");
					for (int k = 0; k < 4; k++) {
						System.out.print(Work[k] + "  ");
					}
					System.out.print("|  ");
					for (int j = 0; j < 4; j++) {
						Work[j] += Alloction[i][j];
					}
					Finish[i] = true;// ����ǰ����������ʱ
					S[count] = i;// ���õ�ǰ�����ź�

					count++;// �����������1
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
			circle++;// ѭ��Ȧ����1

			if (count == 5) {// �ж��Ƿ��������н�����Ҫ
				System.out.print("��ʱ����һ����ȫ����:");
				for (int i = 0; i < 5; i++) {// �����ȫ����
					System.out.print("P" + S[i] + " ");
				}
				System.out.println("�ʵ�ǰ�ɷ��䣡");
				break;// ����ѭ��
			}
			if (count < circle) {// �ж���ɽ������Ƿ�С��ѭ��Ȧ��
				count = 5;
				System.out.println("��ǰϵͳ���ڲ���ȫ״̬���ʲ����ڰ�ȫ���С�");
				break;// ����ѭ��
			}
		}
	}

}