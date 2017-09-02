package lesson170901;

import java.awt.EventQueue;
import java.util.concurrent.ExecutionException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class UsePrime {

	private static JProgressBar progressBar;
	private static JTextArea textArea;
	private static PrimeNumbersTask task;

	public static void main(String[] args)
			throws InterruptedException, ExecutionException {

		EventQueue.invokeLater(() -> {

			JFrame frame = new JFrame("Example");

			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

			JPanel panel = new JPanel();

			textArea = new JTextArea(20,30);
			progressBar = new JProgressBar(0, 100);

			panel.add(textArea);
			panel.add(progressBar);
			
			frame.add(panel);
			
			frame.pack();
			
			frame.setSize(600, 600);
			frame.setVisible(true);

			task = new PrimeNumbersTask(textArea, 100);
			
			task.addPropertyChangeListener(evt -> {
				if ("progress".equals(evt.getPropertyName())) {
					progressBar.setValue((Integer) evt.getNewValue());
				}
			});
			
			new Thread(() -> {
				task.execute();
			}).start();
		});

//		System.out.println(task.get()); // prints all prime numbers we have got

	}
}
