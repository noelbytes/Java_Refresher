import java.util.Arrays;

public class TheQueue {
	
	private String[] queueArray;
	private int queueSize;
	private int front /* start of the queue (index 0) */, rear /* end of the queue */, numberOfItems = 0;
	
	/* Default access modifier / package-private */ 
	TheQueue(int size) {
		queueSize = size;
		
		queueArray = new String[size];
		
		Arrays.fill(queueArray, "-1");
	}
	
	public void insert(String input) {
		if (numberOfItems + 1 <= queueSize) {
			queueArray[rear] = input; // insert items at the end of the queue
			
			rear++;
			
			numberOfItems++;
			
			System.out.println("INSERT " + input + " was added to the queue\n");
		} else {
			System.out.println("Sorry, but the queue is full");
		}
	}
	
	public void remove() {
		if (numberOfItems > 0) {
			System.out.println("REMOVE " + queueArray[front] + " was removed from the queue\n");
			
			queueArray[front] = "-1";
			
			front++;
			
			numberOfItems--;
		} else {
			System.out.println("Sorry, but the queue is empty");
		}
	}
	
	public void peek() {
		System.out.println("The first element is " + queueArray[front]);
	}
	
	// Priority queue implementation - adds items from high to low as they are inputted
	public void priorityInsert(String input) {
		int index; 
		
		if (numberOfItems == 0) {
			insert(input);
		} else {
			// Add everything from high to low
			for (index = numberOfItems - 1; index >= 0; index--) {
				
				// Compare the value to insert with the value that is inside of the queue already
				if (Integer.parseInt(input) > Integer.parseInt(queueArray[index])) {
					queueArray[index + 1] = queueArray[index]; // copy that value further up into the array, since it's going to be moved
				} else {
					break; // done shifting items in your queue
				}
			}
			
			queueArray[index + 1] = input;
			
			rear++;
			
			numberOfItems++;
		}
		
		
	}
	
	public void displayTheQueue() {
		for (int iteration = 0; iteration < 61; iteration++) {
			System.out.print("-");
		}
		
		System.out.println();
		
		for (int index = 0; index < queueSize; index++) {
			System.out.format("| %2s " + " ", index);
		}
		
		System.out.println("|");
		
		for (int iteration = 0; iteration < 61; iteration++) {
			System.out.print("-");
		}
		
		System.out.println();
		
		for (int index = 0; index < queueSize; index++) {
			if (queueArray[index].equals("-1"))
				System.out.print("|     ");
			else
				System.out.print(String.format("| %2s " + " ", queueArray[index]));
		}
		
		System.out.println("|");
		
		for (int iteration = 0; iteration < 61; iteration++)
			System.out.print("-");
		
		System.out.println();
		
		// Number of spaces to put before the F
		int spacesBeforeFront = 3 * (2 * (front + 1) - 1);
		
		for (int iteration = 1; iteration < spacesBeforeFront; iteration++)
			System.out.print(" ");
		System.out.print("F");
		
		// Number of spaces to put before the R
		// Added -2 to fix spacing
		int spacesBeforeRear = (2 * (3 * rear) - 1) - (spacesBeforeFront) - 1;
		
		for (int iteration = 1; iteration < spacesBeforeRear; iteration++)
			System.out.print(" ");
		System.out.print("R");
		
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		TheQueue theQueue = new TheQueue(10);
		
		theQueue.insert("10");
		theQueue.insert("15");
		theQueue.insert("11");
//		
//		theQueue.displayTheQueue();
//		
//		theQueue.remove();
//		theQueue.remove();
//		
//		theQueue.displayTheQueue();
//		
//		theQueue.peek();
//		
//		theQueue.remove();
		
		theQueue.displayTheQueue();
		
		theQueue.priorityInsert("10");
		theQueue.priorityInsert("19");
		theQueue.priorityInsert("15");
		theQueue.priorityInsert("11");
		
		theQueue.displayTheQueue();
		
		theQueue.remove();
		theQueue.remove();
		
		theQueue.displayTheQueue();
		
		theQueue.peek();
	}
}
