
public class App {

	private int count = 0;

	// synchronized ensures that only one method can access the method / variable at
	// a time
	// in other words, no other threads will be able to call this method when it's
	// being used by one thread
	
	/* How does this work behind the scenes? 
	 * Every object in java has what we call an intrinsic lock or a monitor lock.
	 * You could also call it a mutex
	 * and if you call a synchronized method of an object, in this case, we're calling the synchronized 
	 * method of the app object, you have to acquire the intrinsic lock before you can call it, and the thing is, 
	 * only one thread can acquire this intrinsic lock at a time, and if one thread acquires the intrinsic lock and 
	 * runs the increment() method, and if another thread at the same time tries to call this method, then the second 
	 * thread will just have to wait. It will just quietly wait until the first thread releases the intrinsic lock by the 
	 * method finishing executing. 
	*/
	
	/* NOTE: You don't have to declare count as volatile here, because if your running something in 
	 * a synchronized block, then it's guaranteed that the current state of the variables will be 
	 * visible to all thread or threads, which is what volatile does. It just guarantees that all threads 
	 * can see the current state of a variable and synchronized handles that itself
	*/
	public synchronized void increment() {
		count++; // count = count + 1;
	}

	public static void main(String[] args) {

		App app = new App();
		app.doWork();
	}

	public void doWork() {
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int index = 0; index < 10000; index++) {
					increment();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int index = 0; index < 10000; index++) {
					increment();
				}
			}
		});

		thread1.start();
		thread2.start();

		try {
			// To wait for the threads to finish before displaying the value of count in the
			// main method, use the join() method
			thread1.join(); // join won't return until thread1 is finished
			thread2.join(); // the same thing applies to thread2
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}

		System.out.println("Count is : " + count); // count will possess a different value every time it is run, since
													// it is being accessed by both thread1 and thread2 and the main
													// thread, and all of them are executed in parallel
	}
}
