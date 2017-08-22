package lesson170821;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {

	public static void main(String[] args) {

		ExecutorService service = Executors.newCachedThreadPool();

		while (true) {
			Utils.pause(200);
			service.execute(new Task(1000));
		}

	}

}
