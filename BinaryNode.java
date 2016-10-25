/** 
 * A Binary Node that stores an integer value, two binary node references,
 * and a boolean value to indicate whether it is right threaded to a 
 * parent/ancestor node.
 * 
 * @author Preston Peck 313
 * @version 1.0 August 3, 2016
 */

public class BinaryNode {
	//changed element from Object to int
	//cleaned up unused functions for clarity:
	//countNode, height
	int element;
	BinaryNode left, right;
	boolean thread;
	
	BinaryNode() {this(0);}
	BinaryNode(int e) {this(e, null, null, false);}
	BinaryNode(int e, BinaryNode l, BinaryNode r, boolean t) {
		element = e;
		left = l;
		right = r;
		thread = t;
	}
}
