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

How to delete nodes in Binary Trees
-------------------------------------
Deleting 50 (Refer the screenshots for the diagrams)
-------------------------------------------------------
- Is 50 the root node?
- The replacement for 50 is 75 (since it is the right child)
- Assign 50 leftChild to 75

Deleting 25
--------------
- Is 25 < 50?
- 30 will replace 25
- root.leftChild = 30
- 30.rightChild = 15

Deleting 15
-------------
- Is 15 < 50?
- 18 will replace 15
- 25.leftChild = 18
- 18.leftChild = 2

Deleting 75
--------------
- Is 75 >= 50
- The replacement for 75 is 85
- Assign the leftChild of 85 to 70
- Assign the root's (i.e. 50) right child to 85

*/

import java.util.Scanner;

/**
 * A class representing a binary tree structure. It supports adding nodes,
 * performing in-order, pre-order, and post-order traversals, and searching for
 * nodes.
 */
public class BinaryTree {

	Node root; // The root node of the binary tree

	/**
	 * Adds a new node to the binary tree.
	 * 
	 * @param key  - The key of the new node.
	 * @param name - The name associated with the new node.
	 */
	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);

		if (root == null) {
			// If the tree is empty, set the new node as the root
			root = newNode;
		} else {
			// Start from the root and find the appropriate position
			Node focusNode = root;
			Node parent;

			while (true) {
				parent = focusNode; // focusNode is the root, since that's where we are going to start from

				// Check if the new node should go on the left side or the right side of our
				// parent
				if (key < focusNode.key) {
					// Traverse the left subtree if the key is smaller
					focusNode = focusNode.leftChild;

					// If the left child has no children, place the new node on the left of it
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					// Traverse the right subtree if the key is greater or equal
					focusNode = focusNode.rightChild;

					if (focusNode == null) {
						// If no right child, insert the new node on the right
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	/**
	 * Performs an in-order traversal of the binary tree.
	 * 
	 * @param focusNode - The starting node for the traversal.
	 */
	public void inOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			inOrderTraverseTree(focusNode.leftChild); // Visit the left subtree
			System.out.println(focusNode); // Visit the current node
			inOrderTraverseTree(focusNode.rightChild); // Visit the right subtree
		}
	}

	/**
	 * Performs a pre-order traversal of the binary tree.
	 * 
	 * @param focusNode - The starting node for the traversal.
	 */
	public void preOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			System.out.println(focusNode); // Visit the current node
			preOrderTraverseTree(focusNode.leftChild); // Visit the left subtree
			preOrderTraverseTree(focusNode.rightChild); // Visit right subtree
		}
	}

	/**
	 * Performs a post-order traversal of the binary tree.
	 * 
	 * @param focusNode - The starting node for the traversal.
	 */
	public void postOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			postOrderTraverseTree(focusNode.leftChild); // Visit the left subtree
			postOrderTraverseTree(focusNode.rightChild); // Visit the right subtree
			System.out.println(focusNode); // Visit the current node
		}
	}

	/**
	 * Searches for a node in the binary tree by its key.
	 * 
	 * @param key - The key of the node to find.
	 * @return - The node with the specified key, or null if not found.
	 */
	public Node findNode(int key) {
		Node focusNode = root;

		while (focusNode.key != key) {
			// Traverse the left subtree
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;
			} else {
				// Traverse the right subtree
				focusNode = focusNode.rightChild;
			}

			if (focusNode == null) {
				return null;
			}
		}

		return focusNode; // Return the found node or null
	}

	/**
	 * Removes a node with the specified key from the binary search tree
	 * 
	 * @param key - The key of the node to be removed
	 * @return - true if the node was successfully removed, false if the key was not
	 *         found.
	 */
	public boolean remove(int key) {
		Node focusNode = root; // The node currently being inspected
		Node parentNode = root; // The parent of the node being inspected

		// Flag to indicate whether the current focusNode is a left child of the
		// parentNode.
		boolean isItALeftChild = true;

		// Search for the node with the given key
		while (focusNode.key != key) {
			parentNode = focusNode;

			if (key < focusNode.key) {
				// Move to the left child.
				isItALeftChild = true;
				focusNode = focusNode.leftChild;
			} else {
				// Move to the right child.
				isItALeftChild = false;
				focusNode = focusNode.rightChild;
			}

			// If the key is not found in the tree, return false.
			if (focusNode == null) {
				return false;
			}
		}

		// Node to be deleted is found

		// Case 1: Node has no children
		if (focusNode.leftChild == null && focusNode.rightChild == null) {
			if (focusNode == root) {
				root = null; // If the node is the root, set the root to null.
			} else if (isItALeftChild) {
				parentNode.leftChild = null; // Disconnect the left child.
			} else {
				parentNode.rightChild = null; // Disconnect the right child.
			}
		}
		// Case 2: Node has no right child but has a left child.
		else if (focusNode.rightChild == null) {
			if (focusNode == root) {
				root = focusNode.leftChild; // Promote the left child to root.
			} else if (focusNode.rightChild == null) {
				if (focusNode == root) {
					root = focusNode.leftChild;
				} else if (isItALeftChild) {
					parentNode.leftChild = focusNode.leftChild; // Link the left child to the parent.
				} else {
					parentNode.rightChild = focusNode.leftChild; // Link the left child to the parent.
				}
			}
		}
		// Case 3: Node has no left child but has a right child.
		else if (focusNode.leftChild == null) {
			if (focusNode == root) {
				root = focusNode.rightChild; // Promote the right child to root.
			} else if (isItALeftChild) {
				parentNode.leftChild = focusNode.rightChild; // Link the right child to the parent.
			} else {
				parentNode.rightChild = focusNode.leftChild; // Link the right child to the parent.
			}
		}
		// Case 4: Node has two children.
		else {
			// Find the replacement node.
			Node replacement = getReplacementNode(focusNode);

			// If the focusNode is root, replace root with the replacement that was sent
			// back, which will be roots right child.
			// OR (alternate explanation)
			// If the node to be removed is the root, update the root.
			if (focusNode == root) {
				root = replacement;
			} else if (isItALeftChild) {
				parentNode.leftChild = replacement; // Replace the left child.
			} else {
				parentNode.rightChild = replacement; // Replace the right child.
			}

			// Connect the replacement node's left child to the focusNode's left child.
			replacement.leftChild = focusNode.leftChild;
		}

		return true; // Node successfully removed.
	}

	/**
	 * Finds the replacement node for a node being removed (used in case the node
	 * has two children). The replacement node is the smallest node in the right
	 * subtree.
	 * 
	 * @param replacedNode - The node to be replaced
	 * @return - The replacement node
	 */
	public Node getReplacementNode(Node replacedNode) {
		Node replacementParent = replacedNode; // The parent of the replacement node.
		Node replacement = replacedNode; // The node that will replace the removed node.

		// Here we are moving the right child up
		Node focusNode = replacedNode.rightChild; // Start with the right child.

		// Traverse the leftmost node in the right subtree.
		while (focusNode != null) {
			replacementParent = replacement;
			replacement = focusNode;
			// Here, we are moving the left child up
			focusNode = focusNode.leftChild;
		}

		// If the replacement isn't the right child, move the replacement into the
		// parent's left child slot, and then move the replaced node's right child into
		// the replacements right child
		// OR (alternate explanation)
		// If the replacement is not the immediate right child of the node being
		// removed.
		if (replacement != replacedNode.rightChild) {
			replacementParent.leftChild = replacement.rightChild; // Promote the replacement's right child.
			replacement.rightChild = replacedNode.rightChild; // Link the removed node's right child.
		}

		return replacement; // Return the replacement node.
	}

	public static void main(String[] args) {
		BinaryTree theTree = new BinaryTree();

		// Adding nodes to the tree
		theTree.addNode(50, "Boss");
		theTree.addNode(25, "Vice President");
		theTree.addNode(75, "Sales Manager");
		theTree.addNode(15, "Office Manager");
		theTree.addNode(30, "Secretary");
		theTree.addNode(70, "Salesman 1");
		theTree.addNode(85, "Salesman 2");
		theTree.addNode(2, "Intern");
		theTree.addNode(18, "HR Manager");
		theTree.addNode(28, "Joint Secretary 1");
		theTree.addNode(35, "Joint Secretary 2");
		theTree.addNode(27, "Assistant Secretary");
		theTree.addNode(29, "Clerk");
		theTree.addNode(32, "Assistant Joint Secretary");
		theTree.addNode(38, "Coordinator");

		// Traversing the tree
		System.out.println("In-order Traversal:");
		theTree.inOrderTraverseTree(theTree.root);

		System.out.println("\nPre-order Traversal:");
		theTree.preOrderTraverseTree(theTree.root);

		System.out.println("\nPost-order Traversal:");
		theTree.postOrderTraverseTree(theTree.root);

		// Searching for a node
		System.out.println("-------------------------------------------------------");
		System.out.println("Search for 30");
		System.out.println(theTree.findNode(30));
		System.out.println("-------------------------------------------------------");

		System.out.println("Enter the value that you'd like to delete : ");

		theTree.remove(new Scanner(System.in).nextInt());

		// Traversing the tree
		System.out.println("In-order Traversal:");
		theTree.inOrderTraverseTree(theTree.root);
		System.out.println("-------------------------------------------------------");
	}
}

/**
 * A class representing a node in the binary tree.
 */
class Node {
	int key; // The key of the node
	String name; // The name associated with the node

	Node leftChild; // Reference to the left child
	Node rightChild; // Reference to the right child

	/**
	 * Constructor to initialize the node with a key and name.
	 * 
	 * @param key  - The key of the node.
	 * @param name - The name associated with the node.
	 */
	Node(int key, String name) {
		this.key = key;
		this.name = name;
	}

	/**
	 * Returns a string representation of the node.
	 * 
	 * @return A string in the format "name has a key keyValue".
	 */
	@Override
	public String toString() {
		return name + " has a key " + key;
	}
}
