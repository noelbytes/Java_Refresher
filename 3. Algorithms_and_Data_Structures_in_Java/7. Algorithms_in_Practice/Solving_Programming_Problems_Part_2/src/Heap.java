/* What is a heap? 
 * It is a data structure which is like a tree, but is implemented as an array 
 * */

public class Heap {
	
	private Data[] theHeap;
	private int itemsInArray = 0;
	private int maxSize;
	
	public Heap(int maxSize) {
		this.maxSize = maxSize;
		theHeap = new Data[maxSize];
	}
	
	/**
	 * This method will insert values into the array
	 * @param index - the index where you would like to insert data
	 * @param newData - The data object that is to be inserted
	 */
	private void insert(int index, Data newData) {
		theHeap[index] = newData;
		itemsInArray++; // Since we've added a new item, increment the number of items in the array
	}
	
	/**
	 * This method will fill the heap with numbers
	 * @param randomNumber - 
	 */
	private void generateFilledArray(int randomNumber) {
		Data randomData;
		for (int index = 0; index < this.maxSize; index++) {
			// Generate random data based off of the random number that was passed
			randomData =  new Data((int) (Math.random() * randomNumber) + 1);
			
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
		 * next row, followed by 4 in the next row, followed by 8 in the next row. 1, 2, 4, 8 
		 * 
		 * --> Structure
		 * 
		 * _______1
		 * ___1_______1
		 * _1___1___1___1 
		 * 1_1_1_1_1_1_1_1
		 * 
		 * 1st Row Indent - 7; Spaces - 0 (since we only have one number) 
		 * 2nd Row Indent- 3; Spaces - 7 
		 * 3rd Row Indent - 1; Spaces - 3 
		 * 4th Row Indent - 0; Spaces - 1
		 * 
		 * How are we going to model it? 
		 * We need to calculate Indent i.e. figure out a way to calculate 7, 3, 1, and 0 
		 * --> The equation can be obtained from this website - https://www.wolframalpha.com/ 
		 * --> Just type in the sequence 7, 3, 1, 0 and search for it 
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
		 * Indent Number 
		 * Indent Number Space Number 
		 * Indent Number Space Number Space Number Space Number
		 */

		int spaces = 0;
		int iterator = 1;

		// Keep printing things out as long as you have rows
		while (iterator <= rows) {
			int indent = (int) Math.abs(Math.pow(2, -iterator) * (Math.pow(2, iterator) - 16));

			// This will be the first index of the array to print on every row
			int indexToPrint = (int) (0.5 * (Math.pow(2, iterator) - 2));

			int itemsPerRow = (int) Math.pow(2, iterator - 1);

			// Calculate the maximum index of the array that can be printed in that row
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
		System.out.println("OLD TREE");
		Heap newHeap = new Heap(70);
		newHeap.generateFilledArray(90);
		newHeap.printTree(6);
	}
}

class Data {
	public int key;
	
	public Data(int key) {
		this.key = key;
	}
}