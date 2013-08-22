package encoding;

import java.io.*;
import java.util.*; // for Stack class

////////////////////////////////////////////////////////////////
public class Tree implements Comparable<Tree>
{
	public Node root; // first node of tree
	public int frequency = 0;

	// -------------------------------------------------------------
	public Tree() // constructor
	{
		root = null;
	} // no nodes in tree yet
	// -------------------------------------------------------------

	// the PriorityQueue needs to be able to somehow rank the objects in it
	// thus, the objects in the PriorityQueue must implement an interface called
	// Comparable
	// the interface requires you to write a compareTo() method so here it is:

	public int compareTo(Tree object)
	{ //
		if (frequency - object.frequency > 0)
		{ // compare the cumulative frequencies of the tree
			return 1;
		} else if (frequency - object.frequency < 0)
		{
			return -1; // return 1 or -1 depending on whether these frequencies
						// are bigger or smaller
		} else
		{
			return 0; // return 0 if they're the same
		}
	}

	// -------------------------------------------------------------

	String path = "error"; // this variable will track the path to the letter
							// we're looking for

	public String getCode(char letter)
	{ // we want the code for this letter

		inOrder(root, letter, "");

		// How do you get the code for the letter? Maybe try a traversal of the
		// tree
		// Track the path along the way and store the current path when you
		// arrive at the right letter

		return path; // return the path that results
	}
	private void inOrder(Node localRoot, char letter, String path)
	{
		if(localRoot != null)
				if(localRoot.letter == letter)
				{
					this.path = path;
				}
			
				else
				{
					inOrder(localRoot.leftChild, letter, path+"0");
					inOrder(localRoot.rightChild, letter, path+"1");
				}
		return;
	}

} // end class Tree
// //////////////////////////////////////////////////////////////
