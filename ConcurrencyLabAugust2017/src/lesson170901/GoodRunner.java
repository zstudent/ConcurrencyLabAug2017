package lesson170901;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JTextArea;

import lesson170821.Utils;

public class GoodRunner implements Runnable {

	private static final int MAX = 1000000;
	Random r = new Random();
	private JTextArea text;

	public GoodRunner(JTextArea text) {
		this.text = text;
	}

	@Override
	public void run() {
		while (true) {
			Utils.pause(1000);
			int nextInt = r.nextInt(MAX);
			boolean colorChoose = r.nextBoolean();
			EventQueue.invokeLater(() -> {
				text.setBackground(colorChoose ? Color.BLUE : Color.RED);
				text.append(Integer.toString(nextInt) + '\n');
			});
		}

	}

}
