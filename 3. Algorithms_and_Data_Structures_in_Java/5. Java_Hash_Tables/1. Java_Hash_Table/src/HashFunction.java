/* What is a hash table? 
-----------------------------------------------------------------
--> A hash table is a data structure that is more like an array. 
--> It offers very fast insertion and searching.
--> They are limited in size because they are based on arrays. 
	--> Can be resized, but it should be avoided. 
--> They are hard to order.

Hash Tables & Hash Functions
------------------------------
--> Key values are assigned to elements in a Hash Table using a Hash Function
--> A hash function helps calculate the best index an item should go in
	--> Index must be small enough for the arrays size.
	--> Don't overwrite other data in the Hash Table
	
Hash functions
----------------
--> A hash functions job is to store values in an array with a limited size
--> It does it in a way that the array doesn't need to be searched through to find it. 
	This allows you to - 
	--> Enter values in any order
	--> Be able to find them using a calculation instead of searching through the array. 
	
	
Hash functions = Speed (Visualisation) 
---------------------------------------
			           Send info back to the user
	(User) <---------------------------------------------------
															  |	
I want the info ----------> Calculation (ID) ----------->   HashTable
  with this ID        	   Provides the exact			Goes directly to the
  					    	  index for the			    location in the array (a.k.a hashtable)
  					     	   information 
 */

import java.util.Arrays;

public class HashFunction {

	String[] theArray;
	int arraySize;
	int itemsInArray = 0;
	
	private HashFunction(int size) {
		arraySize = size;
		theArray = new String[size];
		Arrays.fill(theArray, "-1");
	}
	
	public void hashFunction1(String[] stringsForArray, String[] theArray) {
		/* This hashfunction will put values in the same index that match their value.
		 * So if the value is 1, it will be stored in index 1 */
		for (int index = 0; index < stringsForArray.length; index++) {
			String newElementValue = stringsForArray[index];
			theArray[Integer.parseInt(newElementValue)] = newElementValue; // this specifically is the hash function part of this function
		}
	}
	
	public void hashFunction2(String[] stringsForArray, String[] theArray) {
		/*
		 * Let's say that we have to hold values between 0 and 999, we never plan to
		 * have more than 15 values total stored in any array. Now it wouldn't make sense 
		 * to create a 1000 item array, just to be able to use our previous hash function. 
		 * 
		 * What exactly are the other options?
		 * One way to fit these values into a 30 item array is to use the mod function.
		 * All you'll need to do is take the modulus of the value i.e. 0 - 999 vs. the 
		 * array size to make sure that it fits in one of the indexes in the array
		 * In judging on the size that the hash table or the array needs to be, the goal 
		 * is to make the array big enough to avoid collisions, but not so big that you 
		 * waste memory.
		 * 
		 * Collisions - means that you're trying to throw something into an index that 
		 * already has something
		 */	
		
		for (int index = 0; index < stringsForArray.length; index++) {
			String newElementValue = stringsForArray[index];
			
			int arrayIndex = Integer.parseInt(stringsForArray[index]) % 29; /* Create an index to store the value in by taking it's modulus. 
																				The modulus operation is going to guarentee that the index is 
																				not going to be greater than 30. For any other value, adjust 
																				the divisor accordingly. */ 
			
			System.out.println("Modulus Index = " + arrayIndex + " for value " + newElementValue);
			
			while (theArray[arrayIndex] != "-1") {
				++arrayIndex;
				
				System.out.println("Collision Try " + arrayIndex + " Instead");
				
				// If we get to the end of the array, cycle back to the zero index
				arrayIndex %= arraySize;
			}
			
			theArray[arrayIndex] = newElementValue;
		}
	}
	
	/**
	 * Searches for a given key in the hash table and returns the associated value if found.
	 * 
	 * This method calculates the hash index of the key using a hash function (modulus operation).
	 * If the key is not found at the computed index, linear probing is used to resolve collisions
	 * and continue searching for the key. If the key is found, its value is returned. Otherwise,
	 * the method returns `null`.
	 * 
	 * @param key The key to be searched for in the hash table.
	 * @return The value associated with the given key if found, or `null` if the key does not exist.
	 */

	public String findKey(String key) {
		// Find the keys original hash key
		int arrayIndexHash = Integer.parseInt(key) % 29;
		
		while (theArray[arrayIndexHash] != "-1") {
			if (theArray[arrayIndexHash] == key) {
				System.out.println(key + " was found in Index " + arrayIndexHash);
				
				return theArray[arrayIndexHash];
			}
			
			// If we didn't find a match
			++arrayIndexHash;
			
			arrayIndexHash %= arraySize; // If we get to the end of the array, go back to zero
		}
		
		return null; // This means that the value associated with the specific key could not be found
	}
	
	/**
	 * Displays the contents of the hash table (`theArray`) in a formatted, tabular view.
	 * 
	 * The hash table is represented as an array divided into three segments, each containing 10 elements.
	 * For each segment:
	 * 1. A horizontal divider is printed.
	 * 2. The hash table indices for the segment are displayed in a row.
	 * 3. A second horizontal divider is printed.
	 * 4. The values stored in the hash table for the segment are displayed in a row.
	 * 5. A final horizontal divider is printed.
	 * 
	 * Special handling is included for empty slots (represented by the string "-1"),
	 * which are displayed as blank spaces in the output.
	 * 
	 * This method is intended for debugging or educational purposes, providing a clear view 
	 * of the current state of the hash table.
	 */
	public void displayTheHashTable() {
		/* This method will help us to learn what exactly is going on with hash tables */
		int segmentStartIndex = 0; // Tracks the starting index of the current segment
		
		for (int segment = 0; segment < 3; segment++) { // Loops through 3 segments of the array
			
			segmentStartIndex +=10;
			
			// Print horizontal divider
			for (int dashCount = 0; dashCount < 71; dashCount++) {
				System.out.print("-");
			}
			System.out.println();
			
			// Print array indices for the current segment
			for (int index = segmentStartIndex - 10; index < segmentStartIndex; index++) {
				System.out.format("| %3s " + " ", index);
			}
			System.out.println("|");
			
			// Print another horizontal divider
			for (int dashCount = 0; dashCount < 71; dashCount++) {
				System.out.print("-");
			}
			System.out.println();
			
			// Print array values for the current segment
			for (int index = segmentStartIndex - 10; index < segmentStartIndex; index++) {
				if (theArray[index].equals("-1")) {
					// Placeholder for empty slot
					System.out.print("|      ");
				} else {
					System.out.print(String.format("| %3s " + " ", theArray[index]));
				}
			}
			System.out.println("|");
			
			// Print final horizontal divider for the segment
			for (int dashCount = 0; dashCount < 71; dashCount++) {
				System.out.print("-");
			}
			System.out.println();
			
		}
	}
	
	public static void main(String[] args) {
		HashFunction theFunction = new HashFunction(30);
		
//		String[] elementsToAdd = {"1", "5", "17", "21", "26"};
		
//		theFunction.hashFunction1(elementsToAdd, theFunction.theArray);
		
		String[] elementsToAdd = {"100", "510", "170", "214", "268", "398", 
				"235", "802", "900", "723", "699", "1", "16", "999", "890", 
				"725", "998", "978", "988", "990", "989", "984", "320", "321", 
				"400", "415", "450", "50", "660", "624"};
		
		theFunction.hashFunction2(elementsToAdd, theFunction.theArray);
		
		theFunction.findKey("660");
		
		theFunction.displayTheHashTable();
	}

}
