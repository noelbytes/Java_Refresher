import java.util.Random;

public class App {
	public static void main(String[] args) throws InterruptedException {

		System.out.println("Starting.");

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Random random = new Random();

				for (int i = 0; i < 1E8; i++) {

					// To check if the thread is being interrupted
//					if (Thread.currentThread().isInterrupted()) {
					// Thread.currentThread() - this will get the currently executing thread
//						System.out.println("Interrupted!"); // this will be printed on the console, since thread1.interrupt() is being called
//						break;
//					}

					try {
						Thread.sleep(1);
					} catch (InterruptedException exception) {
						System.out.println("Interrupted!"); // this will also be printed on this console, since thread1.interrupt() is being called
						break;
					}
					
					Math.sin(random.nextDouble());
				}
			}
		});
		thread1.start();

		Thread.sleep(500);

		thread1.interrupt(); // this will not stop the thread, but rather set a flag that will tell the
								// thread that it's being interrupted. So it won't interrupt any running code

		thread1.join(); // wait for the thread to finish

		System.out.println("Finished");
	}
}
