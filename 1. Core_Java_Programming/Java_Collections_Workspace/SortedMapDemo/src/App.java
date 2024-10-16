import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

class Temp {
	
}

public class App {
	public static void main(String[] args) {
//		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		Map<Integer, String> hashMap = new HashMap<Integer, String>();

//		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
		Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();

		// Difference between LinkedHashMap and HashMap
		// - LinkedHashMap has a doubly linked list connecting the entries, and this means that the keys and 
		// values will stay in the same order that you add them to the Map
		
		System.out.println(new Temp());   // this will print the hashcode of the object
		
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		// A tree sorts the values that you add to it, usually in the natural order, i.e. for Integers - the natural order is 1, 2, 3, 4, 5...
		// For strings, the natural order is alphabetical order
		// In other words, TreeMap will sort the keys in the natural order
	
//		testMap(hashMap);
//		testMap(linkedHashMap);
		testMap(treeMap);
	}
	
	public static void testMap(Map<Integer, String> map) {
		map.put(9, "fox");
		map.put(4, "cat");
		map.put(8, "dog");
		map.put(1, "giraffe");
		map.put(0, "swan");
		map.put(15, "bear");
		map.put(6, "snake");

		// map.keySet() returns a collection called Set
		for (Integer key : map.keySet()) {
			String value = map.get(key);
			
			System.out.println(key + " : " + value);
		}
	}
}
