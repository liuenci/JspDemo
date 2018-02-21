package cn.liuenci.multithreading1;

public class TransferRunnable implements Runnable {
	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 10;

	public TransferRunnable(Bank b, int from, double max) {
		bank = b;
		fromAccount = from;
		maxAmount = max;
	}

	@Override
	public void run() {
		try {
			while (true) {
				//��������յ�ת�˵��˻�
				int toAccount = (int) (bank.size() * Math.random());
				//�������ת�˽��
				double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
