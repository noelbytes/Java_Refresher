/* 1. Java Algorithms
 * --> What are algorithms?
 * 	   Steps you take to manipulate data
 * --> Data Structures: The way data is arranged in memory */

public class ArrayStructures {

	private int[] theArray = new int[50];

	private int arraySize = 10; // Here, we are using a fixed size that is less than the size of the array,
								// since we don't want to print out the default values

	public void generateRandomArray() {
		for (int index = 0; index < arraySize; index++) {
			theArray[index] = (int) (Math.random() * 10) + 10; // numbers between 10 and 19
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

		if (index < arraySize) {
			return theArray[index];
		}

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
		/* Linear search will look at every index value in the entire array.
		 * Linear search works better when you want to find all matches instead of one. 
		 * This is very useful when you have duplicates in your array
		 * 
		 *  If you only want to find one match, and if there's no duplicates in your array, 
		 *  then a binary search is going to work better */
		boolean valueInArray = false;

		String indexesWithValue = "";

		System.out.print("The value was found in the following : ");

		for (int index = 0; index < arraySize; index++) {
			if (theArray[index] == value) {
				valueInArray = true;

				System.out.print(index + " ");

				indexesWithValue += index + " ";
			}
		}

		if (!valueInArray) {
			indexesWithValue = "None";

			System.out.println(indexesWithValue);
		}

		System.out.println();

		return indexesWithValue;
	}

	public static void main(String[] args) {

		ArrayStructures newArray = new ArrayStructures();

		newArray.generateRandomArray();

		newArray.printArray();

		System.out.println(newArray.getValueAtIndex(3));

		System.out.println(newArray.doesArrayContainThisValue(18));

		newArray.deleteIndex(4);

		newArray.printArray();

		newArray.insertValue(55);

		newArray.printArray();

		newArray.linearSearchForValue(12);
	}
}
