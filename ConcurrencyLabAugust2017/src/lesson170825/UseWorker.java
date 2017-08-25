package lesson170825;

import lesson170821.Utils;

public class UseWorker {
	
	public static void main(String[] args) {
		
		WorkerWithBlockingQueue worker = new WorkerWithBlockingQueue();
		
		worker.execute(() -> {
			Utils.pause(1000);
			System.out.println("Hello, world!");
		});
		
		worker.execute(() -> {
			Utils.pause(1000);
			System.out.println("Hello, world!");
		});
		
		worker.execute(() -> {
			Utils.pause(1000);
			System.out.println("Hello, world!");
		});
		
		System.out.println("finish");
		
	}

}
