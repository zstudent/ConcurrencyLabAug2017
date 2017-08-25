package lesson170825;

import lesson170821.Utils;

public class RunnerExample {
	
	public static void main(String[] args) {
		System.out.println("start");
		
		Runner r = new Runner();
		
		new Thread(r).start();
		
		Utils.pause(5000);

		r.stop();
	}
	

}


class Runner implements Runnable {
	
	volatile 
	boolean stop = false;

	@Override
	public void run() {
		long count = 0;
		while (!getStop()) {
			count++;
		}
		System.out.println("stopped at " + count);
	}


//	synchronized 
	public boolean getStop() {
		return stop;
	}
	
	
//	synchronized 
	public void stop() {
		stop = true;
	}
	
	
}
