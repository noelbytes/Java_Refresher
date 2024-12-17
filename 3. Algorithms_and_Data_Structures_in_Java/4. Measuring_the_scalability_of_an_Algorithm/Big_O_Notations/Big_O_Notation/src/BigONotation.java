//  The big O notation is not always a measure of speed, but instead, a measure of how well an algorithm scales

public class BigONotation {

//	45n^3 + 20n^2 + 19 = 84 (n = 1)
//	45n^3 + 20n^2 + 19 = 459 (n = 2)
//	45n^3 + 20n^2 + 19 = 47,019 (n = 10)
//	45n^3 = 45,000

/*
 * If you're dealing with very large numbers, you quickly see that the part of
 * this algorithm that really has a lot to do with the final answer as this
 * dataset scales is not even going to be the 45, but it's going to be the n^3.
 */

//	Hence, we say that this has an order of N^3 or O(N^3)

//	O(1)
//	O(N)
//	O(N^2)
//	O(logN)
//	O(nlogN)

	private int[] theArray;
	private int arraySize;
	private int itemsInArray = 0;
	static long startTime;
	static long endTIme;

	public static void main(String[] args) {

	}

	/*
	 * O(1) - This notation indicates an algorithm that executes in the same amount
	 * of time regardless of the amount of data, or in other words, it's going to be
	 * code that executes in the same amount of time no matter how big the array is
	 */
	public void addItemToArray(int newItem) {
		theArray[itemsInArray++] = newItem;
	}

	public void generateRandomArray() {
		for (int index = 0; index < arraySize; index++) {
			theArray[index] = (int) (Math.random() * 1000) + 10;
		}
		itemsInArray = arraySize - 1;
	}
}
