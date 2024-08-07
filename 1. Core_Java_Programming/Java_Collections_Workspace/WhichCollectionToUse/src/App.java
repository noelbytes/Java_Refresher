import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class App {
	public static void main(String[] args) {
		
		/* Consider:
		 * 1. What you need the collection to do?
		 * 2. Are you using the fastest collection for your purposes
		 * (think about insertion / deletion, retrieval and traversal
		 */
		
		// --------------------------LISTS------------------------------------
		
		/* Store lists of objects
		 * Duplicates are allowed
		 * Objects remain in order
		 * Elements are indexed via an integer
		 * cf. shopping list
		 * Checking for a particular item in the list is slow
		 * Looking an item up by the index is fast
		 * Iterating through lists is relatively fast
		 * Note: You can sort lists if you want to
		*/
		
		// If you only add or remove items at the end of the list, use an ArrayList
		List<String> arrayList = new ArrayList<String>();
		
		// Removing or adding items elsewhere in the list?
		List<String> linkedList = new LinkedList<String>();
		
		// --------------------------SETS------------------------------------
		
		/* Only store unique values
		 * Great for removing duplicates
		 * Not indexed, unlike lists
		 * Very fast to check if a particular object exists
		 * If you want to use it on your own objects, you must implement the hashCode() and the equals() method
	    */
		
		// Order is unimportant and OK if it changes?
		// HashSet is not ordered
		Set<String> hashSet = new HashSet<String>();
		
		// Sorted in natural order? Use TreeSet - must implement Comparable for custom types / objects
		// (1, 2, 3 ...., a, b, c .... etc)
		Set<String> treeSet = new TreeSet<String>();
		
		// Elements remain in the order in which they are added to the set - Use LinkedHashSet
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		
		// --------------------------MAPS------------------------------------

		/* Key-value pairs.
		 * Like lookup tables
		 * Retrieving a value by key is fast
		 * Iterating over map values is very slow
		 * Maps are not really optimized for iteration
		 * Always iterate over keys, and never iterate over values in a map, as it's incredibly slow when compared to iterating over keys
		 * If you want to use your own objects as keys, you must implement the hashCode() and the equals() methods
		*/
		
		// Keys not in a particular order, and order is liable to change.
		Map<String, String> hashMap = new HashMap<String, String>();
		
		// Keys sorted in natural order - must implement Comparable for custom types / objects
		Map<String, String> treeMap = new TreeMap<String, String>();
		
		// Keys remain in the order added
		Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		
		// There is also the SortedSet and the SortedMap interface
		
	}
}
