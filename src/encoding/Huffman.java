package encoding;

import java.util.*;

public class Huffman
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		System.out.print("Enter your sentence: ");
		String sentence = "The cat sat on the mat"; //in.nextLine();
		String binaryString = ""; // this stores the string of binary code

		for (int i = 0; i < sentence.length(); i++)
		{ // go through the sentence
			int decimalValue = (int) sentence.charAt(i); // convert to decimal
			String binaryValue = Integer.toBinaryString(decimalValue); // convert to binary
																		
			for (int j = 7; j > binaryValue.length(); j--)
			{
				binaryString += "0"; // this loop adds in those pesky leading
										// zeroes
			}
			binaryString += binaryValue + " "; // add to the string of binary
		}
		System.out.println(binaryString); // print out the binary

		int[] array = new int[256]; // an array to store all the frequencies

		for (int i = 0; i < sentence.length(); i++)
		{ // go through the sentence
			array[(int) sentence.charAt(i)]++; // increment the appropriate frequencies
		}

		PriorityQueue<Tree> PQ = new PriorityQueue<Tree>(); // make a priority queue to hold the forest of trees
															
		for (int i = 0; i < array.length; i++)
		{ // go through frequency array
			if (array[i] > 0)
			{ // print out non-zero frequencies - cast to a char
				System.out.println("'" + (char) i + "' appeared " + array[i]
						+ ((array[i] == 1) ? " time" : " times"));

				// FILL THIS IN:

				// MAKE THE FOREST OF TREES AND ADD THEM TO THE PQ
				
				Node newNode = new Node();
				newNode.letter = ((char) i);
				
				Tree codeTree = new Tree();
				codeTree.frequency = array[i];
				codeTree.root =newNode;
				PQ.add(codeTree);

				// create a new Tree
				// set the cumulative frequency of that Tree
				// insert the letter as the root node
				// add the Tree into the PQ

			}
		}

		while (PQ.size() > 1)
		{ // while there are two or more Trees left in the forest
			// IMPLEMENT THE HUFFMAN ALGORITHM
			Node rootNode = new Node();
			rootNode.letter = '@';
			
			Tree combinedTree = new Tree();
			combinedTree.root = rootNode;
			
			
			Tree left = PQ.poll();
			Tree right = PQ.poll();
			
			combinedTree.frequency = left.frequency + right.frequency;
			
			combinedTree.root.leftChild = left.root;
			combinedTree.root.rightChild = right.root;
			
			PQ.add(combinedTree);
		}

		Tree HuffmanTree = PQ.poll(); // now there's only one tree left - get its codes
	
		for (int i = 0; i < array.length; i++)
		{ // go through frequency array
			if (array[i] > 0)
			{
				char letter = (char) i;
				System.out.println(letter +" "+HuffmanTree.getCode(letter));
			}
		}
		System.out.println("test");
		for(int i = 0; i < sentence.length(); i++)
		{
			System.out.print("\""+sentence.charAt(i)+"\"-"+HuffmanTree.getCode(sentence.charAt(i)) +" " );
		}
	}

}
