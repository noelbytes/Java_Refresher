import java.util.HashMap;
import java.util.Map;

public class App {
	public static void main(String[] args) {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		
		hashMap.put(5, "Five");
		hashMap.put(8, "Eight");
		hashMap.put(6, "Six");
		hashMap.put(4, "Four");
		hashMap.put(2, "Two");

		hashMap.put(6, "Hello");	// this will override the previous key
		
		String text = hashMap.get(6); // Hello
		String unknownKey = hashMap.get(1);	// returns null
		System.out.println(text);
		System.out.println(unknownKey);
		
		for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
			int key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println(key + " : " + value);   
		}
		
		// NOTE : hashMap is not sorted, so everytime you iterate through it, you may or may not see the same order
	}
}
