/**
 * 
 */
package com.dabberu.pojos;

import java.io.File;

/**
 * @author ddabberu
 *
 */
import java.util.*;

/**
 * Read bunch of words from a passage in a file, delimit by non alpha
 * Assign the words and increment counts if word repeats
 * Print the words and counts
 * @author ddabberu
 *
 */
public class WordsBSTMain
{
	public static void main( String[] args) throws Exception
	{
		WordsBST bst= new WordsBST();
		Scanner s= new Scanner( new File("/Users/ddabberu/words.txt"));
		while( s.hasNextLine())
		{
			String line= s.nextLine();
			System.out.println(line);
			Scanner s1= new Scanner( line).useDelimiter("[^a-zA-z0-9]+");// delimit by non alpha characters including space
			while( s1.hasNext())
			{
				bst.findInsert(s1.next().toLowerCase());
			}
			s1.close();
		}
		s.close();
		System.out.println("########In Order Traversal, prints tree in sorted######");
		bst.printBSTInOrder();
		//System.out.println("########Post Order Traversal######");
		//bst.traverePostOrder();
		//System.out.println("########Pre Order Traversal######");
		//bst.traverePreOrder();
		//System.out.println("########Stats######");
		//bst.printTreeStats();
		System.out.println("#Delete a leaf 20");
		bst.deleteNode("20");
		bst.printBSTInOrder();
		System.out.println("Delete a node with on subtree, 30");
		bst.deleteNode("30");
		bst.printBSTInOrder();
		System.out.println("Delete a node with 2 subtrees, 50");
		bst.deleteNode("50");
		bst.printBSTInOrder();
	}
}




class WordsBST{

	TreeNode root;
	/**
	 * Finds if String exists, otherwise add to left or right subtree
	 * @param str
	 */
	public void findInsert(String str)
	{
		if(root == null)
		{
			root= new TreeNode(str); return;
		}
		TreeNode node=root;
		int val;
		//while( (val= node.data.compare(str))  != 0) //desc
		while( (val =str.compareTo(node.data.word)) !=0) //asc
		{	
			//System.out.println("FindInsert:str:"+str+",val:"+val);

			if( val < 0)
			{
				if( node.left != null) node= node.left;
				else
				{
					node.left=new TreeNode( str);
					return;
				}
			}
			else if( val > 0)
			{
				if( node.right != null) node= node.right;
				else
				{
					node.right=new TreeNode( str);
					return;
				}
				
			}
		}
		//found the node, increment the count
		node.data.incrementCount();
		return;		
	}
	public void printBSTInOrder()
	{
		inOrderTraversal( this.root);
	}
	void inOrderTraversal(TreeNode node)
	{
		if( node != null)
		{
			inOrderTraversal(node.left);
			printTreeNode( node);
			inOrderTraversal(node.right);
		}
	}
	
	public void traverePostOrder()
	{
		postOrderTraversal(this.root);
	}
	void postOrderTraversal( TreeNode node)
	{
		if( node != null)
		{
			//go left
			postOrderTraversal(node.left);
			//go right
			postOrderTraversal(node.right);
			//print root
			printTreeNode(node);
		}
	}
	public void traverePreOrder()
	{
		preOrderTraversal(this.root);
	}	
	void preOrderTraversal( TreeNode node)
	{
		if( node != null){
			//print root
			printTreeNode(node);
			//go left
			preOrderTraversal(node.left);
			//go right
			preOrderTraversal(node.right);
		}
	}
	void printTreeNode(TreeNode node)
	{
		node.data.printData();
	}
	
	public void printTreeStats()
	{
		System.out.println(" Total Number of Nodes:" + totalNodes(root));
		System.out.println(" Total Number of Leaves:" + totalLeaves(root));
		System.out.println(" Height of the Tree:" + totalLevels(root));
	}
	
	/**
	 * 
	 * @param node
	 * @return number of nodes in a bSt
	 */
	private int totalNodes(TreeNode node)
	{
		if( node != null)
		{
			return 1+totalNodes(node.left)+totalNodes(node.right);
		}
		else return 0;
	}
	
	/**
	 * 
	 * @param node
	 * @return number of levels in BST
	 */
	private int totalLevels(TreeNode node)
	{
		if( node != null)
		{
			return 1+Math.max( totalLevels(node.left),totalLevels(node.right));
		}
		else return 0;
	}	
	/**
	 * 
	 * @param node
	 * @return number of leaves in a tree
	 */
	private int totalLeaves(TreeNode node)
	{
		if( node != null)
		{
			if( node.left == null && node.right== null) return 1;
			return totalLeaves(node.left)+totalLeaves(node.right);
		}
		else return 0;
	}
	
	void deleteNode( String key)
	{
		deleteNodeRecursive(root, key);
	}
	
	TreeNode deleteNodeRecursive( TreeNode node, String key)
	{
		if(node == null) return null;
		if( key.compareTo(node.data.word) < 0)
		{
			node.left= deleteNodeRecursive( node.left, key);
		}
		else if( key.compareTo(node.data.word) > 0)
		{
			node.right= deleteNodeRecursive( node.right, key);
		}
		else { //val matches
			//for a leaf, or 1 or no subtrees
			if( node.left == null)
				return node.right;
			else if( node.right == null)
				return node.left;
			
			//if node has subtree, get the inorder successor ( far left of the right subtree)
			node.data= minValue( node.right);
			node.right= deleteNodeRecursive( node.right, node.data.word);
			
		}
		return node;
		
	}
	
	private NodeData minValue( TreeNode node)
	{
		NodeData nd= node.data;
		while( node.left != null)
		{
			node=node.left;
			nd=node.data;
		}
		return nd;
	}
	
}

/**
 * Define a Binary Tree
 * @author ddabberu
 *
 */
class TreeNode
{
	NodeData data;
	TreeNode left,right;
	
	public TreeNode(String str)
	{
		data= new NodeData(str);		
		left=right=null;
	}
}

/**
 * Node Data Object
 * Could be anything
 * @author ddabberu
 *
 */
class NodeData
{
	String word;
	int count;
	
	public NodeData(String str)
	{
		word=str;
		count=1;
	}
	
	public void incrementCount()
	{
		this.count++;
	}
	public void printData()
	{
		System.out.println(word+"\t\t"+count);
	}
	public int compare( String str)
	{
		return word.compareTo(str);
	}
}