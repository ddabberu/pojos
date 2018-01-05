/**
 * @author ddabberu
 *
 */
package com.dabberu.pojos;
public class SortAlgos {

	private int[] arr;
	private int arrayMaxsize=50;
	private int arraySize=10;
	
	public SortAlgos()
	{
		arr= new int[arrayMaxsize];
	}
	/**
	 * Bubblesort
	 * @param asc
	 */
	public void bubbleSort(boolean asc)
	{
		//sort each pair and swap big with small
		for( int i=arraySize-1; i > 0; i--)
		{
			for( int j=0; j<i ; j++)
			{
				if( asc) 
				{
					//if( arr[j] > arr[i])
					if( arr[j] > arr[j+1])
					{
						int temp= arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=temp;
					}
				}
				else
				{
					if( arr[j] < arr[j+1])
					{
						int temp= arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=temp;
					}				
				}
			}
		}
	}
	/**
	 * Binary Search
	 * @param element
	 * @return
	 */
	public int binarySearch(int element)
	{
		//works on sorted arrays in asc
		//returns the index of 1st element it finds match
		//loop through midpoints
		printArr();
		
		int low= 0, high=arraySize-1, mid= (arraySize-1)/2;
		while( low < high)
		{
			if(  element > arr[mid])
			{
				low= mid+1; mid= (low+high)/2;
				System.out.println("111low:"+low+",high:"+high+",mid:"+mid);
			}
			else if(  element < arr[mid])
			{
				high= mid-1;  mid= (low+high)/2;
				System.out.println("222low:"+low+",high:"+high+",mid:"+mid);
			}
			else
			{
				System.out.println("333low:"+low+",high:"+high+",mid:"+mid);
				return mid;
			}
		}
		return -1;
	}
	public void printArr()
	{
		for( int i=0; i < arraySize; i++)
		{
			System.out.print( "|"+ arr[i]+"|");
		}
		System.out.println();
	}
	
	public void printArr(int[] arr)
	{
		for( int i=0; i < arr.length; i++)
		{
			System.out.print( "|"+ arr[i]+"|");
		}
		System.out.println();
	}	
	
	public void generateRandomArray()
	{
		for( int i=0; i < arraySize; i++)
		{
			arr[i]= (int) (Math.random()*10+arraySize);
		}
	}
	
	/**
	 * Insertion Sort
	 * @param uarr
	 */
	public void insertionSort( int[] uarr)
	{
		int insert=0;
		for( int i=1; i < uarr.length; i++)
		{
			insert= uarr[i];
			int j=i;
			
			while(j>0  && (  uarr[j-1] > insert))
			{
				uarr[j]= uarr[j-1];
				//uarr[j]=insert;				
				j--;
				myPrint( "i,j,insert:"+i+","+j +","+insert);
				printArr(uarr);
			}
			uarr[j]=insert;
		}
	}

	/*
	 * @returns partition index
	 */
	public int partition(int[] uarr,  int low, int high)
	{
		
		//move low items left of pivot
		
		int i=low-1; int pivot= uarr[high]; int tmp=0;
		for( int j=low; j <= high-1; j++)
		{
			if( uarr[j] <= pivot) ///pivot is last element
			{
				//swap fields
				i++;
				tmp= uarr[i];
				uarr[i]=uarr[j];
				uarr[j]= tmp;
			}
		}
		
		myPrint( "pivot:"+ pivot+",i="+i+",high="+high);
		printArr(uarr);
		//final swap to move to move the pivot to middle
		uarr[high]=uarr[i+1];
		uarr[i+1]=pivot;
		return i+1;
	}
	/**
	 * Quick Sort
	 * @param uarr
	 * @param low
	 * @param high
	 */
	public void quickSort(int[] uarr, int low, int high)
	{
		//find a pivot as last item of the array
		//partition on pivot
		if( low < high)
		{
			int pi= partition( uarr,low, high);
			
			//recurse
			quickSort( uarr,low, pi-1);
			quickSort(uarr,pi+1,high);
		}
	}
	/**
	 * merges the arrays recursively from low to high
	 * @param uarr
	 * @param l
	 * @param m
	 * @param r
	 */
	public void merge( int[]uarr, int l, int m, int r)
	{
		int larrLen= m-l+1;
		int rarrLen= r-m;
		
		//create 2 temp arrays
		int[] leftArr= new int[larrLen];
		int[] rightArr= new int[rarrLen];
		
		//populate arraysi
		int i=0,j=0;
		for(i=0; i < larrLen; i++ )
		{
			leftArr[i]= uarr[l+i];
		}
		for(i=0; i < rarrLen; i++ )
		{
			rightArr[i]= uarr[m+1+i];
		}
		
		int k= l; //init to low left
		i=0;j=0;  //tmps for looping
		
		while( ( i < larrLen ) && (j < rarrLen))
		{
			if( leftArr[i] <= rightArr[j])
			{
				uarr[k]= leftArr[i];
				i++;
			}
			else
			{
				uarr[k]= rightArr[j];
				j++;
			}
			k++;
		}
		//now merge any leftovers
		while( i < larrLen)
		{
			uarr[k]= leftArr[i];
			i++; k++;
		}
		while( j < rarrLen)
		{
			uarr[k]= rightArr[j];
			j++; k++;
		}		
		
	}
	/**
	 * Merge Sort
	 * @param uarr
	 * @param low
	 * @param high
	 */
	public void mergeSort( int[] uarr, int low, int high)
	{
		if( low < high)
		{
			//find the middle
			int m= (low+high)/2;
			
			//sort left
			mergeSort( uarr, low, m);
			//sort right
			mergeSort( uarr, m+1, high);
			//merge
			merge( uarr, low,m,high);
		}
	}
	
	/**
	 * Heap Sort
	 * @param uarr
	 */
	public void heapSort(int[] uarr )
	{
		// build max heap from arr
		// move the top to bottom
		// remove the bottom from heap and heapify
		//repeat until size of heap is 1
		
		int n= uarr.length;
		
		for( int i= n/2-1; i >= 0; i--)
		{
			heapify( uarr, n, i);
		}
		
		for( int i= n-1; i >=0; i--)
		{
			//swap 1st and last 
			int temp= uarr[0];
			uarr[0]= uarr[i];
			uarr[i]=temp;
			//heapify
			heapify( uarr, i, 0);
		}
		
	}
	
	
	void printKLargestUsingHeap( int[] uarr, int k)
	{
		//build max heap
		int n= uarr.length;
		//myPrint( "arr len:"+n);
		for( int i= n/2-1; i >= 0; i--)
		{
			heapify(uarr, n, i);
		}
		int j=0;
		for(int i=n-1; i>=0; i--)
		{
			myPrint(" "+extractMax( uarr, i));
			j++;
			if(j > k) return;
		}
		
	}
	
	int extractMax(int[] uarr, int n)
	{
		if( n == 0) return -1;
		if( n == 1) return uarr[0];
		//myPrint( "extractMax: n="+n);
		int max= uarr[0];
		uarr[0]=uarr[n];
		uarr[n]= max;

		heapify( uarr, n, 0);
		return max;
	}
	/**
	 * heapify a sub tree rooted with node i, n is size of the heap
	 * @param arr
	 */
	void heapify(int[] uarr, int n, int i)
	{
		//get the indices in order
		int largest= i; //assume i is root node
		int left= 2*i+1; // since heap is complete binary tree
		int right= 2*i+2; 

		//myPrint( "heapify:n="+n+",i="+i);
		//printArr(uarr);
		
		if( left < n && (uarr[left] > uarr[largest]))
		{
			largest= left;
		}
		if( right < n && (uarr[right] > uarr[largest]))
		{
			largest= right;
		}
		
		if( largest != i)
		{
			//swap values and heapify again
			int temp= uarr[i];
			uarr[i]= uarr[largest];
			uarr[largest]=temp;
			heapify( uarr, n, largest);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//String str=null;
		//System.out.println(str);
		// TODO Auto-generated method stub
		//System.out.println("Blah");
		SortAlgos sa= new SortAlgos();
//		sa.generateRandomArray();
//		sa.printArr();
//		System.out.println("Sorting ascending order using bubble sort");
//		sa.bubbleSort(true);
//		sa.printArr();
//		System.out.println( "Enter a value to search:");
		//String elementS= System.console().readLine();
		//int element= Integer.parseInt(elementS);
		
		//System.out.println( element+" Binary search returned: "+ sa.binarySearch(element));
		
		//int[] uarr= {12,11,13,6,5};
		
/*		System.out.println( "Quick Sort");
		int[] uarr=  {10, 80, 30, 90, 40, 50, 70};
		sa.printArr(uarr);
		//sa.insertionSort(uarr);
		sa.quickSort(uarr, 0, uarr.length-1);
		sa.printArr(uarr);
		
		System.out.println( "######## Merge Sort############");
		int uarr1[]= {10, 80, 30, 90, 40, 50, 70};
		sa.printArr(uarr1);
		//sa.insertionSort(uarr);
		sa.mergeSort(uarr1, 0, uarr1.length-1);
		sa.printArr(uarr1);
		*/
		
		System.out.println( "Heap Sort");
		//int[] uarr=  {10, 80, 30, 90, 40, 50, 70};
		int uarr[] = {12, 11, 13, 5, 6, 7};
		sa.printArr(uarr);
		//sa.heapSort(uarr);
		sa.printKLargestUsingHeap(uarr, 4);
		sa.printArr(uarr);		
		

	}

	
	public void myPrint( String str)
	{
		System.out.println(str);
	}
}
