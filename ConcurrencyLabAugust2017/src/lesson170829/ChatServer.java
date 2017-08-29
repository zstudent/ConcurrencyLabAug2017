package lesson170829;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

	private static final int DEFAULT_PORT = 10000;

	private final static List<ChatSession> sessions = new CopyOnWriteArrayList<>();

	private static ExecutorService service;

	private static ExecutorService broadcastService;

	public static void main(String[] args) {

		System.out.println("start");

		service = Executors.newCachedThreadPool();

		int threads = Math.max(2,
				Runtime.getRuntime().availableProcessors() / 2);
		broadcastService = Executors.newFixedThreadPool(threads);

		try {

			ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);

			while (true) {
				Socket socket = serverSocket.accept();

				System.out.println(socket);

				ChatSession chatSession = new ChatSession(socket);

				sessions.add(chatSession);

				service.execute(() -> {
					chatSession.process(ChatServer::broadcast);
				});
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void broadcast(String message) {
		service.execute(() -> {
			for (ChatSession chatSession : sessions) {
				broadcastService.execute(() -> {
					chatSession.sendMessage(message);
				});
			}
		});
	}

}
