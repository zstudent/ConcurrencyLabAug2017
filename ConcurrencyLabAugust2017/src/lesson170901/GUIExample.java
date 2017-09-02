package lesson170901;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GUIExample {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			JFrame frame = new MyFrame();
			
			frame.setSize(400, 400);
			
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			frame.setVisible(true);
		});
		
		
	}

}
