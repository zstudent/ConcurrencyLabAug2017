package lesson170828;

import java.util.concurrent.CountDownLatch;

public class Driver { // ...
	private static final int N = 2;

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(N);

		for (int i = 0; i < N; ++i) {
			new Thread(new Worker(startSignal, doneSignal)).start();
		}

		startSignal.countDown(); // let all threads proceed
		doneSignal.await(); // wait for all to finish
		System.out.println("all done");
	}
}

class Worker implements Runnable {
	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;

	Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
	}

	@Override
	public void run() {
		try {
			System.out.println("ready...");
			startSignal.await();
			System.out.println("working...");
			doWork();
			System.out.println("done " + this);
			doneSignal.countDown();
		} catch (InterruptedException ex) {
		} // return;
	}

	void doWork() { //
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}