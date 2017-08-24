package lesson170823;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

public class Worker implements Executor {
	
	private Queue<Runnable> tasks = new LinkedList<>();
	
	public Worker() {
		new Thread(this::process).start();
	}
	
	@Override
	public void execute(Runnable task) {
		tasks.offer(task);
	}
	
	private void process() {
		while (true) {
			Runnable task = null;
			synchronized (tasks) {
				while (tasks.isEmpty()) { // to deal with spruious wakeup
					try {
						tasks.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				task = tasks.poll();
			}
			if (task != null) {
				task.run();
			}
		}
	}

}
