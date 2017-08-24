package lesson170823;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreAsResourceUsageRegulator {
	
	static final Random r = new Random();
	private static final int MAX = 1000000;
	
	static double[] generate() {
		double[] data = new double[MAX];
		for (int i = 0; i < data.length; i++) {
			data[i] = r.nextDouble();
		}
		return data;
	}
	
	public static void main(String[] args) {
		
//		ExecutorService service = Executors.newCachedThreadPool();
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		Semaphore sem = new Semaphore(4);
		
		while (true) {
			double[] data = generate();
			sem.acquireUninterruptibly();
			service.submit(() -> {
				double sum = 0;
				for (int i = 0; i < data.length; i++) {
					sum += data[i];
					try {
						Thread.sleep(0,1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				sem.release();
			});
		}
		
		
	}

}
