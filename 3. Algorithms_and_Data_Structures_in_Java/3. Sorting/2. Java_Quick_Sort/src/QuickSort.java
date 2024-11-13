import java.util.Arrays;

public class QuickSort {

	private static int[] theArray;
	private static int arraySize;

	private QuickSort(int newArraySize) {
		arraySize = newArraySize;
		theArray = new int[arraySize];
		generateRandomArray();
	}

	private void generateRandomArray() {
		for (int index = 0; index < arraySize; index++) {
			theArray[index] = (int) (Math.random() * 50) + 10;
		}
	}

	private void quickSort(int leftIndex, int rightIndex) {

		if (rightIndex - leftIndex <= 0) { // Base case
			// If this condition is true, everything in the array is sorted.
			return;
		} else {
			int pivot = theArray[rightIndex];
			System.out.println(
					"Value at the right index of the array " + theArray[rightIndex] + " is made the pivot value");

			System.out.println("leftIndex = " + leftIndex + " rightIndex = " + rightIndex + "; pivot = " + pivot
					+ " sent to be partitioned");

			int pivotLocation = partitionArray(leftIndex, rightIndex, pivot);

			System.out.println(
					"Value at the left index of the array " + theArray[leftIndex] + " is made the pivot value");

			// Recursive call
			quickSort(leftIndex, pivotLocation - 1); // this will sort the left side
			quickSort(pivotLocation + 1, rightIndex); // this will sort the right side
		}

	}

	private int partitionArray(int leftIndex, int rightIndex, int pivot) {
		int leftPointer = leftIndex - 1;
		int rightPointer = rightIndex;

		while (true) {
			while (theArray[++leftPointer] < pivot)
				; // Search through the array until we find a value that needs to be switched
			printHorizontalArray(leftPointer, rightPointer);

			System.out.println(theArray[leftPointer] + " in index " + leftPointer + " is bigger than the pivot value "
					+ pivot);

			/*
			 * The right pointer is going to cycle through the array until the beginning is
			 * reached, or an item is smaller than pivot is found
			 */

			while (rightPointer > 0 && theArray[--rightPointer] > pivot)
				; // this is used to find the right pointer

			printHorizontalArray(leftPointer, rightPointer);

			System.out.println(theArray[rightPointer] + " in index " + rightPointer
					+ " is smaller than the pivot value " + pivot);

			printHorizontalArray(leftPointer, rightPointer);

			if (leftPointer >= rightPointer) {
				System.out.println("The left pointer is >= the right pointer so start again");
				break;  // this will break out of the infinite while loop
			} else {
				swapValues(leftPointer, rightPointer);
				System.out.println(theArray[leftPointer] + " was swapped for " + theArray[rightPointer]);
			}
		}
		
		swapValues(leftPointer, rightIndex);
		
		return leftPointer;
	}
	
	private void swapValues(int indexOne, int indexTwo) {
		int temporaryValue = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temporaryValue;
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
			int spacesBeforeTheLeftPointer = 6 * (index1 + 1) - 5 + 1;

			for (int iteration = 0; iteration < spacesBeforeTheLeftPointer; iteration++) {
				System.out.print(" ");
			}

			System.out.print("L" + index1);

			// Number of spaces to put before the R
			int spacesBeforeTheRightPointer = 6 * (index2 - index1) - 2;

			for (int iteration = 0; iteration < spacesBeforeTheRightPointer; iteration++) {
				System.out.print(" ");
			}

			System.out.print("R" + index2);

			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		QuickSort quickSortReference = new QuickSort(10);
		
		System.out.println(Arrays.toString(QuickSort.theArray));
		quickSortReference.quickSort(0, arraySize - 1);
		System.out.println(Arrays.toString(QuickSort.theArray));
	}
}
