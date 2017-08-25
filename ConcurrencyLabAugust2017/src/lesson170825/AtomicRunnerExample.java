package lesson170825;

import java.util.concurrent.atomic.AtomicLong;

import lesson170821.Utils;

public class AtomicRunnerExample {
	
	public static void main(String[] args) {
		System.out.println("start");
		
		AtomicRunner r = new AtomicRunner();
		
		new Thread(r).start();
		new Thread(r).start();
		
		Utils.pause(5000);

		r.stop();
	}
	

}


class AtomicRunner implements Runnable {
	
	volatile 
	boolean stop = false;

	AtomicLong count = new AtomicLong(0);

	@Override
	public void run() {
		while (!getStop()) {
			count.incrementAndGet();
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
