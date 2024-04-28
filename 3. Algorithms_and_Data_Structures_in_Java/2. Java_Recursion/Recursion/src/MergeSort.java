import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] array = { 10, 8, 4, 80, 13, 1, 3, 11 };

		System.out.println("STARTING ARRAY\n");

		printHorizontalArray(array, 49);

		System.out.println();

		// Send the array, 0 and the array size
		mergeSort(array, 0, array.length - 1);

		System.out.println("\nFINAL SORTED ARRAY");
		printHorizontalArray(array, 49);
	}

	// Receives the array, 0 and the array size
	public static void mergeSort(int array[], int lowerArrayIndex, int higherArrayIndex) {
		int lowerIndex = lowerArrayIndex;
		int higherIndex = higherArrayIndex;

		// Base case
		if (lowerIndex >= higherIndex) {
			return;
		}

		// Find the middle index of the array
		int middleIndex = (lowerIndex + higherIndex) / 2;

		// CREATE TWO ARRAYS FROM THE ONE
		// Send the array, 0 and the middle index of the array
		mergeSort(array, 0, middleIndex);

		// Send the array, the middle index + 1 and the highest index of the array
		mergeSort(array, middleIndex + 1, higherIndex);

		// Store the last index of the first array
		int lastIndexOfTheFirstArray = middleIndex;

		// Store the first index of the second array
		int firstIndexOfTheSecondArray = middleIndex + 1;

		// If the lowest index is less than or equal to the bottom arrays highest index
		// and the lowest index of the 2nd array is less than or equal to it's highest
		// index
		while ((lowerArrayIndex <= lastIndexOfTheFirstArray) && (firstIndexOfTheSecondArray <= higherIndex)) {

			System.out.println("\nBOTTOM ARRAY");
			printSmallArray(array, lowerArrayIndex, middleIndex);

			System.out.println("\nTOP ARRAY");
			printSmallArray(array, firstIndexOfTheSecondArray, higherIndex);

			printHorizontalArray(array, 49);

			// If the value in the first index of the first array is less than the value in
			// the first index of the second array
			System.out.println("Is " + array[lowerIndex] + " < " + array[firstIndexOfTheSecondArray] + "? "
					+ (array[lowerIndex] < array[firstIndexOfTheSecondArray]));

			if (array[lowerIndex] < array[firstIndexOfTheSecondArray]) {
				// Increment to the next index in the 1st array
				lowerIndex++;
			} else {
				// Store the value in the 1st index of the second array
				int temporaryValue = array[firstIndexOfTheSecondArray];
				System.out.println("Temp: " + temporaryValue);

				// Decrement backwards through the first array starting at the last index in the
				// first array
				for (int index = firstIndexOfTheSecondArray - 1; index >= lowerIndex; index--) {
					System.out.println(
							"array[" + index + "] = " + array[index] + " Stored in array index " + (index + 1));
					array[index + 1] = array[index];
				}

				System.out.println(temporaryValue + " is stored in index " + lowerIndex);

				printHorizontalArray(array, 49);

				array[lowerIndex] = temporaryValue;
				lowerIndex++;
				lastIndexOfTheFirstArray++;
				firstIndexOfTheSecondArray++;
			}
		}

		printHorizontalArray(array, 49);
	}

	// Used to print out the smaller arrays
	static void printSmallArray(int theArray[], int lowerArrayIndex, int higherArrayIndex) {
		int[] temporaryArray = Arrays.copyOfRange(theArray, lowerArrayIndex, higherArrayIndex);
		int temporaryArrayDashes = temporaryArray.length * 6;
		System.out.println("Array Index Start " + lowerArrayIndex + " and End " + higherArrayIndex);
		printHorizontalArray(temporaryArray, temporaryArrayDashes);
	}

	static void printHorizontalArray(int theArray[], int numberOfDashes) {
		for (int iteration = 0; iteration < numberOfDashes; iteration++) {
			System.out.print("-");
		}

		System.out.println();

		for (int index = 0; index < theArray.length; index++) {
			System.out.format("| %2s " + " ", index);
		}

		System.out.println("|");

		for (int iteration = 0; iteration < numberOfDashes; iteration++) {
			System.out.print("-");
		}

		System.out.println();

		for (int index = 0; index < theArray.length; index++) {
			System.out.print(String.format("| %2s " + " ", theArray[index])); // here, the %2s ensures that each element
																				// takes up at least 2 characters of
																				// space when printed. If an element
																				// requires less than 2 characters, it's
																				// padded with spaces.
		}

		System.out.println("|");

		for (int iteration = 0; iteration < numberOfDashes; iteration++) {
			System.out.print("-");
		}

		System.out.println();
	}
}
