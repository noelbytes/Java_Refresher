/*The Shell Sort partially sorts the array by sorting elements that are a certain 
 * number of spaces apart called the interval
 * The index to the left will be referred to as the inner index, and h -  will be representing the interval, 
 * or number of spaces apart, and this is also known as the outer part of the array when using the shell sort. 
 * The performance of the shell sort algorithm improves when compared to the insertion sort algorithm, 
 * since we eliminate the need to shift many indexes in the array. */

import java.util.Arrays;

public class ShellSort {

	private int[] theArray;
	private int arraySize;

	ShellSort(int arraySize) {
		this.arraySize = arraySize;
		theArray = new int[arraySize];
		generateRandomArray();
	}

	public void generateRandomArray() {
		for (int index = 0; index < arraySize; index++) {
			theArray[index] = (int) (Math.random() * 50) + 10;
		}
	}

	public void sort() {
		int inner, outer, temp;
		int interval = 1; // spaces between the different indexes that we are comparing
		while (interval <= arraySize / 3) {
			interval = interval * 3 + 1; // this will change depending on the size of the array to improve performance

			while (interval > 0) {
				// this loop will continue to run until this becomes an insertion sort
				for (outer = interval; outer < arraySize; outer++) { // increment the index labeled as outer until the
																		// end of the array is reached
					temp = theArray[outer]; // store the value of the array in a temp unless it has to be copied to a
											// space that was previously occupied by a bigger number closer to the
											// beginning of the array

					System.out.println("Copy " + theArray[outer] + " into temp");

					inner = outer; // assign the value of the highest index to check against all values that
									// preceed it

					System.out.println("Checking if " + theArray[inner - interval] + " in index " + (inner - interval)
							+ " is bigger than temp");

					while (inner > interval - 1 && theArray[inner - interval] >= temp) {
						// loop when there is a number bigger than temp that is further up in the array
						// - continue to swap elements
						System.out.println("In while checking if " + theArray[inner - interval] + " in index "
								+ (inner - interval) + " is bigger than " + temp);

					}
				}
			}
		}
	}

	public static void main(String[] args) {
		ShellSort theSort = new ShellSort(10);

		System.out.println(Arrays.toString(theSort.theArray));

		theSort.sort();

		System.out.println(Arrays.toString(theSort.theArray));
	}
}
