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
		if (index2 != -1) {
			// Add the +2 to fix spacing
			for (int index3 = 0; index3 < ((index2 * 5) + 2); index3++)
				System.out.print(" ");
			System.out.print(index2);
		}

		if (index1 != -1) {
			// Add the -1 to fix spacing
			for (int index3 = 0; index3 < (5 * (index1 - index2) - 1); index3++)
				System.out.print(" ");

			System.out.print(index1);
		}

		System.out.println();
	}

	public void bubbleSort() {
		// Bubble sort will sort everything from smallest to largest or largest to
		// smallest by changing a certain fragment of code
		
		for (int index1 = arraySize - 1; index1 > 1; index1--) {
			for (int index2 = 0; index2 < index1; index2++) {
				if (theArray[index2] > theArray[index2 + 1]) {
					swapValues(index2, index2 + 1);
					
					printHorizontalArray(index1, index2);
				}
				
				printHorizontalArray(index1, index2);
			}
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

//		newArray.printHorizontalArray(-1, -1);

//		newArray.linearSearchForValue(10);
		
		newArray.bubbleSort();
	}
}