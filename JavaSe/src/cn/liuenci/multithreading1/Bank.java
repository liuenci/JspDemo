package cn.liuenci.multithreading1;

public class Bank {
	private final double[] accounts;

	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++) {
			//给每个账户一个初始余额
			accounts[i] = initialBalance;
		}
	}
	/**
	 * 从一个账户转账到另外一个账号上
	 * @param from
	 * @param to
	 * @param amount 转账的金额
	 */
	public void transfer(int from, int to, double amount) {
		if (accounts[from] < amount) {
			return;
		}
		System.out.println(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d", amount, from, to);
		accounts[to] += amount;
		//这里为什么不是输出accounts[to],因为账户之间的转账不会导致银行的总存款减少或增多,但是这段代码实际上会出现这种情况,所以容易辨识
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
