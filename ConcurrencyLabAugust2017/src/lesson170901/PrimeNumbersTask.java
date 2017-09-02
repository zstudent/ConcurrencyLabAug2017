package lesson170901;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import lesson170821.Utils;

public class PrimeNumbersTask extends SwingWorker<List<Integer>, Integer> {
	private int numbersToFind;
	private JTextArea textArea;
	private int count;

	PrimeNumbersTask(JTextArea textArea, int numbersToFind) {
		this.textArea = textArea;
		this.numbersToFind = numbersToFind;
	}

	@Override
	public List<Integer> doInBackground() {
		count = 0;
		List<Integer> numbers = new ArrayList<>();
		while (count < numbersToFind && !isCancelled()) {
			int number = nextPrimeNumber();
			numbers.add(number);
			count++;
			publish(number);
			setProgress(100 * numbers.size() / numbersToFind);
		}
		return numbers;
	}

	private int nextPrimeNumber() {
		Utils.pause(3000);
		return count;
	}

	@Override
	protected void process(List<Integer> chunks) {
		if (chunks == null) {
			System.out.println(chunks);
			return;
		}
		for (int number : chunks) {
			textArea.append(number + "\n");
		}
	}
}