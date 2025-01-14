
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
		
		while (index < itemsInArray / 2) {
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;
			
			if (rightChild < itemsInArray && theHeap[leftChild].key < theHeap[rightChild].key) {
				largeChild = rightChild;
			} else {
				largeChild = leftChild;
			}
			
			if (root.key >= theHeap[largeChild].key) {
				break;
			}
			
			theHeap[index] = theHeap[largeChild];
			index = largeChild;
		}
		
		theHeap[index] = root;
	}
	
	public void displayTheHeap() {
		for (int index = 0; index < itemsInArray; index++) {
			System.out.println(theHeap[index].key);
		}
	}
	
	public void printTree() {
		
	}
	
	public static void main(String[] args) {
		
	}
}

class Data {
	
	public int key;
	
	public Data(int key) {
		this.key = key;
	}
}