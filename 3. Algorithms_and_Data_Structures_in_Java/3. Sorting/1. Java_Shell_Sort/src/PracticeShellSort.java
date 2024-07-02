import java.util.Arrays;

public class PracticeShellSort {

	private int[] array;
	private int arraySize;

	private PracticeShellSort(int arraySize) {
		this.arraySize = arraySize;
		array = new int[arraySize];
		generateRandomArray();
	}

	private void generateRandomArray() {
		for (int index = 0; index < arraySize; index++) {
			array[index] = (int) (Math.random() * 50) + 10;
		}
	}

	private void shellSort() {
		int innerIndex, outerIndex, temporaryValue;
		int interval = 1;

		while (interval <= arraySize / 3) {
			interval = interval * 3 + 1;
		}

		while (interval > 0) {
			for (outerIndex = interval; outerIndex < arraySize; outerIndex++) {
				System.out.println("Copy " + array[outerIndex] + " into the temporaryValue variable");
				temporaryValue = array[outerIndex];

				innerIndex = outerIndex;

				System.out.println("Checking if " + array[innerIndex - interval] + " in the index "
						+ (innerIndex - interval) + " is greater than the value in the temporaryValue variable");

				while (innerIndex > interval - 1 && array[innerIndex - interval] >= temporaryValue) {
					System.out.println("Inside the while loop - Checking if " + array[innerIndex - interval]
							+ " in the index " + (innerIndex - interval) + " is greater than " + temporaryValue);
					
					printHorizontalArray(innerIndex, outerIndex, interval);
					
					array[innerIndex] = array[innerIndex - interval];
					System.out.println(array[innerIndex - interval] + " has been moved to position " + innerIndex);
					
					innerIndex = innerIndex - interval;
					System.out.println("innerIndex = " + innerIndex);
					
					printHorizontalArray(innerIndex, outerIndex, interval);
					
					System.out.println("outerIndex = " + outerIndex);
					System.out.println("temporaryValue = " + temporaryValue);
					System.out.println("interval = " + interval);
				}

				array[innerIndex] = temporaryValue;
				System.out.println(
						temporaryValue + " in the index " + outerIndex + " has moved to the index " + innerIndex);
				printHorizontalArray(innerIndex, outerIndex, interval);
				
			}
			
			interval = (interval - 1) / 3;
		}
	}

	private void printHorizontalArray(int innerIndex, int outerIndex, int interval) {
		int spacesBeforeFront, spacesBeforeRear;

		if (innerIndex == outerIndex) {
			innerIndex = innerIndex - interval;
		}

		for (int iteration = 0; iteration < (arraySize * 5 + 1); iteration++) {
			System.out.print("-");
		}

		System.out.println();

		for (int index = 0; index < arraySize; index++) {
			System.out.format("| %2s ", index);
		}

		System.out.println("|");

		for (int iteration = 0; iteration < (arraySize * 5 + 1); iteration++) {
			System.out.print("-");
		}

		System.out.println();

		for (int index = 0; index < arraySize; index++) {
			System.out.print("| " + array[index] + " ");
		}

		System.out.println("|");
		
		for (int iteration = 0; iteration < (arraySize * 5) + 1; iteration++) {
			System.out.print("-");
		}
		
		System.out.println();

		if (innerIndex != -1) {
			spacesBeforeFront = (innerIndex * 5) + 2;

			for (int iteration = 0; iteration < spacesBeforeFront; iteration++) {
				System.out.print(" ");
			}

			System.out.print("I");

			spacesBeforeRear = (outerIndex * 5 + 2) - spacesBeforeFront;

			for (int iteration = 0; iteration < spacesBeforeRear; iteration++) {
				System.out.print(" ");
			}

			System.out.println("O");
		}
	}

	public static void main(String[] args) {
		PracticeShellSort practiceShellSortReference = new PracticeShellSort(10);
		System.out.println(Arrays.toString(practiceShellSortReference.array));

		practiceShellSortReference.shellSort();
	}
}
