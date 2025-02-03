/* 
 * What is a Heap?
 * ----------------
 * --> A heap is kind of like a tree, but it is normally implemented as an array
 * --> All the rows need to be complete, meaning there is an item in each one of the nodes, except for in the last row. 
 * --> Parent keys are always bigger than their children.
 * --> Unlike a binary tree, the left child isn't always less than the right child.
 * --> They can also contain duplicates as well
 * 
 * Why do we use heaps?
 * -------------------------
 * --> Very fast at insertion and deletion.
 * --> Very slow at traversal and searching.
 * --> They are particularly quick when regards to sorting as seen in Heap Sort. 
 * 
 * 
 * Explanation of `newHeap.maxSize / 2 - 1` and `while (index < itemsInArray / 2)`
 * -------------------------------------------------------------------------------
 *
 * 1. newHeap.maxSize / 2 - 1 (used in the for-loop)
 * -------------------------------------------------
 * This expression is used to start heapifying from the last non-leaf node 
 * and work up to the root. In a complete binary heap stored as an array:
 * - Nodes at indices 0 to (size/2 - 1) are internal nodes (having children).
 * - Nodes at indices (size/2) to (size - 1) are leaf nodes (no children).
 * 
 * The last non-leaf node is located at index `maxSize / 2 - 1`.
 * The loop ensures heapification is done bottom-up to satisfy the heap property.
 *
 * Example calculation (if maxSize = 7):
 * 7 / 2 = 3, subtracting 1 gives index 2 (last internal node to start heapification).
 *
 * 2. while (index < itemsInArray / 2) (used in heapTheArray method)
 * ----------------------------------------------------------------
 * This loop ensures that the process of moving down (sifting down) in the heap 
 * stops when the index reaches the last internal node.
 * 
 * Internal nodes are those that have children, and in a complete binary tree:
 * - Internal nodes are in indices 0 to (itemsInArray / 2 - 1).
 * - Leaf nodes are in indices (itemsInArray / 2) to (itemsInArray - 1).
 *
 * The condition `index < itemsInArray / 2` ensures that swaps and comparisons 
 * occur only where valid children exist.
 *
 * Example calculation (if itemsInArray = 7):
 * 7 / 2 = 3, meaning internal nodes are at indices 0, 1, 2, and 
 * leaf nodes start from index 3 onward.
 *
 * These calculations leverage the array-based representation of a binary heap where:
 * - Parent at index `i` has children at indices `2*i + 1` (left) and `2*i + 2` (right).
 * - Leaf nodes start from index `size / 2`.
 *
 * Both expressions contribute to the efficiency of heap operations.
 * 
 */


import java.util.Arrays;

public class Heap {

	private Data[] theHeap;
	private int itemsInArray = 0, maxSize;

	public Heap(int maxSize) {
		this.maxSize = maxSize;
		theHeap = new Data[maxSize];
	}

	private void insert(int index, Data newData) {
		theHeap[index] = newData;
	}

	/**
	 * This method will increment the number of items in the array
	 */
	private void incrementTheArray() {
		itemsInArray++;
	}

	private Data pop() {

		int tempItemsInArray = itemsInArray - 1;

		// Used to show how data is moved during sorting
		System.out.println("Store " + theHeap[0] + " in root. Store " + theHeap[tempItemsInArray] + " in index 0");

		System.out.println(Arrays.toString(theHeap) + "\n");

		Data root = theHeap[0];
		theHeap[0] = theHeap[--itemsInArray];
		
		System.out.println(Arrays.toString(theHeap));
		// Moving all the values that are greater than, in the bottom, upwards so that
		// all the parents have children that have smaller items inside of them
		heapTheArray(0); // Pass the root position of the array as a parameter

		return root;
	}

	private void printTree(int rows) {
		// Number of spaces between items in the tree
		int spaces = 0, iteration = 1;

		// Generate all of the indents that are needed depending on the number of rows
		// to print
		int[] indent = getIndentArray(rows);

		while (iteration <= rows) {

			// Find first index : 0.5 * (-2 + 2^n)
			int indexToPrint = (int) (0.5 * (-2 + (Math.pow(2, iteration))));

			// Number of items per row: 2^(n-1)
			int itemsPerRow = (int) (Math.pow(2, iteration - 1));

			int maxIndexToPrint = indexToPrint + itemsPerRow;

			// Print the indents needed
			for (int indentCount = 0; indentCount < indent[iteration - 1]; indentCount++) {
				System.out.print(" ");
			}

			// Print all of the index values for each row. indexToPrint represents the first
			// index in the row, while maxIndexToPrint equals the last.
			for (int index = indexToPrint; index < maxIndexToPrint; index++) {

				// If the array isn't fill, don't try to print indexes that don't exist
				if (index < itemsInArray) {
					System.out.print(String.format("%02d", theHeap[index].key));

					for (int spaceCount = 0; spaceCount < spaces; spaceCount++) {
						System.out.print(" ");
					}
				}
			}

			// In a tree, the spaces get bigger in the same way that the indents get smaller
			spaces = indent[iteration - 1];
			iteration++;

			System.out.println();
		}
	}

	/**
	 * Method to calculate each indent per row for the tree, then reverse their
	 * order to go from biggest to smallest
	 * 
	 * @param rows - The number of rows in the tree
	 * @return - an array containing the indents in reverse order
	 */
	private int[] getIndentArray(int rows) {
		int[] indentArray = new int[rows];

		for (int index = 0; index < rows; index++) {
			indentArray[index] = (int) Math.abs(-2 + Math.pow(2, index + 1));
		}

		Arrays.sort(indentArray);
		indentArray = reverseArray(indentArray);
		return indentArray;
	}

	/**
	 * This method will reverse the indent values in the array so that they go from
	 * biggest to smallest
	 * 
	 * @param theArray - The array that contains the indents in ascending order
	 * @return - The inverted array
	 */
	private int[] reverseArray(int[] theArray) {
		// Index of the first element
		int leftIndex = 0;

		// Index of the last element
		int rightIndex = theArray.length - 1;

		while (leftIndex < rightIndex) {
			// Exchange the left and right elements
			int temp = theArray[leftIndex];
			theArray[leftIndex] = theArray[rightIndex];
			theArray[rightIndex] = temp;

			// Move the indexes to check towards the middle
			leftIndex++;
			rightIndex--;
		}

		return theArray;
	}

	/**
	 * This method will fill the heap with random numbers based on the number that
	 * is passed in
	 * 
	 * @param randomNumber - the upper limit for generating random numbers. Random
	 *                     numbers will be in the range [1, randomNumber]
	 */
	private void generateFilledArray(int randomNumber) {
		Data randomData;

		for (int index = 0; index < this.maxSize; index++) {
			randomData = new Data((int) (Math.random() * randomNumber) + 1);
			this.insert(index, randomData);

			// Need to do this in a separate method because later when I sort the array I
			// need to use insert without incrementing the array
			incrementTheArray();
		}
	}

	private void heapTheArray(int index) {
		// Here, we are going to take any situations in which a parent has a child that
		// is larger than it, and move that item that is larger into the parent position
		// and then the item that is in the parent position will be moved down to the
		// child position

		int largestChild;

		Data root = theHeap[index];

		while (index < itemsInArray / 2) {
			int leftChild = 2 * index + 1; // this will get the left child for the index that is passed here
			int rightChild = leftChild + 1; // Get the index for the rightChild

			// If leftChild is less then rightChild save rightChild in largestChild
			if (rightChild < itemsInArray && theHeap[leftChild].key < theHeap[rightChild].key) {
				System.out.println("Put Value " + theHeap[rightChild] + " in largestChild");
				largestChild = rightChild;
			} else {
				System.out.println("Put Value " + theHeap[leftChild] + " in largestChild");

				// Otherwise save leftChild in largestChild
				largestChild = leftChild;
			}

			// If the root is greater than the largest child, don't switch anything
			if (root.key >= theHeap[largestChild].key) {
				break;
			}

			System.out.println("Put Index Value " + theHeap[largestChild] + " in Index " + index);

			// else, the child needs to be moved up or in other words - Save the value in
			// largest child into the top index
			theHeap[index] = theHeap[largestChild];

			index = largestChild;

			System.out.println();

			printTree(4);

			System.out.println();

		}

		theHeap[index] = root;
		System.out.println("Updated tree after the swap operations : ");
		printTree(4);
	}

	/**
	 * This method will pop off all the items in the array so that they go from
	 * smallest to largest
	 * 
	 */
	private void heapSort() {
		for (int index = maxSize - 1; index >= 0; index--) {
			Data largestNode = pop(); // We always know that the largest node is going to be the top part of the tree
										// because that's the way in which sorting works
			insert(index, largestNode);
		
			System.out.println(Arrays.toString(theHeap));
		}
	}

	public static void main(String[] args) {
		
		Heap newHeap = new Heap(7);

		newHeap.generateFilledArray(90);

		// Print out the array before it is sorted
		System.out.println("Original array");
		System.out.println(Arrays.toString(newHeap.theHeap));
		
		System.out.println();

		newHeap.printTree(4);
		System.out.println();

		for (int index = newHeap.maxSize / 2 - 1; index >= 0; index--) {
			newHeap.heapTheArray(index);
		}

		System.out.println("\nHeaped array");
		System.out.println(Arrays.toString(newHeap.theHeap) + "\n");

		newHeap.printTree(4);
		
		System.out.println("Heaped Sorted");
		
		newHeap.heapSort();
		
		// Print the sorted array
		System.out.println("\nSorted Array");
		System.out.println(Arrays.toString(newHeap.theHeap));
	}
}

class Data {

	public int key;

	Data(int key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return Integer.toString(key);
	}
}