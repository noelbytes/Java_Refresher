import java.util.Scanner;

public class Processor {

	public void produce() throws InterruptedException {
		synchronized (this) {
			// the this keyword will point to the processor object.
			// you can pass any object into synchronized to establish an intrinsic lock
			System.out.println("Producer thread running ....");
			wait(); // wait can only be called within synchronized code blocks, 
			// and it actually hands over control of the lock that the synchronized 
			// block is locked on. At this point (i.e. when wait() is called, the synchronized block 
			// will loose control of the lock
			
			/* NOTE: Every object in Java has a wait() method because it's a method of the 
			 * Object class, that is the ancestor of all objects in Java
			 * Two types of wait:
			 * 1. wait() - this could cause your thread to wait indefinitely if you are not careful
			 * 2. wait(2000) - wait with a timeout
		    */
			System.out.println("Resumed.");
		}
	}
	
	public void consume() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		
		Thread.sleep(2000); // 2 seconds
		
		// since the same object used in the produce() method is being locked on in 
		// the below synchronized block, the code in the synchronized block will only execute 
		// when the wait() method is called from the produce() method, since wait() will release 
		// the intrinsic lock on the same object. 
		synchronized (this) {
			System.out.println("Waiting for return key.");
			scanner.nextLine();
			System.out.println("Return key pressed");
			notify(); // notify will notify the other thread which released the intrinsic lock on the same object to wake up 
			// if the thread is waiting. It does not relinquish (release) control of the lock. 
			// So after you call notify(), you will have to relinquish control of the lock very quickly, because otherwise, the other 
			// thread which is waiting will not be able to get the lock again
			// If you want to notify all the other threads which called wait, and which have an intrinsic lock on the same object,
			// there's a method called notifyAll()
			
			// To prove that the intrinsic lock isn't released by notify() we can call the following sleep() method
			Thread.sleep(5000); // 5 seconds
			// The lock will only be released after the last statement in the synchronized block has finished executing, 
			// which is in this case, the Thread.sleep() method
		}
	}
}
