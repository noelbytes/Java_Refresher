
public class App {
	public static void main(String[] args) throws InterruptedException {

		final Runner runner = new Runner();

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					runner.firstThread();
				} catch (InterruptedException exception) {
					exception.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					runner.secondThread();
				} catch (InterruptedException exception) {
					exception.printStackTrace();
				}
			}
		});

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		System.out.println("------------------------------------------------------------------");
		runner.finished();
	}
}
