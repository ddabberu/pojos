/**
 * 
 */
package com.dabberu.pojos;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author ddabberu
 *
 */
public class SumTree {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
/*		BinaryTree bt= new BinaryTree();
		bt.addLeaf(4);
		bt.addLeaf(5);
		bt.addLeaf(2);
		bt.addLeaf(1);
		bt.addLeaf(3);
		bt.addLeaf(6);
		bt.addLeaf(7);
		bt.printTree(bt.root);*/
		
//		int arr[]={57,48,79,65,15,33,52,95};
//		//15,33,48,52,57,65,79
//		printArr(arr);
//		insertionSort(arr);
//		selectionSort(arr);
//		System.out.println("sorted array");
//		printArr(arr);
//		System.out.println("Insert an element");
//		//int newElement= System.in.read();
//		int newElement= Integer.parseInt(System.console().readLine());
//		System.out.println("Inserting an element "+ newElement);

//		int[] arr1= new int[arr.length+1];
//		for( int i=0; i < arr.length; i++) arr1[i]=arr[i];
//		addAnElement( arr1, newElement);
//		printArr(arr1);
//		for( int i=0; i< arr.length; i++)
//		{
//			int val=arr[i];
//			int index=binarySearchInt(arr, val, 0, arr.length-1);
//			if (index >= 0) System.out.println("Value "+val+" found at "+index);
//			else System.out.println("Value "+val+" not found");
//		}
//		for( int i=0; i< arr.length; i++)
//		{
//			int val=arr[i];
//			int index=binarySearch(val, arr, 0, arr.length-1);
//			if (index >= 0) System.out.println("Value "+val+" found at "+index);
//			else System.out.println("Value "+val+" not found");
//		}		
//		
//		ArrayList<String> strList= new ArrayList();
//
//		strList.add("Aneesh");
//		strList.add("Sobha");
//		strList.add("vijay durgaprasad");
//		strList.add("Aditya");
//		
//		String[] strarr= new String[strList.size()];
//		strarr= strList.toArray(strarr);
//		sortStringArray(strarr);
		
		int a[]={1,3,5,7,9};
		int b[]={2,4,6,8,10,12,14};
		
		int c[]= merge2Arrays( a, b);
		
		printArr( c);
	}
	
	static void printArr( int arr[])
	{
		for(int i=0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println("\n");
	}
	/**
	 * Time Complexity O(n2), space complexity: O(n)
	 * @param arr
	 */
	static void insertionSort(int[] arr)
	{
		for( int i=1; i < arr.length; i++)
		{
			int val=arr[i];
			int j=i-1;
						
			while( j >= 0 && arr[j] > val)
			{
				arr[j+1]=arr[j];
				j--;
			}
			
			arr[j+1]=val;
		}
	}

	static void selectionSort( int[] arr){
		for( int i=0; i < arr.length; i++)
		{
			int val=arr[i]; int minIndex=i;
			//find min index
			for( int j=i+1; j < arr.length; j++)
			{
				if( arr[j] < arr[minIndex]) minIndex=j;
			}
			//swap vals
			arr[i]= arr[minIndex];
			arr[minIndex]=val;
			
		}
	}
	// arr is a sorted array
	static void addAnElement( int[] arr, int val)
	{
		int len= arr.length;
		if( val > arr[len-2])
		{
			arr[len-1]= val;
			return;
		}
		else arr[len-1]= val;
		
		//go backwards and insert
		int j= len-2;
		while( j >=0 && arr[j] > val)
		{
			arr[j+1]=arr[j];
			j--;
		}
		arr[j+1]=val;
		
	}
	
	/**
	 * Insertion sort with strings
	 * @param strarr
	 */
	static void sortStringArray( String[] strarr)
	{
		for( int i=0; i < strarr.length; i++)
			System.out.print(strarr[i]+",");
		for( int i=0; i < strarr.length; i++)
		{
			String val= strarr[i];
			int j=i-1;
			while(j >= 0 && strarr[j].compareToIgnoreCase(val) > 0)
			{
				strarr[j+1]= strarr[j];
				j--;
			}
			strarr[j+1]=val;
		}
		System.out.print("\nSorted Array\n");
		for( int i=0; i < strarr.length; i++)
			System.out.print(strarr[i]+",");
	}
	/**
	 * 
	 * @param arr : sorted array
	 * @param val : value to search
	 * @return position of the value in the array, or -1
	 */
	static int binarySearchInt(int[] arr, int val, int lo, int high)
	{
		//15,33,48,52,57,65,79
		int mid= (high+lo)/2;
		//System.out.println(mid);
		if( mid < 0 || mid > arr.length-1) return -1;
		if( arr[mid] == val) return mid;
		if( arr[mid+1] == val) return mid+1;
		else if( arr[mid] < val)
		{
			//System.out.println("High: "+ arr[mid]+"lo:"+mid+",high:"+high);
			return binarySearchInt( arr, val, mid, high);
		}
		else if( arr[mid] > val)
		{
			//System.out.println("Lo: "+ arr[mid]);
			return binarySearchInt( arr, val, lo, mid);
		}		
		else return -1;
	}
	
    static int binarySearch(int key, int[] list, int lo, int hi) {
    //search for key from list[lo] to list[hi]
    //if found, return its location; otherwise, return -1
       while (lo <= hi) {
          int mid = (lo + hi) / 2;
          if (key == list[mid]) return mid; // found
          if (key < list[mid]) hi = mid - 1;
          else lo = mid + 1;
       }
       return -1; //lo and hi have crossed; key not found
    }
    
    
    static int[] merge2Arrays( int[] a, int[] b)
    {
    	int len1=a.length;
    	int len2=b.length;
    	int[] c= new int[len1+len2];
    	int i=0,j=0,k=0;
    	//algo
    	while( i < len1 && j < len2 )
    	{
    		if(  a[i] < b[j])
    		{
    			//move to c
    			//next element in a
    			c[k]=a[i];
    			i++;k++;
    		}
    		else
    		{
    			c[k]=b[j];
    			j++;k++;
    		}
    	}
    	if( i < len1)
    	{
    		while( i < len1)
    		{
    			c[k]=a[i];
    			i++;k++;
    		}
    	}
    	else if( j < len2)
    	{
    		while( j< len2)
    		{
    			c[k]=b[j];
    			j++;k++;
    		}
    	}
    	return c;
    }

}
class BinaryTree{

	Node root;

	class Node
	{
		int val;
		Node right;
		Node left;
		
		Node(int val)
		{
			this.val=val;
			right=left=null;
		}
	}
	
	void addLeaf( int val)
	{
		if( root == null)
		{
			root=new Node(val);
		}
		else
		{
			traverseAndAddLeaf( val, root);
		}
	}
	
	void traverseAndAddLeaf( int val, Node n)
	{
		if( val < n.val)
		{
			//add to left
			if( n.left == null)
			{
				n.left= new Node( val);
			}
			else traverseAndAddLeaf( val, n.left);
		}
		else if( val > n.val)
		{
			if( n.right == null)
			{
				n.right= new Node( val);
			}
			else traverseAndAddLeaf( val, n.right);			//add to right
		}
	}
	
	void balanceTree()
	{
		
	}
	
	void printTree( Node node)
	{
		if( node != null)
		{
			System.out.print(node.val+" ");
			printTree( node.left);
			printTree( node.right);
		}
	}
	
}