import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	public static void main(String[] args) throws InterruptedException {

		// Connection.getInstance().connect();

		// Semaphore is a object that maintains a count, and we refer to
		// the count as the number of available permits of the semaphore
		// Semaphore semaphore = new Semaphore(1);

		// semaphore.acquire(); // decrement the number of available permits. acquire()
		// will wait if there are
		// no permits available
		// semaphore.release(); // increment the number of available permits
		/*
		 * You can think of acquire and release more like lock() and unlock(). A
		 * semaphore with one permit is basically a lock. The only difference between
		 * locks and semaphores is that in semaphores, you can happily release from
		 * different threads to where you did the acquire. Whereas in a lock, you will
		 * have to unlock from the same thread that you locked from, but there's no such
		 * requirement with a semaphore.
		 */

		// Use-cases of Semaphores
		/*
		 * Semaphores are usually used to control access to some resource
		 */

		// System.out.println("Available permits : " + semaphore.availablePermits()); //
		// Print the number of available permits associated with a semaphore

		ExecutorService executor = Executors.newCachedThreadPool();
		/*
		 * A cachedThreadPool creates a new thread when you call the executor.submit
		 * method, and it will also try to reuse threads that had become idle.
		 */

		for (int loopNumber = 0; loopNumber < 200; loopNumber++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}

		executor.shutdown(); // shuts down the managerial thread after all the threads have finished running
		
		// wait till the threads finish
		executor.awaitTermination(1, TimeUnit.DAYS); // wait for a day
	}
}
