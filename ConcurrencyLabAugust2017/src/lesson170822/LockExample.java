package lesson170822;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
	
	static class Counter {
		int count;
		Lock lock = new ReentrantLock();
		
		public void inc() {
			lock.lock();
			try {
				count++;
			} finally {
				lock.unlock();
			}
		}
		
		public int get() {
			lock.lock();
			try {
				return count;
			} finally {
				lock.unlock();
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		
		
	}

}
