
class Neighbor {

	public String homeOwnerName;
	public int houseNumber;

	public Neighbor next; // link to the next neighbor in the linked list
	public Neighbor previous; // link to the previous neighbor in the linked list

	public Neighbor(String homeOwnerName, int houseNumber) {
		this.homeOwnerName = homeOwnerName;
		this.houseNumber = houseNumber;
	}

	public void display() {
		System.out.println(homeOwnerName + ": " + houseNumber + " Privet Drive");
	}

	public String toString() {
		return homeOwnerName;
	}
}

class NeighborIterator {

	NeighborIterator(DoubleEndedLinkedList theNeighbors) {

	}

	public boolean hasNext() {
		return false;
	}
}

public class DoubleEndedLinkedList {

	Neighbor firstLink;
	Neighbor lastLink;

	public void insertInFirstPosition(String homeOwnerName, int houseNumber) {
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

		if (isEmpty()) {
			// if our linked list is empty
			lastLink = theNewLink;
		}

		theNewLink.next = firstLink;
		firstLink = theNewLink; // since the element is added to the beginning of the list, the firstLink
								// pointer should now be pointing to the first element in the list
	}

	public void insertInLastPosition(String homeOwnerName, int houseNumber) {
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

		if (isEmpty()) {
			firstLink = theNewLink;
		} else {
			lastLink.next = theNewLink;
		}
		lastLink = theNewLink;
	}
	
	public boolean isEmpty() {
		return (firstLink == null);
	}

	/*
	 * public boolean insertAfterKey(String homeOwnerName, int houseNumber, int key)
	 * {
	 * 
	 * }
	 */
	
	public static void main(String[] args) {
		DoubleEndedLinkedList theLinkedList = new DoubleEndedLinkedList();
		
	}
}
