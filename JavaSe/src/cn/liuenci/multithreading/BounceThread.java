package cn.liuenci.multithreading;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BounceThread {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new Bounce().new BounceFrame();
				frame.setTitle("BounceThread");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

	class BallRunnable implements Runnable {
		private Ball ball;
		private Component component;
		public static final int STEPS = 1000;
		public static final int DELAY = 5;

		public BallRunnable(Ball aBall, Component aComponent) {
			ball = aBall;
			component = aComponent;
		}

		@Override
		public void run() {
			try {
				for (int i = 1; i <= STEPS; i++) {
					ball.move(component.getBounds());
					component.repaint();
					Thread.sleep(DELAY);
				}
			} catch (InterruptedException e) {

			}

		}

	}

	@SuppressWarnings("serial")
	class BounceFrame extends JFrame {
		private BallComponent comp;

		public BounceFrame() {
			comp = new BallComponent();
			add(comp, BorderLayout.CENTER);
			JPanel buttonPanel = new JPanel();
			addButton(buttonPanel, "Start", new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					addBall();
				}
			});
			addButton(buttonPanel, "Close", new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					System.exit(0);
				}
			});
			add(buttonPanel, BorderLayout.SOUTH);
			pack();
		}

		public void addButton(Container c, String title, ActionListener listener) {
			JButton button = new JButton(title);
			c.add(button);
			button.addActionListener(listener);
		}

		public void addBall() {
			Ball ball = new Ball();
			comp.add(ball);
			Runnable r = new BallRunnable(ball, comp);
			Thread t = new Thread(r);
			t.start();
		}
	}
}
