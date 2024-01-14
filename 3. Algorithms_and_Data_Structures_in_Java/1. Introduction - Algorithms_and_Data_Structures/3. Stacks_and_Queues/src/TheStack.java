import java.util.Arrays;

/* Arrays, LinkedLists, Trees, etc are best used to represent real objects
 * Stacks and queues however, are instead used to complete a task. They're like a 
 * programmers tool that is used and soonafter discarded
 * 
 * Difference between a stack and a queue
 * ----------------------------------------
 * 1. A stack is going to allow access to just one item, being the last item put into the stack
 * 2. A queue is also going to provide access to just one item, however the first item put in is going to be the first item pulled out. 
 * 
 * --> Stacks and Queues only allow a single item to be added or removed at any one time, so that makes them very, very fast. 
*/

public class TheStack {

	private String[] stackArray;
	private int stackSize;
	private int topOfStack = -1; // the stack is initially empty

	TheStack(int size) {
		stackSize = size;
		stackArray = new String[size];
		Arrays.fill(stackArray, "-1");
	}

	public static void main(String[] args) {

	}
}
