package lesson170821;

public class DaemonExample {

	public static void main(String[] args) {
		System.out.println("start");

		Thread daemon = new Thread(() -> {
			while (true) {
				System.out.println("hi");
				Utils.pause(1000);
			}
		});
		
		daemon.setDaemon(true);
		
		daemon.start();
		
		new Thread(() -> {
			Utils.pause(10000);
		}).start();
		
		
		System.out.println("finish");

	}

}
