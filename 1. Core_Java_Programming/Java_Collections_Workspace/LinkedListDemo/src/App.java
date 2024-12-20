import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		
		
//		ArrayList<Integer> arrayList = new ArrayList<Integer>();
//		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		// RULE: If you want to add or remove items at the end / near the end of your
		// list - Use an ArrayList
		/**
		 * ArrayLists manage arrays internally.
		 * [0][1][2][3][4][5] ...
		 */
//		List<Integer> arrayList = new ArrayList<Integer>(100);  // ArrayList with 100 elements as the size
		// NOTE: Once you cross the default limit for an ArrayList, i.e. 10, Java will create a new array with the size double that of the arrayList and copy all the elements over to it. 
		List<Integer> arrayList = new ArrayList<Integer>();

		// RULE: If you want to add or remove items from anywhere else, i.e. either the
		// beginning or the middle, use a LinkedList
		/** LinkedLists consists of elements where each element 
		 * has a reference to the previous and the next element
		 * [0]->[1]->[2]
		 * <-   <-
		 */
		List<Integer> linkedList = new LinkedList<Integer>();

		doTimings("ArrayList", arrayList);
		doTimings("LinkedList", linkedList);
	}

	private static void doTimings(String type, List<Integer> list) {
		// 1E5 = 100,000
		for (int item = 0; item < 1E5; item++) {
			list.add(item);
		}

		long start = System.currentTimeMillis();

		// Adding items to the end of the list
//		for (int item = 0; item < 1E5; item ++) {
//			list.add(item);
//		}

		// Adding items elsewhere in the list
		for (int item = 0; item < 1E5; item++) {
//			list.add(0, item);
			list.add(list.size() - 100, item);	// in this case, the arrayList will be more faster, since the index is almost close to the end
		}

		long end = System.currentTimeMillis();

		System.out.println("Time taken : " + (end - start) + " ms for " + type);
	}
}
