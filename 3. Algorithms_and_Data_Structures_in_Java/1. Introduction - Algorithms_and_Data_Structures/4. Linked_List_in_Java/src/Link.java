/* A link is an Object
 * Each link that you create has a reference to another Link in the List
 * The LinkedList has only a reference to the last Link added to it */

public class Link {
	public String bookName;
	public int millionsSold;

	public Link next; // holds the address of the previous link that was added to the LinkedList

	public Link(String bookName, int millionsSold) {
		this.bookName = bookName;
		this.millionsSold = millionsSold;
	}

	public void display() {
		System.out.println(bookName + " : " + millionsSold + ",000,000");
	}

	@Override
	public String toString() {
		return bookName;
	}

	public static void main(String[] args) {
		LinkedList theLinkedList = new LinkedList();
		
		theLinkedList.insertFirstLink("Don Quixote", 500);
		theLinkedList.insertFirstLink("A Tale of Two Cities", 200);
		theLinkedList.insertFirstLink("The Lord of the Rings", 150);
		theLinkedList.insertFirstLink("Harry Potter and the Sorcerer's Stone", 107);
		
//		theLinkedList.display();
		
		theLinkedList.removeFirst();
		
//		theLinkedList.display();
		
		System.out.println(theLinkedList.find("The Lord of the Rings").bookName + " was found");
		
		theLinkedList.removeLink("The Lord of the Rings");
		
		theLinkedList.display();
	}
}

class LinkedList {

	public Link firstLink; // reference to the first link in the list, or the last link that was added to
							// the LinkedList. It can also be called the HEAD of the LinkedList

	LinkedList() {
		firstLink = null;
	}

	public boolean isEmpty() {
		return (firstLink == null);
	}

	// insert a new link into a LinkedList

	// How is a new link added
	/*
	 * New Link is created 
	 * It's Next is assigned the reference to the previous Link created 
	 * The LinkedList's firstLink is assigned a reference to the newest Link added
	 */
	public void insertFirstLink(String bookName, int millionsSold) {
		// This will insert elements at the beginning of the LinkedList
		// LinkedList (firstLink) --> Link (next) --> Link (next) --> Link (next) ....
		// Think of LinkedList (firstLink) like a pointer that points to the first element in the list
		Link newLink = new Link(bookName, millionsSold);
		newLink.next = firstLink; // Since the node is inserted at the beginning of the list, assign the value of next pointer in the new node to the previous first node
		firstLink = newLink; // the first node is now the most recent node that was inserted into the LinkedList
	}
	
	/* How is a value removed?
	 * The LinkedList's firstLink is assigned the value of the current firstLink's next.
	 * That's it */
	
	public Link removeFirst() {
		// this method will remove the first element from the LinkedList
		Link linkReference = firstLink; // reference to the last element that was inserted
		
		if (!isEmpty()) {
			// if firstLink isn't empty
			firstLink = firstLink.next;
		} else {
			System.out.println("Empty LinkedList");
		}
		
		return linkReference;
	}
	
	/* How do you cycle through all the links?
	 * Start at the reference stored in firstLink for the LinkedList
	 * Get the references stored in next for every Link until next returns null */
	public void display() {
		Link theLink = firstLink;
		
		while (theLink != null) {
			theLink.display(); // prints out the bookName and the millionsSold
			System.out.println("Next Link : " + theLink.next);
			theLink = theLink.next;
			
			System.out.println();
		}
	}
	
	/* How do you find a link in a LinkedList
	 * Check the data for the firstLink reference stored in the LinkedList
	 * If you don't get a match, continue searching every reference stored in next until next returns null.
	*/
	
	public Link find(String bookName) {
		Link theLink = firstLink;
		
		if (!isEmpty()) {
			while (theLink.bookName != bookName) {
				if (theLink.next == null) {
					// we've got to the end of the list without finding a match
					return null;
				} else {
					theLink = theLink.next;
				}
			}
		} else {
			// the the LinkedList is empty
			System.out.println("Empty LinkedList");
		}
		
		// if we've got a match
		return theLink;
	}
	
	/* How do you remove a specific link? 
	 * Cycle through all the Links until there is a match
	 * If the referenced Link stored in the LinkedList's firstLink matches 
	 * --> Store the reference next in firstLink as firstLink
	 * If a match occurs elsewhere, find the Link thats next equals the reference to remove 
	 * Get the reference named next in the Link to remove and assign it to the Link above. 
	 * */
	public Link removeLink(String bookName) {
		Link currentLink = firstLink;
		Link previousLink = firstLink;
		
		// Source code to find if there isn't a match to the bookNames stored in the list
		while (currentLink.bookName != bookName) {
			if (currentLink.next == null) {
				return null;
			} else {
				previousLink = currentLink;
				currentLink = currentLink.next;
			}
		}
		
		if (currentLink == firstLink) {
			// if we got a match in the firstLink
			firstLink = firstLink.next;
		} else {
			// if we got a match in the link other than the firstLink
			previousLink.next = currentLink.next;
		}
		
		return currentLink; // return whatever was deleted
	}
}
