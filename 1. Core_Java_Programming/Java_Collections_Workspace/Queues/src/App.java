import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class App {
	public static void main(String[] args) {
		// (head (front of the queue)) <- oooooooooooooooooooooooooooo <-(tail (end of
		// the queue)) FIFO (first in, first out)

		// Unlike LinkedLists, ArrayBlockingQueue has a fixed size to it
		Queue<Integer> queue1 = new ArrayBlockingQueue<Integer>(3);

		// Throws NoSuchElementException --- no items in the queue yet
		// System.out.println("Head of the queue is : " + queue1.element());
		
		queue1.add(10);
		queue1.add(20);
		queue1.add(30);

		// To see the head of the queue
		System.out.println("Head of the queue is : " + queue1.element());
		
		try {
			queue1.add(40); // Throws an IllegalStateException, since we have added more than 3 elements
							// (this is a runtime exception)
		} catch (IllegalStateException exception) {
			System.out.println("Tried to add too many items to the queue");
		}

		// To see what's in your queue
		for (Integer value : queue1) {
			System.out.println("Queue value : " + value);
		}

		// Removes the head of the queue, and returns it
//		Integer value;

//		value = queue1.remove();
		System.out.println("Removed from queue : " + queue1.remove());
		System.out.println("Removed from queue : " + queue1.remove());
		System.out.println("Removed from queue : " + queue1.remove());
		try {
			System.out.println("Removed from queue : " + queue1.remove());
		} catch (NoSuchElementException exception) {
			System.out.println("Tried to remove too many items from the queue");
		}
		
		// ------------------------------------------------------------------------------
		
		Queue<Integer> queue2 = new ArrayBlockingQueue<Integer>(2);
		
		// Item at the head of the queue can be found out using peek()
		System.out.println("Queue 2 peek : " + queue2.peek());
		
		queue2.offer(10);
		queue2.offer(20);
		// queue2.offer(30); // offer will return false if it can't add the item
		
		System.out.println("Queue 2 peek : " + queue2.peek());
		
//		for (Integer value : queue2) {
//			System.out.println("Queue value : " + value);
//		}
		
		// In other words, offer will attempt to add items to the queue
		// offer is just like add, except that if it can't add the item, 
		// it will return false
		if (queue2.offer(30) == false) {
			System.out.println("Offer failed to add the third item");
		}
		
		for (Integer value : queue2) {
			System.out.println("Queue 2 value : " + value);
		}
		
		// poll() is just like remove(), except that if it can't remove 
		// the item, it will return null
		System.out.println("Queue 2 poll : " + queue2.poll());
		System.out.println("Queue 2 poll : " + queue2.poll());
		System.out.println("Queue 2 poll : " + queue2.poll());
		
		// ArrayBlockingQueue is very useful in multi-threading
		// Other methods that are a part of the BlockingQueue interface which is implemented by ArrayBlockingQueue
		// - put(element) - hangs / suspends the program / thread until the space becomes free in the queue and you can add the value
		// - take() - if you try to take an item (in other words - remove and return it) from a queue that has no items in it, then it will 
		// again suspend your program thread until items become available in that queue
		
		// Real life scenario (for using ArrayBlockingQueue)
		// Suppose you have one thread that adds items to a queue
		// and another thread that removes items from a queue
		// If another thread can't remove items, it will just wait, until items 
		// become available in the queue
	}
}
