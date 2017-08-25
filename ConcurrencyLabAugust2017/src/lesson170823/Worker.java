package lesson170823;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

import lesson170821.Utils;

public class Worker implements Executor {
	
	private Queue<Runnable> tasks = new LinkedList<>();
	
	public Worker() {
		new Thread(this::process).start();
	}
	
	@Override
	public void execute(Runnable task) {
		synchronized (tasks) {
			tasks.offer(task);
			tasks.notify();
			System.out.println("notified");
			Utils.pause(3000);
		}
	}
	
	private void process() {
		while (true) {
			Runnable task = null;
			synchronized (tasks) {
				while (tasks.isEmpty()) { // to deal with spurious wakeup
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
