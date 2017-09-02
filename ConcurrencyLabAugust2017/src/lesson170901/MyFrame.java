package lesson170901;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyFrame extends JFrame {

	public MyFrame() {
		super("Example");
		
		JPanel panel = new JPanel();
		
		JTextArea text = new JTextArea(20, 30);
		
		JButton good = new JButton("good");
		
		good.addActionListener(e -> {
			System.out.println("I am good");
			new Thread(new GoodRunner(text)).start();
		});
		
		JButton bad  = new JButton("bad");
		
		bad.addActionListener(e -> {
			System.out.println("I am bad");
			new Thread(new BadRunner(text)).start();
		});
		
		panel.add(good);
		panel.add(bad);
		panel.add(text);
		
		add(panel);
		
		pack();
		
	}
	
}
