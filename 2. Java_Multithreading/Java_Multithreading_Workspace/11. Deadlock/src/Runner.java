import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	private Account account1 = new Account();
	private Account account2 = new Account();

	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	private void acquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException {
		/*
		 * The job of acquireLocks is to acquire the first and the second locks in such
		 * a way that a deadlock can't be caused. The way to do this is to use
		 * "tryLock", which is a method of ReentrantLock and it returns true if it's got
		 * the lock, and false if it hasn't.
		 */
		while (true) {
			/*
			 * Here, we are using a loop to make sure that the acquireLocks method does
			 * acquire the locks, and we don't want it to return, in this case, unless it
			 * does acquire them.
			 */

			// Acquire the locks
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;

			try {
				// tryLock() will return immediately and it will only return true if it's got
				// the lock
				gotFirstLock = firstLock.tryLock();
				gotSecondLock = secondLock.tryLock();
			} finally {
				// if tryLock() returns false, you need to unlock the locks and go around the
				// loop again
				if (gotFirstLock && gotSecondLock) {
					// if you've got both the locks, return from the method, because it has now
					// acquired the locks
					return;
				}

				// if you haven't got at least one of the locks, but you want to make sure that
				// you want to unlock whatever locks you have got
				if (gotFirstLock) {
					firstLock.unlock();
				}

				if (gotSecondLock) {
					secondLock.unlock();
				}

			}

			// Locks not acquired - make the thread sleep long enough that one of the
			// threads might unlock the locks that it's got
			Thread.sleep(1); // if you don't get the locks, and if you don't return - sleep for a bit, and
								// try again in another iteration of the loop
		}
	}

	public void firstThread() throws InterruptedException {
		Random random = new Random();

		for (int iteration = 0; iteration < 1e4; iteration++) {

//			lock1.lock();
//			lock2.lock();
			acquireLocks(lock1, lock2);

			try {
				Account.transfer(account1, account2, random.nextInt(100), "thread1");
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void secondThread() throws InterruptedException {
		Random random = new Random();

		for (int iteration = 0; iteration < 1e4; iteration++) {

//			lock1.lock();
//			lock2.lock();

			// The following code results in a deadlock, and the reason for this is that
			// thread1 has already acquired lock1, and thread2 has already acquired lock2.
			// Now when thread1 tries to acquire lock2, it can't acquire it - since it
			// already has been acquired by thread2, and when thread2 tries to acquire
			// lock1, it won't be able to acquire it, as it already has been acquired by
			// thread1. So both the threads will just be waiting for each other to release
			// the lock in order to proceed
//			lock2.lock();
//			lock1.lock();

			// NOTE: A deadlock occurs if you lock your locks in different orders, and it
			// doesn't just happen with Reentrant locks, but also with nested synchronized
			// blocks. By nested synchronized blocks, it can mean that it is possible that
			// you'll have one synchronized block in one method, and that will call another
			// method, which in it i.e. in the second method, you have another synchronized
			// block. So they're not necessarily going to be obviously nested.
			// There are two solutions to this:
			// 1. Lock your locks in the same order, and that will ensure that you don't get
			// a deadlock
			// 2. Externalize the mechanism to acquire the locks in a separate method and
			// use tryLock() and unlock() of the ReentrantLock class to acquire / unlock the
			// lock by a thread.
			acquireLocks(lock2, lock1);

			try {
				Account.transfer(account2, account1, random.nextInt(100), "thread2");
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void finished() {
		System.out.println("Account 1 balance : " + account1.getBalance());
		System.out.println("Account 2 balance : " + account2.getBalance());
		System.out.println("Total balance : " + (account1.getBalance() + account2.getBalance()));
	}
}
