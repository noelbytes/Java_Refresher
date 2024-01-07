package demo2;

class Runner implements Runnable {
	
	@Override
	public void run() {
		for (int index = 0; index < 10; index++) {
			System.out.println("Hello " + index);

			try {
				Thread.sleep(100); // sleep pauses your program for a specified number of milliseconds
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
	}
	
}

public class App {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runner());
		Thread thread2 = new Thread(new Runner());
		
		thread1.start();
		thread2.start();
	}
}
