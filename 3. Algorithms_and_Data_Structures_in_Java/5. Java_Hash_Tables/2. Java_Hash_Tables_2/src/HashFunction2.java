
/**
 * Java Hash Tables:
-------------------
Why we use primes?
-----------------------
--> Previously, we used the following formula to calculate the hash value.
	arrayIndex = newElementVal (i.e. the value that we wanted to store in our hash  table) % arraySize
--> The arraySize should be a prime number for the following reasons:
		- We want to avoid collisions
		- Collisions occur when storing similar data
		- If we have n values that we're trying to store in our hash table that are similar, this is going to cause n times as many collisions.
		- Using a prime number for the array size helps minimize collisions.
		
--------------------------------
How to increase hash table size
(Useful for situations where if you'd like to put 30 items into a 30 item hash table, and you'd like to increase that to 60. 
--------------------------------
--> Find a prime sized array bigger than the array size that is requested.
--> Store the values in the current array and eliminate empty spaces.
--> Increase the size of the current array.
--> Use a hash function to fill the newly sized array with the original values

--------------------------
How to avoid clustering?
--------------------------
--> Clustering occurs because if there is a collision, we just move to the next index and put the value inside of that
--> The only problem with that is, is each time this occurs, it increases the likelihood or the chance that it will later hit
    one of those big clusters (group of indexs) when we try to put another value in.
    
    E.g. These are two clusters
    -----------------------------------------------------------------------
|  10  |  11  |  12  |  13  |  14  |  15  |  16  |  17  |  18  |  19  |
-----------------------------------------------------------------------
|      |      |      | 989  | 624  | 320  | 321  |      |      |      |
-----------------------------------------------------------------------
-----------------------------------------------------------------------
|  20  |  21  |  22  |  23  |  24  |  25  |  26  |  27  |  28  |  29  |
-----------------------------------------------------------------------     <-------- This is the bigger cluster
|      | 570  | 510  | 450  | 450  | 390  | 330  | 270  | 210  | 150  |
-----------------------------------------------------------------------

This is the reason why we'll end up with arrays where there is literally nothing in one part of the array, and in another part 
of the array, everything seems to be bunched up. That is bad, and that is to be avoided
 */

import java.util.Arrays;
import java.util.ArrayList;

public class HashFunction2 {

	private String[] theArray;
	private int arraySize;
	private int itemsInArray = 0;

	private HashFunction2(int size) {
		arraySize = size;
		theArray = new String[size];
		Arrays.fill(theArray, "-1");
	}

	public boolean isPrime(int number) {

		// Eliminate the need to check for even numbers. This will immediately cut out
		// half of all the numbers that you will have to search for.
		if (number % 2 == 0) {
			return false;
		}

		// Check it against all the odd numbers after 2
		for (int iterator = 3; iterator * iterator <= number; iterator += 2) {
			if (number % iterator == 0) {
				return false; // i.e. it is not a prime number
			}
		}

		// The number is indeed a prime number
		return true;
	}

	/**
	 * Since we are increasing the size of the array, we want to use the isPrime
	 * method to define or make sure that we have a prime number array size. So that
	 * menas that you will have to receive a number and return the next prime that
	 * follows that number.
	 * 
	 * @param minNumberToCheck - This is the minimum array size that's needed
	 * @return a prime that is above the array size
	 */
	public int getNextPrime(int minimumNumberToCheck) {
		for (int number = minimumNumberToCheck; true; number++) {
			if (isPrime(number)) {
				return number;
			}
		}
	}

	public void increaseArraySize(int minimumArraySize) {
		// Get a prime number that is bigger than the array that is requested
		int newArraySize = getNextPrime(minimumArraySize);

		// Move the array into a bigger array with a larger prime size
		moveOldArray(newArraySize);
	}

	public void moveOldArray(int newArraySize) {
		String[] cleanArray = removeEmptySpacesInArray(theArray);

		// Increase the size for your array
		theArray = new String[newArraySize];

		// Assign the updated value for the array size
		arraySize = newArraySize;

		// Fill array with negative one's
		fillArrayWithNegativeOnes();

		// Copy the values from the older array over to the new larger array
		hashFunction2(cleanArray, theArray);
	}

	private String[] removeEmptySpacesInArray(String[] arrayToClean) {

		ArrayList<String> stringList = new ArrayList<String>();

		// Cycle through the array, and if a space isn't empty, add it to your ArrayList
		for (String theString : arrayToClean) {
			if (!theString.equals("-1") && !theString.equals("")) {
				stringList.add(theString);
			}
		}

		return stringList.toArray(new String[stringList.size()]);
	}

	private void hashFunction2(String[] elementsToAdd, String[] theArray) {
		// If the array size is a prime number, most of the collisions that can occur by
		// using a non-prime number can be avoided
		for (int index = 0; index < elementsToAdd.length; index++) {
			String elementToAdd = elementsToAdd[index];

			int hashIndex = Integer.parseInt(elementToAdd) % arraySize;

			System.out.println("Modulus Index = " + hashIndex + " for value " + elementToAdd);
			while (theArray[hashIndex] != "-1") {
				++hashIndex;
				System.out.println("Collision. Try " + hashIndex + " instead.");
				hashIndex %= arraySize; // Cycle back to the zero index
			}
			theArray[hashIndex] = elementToAdd;
		}

	}

	/**
	 * Updated version of hashFunction2 to avoid clustering. We're basically going
	 * to be staggering it. This will randomize the index that we're trying to
	 * insert into when collisions are detected, rather than trying to insert it
	 * into the immediate next index.
	 */
	private void doubleHashFunction(String[] stringsForArray, String[] theArray) {
		for (int index = 0; index < stringsForArray.length; index++) {
			String newElementValue = stringsForArray[index];

			// Create an index to store the value by taking the modulus
			int arrayIndex = Integer.parseInt(newElementValue) % arraySize;

			// Change the step / step distance to get the distance to skip down in the array
			// after a collision occurs to a other random index, and we're going to do this
			// to avoid creating clusters
			int stepDistance = 5 - (Integer.parseInt(newElementValue) % 5); // Here, we are using 7, since it is a prime
																			// number. Always make sure that the value
																			// that you are using is a prime number.
																			// Here it will move the value 7 steps down
																			// in other indexes rather than just picking
																			// the next index

			System.out.println("Modulus Index = " + arrayIndex + " for value " + newElementValue);

			// Cycle through the array until we find an empty space
			while (theArray[arrayIndex] != "-1") {
				arrayIndex += stepDistance;

				System.out.println("Collision. Try " + arrayIndex + " Instead.");

				// If we get to the end of the array, go back to index 0
				arrayIndex %= arraySize;
			}

			theArray[arrayIndex] = newElementValue;
		}
	}

	private String findKeyDoubleHashed(String key) {
		// Find the keys to the original hash key
		int arrayIndexHash = Integer.parseInt(key) % arraySize;

		// Calculate the step distance
		int stepDistance = 5 - (Integer.parseInt(key) % 5);

		while (theArray[arrayIndexHash] != "-1") {
			if (theArray[arrayIndexHash] == key) {
				// Found the key so return it
				System.out.println(key + " was found in the index " + arrayIndexHash);

				return theArray[arrayIndexHash];
			}

			// Look in the next distance / index
			arrayIndexHash += stepDistance;

			// If we go back to the end of the array, go back to index 0
			arrayIndexHash %= arraySize;
		}

		// Couldn't locate the key
		return null;
	}

	private void fillArrayWithNegativeOnes() {
		Arrays.fill(theArray, "-1");
	}

	private void displayTheHashFunction() {
		int segmentStartIndex = 0;

		int numberOfRows = (arraySize / 10) + 1;

		for (int segment = 0; segment < numberOfRows; segment++) {
			segmentStartIndex += 10;

			printDashes();

			for (int index = segmentStartIndex - 10; index < segmentStartIndex; index++) {
				System.out.format("| %3s " + " ", index);
			}
			System.out.println("|");

			printDashes();

			for (int index = segmentStartIndex - 10; index < segmentStartIndex; index++) {
				if (index >= arraySize) {
					System.out.print("|      ");
				} else if (theArray[index] == "-1") {
					System.out.print("|      ");
				} else {
					System.out.format("| %3s " + " ", theArray[index]);
				}
			}
			System.out.println("|");

			printDashes();
		}
	}

	private void printDashes() {
		for (int dashCount = 0; dashCount < 71; dashCount++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		HashFunction2 hashFunctionReference = new HashFunction2(31);

		String[] elementsToAdd1 = { "100", "510", "170", "214", "268", "398", "235", "802", "900", "723", "699", "1",
				"16", "999", "890", "725", "998", "978", "988", "990", "989", "984", "320", "321", "400", "415", "450",
				"50", "660", "624" };

		String[] elementsToAdd2 = { "30", "60", "90", "120", "150", "180", "210", "240", "270", "300", "330", "360",
				"390", "420", "450", "480", "510", "540", "570", "600", "989", "984", "320", "321", "400", "415", "450",
				"50", "660", "624" }; // elements that are multiples of 30

		hashFunctionReference.hashFunction2(elementsToAdd2, hashFunctionReference.theArray);

		hashFunctionReference.increaseArraySize(60); // NOTE: Our array should be at the minimum - twice, the number of
														// values that we are trying to put in, and that should never be
														// considered the maximum or the ideal array size

		hashFunctionReference.displayTheHashFunction();

		hashFunctionReference.fillArrayWithNegativeOnes();

		hashFunctionReference.doubleHashFunction(elementsToAdd2, hashFunctionReference.theArray);

		hashFunctionReference.displayTheHashFunction();

		// Since we've changed the way of storing values in the hash table, we would
		// need a new implementation to find values in the hash table
		hashFunctionReference.findKeyDoubleHashed("989");
	}
}
