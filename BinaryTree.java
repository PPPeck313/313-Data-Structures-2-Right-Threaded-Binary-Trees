/** 
 *A Binary Tree
 * 
 * @author Preston Peck 313
 * @version 1.0 August 3, 2016
 */

public class BinaryTree {
	//changed insert return and parameter from BinaryTree to BinaryNode for consistency
	//cleaned up unused functions for clarity:
	//makeEmpty, nodeCount, height, getRootObj, getLeft, setLeft, getRight, setRight
	private BinaryNode root;
	/**
	 * Default constructor 
	 * @param root starting node at height 0
	 */
	public BinaryTree() {root = null;};
	
	public BinaryTree(int x) {root = new BinaryNode(x);}
	
	public boolean isEmpty() {return root == null;}
	
	public BinaryNode getRoot() throws BinaryTreeException {
		if (root == null) throw new BinaryTreeException ("Empty tree");
		else
			return root;
	}
	//automated insert, otherwise NPE with getRoot() if root = null
	public void insert(int x) {root = insert(root, x);}
	/**
	 *Traverses recursively and inserts a new node into a tree in numerical order such 
	 *that new entries when compared to existing nodes get sent left of them when its 
	 *value is less than or equal to their stored values, or right when greater than until 
	 *it is a leaf.
	 * @param n node traveler- initially root if x is to be properly appended and ordered
	 * @param x value to be stored in node
	 * @return n inserted node
	 */
	public BinaryNode insert(BinaryNode n, int x) {
		if (n == null) {
			n = new BinaryNode(x);
			return n;
		}
		else {
			if (n.element < x)
				n.right = insert(n.right, x);
			else
				n.left = insert(n.left, x);
			return n;
		}
	}
	//automated setRightThreaded because requiring user null entry is nonintuitive
	public void setRightThreaded() {
		setRightThreaded(root, null);
	}
	/**
	 * Traverses recursively and right threads every node in a tree without a right link
	 * to its parent/ancestor to allow for continuous traversal until a sole terminating 
	 * node is reached. To do this it prioritizes advancing left through the tree until 
	 * unable. If the current node lacks a right link it is threaded to its parent/ancestor,
	 * otherwise the right link is traveled and the process is repeated.
	 * @param n traveler node
	 * @param p parent/ancestor node
	 */
	public void setRightThreaded(BinaryNode n, BinaryNode p) throws BinaryTreeException {
		if (!isEmpty()) {
			if (n.left != null) {
				setRightThreaded(n.left, n);
			}
			if (n.right != null) {
				setRightThreaded(n.right, p);
			}
			else {
				n.thread = true;
				if (p != null) {
					n.right = p;
					System.out.print(n.element + "->");
					System.out.print(p.element + "  ");	
				}
			}
		}
	}
	/**
	 *Traverses and prints out Right Threaded Binary Trees in-order. To do this
	 *it prioritizes advancing left in the tree until unable. The traversed nodes are 
	 *then printed in reverse order using right advances so long as they are marked as 
	 *having been threaded to a parent/ancestor. An additional right and then print is 
	 *made if possible and the process is repeated until fully exhausted.
	 * @param n traveler node
	 */
	public void inorder(BinaryNode n) throws BinaryTreeException {
		while (n != null) {
			while (n.left != null) {
				n = n.left;
			}
			while (n != null && n.thread == true) {
				System.out.print(n.element + "  ");
				n = n.right;
			}//short circuit logic otherwise NPE for any other n checks
			if (n != null && n.right != null) {
				System.out.print(n.element + "  ");
				n = n.right;
			}
		}
	}
}