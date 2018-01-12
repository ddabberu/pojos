package com.dabberu.pojos;

public class QuickSortTest {

	public static void main(String[] args) {
		int[] arr= {12, 11, 13, 5, 6, 7, 10};
		QuickSort qs=new QuickSort();
		qs.printArr(arr);
		qs.sort(arr, 0, arr.length-1);
		qs.printArr(arr);

	}

}


class QuickSort
{
	
	/**
	 * 
	 * @param arr to be partitioned
	 * the elements lower to be moved to left, and higher to the right of pivot
	 * @param lo
	 * @param hi
	 * @return partition final index
	 */
	int partition1(int[] arr, int lo, int hi)
	{
		int dp=0;
		
		int pivotIndex= lo;
		int pivot= arr[pivotIndex]; //pivot around 1st element
		//swap pivot with random element
		//int ri= (int) ( Math.random() * hi-lo+1)+lo;
		//arr[pivotIndex]= arr[ri];
		//arr[ri]=pivot;
		//pivot= arr[pivotIndex]; //pivot around 1st element as randomized
		
		//System.out.println("pi:"+pivotIndex+",pivot:"+pivot);
		for( int i=lo+1; i <= hi; i++)
		{
			if( pivot > arr[i])
			{
				dp++;
				int tmp= arr[i];
				arr[i]=arr[dp];
				arr[dp]=tmp;
			}
		}
		arr[pivotIndex]= arr[dp];
		arr[dp]=pivot;
		return dp;
	}
	
	void sort(int[] arr, int lo, int hi)
	{	
		if( lo < hi)
		{
			int dp= partition1(arr, lo, hi);
			sort( arr, lo, dp-1);
			sort(arr, dp+1, hi);
		}
	}
	
	void printArr( int arr[])
	{
		for(int i=0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println("\n");
	}
	
}