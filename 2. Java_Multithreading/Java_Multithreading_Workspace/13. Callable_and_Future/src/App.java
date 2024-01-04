import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
	public static void main(String[] args) {
		/*
		 * Callable and Future are two classes that enable you to get return results
		 * from your threads and they also allow your thread code to throw exceptions
		 */
		ExecutorService executorService = Executors.newCachedThreadPool();

//		executorService.submit(new Runnable() {
//			@Override
//			public void run() {
//
//				Random random = new Random();
//				int duration = random.nextInt(4000);
//
//				System.out.println("Starting ...");
//
//				try {
//					Thread.sleep(duration);
//				} catch (InterruptedException exception) {
//					exception.printStackTrace();
//				}
//				System.out.println("Finished.");
//			}
//		});

		// Callable is a parameterized class, and the parameter that it takes here is
		// the type that you want to return from your running thread code
		// Future is also a parameterized class

		Future<Integer> future = executorService.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// The type of the value that call returns is whatever you specify in <>
				Random random = new Random();
				int duration = random.nextInt(4000);

				// Throwing an exception from call
				// NOTE: If you throw an exception from call(), that exception will get thrown
				// from get(), but get() won't throw the specified exception that you threw, it
				// will throw an ExecutionException, and the cause of the ExecutionException
				// will be the exception that you have thrown in call()
				if (duration > 2000) {
					throw new IOException("Sleeping for too long.");
				}

				System.out.println("Starting ...");

				try {
					Thread.sleep(duration);
				} catch (InterruptedException exception) {
					exception.printStackTrace();
				}
				System.out.println("Finished.");

				return duration;
			}

		});

		

		// other methods for Future besides get()
		// If you don't want to return a result from call, but still would like to use a
		// Future object to access the other methods associated with the Future class,
		// use a Wild card (?) as a parameter for the Future object and use Void as a
		// return type for call()
		Future<?> futureVoid = executorService.submit(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				// The type of the value that call returns is whatever you specify in <>
				Random random = new Random();
				int duration = random.nextInt(4000);

				// Throwing an exception from call
				// NOTE: If you throw an exception from call(), that exception will get thrown
				// from get(), but get() won't throw the specified exception that you threw, it
				// will throw an ExecutionException, and the cause of the ExecutionException
				// will be the exception that you have thrown in call()
				if (duration > 2000) {
					throw new IOException("Sleeping for too long.");
				}

				System.out.println("Starting ...");

				try {
					Thread.sleep(duration);
				} catch (InterruptedException exception) {
					exception.printStackTrace();
				}
				System.out.println("Finished.");

				return null;
			}
		});
		
		executorService.shutdown();

		// To access the result returned by the call method
		try {
			System.out.println("Result is : " + future.get()); // if you don't wait for your threads to finish and you
																// directly call get, get() will block until the threads
																// associated with the future object have been
																// terminated. If you have multiple threads that run the
																// call method, you could store the result in an
																// ArrayList and call
																// executorService.awaitTermination(timeout, unit) to
																// wait for the threads to finish before calling get()
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		} catch (ExecutionException exception) {
//			System.out.println(exception); // Output : java.util.concurrent.ExecutionException: java.io.IOException: Sleeping for too long.
//			System.out.println(exception.getMessage()); // Output : java.io.IOException: Sleeping for too long.

			// To retrieve the original exception
			IOException cause = (IOException) exception.getCause();

			System.out.println(cause.getMessage()); // Output: Sleeping for too long.
		}
	}
}
