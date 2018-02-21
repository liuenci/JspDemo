package cn.liuenci.multithreading1;

public class UnsynchBankTest {
	public static final int NACCOUNTS = 10;//�����˻�
	public static final double INITIAL_BALANCE = 1000;//�˻���ʼ���
	
	public static void main(String[] args) {
		Bank b = new Bank(NACCOUNTS,INITIAL_BALANCE);
		for(int i=0;i<NACCOUNTS;i++) {
			TransferRunnable r = new TransferRunnable(b,i,INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}
}
