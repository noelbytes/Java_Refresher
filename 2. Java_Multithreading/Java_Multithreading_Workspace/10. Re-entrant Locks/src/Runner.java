import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	// NOTE: A Re-entrant lock is kind of an alternative to using the synchronized
	// keyword
	// Alternative to wait() and notify() for reentrant locks - await() and signal()
	// notifyAll() - signalAll()
	// These methods, i.e. await(), signal() and signalAll() are methods of a class
	// named Condition

	private int count = 0;
	private Lock lock = new ReentrantLock(); // this means that once the lock is acquired by a thread / once the thread
												// has locked the lock, it can lock it again if it wants to, and the
												// lock just keeps count of how many times it's been locked, and you'll
												// have to unlock it by the same number of times
	private Condition condition = lock.newCondition(); // here, you're getting a condition object from the lock that you
														// are locking on

	private void increment() {
		for (int index = 0; index < 1e4; index++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {

		lock.lock(); // only one thread can lock the thread at a given time. It will work just like
						// synchronized. So if another thread tries to lock this while this has already
						// got a lock, the other thread will have to quietly wait.

		// NOTE: signal() and await() can only be called after you've got a lock

		System.out.println("Waiting ....");
		condition.await(); // same as wait() within a synchronized block. The lock is handed over (i.e.
							// unlocked) so that another thread can get in there and lock it

		System.out.println("Woken up!");
		try {
			increment(); // if this throws an exception, the unlock statement will never be called, so it
							// is a good idea to handle the exception within a try-catch block
		} finally {
			lock.unlock();
		}
	}

	public void secondThread() throws InterruptedException {
		
		Thread.sleep(1000);
		
		lock.lock();
		
		System.out.println("Press the return key!");
		new Scanner(System.in).nextLine();
		System.out.println("Got return key!");
		
		condition.signal(); // signal() wakes up one waiting thread. signalAll() will notify all the waiting threads
		// NOTE: Always remember to unlock after you call condition.signal()
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void finished() {
		// This method is run after the two threads, i.e. firstThread and secondThread
		// finish
		System.out.println("Count is : " + count);
	}
}

/*
 * Advantages of using re-entrant locks instead of synchronized:
 * 1. Fine-grained control: Re-entrant locks provide more flexibility and control over locking compared to synchronized.
 * 2. Condition support: Re-entrant locks allow threads to wait for specific conditions, offering more advanced synchronization capabilities.
 * 3. Interruptible locking: Re-entrant locks can be interrupted, providing better handling of thread interruptions.
 * 4. Lock timeouts: Re-entrant locks allow specifying a maximum wait time for acquiring a lock, which helps prevent potential deadlocks.
 * 5. Fairness: Re-entrant locks can be configured for fair locking, ensuring that threads are granted access in the order they requested it.
 * 6. Multiple condition variables: Re-entrant locks support multiple condition variables, useful for handling different waiting conditions within the same critical section.
 */
