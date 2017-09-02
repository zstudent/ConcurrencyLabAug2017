package lesson170901;

import java.awt.Color;
import java.util.Random;

import javax.swing.JTextArea;

import lesson170821.Utils;

public class BadRunner implements Runnable {

	private static final int MAX = 1000000;
	Random r = new Random();
	private JTextArea text;

	public BadRunner(JTextArea text) {
		this.text = text;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		while (true) {
			int nextInt = r.nextInt(MAX);
			text.setBackground(r.nextBoolean()? Color.BLUE: Color.RED);
//			text.append(Integer.toString(nextInt) + '\n');
			Utils.pause(1000);
		}
	}

}
