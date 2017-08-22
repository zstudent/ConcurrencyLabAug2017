package lesson170821;

public class ThreadExample {
	
	public static void main(String[] args) {
		
		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println("hello, world!");
			}
		};
		
		t.start();
		
		Runnable task = () -> {
			System.out.println("hello there!");
		};
		
		t = new Thread(task);
		
		t.start();
		
		
	}

}
