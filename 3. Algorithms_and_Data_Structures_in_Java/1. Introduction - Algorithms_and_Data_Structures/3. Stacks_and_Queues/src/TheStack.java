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

	public void push(String input) {
		if (topOfStack + 1 < stackSize) {
			topOfStack++;

			stackArray[topOfStack] = input;
		} else {
			System.out.println("Sorry, but the stack is full");
		}

		displayTheStack();

		System.out.println("PUSH " + input + " was added to the stack");
	}

	public String pop() {
		if (topOfStack >= 0) {
			displayTheStack();

			System.out.println("POP " + stackArray[topOfStack] + " was removed from the stack\n");

			stackArray[topOfStack] = "-1"; // Done for display purposes. In memory, when you delete an item, it is still
											// going to be there, however, it will have the value of -1 instead of the
											// original value
			
			return stackArray[topOfStack--];
		} else {
			displayTheStack();
			
			System.out.println("Sorry, but the stack is empty");
			
			return "-1";
		}
	}
	
	public String peek() {
		// This method will return what's on top of the stack, but won't remove it
		displayTheStack();
		
		System.out.println("PEEK " + stackArray[topOfStack] + " is at the top of the stack\n");
		
		return stackArray[topOfStack];
	}

	public void displayTheStack() {
		for (int iteration = 0; iteration < 61; iteration++)
			System.out.print("-");

		System.out.println();

		for (int number = 0; number < stackSize; number++) {
			System.out.format("| %2s " + " ", number);
		}

		System.out.println("|");

		for (int iteration = 0; iteration < 61; iteration++)
			System.out.print("-");
		
		System.out.println();
		
		for (int index = 0; index < stackSize; index++) {
			if (stackArray[index].equals("-1"))
				System.out.print("|     ");
			else
				System.out.print(String.format("| %2s " + " ", stackArray[index]));
		}
		
		System.out.println("|");
		
		for (int iteration = 0; iteration < 61; iteration++)
			System.out.print("-");
		
		System.out.println();
	}

	TheStack(int size) {
		stackSize = size;
		stackArray = new String[size];
		Arrays.fill(stackArray, "-1");
	}

	public static void main(String[] args) {
		
		TheStack theStack = new TheStack(10);
		
		theStack.push("10");
	}
}
