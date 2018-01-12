package com.dabberu.pojos;

public class HeapSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {12, 11, 13, 5, 6, 7, 10};
		HeapSort hs= new HeapSort();
		hs.printArr(arr);
		hs.heapSort(arr);
		hs.printArr(arr);
	}

}

/**
 * Builds a heap of given array
 * Sorts the array ascending
 *
 * @author ddabberu
 *
 */
class HeapSort
{
	/**
	 * 
	 * @param arr
	 * @param n: Size of heap
	 * @param i: subtree index
	 */
	void heapify(int[] arr, int n, int i)
	{
		int largest= i; //init element at i as biggest of the heap
		int l= 2*i+1; //left subtree
		int r= 2*i+2; //right subtree
		
		//if left subchile is > root
		if( l<n && (arr[l] > arr[largest]))
		{
			largest=l;
		}
		//if left subchild is > root
		if( r<n && (arr[r] > arr[largest]))
		{
			largest=r;
		}	
		//if largest isnt the root, then swap and heapify
		if( largest != i)
		{
			int tmp= arr[i];
			arr[i]= arr[largest];
			arr[largest]=tmp;
			//heapify the subtree
			heapify( arr, n, largest);
		}	
	}
	/**
	 * Add an element to existing heap
	 * without breaking the order
	 * n: Size of heap
	 */
	void siftUp(int[] arr, int n)
	{
		int child=n;
		int parent= child/2;
		int item= arr[child];
		while( parent >= 0)
		{
			if( item<= arr[parent]) break;
			arr[child]=arr[parent];
			child=parent;
			parent=child/2;
		}
		arr[child]=item;
		
	}
	void heapSort( int arr[])
	{
		int len= arr.length;
		//build max heap
		for( int h=len/2-1; h >= 0; h--)
		{
			heapify( arr, len, h);
		}		
		//sort by moving the root to the end, and re heaping
		for( int i=len-1; i >= 0; i--)
		{
			int max= arr[0];
			arr[0]=arr[i];
			arr[i]= max;			
			heapify( arr, i, 0);
		}
	}
	
	void printArr( int arr[])
	{
		for(int i=0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println("\n");
	}
}