public class ArrayStructures {

	private int[] theArray = new int[50];

	private int arraySize = 10;

	public void generateRandomArray() {
		for (int index = 0; index < arraySize; index++) {
			theArray[index] = (int) (Math.random() * 10) + 10;
		}
	}

	public void printArray() {
		System.out.println("----------");

		for (int index = 0; index < arraySize; index++) {
			System.out.print("| " + index + " | ");
			System.out.println(theArray[index] + " |");

			System.out.println("----------");
		}
	}

	public int getValueAtIndex(int index) {
		if (index < arraySize)
			return theArray[index];

		return 0;
	}

	public boolean doesArrayContainThisValue(int searchValue) {

		boolean valueInArray = false;

		for (int index = 0; index < arraySize; index++) {
			if (theArray[index] == searchValue) {
				valueInArray = true;
			}
		}

		return valueInArray;
	}

	public void deleteIndex(int index) {
		if (index < arraySize) {
			for (int arrayIndex = index; arrayIndex < (arraySize - 1); arrayIndex++) {
				theArray[arrayIndex] = theArray[arrayIndex + 1];
			}
			arraySize--;
		}
	}

	public void insertValue(int value) {
		if (arraySize < 50) {
			theArray[arraySize] = value;
			arraySize++;
		}
	}

	public String linearSearchForValue(int value) {
		boolean valueInArray = false;

		String indexesWithValue = "";

		for (int index = 0; index < arraySize; index++) {
			if (theArray[index] == value) {
				valueInArray = true;
				indexesWithValue += index + " ";
			}

			printHorizontalArray(index, -1);
		}

		if (!valueInArray) {
			indexesWithValue = "None";
		}

		System.out.print("The value was found in the following : " + indexesWithValue);

		System.out.println();

		return indexesWithValue;
	}

	// Binary search is quicker than linear search because all the values are
	// sorted in ascending order. Once you get to a number that is larger than what
	// you are looking for, stop the search. The binary search isn't going to work
	// quite well when there are duplicate numbers, because it is only going to find
	// the first match
	public void binarySearchForValue(int value) {
		int lowIndex = 0;
		int highIndex = arraySize - 1;

		while (lowIndex <= highIndex) {

			int middleIndex = (highIndex + lowIndex) / 2;

			if (theArray[middleIndex] < value)
				lowIndex = middleIndex + 1; // search in the upper half of the array
			else if (theArray[middleIndex] > value)
				highIndex = middleIndex - 1; // search in the lower half of the array
			else {
				System.out.println("\n Found a match for " + value + " at index " + middleIndex);
				lowIndex = highIndex + 1; // to break out of the while loop
			}

			printHorizontalArray(middleIndex, -1); // -1 is passed when you want to ignore a certain index. This will
													// print out the current location of the middleIndex at the bottom
													// of the array
		}
	}

	public void printHorizontalArray(int index1, int index2) {
		for (int iteration = 0; iteration < 51; iteration++)
			System.out.print("-");

		System.out.println();

		for (int number = 0; number < arraySize; number++) {
			System.out.print("| " + number + "  ");
		}

		System.out.println("|");

		for (int iteration = 0; iteration < 51; iteration++)
			System.out.print("-");

		System.out.println();

		for (int index = 0; index < arraySize; index++) {
			System.out.print("| " + theArray[index] + " ");
		}

		System.out.println("|");

		for (int iteration = 0; iteration < 51; iteration++)
			System.out.print("-");

		System.out.println();

		// End of the first part

		// Added for bubble sort
		// The two if conditions below are used to print the indexes below a specific
		// element in the array
		if (index2 != -1) {
			// Add the +2 to fix spacing
			// We are multiplying by 5 since printing a single element, for example | 17
			// takes up 5 spaces
			for (int iteration = 0; iteration < ((index2 * 5) + 2); iteration++)
				System.out.print(" ");
			System.out.print(index2);
		}

		if (index1 != -1) {
			// Add the -1 to fix spacing
			for (int iteration = 0; iteration < (5 * (index1 - index2) - 1); iteration++)
				System.out.print(" ");

			System.out.print(index1);
		}

		System.out.println();
	}

	public void bubbleSort() {
		// Bubble sort will sort everything from smallest to largest, or largest to
		// smallest which is achieved by changing a certain fragment of code

		for (int higherIndex = arraySize - 1; higherIndex > 1; higherIndex--) {
			for (int lowerIndex = 0; lowerIndex < higherIndex; lowerIndex++) {
				if (theArray[lowerIndex] > theArray[lowerIndex + 1]) { // for the ascending order
//				if (theArray[index2] < theArray[index2 + 1]) { // for the descending order
					swapValues(lowerIndex, lowerIndex + 1);

					printHorizontalArray(higherIndex, lowerIndex);
				}

				printHorizontalArray(higherIndex, lowerIndex);
			}
		}

	}

	// The selection sort algorithm is going to save a number in a minimum spot as
	// it finds it, and then repeats searching through the entire array each time,
	// to slowly put the whole entire array in order
	public void selectionSort() {
		for (int lastUnsortedIndex = 0; lastUnsortedIndex < arraySize; lastUnsortedIndex++) {
			int minimumIndex = lastUnsortedIndex;

			for (int index = lastUnsortedIndex; index < arraySize; index++) {
				if (theArray[minimumIndex] > theArray[index]) { // to sort in the ascending order
//				if (theArray[minimumIndex] < theArray[secondIndex]) { // to sort in the descending order
					minimumIndex = index;
				}
			}

			swapValues(lastUnsortedIndex, minimumIndex);

			printHorizontalArray(lastUnsortedIndex, -1);
		}
	}

	/*
	 * The insertion sort is normally the best of all the elementary sorts. However,
	 * unlike the other sorts in which at any one point in time where there is going
	 * to be a group or a part of the array that is sorted. IN case of the insertion
	 * sort, that not going to be true, or atleast not definitely going to be true
	 * 
	 * Insertion sort basically searches through the array, finds the minimum, and
	 * puts it precisely into place, skipping multiple different indexes
	 */
	public void insertionSort() {
		for (int firstUnsortedIndex = 1; firstUnsortedIndex < arraySize; firstUnsortedIndex++) {

			int arrayIndex = firstUnsortedIndex; // used to traverse the array from right to left

			int valueToInsert = theArray[firstUnsortedIndex];

			while ((arrayIndex > 0) && (theArray[arrayIndex - 1] > valueToInsert)) {
				theArray[arrayIndex] = theArray[arrayIndex - 1];
				arrayIndex--;

				printHorizontalArray(firstUnsortedIndex, arrayIndex);
			}

			theArray[arrayIndex] = valueToInsert;

			printHorizontalArray(firstUnsortedIndex, arrayIndex);

			System.out.println("\nArray[firstUnsortedIndex] = " + theArray[firstUnsortedIndex] + "; Array[arrayIndex] = "
					+ theArray[arrayIndex] + "; valueToInsert = " + valueToInsert);
		}
	}

	public void swapValues(int indexOne, int indexTwo) {
		int temporaryVariable = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temporaryVariable;
	}

	public static void main(String[] args) {
		ArrayStructures newArray = new ArrayStructures();

		newArray.generateRandomArray();

		newArray.printHorizontalArray(-1, -1);

//		newArray.linearSearchForValue(10);

//		newArray.bubbleSort();

//		newArray.binarySearchForValue(11);

//		newArray.selectionSort();

		newArray.insertionSort();
	}
}