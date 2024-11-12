/* What is the Quick Sort?
 * --> In most situations, quick sort is the fastest sorting algorithm
 * --> The quick sort works by partitioning arrays so that the smaller numbers are on the 
 *     left and the larger are on the right - this is known as partitioning
 * --> It then recursively sends small parts of larger arrays to itself and partitions again, 
 *     until the whole array is in order / sorted
 * --> In partitioning, you will have to define a pivot value. Then you will have to switch everything 
 *     on the left side of the array that is larger than your pivot value with a value that is smaller than the pivot value. 
 *     This continues until everything is shifted from the left side of the array to the right side of the array
*/

import java.util.Arrays;

public class Partitioning {

	private static int[] theArray;
	private static int arraySize;

	Partitioning(int newArraySize) {
		arraySize = newArraySize;
		theArray = new int[arraySize];
		generateRandomArray();
	}

	private void generateRandomArray() {
		for (int index = 0; index < arraySize; index++) {
			theArray[index] = (int) (Math.random() * 50) + 10;
		}
	}

	public void partitionArray(int pivotValue) {
		/*
		 * The way the leftPointer is going to work is it's going to sort through the
		 * array until it finds an item that is greater than the pivot. Then it's going
		 * to stop and wait for the right pointer to find a value that is less than the
		 * pivot. Then, those items at the left and right pointer are going to be switched.
		 */
		int leftPointer = -1; // the pointer is currently outside of the array
		int rightPointer = arraySize; // right side of the array

		while (true) {
			// Cycle through the array until the end is reached or an item bigger than pivot
			// is found, and then wait for the right pointer to finish cycling
			while (leftPointer < (arraySize - 1) && theArray[++leftPointer] < pivotValue)
				;

			printHorizontalArray(leftPointer, rightPointer);

			System.out.println(theArray[leftPointer] + " in index " + leftPointer + " is bigger than the pivot value "
					+ pivotValue);

			/*
			 * The right pointer is going to cycle through the array until the beginning is
			 * reached, or an item is smaller than pivot is found
			 */

			while (rightPointer > 0 && theArray[--rightPointer] > pivotValue)
				;

			printHorizontalArray(leftPointer, rightPointer);

			System.out.println(theArray[rightPointer] + " in index " + rightPointer
					+ " is smaller than the pivot value " + pivotValue);

			printHorizontalArray(leftPointer, rightPointer);

			if (leftPointer >= rightPointer) {
				break;
			} else {
				swapValues(leftPointer, rightPointer);

				System.out.println(theArray[leftPointer] + " was swapped for " + theArray[rightPointer]);
			}
		}
	}

	private void printHorizontalArray(int index1, int index2) {
		for (int iteration = 0; iteration < (arraySize * 6) + 1; iteration++) {
			System.out.print("-");
		}

		System.out.println();

		for (int index = 0; index < arraySize; index++) {
			System.out.format("| %2s " + " ", index);
		}

		System.out.println("|");

		for (int iteration = 0; iteration < (arraySize * 6) + 1; iteration++) {
			System.out.print("-");
		}

		System.out.println();

		for (int index = 0; index < arraySize; index++) {
			System.out.print(String.format("| %2s " + " ", theArray[index]));
		}

		System.out.println("|");

		for (int iteration = 0; iteration < (arraySize * 6) + 1; iteration++) {
			System.out.print("-");
		}

		System.out.println();

		if (index1 != -1) {
			// Number of spaces to put before the L
			int spacesBeforeTheLeftPointer = 6 * (index1 + 1) - 5;

			for (int iteration = 0; iteration < spacesBeforeTheLeftPointer; iteration++) {
				System.out.print(" ");
			}

			System.out.print("L" + index1);

			// Number of spaces to put before the R
			int spacesBeforeTheRightPointer = 5 * (index2 + 1) - spacesBeforeTheLeftPointer;

			for (int iteration = 0; iteration < spacesBeforeTheRightPointer; iteration++) {
				System.out.print(" ");
			}

			System.out.print("R" + index2);

			System.out.println("\n");
		}
	}

	private void swapValues(int indexOne, int indexTwo) {
		int temporaryValue = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temporaryValue;
	}

	public static void main(String[] args) {
		Partitioning partitionArrayReference = new Partitioning(10);

		System.out.println(Arrays.toString(Partitioning.theArray));

		partitionArrayReference.partitionArray(35);

		System.out.println(Arrays.toString(Partitioning.theArray));
	}

}
