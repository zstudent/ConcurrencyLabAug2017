package lesson170823;

public class UseWorker {
	
	public static void main(String[] args) {
		
		Worker worker = new Worker();
		
		worker.execute(() -> {
			System.out.println("Hello, world!");
		});
		
	}

}
