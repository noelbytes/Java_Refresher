
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

	@Override
	public String toString() {
		return homeOwnerName;
	}
}

class NeighborIterator {

	Neighbor currentNeighbor;
	Neighbor previousNeighbor;

	DoubleEndedLinkedList theNeighbors;

	NeighborIterator(DoubleEndedLinkedList theNeighbors) {
		this.theNeighbors = theNeighbors;
		currentNeighbor = theNeighbors.firstLink;
		previousNeighbor = theNeighbors.lastLink;
	}

	public boolean hasNext() {
		if (currentNeighbor.next != null) {
			return true;
		}

		return false;
	}

	public Neighbor next() {
		if (hasNext()) {
			previousNeighbor = currentNeighbor;
			currentNeighbor = currentNeighbor.next;

			return currentNeighbor;
		}

		return null;
	}

	public void remove() {
		if (previousNeighbor == null) { // check if we are at the beginning of our list
			theNeighbors.firstLink = currentNeighbor.next;
			currentNeighbor = currentNeighbor.next;
			currentNeighbor.previous = null;
		} else {
			previousNeighbor.next = currentNeighbor.next;

			// if we are at the end of the list
			if (currentNeighbor.next == null) {
				currentNeighbor = theNeighbors.firstLink;
				previousNeighbor = null;
			} else {
				currentNeighbor = currentNeighbor.next;
				currentNeighbor.previous = previousNeighbor;
			}
		}
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
		} else {
			firstLink.previous = theNewLink;

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
			theNewLink.previous = lastLink;
		}
		lastLink = theNewLink;
	}

	public boolean isEmpty() {
		return (firstLink == null);
	}

	public boolean insertAfterKey(String homeOwnerName, int houseNumber, int key) {
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
		Neighbor currentNeighbor = firstLink;

		while (currentNeighbor.houseNumber != key) {
			currentNeighbor = currentNeighbor.next;

			if (currentNeighbor == null) { // if we get to the last neighbor without matching, exit out of the loop
				return false;
			}
		}

		if (currentNeighbor == lastLink) {
			theNewLink.next = null; // since theNewLink will be at the end of the list
			lastLink = theNewLink;
		} else {
			theNewLink.next = currentNeighbor.next;
			currentNeighbor.next.previous = theNewLink; // access the node next to currentNeighbor and have the previous
														// pointer of the next node point to the new node
		}

		theNewLink.previous = currentNeighbor;
		currentNeighbor.next = theNewLink;
		return true;
	}

	public void insertInOrder(String homeOwnerName, int houseNumber) {
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

		// hold the last neighbor searched, so that we'll be able to change it's value
		// for next if we input a new neighbor
		Neighbor previousNeighbor = null;
		Neighbor currentNeighbor = firstLink;

		while (currentNeighbor != null && (houseNumber > currentNeighbor.houseNumber)) {
			previousNeighbor = currentNeighbor;
			currentNeighbor = currentNeighbor.next;
		}

		if (previousNeighbor == null) {
			// if the element is the first element that is being inserted
			firstLink = theNewLink;
			if (currentNeighbor != null) {
				currentNeighbor.previous = theNewLink;
			}
		} else {
			previousNeighbor.next = theNewLink;
			theNewLink.previous = previousNeighbor;
		}

		theNewLink.next = currentNeighbor;
	}

	public static void main(String[] args) {
		DoubleEndedLinkedList theLinkedList = new DoubleEndedLinkedList();

//		theLinkedList.insertInFirstPosition("Mark Evans", 7);
//		theLinkedList.insertInFirstPosition("Piers Polkiss", 9);
//		theLinkedList.insertInLastPosition("Doreen Figg", 6);
//		theLinkedList.insertInFirstPosition("Petunia Dursley", 4);

		theLinkedList.insertInOrder("Mark Evans", 7);
		theLinkedList.insertInOrder("Piers Polkiss", 9);
		theLinkedList.insertInOrder("Doreen Figg", 6);
		theLinkedList.insertInOrder("Petunia Dursley", 4);

		theLinkedList.insertAfterKey("Allan Noel D'Souza", 10, 4);

		theLinkedList.display();

		System.out.println("\n");

		NeighborIterator neighbors = new NeighborIterator(theLinkedList);

		neighbors.currentNeighbor.display();

		System.out.println(neighbors.hasNext());

		neighbors.next();

		neighbors.currentNeighbor.display();

		neighbors.remove(); // removes the current neighbor

		neighbors.currentNeighbor.display(); // currentNeighbor will now point to the next neighbor after the one that
												// was removed in the list
	}

	public void display() {
		Neighbor theLink = firstLink; // HEAD node

		while (theLink != null) {
			theLink.display();
			System.out.println("Next Link: " + theLink.next);
			theLink = theLink.next;

			System.out.println();
		}
	}
}
