package lesson170830;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class UseSerialExecutor {

	private static final int MAX = 1000;

	public static void main(String[] args) {

		ExecutorService processor = Executors
				.newCachedThreadPool();
		
		SerialExecutor[] models = new SerialExecutor[MAX];
		for (int i = 0; i < MAX; i++) {
			models[i] = new SerialExecutor(processor);
		}
		
		Random r = new Random();
		
		AtomicLong count = new AtomicLong();
		
		while (true) {
			models[r.nextInt(MAX)].execute(() -> {
				long incrementAndGet = count.incrementAndGet();
				if (incrementAndGet % 10000 == 0) {
					System.out.println(incrementAndGet);
				}
				try {
					Thread.sleep(0, 100_000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			try {
				Thread.sleep(0, 1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
