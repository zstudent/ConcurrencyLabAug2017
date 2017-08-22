package lesson170821;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
	
	public static void main(String[] args) {
		
		Callable<String> c = () -> {
			Utils.pause(4000);
			int x = 10/0;
			return "hello";
		};
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Future<String> future = service.submit(c);
		Future<String> future2 = service.submit(c);
		System.out.println("task sent");
		
//		service.shutdown();
		
//		service.execute(() -> {System.out.println( "one more");});  RUN-TIME ERROR!
		
		// do something else
		
		future2.cancel(false);
		
		try {
			String result = future.get();
			System.out.println(result);
			String result2 = future2.get();
			System.out.println(result2);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}

}
