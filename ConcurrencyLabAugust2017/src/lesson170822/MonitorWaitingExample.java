package lesson170822;

import lesson170821.Utils;

public class MonitorWaitingExample {
	
	public static void main(String[] args) {
		
		Object mutex = new Object();
		
		new Thread(() -> {
			synchronized (mutex) {
				System.out.println("got it");
				while(true) {}
			}
		}).start();
		
		Utils.pause(1000);
		
		System.out.println("try to get it");
		
		Thread thread = new Thread(() -> {
			synchronized (mutex) {
				System.out.println("I did it!");
			}
		});
		
		thread.start();
		
		Utils.pause(1000);
		
		thread.stop();
		
		Utils.pause(1000);
		
		
		
	}

}
