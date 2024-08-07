import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		List<String> animals = new LinkedList<String>();

		animals.add("fox");
		animals.add("cat");
		animals.add("dog");
		animals.add("rabbit");

		// Iterator is a template type, so include the type in <> to avoid any errors
		// In this case, we have strings in our list. So the type will be String
		Iterator<String> iterator = animals.iterator();
		// NOTE: A lot of java collections implement the Iterable interface.
		// the method iterator is the only method under iterable and it returns the
		// Iterator<T> type

		// NOTE: An Iterator is useful when you want to remove items from the list in a loop
		// This can't be done in a normal foreach loop, as it will result in an error
		while (iterator.hasNext()) {
			String animalIterator = iterator.next(); // when you call next(), it makes the iterator move to the next
														// item,
			// and return it at the same time. Initially, the iterator will be pointing
			// before the first item in your list
			System.out.println(animalIterator);
			
			if (animalIterator.equals("cat")) {
				iterator.remove();
			}
		}
		
		System.out.println();

		// Modern iteration, Java 5 and later
		for (String animal : animals) {
			System.out.println(animal);
			
			// animals.remove(2); // This will result in a ConcurrentModificationException
		}
		
		// If you want to add items to a list while iterating through it, then instead of using an 
		// Iterator<T>, use a ListIterator<T>
		// ListIterator<T> has a previous() method in addition to the next() method to move to the 
		// item before the item that it's currently pointing to in the list
	}
}
