
public class RecursiveMergeSort {
	// Merge Sort - recursively divides an array in 2, sorts them, and then, re-combines the divided arrays into a single array
	// It is a divide and conquer algorithm
	// Run-time complexity = O(nlogn)
	// Space complexity = O(n)
	public static void main(String args[]) {
		int[] array = { 10, 8, 4, 80, 13, 1, 3, 11 };

//		mergeSort(array);

		System.out.println("---------------------------------------------------------");
		for (int index = 0; index < array.length; index++) {
			System.out.println("array[" + index + "] = " + array[index]);
		}
		System.out.println("---------------------------------------------------------");

		mergeSort(array);

		System.out.println("---------------------------------------------------------");
		for (int index = 0; index < array.length; index++) {
			System.out.println("array[" + index + "] = " + array[index]);
		}
		System.out.println("---------------------------------------------------------");
	}

	private static void mergeSort(int[] array) {
		// Get the length of the array
		int length = array.length;

		// Base case
		if (length <= 1) {
			// if the length of the array is 1, there is no need to divide our array further
			return;
		}

		// Find the middle position of our array
		int middle = length / 2;

		// Create two new subarrays
		int[] leftArray = new int[middle];
		int[] rightArray = new int[length - middle];

		// Copy the elements of the original array to the left and the right arrays
		int leftArrayIndex = 0; // index for the left array
		int rightArrayIndex = 0; // index for the right array

		for (; leftArrayIndex < length; leftArrayIndex++) {
			if (leftArrayIndex < middle) {
				// Copy the element from the original array to the left array
				leftArray[leftArrayIndex] = array[leftArrayIndex];
			} else {
				// Else, copy the element to the right array
				rightArray[rightArrayIndex] = array[leftArrayIndex];
				rightArrayIndex++;
			}
		}

		mergeSort(leftArray);
		mergeSort(rightArray);

		merge(leftArray, rightArray, array);
	}

	private static void merge(int[] leftArray, int[] rightArray, int[] array) {
		// Cache the size of the left array and the right array with some local
		// variables
		int leftSize = array.length / 2;
		int rightSize = array.length - leftSize;

		// indices for the individual arrays
		int arrayIndex = 0, leftArrayIndex = 0, rightArrayIndex = 0;

		// check the conditions for merging
		while (leftArrayIndex < leftSize && rightArrayIndex < rightSize) { // while there's elements within both our
																			// left array and our right array, we will
																			// continue adding elements to our original
																			// array
			// check to see which element is smaller
			if (leftArray[leftArrayIndex] < rightArray[rightArrayIndex]) {
				// copy the element from the leftArray over to the original array
				// in other words, we are comparing the value in the left array with the value
				// in the rightArray and adding whatever number is smaller to the original array
				array[arrayIndex] = leftArray[leftArrayIndex];
				arrayIndex++;
				leftArrayIndex++;
			} else {
				array[arrayIndex] = rightArray[rightArrayIndex];
				arrayIndex++;
				rightArrayIndex++;
			}
		}

		// There's probably going to be one element remaining that we cannot compare to
		// another element because there's only one left, so we are writing the
		// following while loop for this condition
		while (leftArrayIndex < leftSize) {
			array[arrayIndex] = leftArray[leftArrayIndex];
			arrayIndex++;
			leftArrayIndex++;
		}

		// another loop for the remaining elements in the right array
		while (rightArrayIndex < rightSize) {
			array[arrayIndex] = rightArray[rightArrayIndex];
			arrayIndex++;
			rightArrayIndex++;
		}
	}
}
