import java.io.BufferedReader;
import java.io.FileReader;

/** 
 *Takes a Binary Search Tree created from a provided input file and turns it
 *into a Right Threaded Binary Search Tree printing out each right thread connection. 
 *The tree is then traversed and printed out in-order.
 * 
 * @author Preston Peck 313
 * @version 1.0 August 3, 2016
 */

public class Project2 {
	public static void main(String[] args) {
		FileReader theFile;
		BufferedReader inFile;
		String oneLine;
		try {
			theFile = new FileReader(args[0]);
			inFile = new BufferedReader(theFile);
			while ((oneLine = inFile.readLine()) != null) {
				BinaryTree t = new BinaryTree();
				String numbers[] = oneLine.split(" ");
				for(int i=0; i < numbers.length; i++) {
					t.insert(Integer.parseInt(numbers[i]));
				}
				System.out.print("Threads: ");
				t.setRightThreaded();
				System.out.print('\n' + "Inorder: ");
				t.inorder(t.getRoot());
				System.out.println('\n');
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}