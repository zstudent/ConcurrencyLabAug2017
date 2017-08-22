package lesson170821;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

	public static void main(String[] args) {
		System.out.println("start"
				+ "");

//		ExecutorService service = Executors.newSingleThreadExecutor();  serial
		ExecutorService service = Executors.newFixedThreadPool(2);

		service.execute(new Task());
		service.execute(new Task());
		service.execute(new Task());
		service.execute(new Task());
		
//		service.shutdown();
		
		Utils.pause(1000);
		
		List<Runnable> tasksLeft = service.shutdownNow();
		
		System.out.println(tasksLeft);

		System.out.println("finish");

	}

}

class Task implements Runnable {

	private long millis;
	
	public Task() {
		this(1000);
	}

	public Task(long millis) {
		this.millis = millis;
	}
	
	@Override
	public void run() {
		Utils.pause(millis);
		System.out.println("hello");
	}

}
