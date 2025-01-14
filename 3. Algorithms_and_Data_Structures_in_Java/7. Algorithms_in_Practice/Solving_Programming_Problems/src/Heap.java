
public class Heap {
	private Data[] theHeap;
	private int itemsInArray = 0;
	private int maxSize;

	public Heap(int maxSize) {
		this.maxSize = maxSize;
		theHeap = new Data[maxSize];
	}

	public void insert(int index, Data newData) {
		theHeap[index] = newData;
		itemsInArray++;
	}

	public Data pop() {
		if (itemsInArray != 0) {
			Data root = theHeap[0];
			theHeap[0] = theHeap[--itemsInArray];
			percolate(0);
			return root;
		}
		return null;
	}

	public void percolate(int index) {
		int largeChild;
		Data root = theHeap[index];

		while (index < itemsInArray / 2) { // Only proceed if index is not a leaf
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;

			// Check bounds for rightChild to avoid ArrayIndexOutOfBoundsException
			if (rightChild < itemsInArray && theHeap[leftChild].key < theHeap[rightChild].key) {
				largeChild = rightChild;
			} else {
				largeChild = leftChild;
			}

			// If root is greater or equal to the largest child, we're done
			if (root.key >= theHeap[largeChild].key) {
				break;
			}

			// Move the larger child up
			theHeap[index] = theHeap[largeChild];
			index = largeChild;
		}

		// Place the original root in its correct location
		theHeap[index] = root;
	}

	public void displayTheHeap() {
		for (int index = 0; index < itemsInArray; index++) {
			System.out.println(theHeap[index].key);
		}
	}

	// Fill the heap with random numbers based on the number that is passed in
	public void generateFilledArray(int randomNumber) {
		Data randomData;

		for (int index = 0; index < this.maxSize; index++) {
			randomData = new Data((int) (Math.random() * randomNumber) + 1);

			this.insert(index, randomData);

		}
	}

	public void printTree(int rows) {
		/*
		 * Solving Programming Problems
		 * 
		 * ------------------------------
		 * 
		 * The process of turning a problem into a solution
		 * 
		 * Our problem: Print a tree on the console
		 * 
		 * 4 ROW TREE
		 * 
		 * How are we going to print this tree? 
		 * --> There is going to be a certain number of spaces, so we need to figure out how many indexes we are going to
		 * have 
		 * --> In a tree, we will have one element at the top, 2 elements in the
		 * next row, followed by 4 in the next row, followed by 8 in the next row. 1, 2,
		 * 4, 8 
		 * 
		 * --> Structure
		 * 
		 * _______1
		 * ___1_______1
		 * _1___1___1___1 
		 * 1_1_1_1_1_1_1_1
		 * 
		 * 1st Row Indent - 7; Spaces - 0 (since we only have one number) 2nd Row Indent
		 * - 3; Spaces - 7 3rd Row Indent - 1; Spaces - 3 4th Row Indent - 0; Spaces - 1
		 * 
		 * How are we going to model it? We need to calculate Indent i.e. figure out a
		 * way to calculate 7, 3, 1, and 0 
		 * --> The equation can be obtained from this website - https://www.wolframalpha.com/ --> Just type in the sequence 7, 3,
		 * 1, 0 and search for it 
		 * --> Under the possible sequence identification, look at the formula for the closed form. That will be our algorithm for
		 * calculating and achieving this sequence. 
		 * Indent: -2^-n * (2^n - 16) (n in this situation will start from 1) 
		 * Note: We need an iterator that starts at 1, and we need to go on till there are no more rows.
		 * 
		 * How are we going to calculate spaces? 
		 * The cool thing about generating trees is that what was once the indent then becomes the space, and so forth and so
		 * on. 
		 * Spaces: Start off at 0 and then whatever indent was First Index per row:
		 * (These will be the start indexes of every row) 
		 * 0 
		 * 1 2 
		 * 3 4 5 6 
		 * 7 8 9 10 11 12 13 14 
		 * Formula for calculating the indexes (based on the sequence: 0, 1, 3, 7) : 0.5 * (2^n - 2) (Here, n is the iterator)
		 * 
		 * Number of items per row: 1, 2, 4, 8 Formula: 2^(n -1) (n is the iterator here)
		 * 
		 * Maximum index per row: indexToPrint + itemsPerRow
		 * 
		 * Now, how do we print the following structure?
		 * 
		 * _______1
		 * ___1_______1
		 * _1___1___1___1 
		 * 1_1_1_1_1_1_1_1
		 * 
		 * Indent Number Indent Number Space Number Indent Number Space Number Space
		 * Number Space Number
		 */

		int spaces = 0;
		int iterator = 1;

		// Keep printing things out as long as you have rows
		while (iterator <= rows) {
			int indent = (int) Math.abs(Math.pow(2, -iterator) * (Math.pow(2, iterator) - 16));

			// This will be the first index to print on every row
			int indexToPrint = (int) (0.5 * (Math.pow(2, iterator) - 2));

			int itemsPerRow = (int) Math.pow(2, iterator - 1);

			// Calculate the maximum index to print
			int maxIndexToPrintPerRow = indexToPrint + itemsPerRow;

			for (int spaceCount = 0; spaceCount < indent; spaceCount++) {
				System.out.print(" ");
			}

			for (int index = indexToPrint; index < maxIndexToPrintPerRow; index++) {
				System.out.print(theHeap[index].key);

				for (int spaceCount = 0; spaceCount < spaces; spaceCount++) {
					System.out.print(" ");
				}
			}

			spaces = indent;
			iterator++;

			// End of the row - add a new line
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Heap newHeap = new Heap(15);

		newHeap.generateFilledArray(9);

		for (int index = 4; index >= 0; index--) {
			newHeap.percolate(index);
		}

		newHeap.printTree(4);
	}
}

class Data {

	public int key;

	public Data(int key) {
		this.key = key;
	}
}