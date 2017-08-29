package lesson170829;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import lesson170821.Utils;

public class ChatSession {
	
	static AtomicInteger counter = new AtomicInteger();

	private Socket socket;
	private PrintWriter pw;
	private long delayMilis = 0;
	
	{
		int count = counter.incrementAndGet();
		
		if (count == 1) {
			delayMilis = 5000;
		}
	}

	public ChatSession(Socket socket) {
		this.socket = socket;
	}

	public void process(Consumer<String> broadcaster)  {
		try {
			InputStream inputStream = socket.getInputStream();
			Scanner scanner = new Scanner(inputStream);
			
			OutputStream outputStream = socket.getOutputStream();
			
			pw = new PrintWriter(outputStream);
			
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println(line);
				broadcaster.accept(line);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void sendMessage(String message) {
		Utils.pause(delayMilis);
		pw.println(">> "+ message);
		pw.flush();
	}

}
