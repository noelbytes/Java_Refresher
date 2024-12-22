//  The big O notation is not always a measure of speed, but instead, a measure of how well an algorithm scales, as the amount of data involved increases

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
	static long endTime;

	private BigONotation(int size) {
		arraySize = size;
		theArray = new int[arraySize];
	}

	public static void main(String[] args) {
		BigONotation testAlgorithm1 = new BigONotation(100000);
//		BigONotation testAlgorithm1 = new BigONotation(10000);
		testAlgorithm1.generateRandomArray();

		BigONotation testAlgorithm2 = new BigONotation(200000);
//		BigONotation testAlgorithm2 = new BigONotation(20000);
		testAlgorithm2.generateRandomArray();

		BigONotation testAlgorithm3 = new BigONotation(300000);
		testAlgorithm3.generateRandomArray();

		/*
		 * testAlgorithm1.linearSearchForValue(20);
		 * testAlgorithm2.linearSearchForValue(20);
		 * testAlgorithm3.linearSearchForValue(20);
		 */

		/*
		 * testAlgorithm1.bubbleSort(); testAlgorithm2.bubbleSort();
		 */

		/*
		 * testAlgorithm1.binarySearchForValue(20);
		 * testAlgorithm2.binarySearchForValue(20);
		 */

		startTime = System.currentTimeMillis();
		testAlgorithm3.quickSort(0, testAlgorithm1.itemsInArray);
		endTime = System.currentTimeMillis();
		System.out.println("Quick sort took - " + (endTime - startTime) + "ms");
	}

	/*
	 * O(1) - This notation indicates an algorithm that executes in the same amount
	 * of time regardless of the amount of data, or in other words, it's going to be
	 * code that executes in the same amount of time no matter how big the array is
	 */
	public void addItemToArray(int newItem) {
		/*
		 * Here, it doesn't matter if it is a 10,000 order array, or a 5 item array, it
		 * is going to perform in exactly the same way. Hence, this algorithm executes
		 * in the order of 1 O(1)
		 */
		theArray[itemsInArray++] = newItem;
	}

	/*
	 * O(N) - This is an algorithm that's time to complete is going to grow in
	 * direct proportion to the amount of data, and a perfect example of that would
	 * be a linear search. The reason why a linear search is great for this is to
	 * find all values that match what we are searching for - we will have to look
	 * in exactly each item in the array. So that would make a big difference if it
	 * was a 10 item array vs a 100,000 item array
	 * 
	 * Worst case scenario: If the item doesn't exist, we would still have to search
	 * through each and every element in the array. This would also be the same for
	 * a value that's at the end of the array
	 * 
	 * As the number of elements in the array scale, i.e. the number of elements
	 * that we will have to deal with, the search time is in direct relation to the
	 * number of elements, and that is why it is known as order of N
	 */

	public void linearSearchForValue(int value) {
		boolean valueInArray = false;
		String indexesWithValue = "";

		startTime = System.currentTimeMillis();

		for (int index = 0; index < arraySize; index++) {
			if (theArray[index] == value) {
				valueInArray = true;
				indexesWithValue += index + " ";
			}
		}

		System.out.println("Value Found: " + valueInArray);
		endTime = System.currentTimeMillis();
		System.out.println("Linear search took : " + (endTime - startTime));

	}

	/*
	 * O(N^2) - This just means that the time to complete will be proportional to
	 * the square of the amount of data, and a perfect example of that would be the
	 * bubble sort, and this normally happens with algorithms just like the bubble
	 * sort that have nested iterations, and this will dramatically hamper
	 * performance as the number of items that we will have to deal with increases,
	 * and the reason why is each pass-through our outer loop is actually going to
	 * require us to go through the entire list again.
	 * 
	 * So one trip through the loop is going to work out to O(N), but we're going to
	 * then have to go through the loop again for every single item in the
	 * inner-loop, and that is why you get into a situation where it becomes O(N^2)
	 * 
	 * Algorithms of the order of N^2, i.e. O(/N^2) are bad and are to be avoided
	 * when optimizations are available
	 */
	private void bubbleSort() {
		startTime = System.currentTimeMillis();

		for (int outerIndex = arraySize - 1; outerIndex > 1; outerIndex--) {
			for (int innerIndex = 0; innerIndex < outerIndex; innerIndex++) {
				if (theArray[innerIndex] > theArray[innerIndex + 1]) {
					swapValues(innerIndex, innerIndex + 1);
				}
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("BubbleSort took - " + (endTime - startTime) + "ms");
	}

	private void swapValues(int index1, int index2) {
		int tempValue = theArray[index1];
		theArray[index1] = theArray[index2];
		theArray[index2] = tempValue;
	}

	/*
	 * O(logN) - This is going to occur when data being used is decreased roughly by
	 * 50% each time through the algorithm, and the binary search algorithm is a
	 * perfect example of this, and it's pretty fast because as logN increases or N
	 * specifically increases, the increase in logN in comparison to just N is going
	 * to be dramatically different. N is going to increase at a dramatically faster
	 * rate than logN will, and that is why logN algorithms are very efficient
	 * because increasing the amount of data has little to no effect at some point
	 * early on because the amount of data is halved each time as we have previously
	 * seen with the binary search.
	 * 
	 * The only downside with binary search is that the array should be sorted first
	 * in order to apply the algorithm
	 */
	public void binarySearchForValue(int value) {
		System.out.println("----------------------------------------------------------");
		/*
		 * Because of how efficient the O(logN) algorithms are, timing these algorithms
		 * doesn't really matter because there isn't going to be a dramatic difference
		 * in speed when the dataset for these type of algorithms increases -
		 * dramatically even, it will be almost no effect
		 */
		startTime = System.currentTimeMillis();

		int lowIndex = 0;
		int highIndex = arraySize - 1;

		int timesThrough = 0;

		while (lowIndex <= highIndex) {
			int middleIndex = (highIndex + lowIndex) / 2; // This is the part where we are making it all efficient,
															// since we are constantly cutting the amount of data by
															// half each time we run through it

			if (theArray[middleIndex] < value) {
				lowIndex = middleIndex + 1;
			} else if (theArray[middleIndex] > value) {
				highIndex = middleIndex - 1;
			} else {
				System.out.println("Found a match in index " + middleIndex);
				lowIndex = highIndex + 1;
			}

			timesThrough++; // This will keep a track of the number of times we went through this whole
							// entire process
		}

		endTime = System.currentTimeMillis();
		System.out.println("Binary Search took - " + (endTime - startTime) + "ms");
		System.out.println("Times through " + timesThrough);
		System.out.println("----------------------------------------------------------");
	}

	// O(NlogN)
	/*
	 * Sorts in the past have normally, always been at the very least of the order
	 * of N, i.e. O(N), and the reason why is because to properly sort a list of
	 * elements in an array, we have to look at every single element in the array at
	 * least one time, so that's the absolute minimum.
	 * 
	 * However, what we want to try to avoid is something inefficient like O(N^2),
	 * which is what we had with the bubble sort.
	 * 
	 * We already know that the quick sort is efficient, but the main answer is
	 * going to be, why is it so efficient?
	 * 
	 * To figure out the number of comparisons that we need to make with the quick
	 * sort, we first need to remember that it is comparing and moving values very
	 * efficiently without shifting, unlike the other sorting algorithms that we've
	 * used in the past, and that means that values are only going to be compared
	 * once. They're not going to be compared to each other over and over again. So
	 * in essence, each comparison will reduce the possible final sorted list in
	 * half.
	 * 
	 * In other words: 
	 * --------------------- 
	 * Number of comparisons = logN! or
	 * Comparisons = logN + log(N - 1) + ........ + log(1) 
	 * If we actually look at this, and sort it down, in actuality, we can also see that comparisons is
	 * also going to be equal to - NlogN Comparisons = NlogN
	 * 
	 * Quick Sort in a Nutshell: 
	 * Pick a Pivot: Choose one element from the array (e.g., the last element). 
	 * Partition: Rearrange the array so that: 
	 * Elements smaller than the pivot go to its left. Elements larger go to its right.
	 * Repeat: Recursively apply this to the left and right parts. 
	 * 
	 * Why 𝑂 ( 𝑁 log ⁡𝑁 )? 
	 * Partitioning Takes 𝑂 ( 𝑁 ):
	 * Each partition step goes through the array once to rearrange elements. 
	 * 
	 * Divide and Conquer Takes log ⁡𝑁:
	 * After each partition, the array is split into two smaller subarrays. The
	 * splitting continues until the subarrays are very small (usually 1 element).
	 * 
	 * Combine These Steps:
	 * Since you do O(N) work (partitioning) logN times (splitting), the total time is O(NlogN). 
	 * 
	 * Quick Example: 
	 * For an array with 8 elements:
	 * First split: 8 elements → 𝑂 ( 8 ). 
	 * Second split: Two subarrays with 4 elements each → 𝑂 ( 4 + 4 ). 
	 * Third split: Four subarrays with 2 elements each → 𝑂 ( 2 + 2 + 2 + 2 ). 
	 * Total: 𝑂 ( 8 + 4 + 4 + 2 + 2 + 2 + 2 ) O(8+4+4+2+2+2+2), which simplifies to O(8⋅log8). (i.e. log(base2)8)
	 * 
	 * Why is Quick Sort Fast? 
	 * 
	 * Balanced Splits: When the pivot splits the array into two roughly equal parts, it achieves 𝑂 (𝑁 log 𝑁).
	 * 
	 * If splits are unbalanced (e.g., always one element on one side), it could
	 * degrade to 𝑂 ( 𝑁^2 ). But this is rare with good pivot selection.
	 */
	private void quickSort(int leftIndex, int rightIndex) {

		if (rightIndex - leftIndex <= 0) {
			return; // i.e the array has been sorted
		} else {
			int pivot = theArray[rightIndex];

			int pivotLocation = partitionArray(leftIndex, rightIndex, pivot);

			// Partition parts of the array, each time we cycle through
			quickSort(leftIndex, pivotLocation - 1);
			quickSort(pivotLocation + 1, rightIndex);
		}

	}

	private int partitionArray(int leftIndex, int rightIndex, int pivot) {
		int leftPointer = leftIndex - 1;
		int rightPointer = rightIndex;

		while (true) {
			while (theArray[++leftPointer] < pivot)
				;

			while (rightPointer > 0 && theArray[--rightPointer] > pivot)
				;

			if (leftPointer >= rightPointer) {
				break; // break out of the loop
			} else {
				swapValues(leftPointer, rightPointer);
			}
		}

		swapValues(leftPointer, rightIndex);
		return leftPointer;
	}

	public void generateRandomArray() {
		for (int index = 0; index < arraySize; index++) {
			theArray[index] = (int) (Math.random() * 1000) + 10;
		}
		itemsInArray = arraySize - 1;
	}
}
