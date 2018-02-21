package cn.liuenci.multithreading1;

public class Bank {
	private final double[] accounts;

	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++) {
			//��ÿ���˻�һ����ʼ���
			accounts[i] = initialBalance;
		}
	}
	/**
	 * ��һ���˻�ת�˵�����һ���˺���
	 * @param from
	 * @param to
	 * @param amount ת�˵Ľ��
	 */
	public void transfer(int from, int to, double amount) {
		if (accounts[from] < amount) {
			return;
		}
		System.out.println(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d", amount, from, to);
		accounts[to] += amount;
		//����Ϊʲô�������accounts[to],��Ϊ�˻�֮���ת�˲��ᵼ�����е��ܴ����ٻ�����,������δ���ʵ���ϻ�����������,�������ױ�ʶ
		System.out.printf(" total balance:%10.2f%n", getTotalBalance());
	}

	public double getTotalBalance() {
		double sum = 0;
		for (double a : accounts) {
			sum += a;
		}
		return sum;
	}
	public int size() {
		return accounts.length;
	}
}
