import java.util.concurrent.Semaphore;

public class Connection {

	private static Connection instance = new Connection();

	// To limit the number of connections at any given time, use a semaphore
	// The semaphore constructor also has a fairness parameter (second parameter)
	/*
	 * If you have a fair semaphore which is achieved by setting the parameter to
	 * true, then it means that whichever thread called acquire() first will be the
	 * first one to get a permit when a permit becomes available. If you don't
	 * specify it as true, then that is not always guaranteed. There may be
	 * performance benefits gained by setting it to false, but most of the time, you
	 * will want it to be true, because you don't want it to be leaving some thread
	 * in the background while it services other threads, and you don't want one
	 * thread to have to wait ages and ages to get a permit when other threads that
	 * have been waiting for a shorter time are getting those permits
	 */
	private Semaphore semaphore = new Semaphore(10, true); // 10 permits

	// NOTE: To make a connection, you need to acquire a permit, and after the
	// connections finished, it will release a permit

	private int numberOfConnections = 0;

	private Connection() {

	}

	public static Connection getInstance() {
		return instance; // Singleton pattern
	}

	public void connect() {
		try {
			semaphore.acquire(); // acquire the permit before the thread runs
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}

		try {
			doConnect(); // even if the doConnect method throws an exception, the finally block will
							// still run
		} finally {
			semaphore.release(); // release the permit after you finish running the connect method
		}
	}

	public void doConnect() {

		synchronized (this) {
			numberOfConnections++;
			System.out.println("Current connections : " + numberOfConnections);
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}

		synchronized (this) {
			numberOfConnections--;
		}

	}
}
