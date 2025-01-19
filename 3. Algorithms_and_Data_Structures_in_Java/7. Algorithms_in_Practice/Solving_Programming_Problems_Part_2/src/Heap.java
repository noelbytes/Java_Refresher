/* What is a heap? 
 * It is a data structure which is like a tree, but is implemented as an array 
 * */

import java.util.Arrays;

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
	
	public void printNewTree(int rows) {
		/* 4 ROW TREE
		 * _______1
		 * ___1_______1
		 * _1___1___1___1
		 * 1_1_1_1_1_1_1_1
		 * 
		 * 1st Row Indent 7 Spaces 0
		 * 2nd Row Indent 3 Spaces 7
		 * 3rd Row Indent 1 Spaces 3
		 * 4th Row Indent 0 Spaces 1
		 * 
		 * Indent : -2^-n * (-16 + 2^n) start with 1
		 * Spaces: 0 and then whatever indent was
		 * 
		 * First index per row (Not a problem)
		 * 0
		 * 1 2
		 * 3 4 5 6
		 * 7 8 9 10 11 12 13 14
		 * Formula: 0.5 * (-2 + (Math.pow(2, iteration)))
		 * 
		 * Items per row (Not a problem)
		 * 1, 2, 4, 8
		 * Formula: Math.pow(2, iteration - 1)
		 * 
		 * Max index per row (it's dependent on two other variables that are not a problem, hence it is not a problem)
		 * indexToPrint + itemsPerRow
		 * 
		 * Indent Number
		 * Indent Number Space Number
		 * Indent Number Space Number Space...
		 * 
		 * The major reason why we have a problem printing more than 4 rows is because indent is not dynamic enough. We can solve this problem if we generate the indents dynamically each time depending on the array data that we have, rather than being stuck to trying to generate it based of off knowing there's going to be either 1, 2, 3 or 4 rows. 
		 * Our goal here in fixing this problem is to make the calculation for indent more dynamic in any way that we need to do it.
		 * Another problem that's going to come up is if we try to print indexes that don't exist, which is definetely something that is going to happen in situations in which we have less items in the arrays than it can accomodate all of the rows.  
		 * Another problem - printing both single digit and double digit numbers
		 * 
		 * */

		int spaces = 0;
		int iterator = 1;
		
		// Generate all the indents for each row based off of how many rows that you have
		int[] indent = getIndentArray(rows); 

		// Keep printing things out as long as you have rows
		while (iterator <= rows) {
			

			// This will be the first index of the array to print on every row
			int indexToPrint = (int) (0.5 * (Math.pow(2, iterator) - 2));

			int itemsPerRow = (int) Math.pow(2, iterator - 1);

			// Calculate the maximum index of the array that can be printed in that row
			int maxIndexToPrintPerRow = indexToPrint + itemsPerRow;

			for (int spaceCount = 0; spaceCount < indent[iterator - 1]; spaceCount++) {
				System.out.print(" ");
			}

			for (int index = indexToPrint; index < maxIndexToPrintPerRow; index++) {
				if (index < itemsInArray) {
					// %02d will put in leading 0's
					System.out.print(String.format("%02d", theHeap[index].key));

					for (int spaceCount = 0; spaceCount < spaces; spaceCount++) {
						System.out.print(" ");
					}
				}
			}

			spaces = indent[iterator - 1];
			iterator++;

			// End of the row - add a new line
			System.out.println();
		}
	}
	
	private int[] getIndentArray(int rows) {
		int[] indentArray = new int[rows];
		
		for (int index = 0; index < rows; index++) {
			// Generate all the values that will go into the indent array. 
			// This is the formula for the sequence 0, 1, 3, 7.
			// Here, we've flipped the indents to make the calculation more dynamic
			indentArray[index] = (int) Math.abs((-2 + Math.pow(2, index + 1))); // Here, we're adding 1 to the index, since we need to start n from 1 based on the formula for indents.  
																					 // Math.abs is added to make sure that we only get positive digits from the calculation
		}
		
		// Make sure that the array is sorted, since we want to go from shortest number to largest number
		Arrays.sort(indentArray);
		
		// Reverse the array, since the indents needed for the items at the top of the array should be the max indent
		indentArray = reverseArray(indentArray);
		
		return indentArray;
	}
	
	private int[] reverseArray(int[] theArray) {
		int leftIndex = 0;
		int rightIndex = theArray.length - 1;
		
		while (leftIndex < rightIndex) {
			int temp = theArray[leftIndex];
			theArray[leftIndex] = theArray[rightIndex];
			theArray[rightIndex] = temp;
			
			leftIndex++; // Move the left index to the right
			rightIndex--; // Move the right index backwards
		}
		
		return theArray;
	}
	
	public static void main(String[] args) {
		System.out.println("OLD TREE");
		Heap newHeap = new Heap(70);
		newHeap.generateFilledArray(90);
		newHeap.printTree(6);
		
		System.out.println("\nNEW TREE\n");
		
		newHeap.printNewTree(6);
	}
}

class Data {
	public int key;
	
	public Data(int key) {
		this.key = key;
	}
}