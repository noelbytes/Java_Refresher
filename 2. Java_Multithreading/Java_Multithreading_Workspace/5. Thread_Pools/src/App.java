import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {

	private int id;

	public Processor(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting : " + id);
		try {
			Thread.sleep(5000); // 5 seconds
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
		System.out.println("Completed : " + id);
	}

}

public class App {
	public static void main(String[] args) {
		
		/* What is a thread pool?
		 * A thread pool is more like having a number of workers in a factory, in this case, 2 of them,
		 * and you've got a load of tasks that you want them to get through. For example, in this case, we'll 
		 * say there are five tasks and you want each of these workers (threads) to process a task, and when this worker 
		 * thread finishes processing this task, you want it to start on a new task.
		 * 
		 * So it's like giving those two factory workers a bunch of tasks and saying - Here, please work on these 
		 * tasks one at a time, and when you finish one task, start on a new task. 
		*/
		
		// One thread will process one task at a time, but as soon as one thread is finished and it's idle, 
		// that same thread will now process a new task
		// Advantage of this approach over manually creating threads:
		// - there is a lot of overhead to starting threads, and by recycling the 
		// threads in this thread pool, you avoid that overhead.
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		// To allot the tasks, submit the tasks to executor.
		/* The ExecutorService will run it's own managerial thread that will handle 
		 * parceling out these tasks that you're going to give to it. 
		*/
		for (int id = 0; id < 5; id++) {
			executor.submit(new Processor(id));
		}
		
		// Tell the managerial thread of the ExecutorService to stop accepting new tasks and shut itself down 
		// when all the tasks are finished
		
		executor.shutdown(); // this will not shutdown immediately, but it will wait for all the threads to 
		// complete what they are doing, and then they will terminate
		
		System.out.println("All tasks submitted.");
		
		// wait for all 5 tasks to complete
		try {
			executor.awaitTermination(1, TimeUnit.DAYS); // wait for 1 day
			// executor.awaitTermination(10, TimeUnit.SECONDS); // suppose your tasks didn't finish in 10 seconds, this would wait only 10 seconds 
			// and after that, it would return, so you could execute more stuff below this line.
		} catch (InterruptedException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
		
		System.out.println("All tasks completed. ");
	}
}
