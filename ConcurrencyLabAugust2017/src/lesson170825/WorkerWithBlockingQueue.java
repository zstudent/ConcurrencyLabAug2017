package lesson170825;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class WorkerWithBlockingQueue implements Executor {
	
	private BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>() ;
	
	public WorkerWithBlockingQueue() {
		new Thread(this::process).start();
	}
	
	@Override
	public void execute(Runnable task) {
		try {
			tasks.put(task);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void process() {
		while (true) {
			Runnable task = null;
			try {
				task = tasks.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (task != null) {
				task.run();
			}
		}
	}

}
