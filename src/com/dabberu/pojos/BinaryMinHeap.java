/**
 * 
 */
package com.dabberu.pojos;

/**
 * @author ddabberu
 *
 */
public class BinaryMinHeap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Node root;
	
	//min heap operations
	
	int getMini()
	{
		return root.key;
	}
	
	Node extractMin()
	{
		return null;
	}
	void decreaseKeyVal(int index, int newval)
	{
		
	}
	
	void insertKey( int key)
	{
		
	}
	
	void deleteKey(int key)
	{
		
	}
	
	boolean isBinaryMaxHeap(Node node)
	{
		//check if node.key > node.children.key
		//recursively
		if( node == null) return true;
		if( node.left== null && node.right==null) 
			return true;
		if( node.right == null)
		{
			return node.key >= node.left.key;
		}
		else
		{
			if( node.key >= node.left.key && node.key >= node.right.key)
			{
				return (isBinaryMaxHeap(node.left) && isBinaryMaxHeap(node.right) );
			}
			else return false;
		}
	}

}
