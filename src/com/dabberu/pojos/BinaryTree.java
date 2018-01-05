/**
 * 
 */
package com.dabberu.pojos;

/**
 * @author ddabberu
 *
 */
public class BinaryTree {
	
	com.dabberu.pojos.Node root;
	/***
	 * Checks if binary tree is complete
	 * meaning only the last level do not have children
	 * @return
	 */
	
	int numberOfNodes(Node node)
	{
		if( node != null)
		{
			return 1+numberOfNodes(node.left)+numberOfNodes(node.right);
		}
		else return 0;
	}
	
	boolean isComplete(Node node, int index, int totalNodes)
	{
		//get the number of nodes and levels
		//level order traversal
		//recurse
		int key=0;
		if( node != null) key=node.key;
		System.out.println("isComplete: index:"+index+",key:"+key);
		if( node == null)
		{
			System.out.println("Node is null, true");
			return true;
		}
		if( index >= totalNodes)
		{
			System.out.println(" index is higher,False");
			return false;
		}
		if( isComplete(node.left, 2*index+1,totalNodes ) == true)
		{
				return isComplete(node.right,2*index+2,totalNodes);
		}
		else return false;
	}

	public static void main (String[] args)
	{
			BinaryTree bt= new BinaryTree();
		    Node root = new Node(10);
		    root.left = new Node(9);
	        root.right = new Node(8);
	        root.left.left = new Node(7);
	        //root.left.right = new Node(6);
	        //root.right.left = new Node(5);
	        //root.right.right = new Node(4);
	        //root.left.left.left = new Node(3);
	        //root.left.left.right = new Node(2);
	        //root.left.right.left = new Node(1);
	        int totalNodes=bt.numberOfNodes(root);
	        System.out.println("#of Nodes:"+ totalNodes);
	        System.out.println("Is Complete Binary Tree:"+ bt.isComplete(root,0,totalNodes)); 
	}
}
