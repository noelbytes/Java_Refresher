import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* All classes in the concurrent package are thread safe, so you can 
 * access the classes from multiple threads, and you don't have to worry 
 * about thread synchronization
*/

public class App {

	// FIFO
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					producer();
				} catch (InterruptedException exception) {
					exception.printStackTrace();
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					consumer();
				} catch (InterruptedException exception) {
					exception.printStackTrace();
				}
			}
		});
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
	}

	private static void producer() throws InterruptedException {
		Random random = new Random();

		while (true) {
			// put will patiently wait until items are removed from the queue (if the queue is full), and there's space in the queue (i.e. size < 10)
			queue.put(random.nextInt(100)); // random integers from the range 0 - 99
		}
	}
	
	private static void consumer() throws InterruptedException {
		Random random = new Random();
		
		while (true) {
			Thread.sleep(100);
			
			// this will evaluate to true one in every ten times
			if (random.nextInt(10) == 0) {
				Integer value = queue.take(); // if there is nothing in the queue, take will patiently wait until there is something in the queue
				// and then it will take it and return it, which saves you a lot of effort. It doesn't consumer any resources while it's waiting 
				// or anything like that
				
				System.out.println("Taken value : " + value + " Queue size is : " + queue.size());
			}
		}
	}
}
