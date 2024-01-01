import java.util.List;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>(); // Default size of the ArrayList = 10

		// Adding
		numbers.add(10);
		numbers.add(100);
		numbers.add(40);

		// Retrieving
		System.out.println(numbers.get(0));

		System.out.println("Iteration #1: ");
		// Indexed for loop iteration
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
		
		// Removing items (careful) (fast) - if you remove the last item, it doesn't have to copy items to a different array
		// Even of you remove the second last or the third last item, that can be reasonably fast. 
		// But if you remove the first item, that's going to be slow
		numbers.remove(numbers.size() - 1);

		// This is very slow - because when you remove the first item, it will copy all the items / subsequent items one step back to fill the hole  
		// A better alternative in this scenario is to use a LinkedList
		numbers.remove(0);
		
		System.out.println("\nIteration #2 : ");
		for (Integer value : numbers) {
			System.out.println(value);
		}

		// List iterface
		List<String> values = new ArrayList<String>();
	}
}
