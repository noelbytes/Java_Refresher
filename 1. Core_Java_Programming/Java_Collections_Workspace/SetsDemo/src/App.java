import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class App {
	public static void main(String[] args) {

		// HashSet does not retain order, i.e. the order in which the elements are
		// stored is random
//		Set<String> set1 = new HashSet<String>();

		// If you want to order your items, then you can use a LinkedHashSet
		// LinkedHashSet remembers the order you added items in
		// LinkedHashSet has a doubly linked list running through your items, so it will
		// keep them in the right order
//		Set<String> set1 = new LinkedHashSet<String>();

		// TreeSet sorts in natural order
		// For Strings - natural order is going to be the alphabetical order
		// For any other numerical - it will be in the ascending order
		Set<String> set1 = new TreeSet<String>();

		if (set1.isEmpty()) {
			System.out.println("Set is empty");
		}

		set1.add("dog");
		set1.add("cat");
		set1.add("mouse");
		set1.add("snake");
		set1.add("bear");

		if (set1.isEmpty()) {
			System.out.println("Set is empty after adding (no!)");
		}

		// Adding duplicate items does nothing
		set1.add("mouse");

		System.out.println("Set1 : " + set1);

		// ---------------------- Iteration --------------------------
		for (String element : set1) {
			System.out.println(element);
		}

		// ---------------------- Does set contain a given item? -----------------
		// Sets are optimized for finding particular items quickly
		if (set1.contains("aardvark")) {
			System.out.println("Contains aardvark");
		}

		if (set1.contains("cat")) {
			System.out.println("Contains cat");
		}

		// -------------------------- Itersection -----------------------------------
		// Set2 contians some common elements with set1, and some new
		Set<String> set2 = new TreeSet<String>();

		set2.add("dog");
		set2.add("cat");
		set2.add("giraffe");
		set2.add("monkey");
		set2.add("ant");
		
		System.out.println("Set2 : " + set2);
		
		Set<String> intersection = new HashSet<String>(set1);
		
		System.out.println("Intersection set :  " + intersection);
		
		intersection.retainAll(set2);   // retains the elements that are both in the intersection set and set2 and removes the rest
		
		System.out.println("Intersection set after retaining : " + intersection);
		
		// ---------------------------------- Difference ------------------------------------
		Set<String> difference = new HashSet<String>(set2);
		
		// This will remove the elements that are in set2, and we are going to find the elements in set1 that are not in set2, and remove all the elements in set2 not present in the set1
		// In other words, this will remove the elements in set2 that set2 shares with set1, and retains the other elements of set2
		difference.removeAll(set1);
		
		System.out.println("Difference set : " + difference);
		
		
	}
}
