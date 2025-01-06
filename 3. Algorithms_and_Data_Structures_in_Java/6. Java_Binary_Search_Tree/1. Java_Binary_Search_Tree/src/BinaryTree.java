/* Binary tree vs a Tree
-----------------------------
- A binary tree can have at the max only two nodes, while a tree can have more than two nodes
- In a binary tree, the elements less than the root node are to the left of the tree, and the elements greater than the root node are to the right of the tree

What is an unbalanced tree?
----------------------------
- Most of the elements in this type of tree are only found on one side of the root.
- Random data normally isn't unbalanced
- Ordered data tends to create unbalanced trees, and unbalanced trees are bad, because they are slow

Why should you use trees?
----------------------------
- You can search, and insert / delete items quickly in a tree
- Ordered Arrays are bad at Insertions / Deletions
- Finding items in a  Linked List is slow
- Time needed to perform an operation on a tree (binary tree) is O(logN) (i.e. the search time is reduced by 50%)
- On average, a tree is more efficient if you need to perform many different types of operations quickly.

In Order Traversal
-------------------------
- Aim for the smallest value first
- Start at 1st Left Child
- When Null is reached, then move up in value

Pre Order Traversal
-------------------------
- First hit the main focus node - which is the root
- Then cycle down through all of our left's children
- If we hit null, jump up one parent, and go into the right child. 
- Then jump back to root, and go downwards to all the child nodes on the right.

*/

public class BinaryTree {
	
	Node root;
	
	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);
		
		if (root == null) {
			// Check if this is the root element for our tree
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;  // focusNode is the root, since that's where we are going to start from
				
				// Check if the new node should go on the left side or the right side of our parent
				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;
					
					// If the left child has no children, place the new node on the left of it
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					// Put the node on the right
					focusNode = focusNode.rightChild;
					
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public void inOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	public void preOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			System.out.println(focusNode);
			preOrderTraverseTree(focusNode.leftChild);
			preOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	public void postOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}
	
	public Node findNode(int key) {
		Node focusNode = root;
		
		while (focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;
			} else {
				focusNode = focusNode.rightChild;
			}
			
			if (focusNode == null) {
				return null;
			}
		}
		
		return focusNode;
	}
	
	public static void main(String[] args) {
		BinaryTree theTree = new BinaryTree();
		theTree.addNode(50, "Boss");
		theTree.addNode(25, "Vice President");
		theTree.addNode(15, "Office Manager");
		theTree.addNode(30, "Secretary");
		theTree.addNode(75, "Sales Manager");
		theTree.addNode(85, "Salesman 1");
		
		theTree.inOrderTraverseTree(theTree.root);
		theTree.preOrderTraverseTree(theTree.root);
		theTree.postOrderTraverseTree(theTree.root);
		
		System.out.println("-------------------------------------------------------");
		System.out.println("Search for 30");
		System.out.println(theTree.findNode(300));
		System.out.println("-------------------------------------------------------");
	}
}

class Node {
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	Node (int key, String name) {
		this.key = key;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name + " has a key " + key;
	}
}
