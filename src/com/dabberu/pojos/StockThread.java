/**
 * 
 */
package com.dabberu.pojos;

/**
 * @author ddabberu
 * @category Various solutions to popular java questions
 */
public class StockThread{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stockprices= {1,2,-3,5,8,1};
		Thread s1= new Thread(new StockThread(stockprices) );
		Thread s2= new Thread(new StockThread(stockprices) );
		
	}
}


class Stock{

	int shares;
	int cost;
	int profit;

}
	public void run()
	{
		
	}
	
	int arr[];
	int stocks;
	int cost;
	int sellPrice;
	boolean bSorted;
	StockThread(int[] range)
	{
		stocks=cost=sellPrice=0;
		bSorted=false;
		arr=range;
	}
	void buy()
	{
		//stocks=stock
		cost= findMin();
		synchronized(this){
			stocks=stocks+1;
		}
	}
	
	void sell()
	{
		if( stocks > 0)
		{
			sellPrice=findMax();
			synchronized( this)
			{
				stocks=stocks-1;
			}
		}
	}
	void merge( int[] uarr, int l, int m, int h)
	{
		//define 2 arrays
		int rLen= h-m;
		int rightArr[]=new int[rLen];
		
		//rightarr
		for( int i=0; i < rLen; i++)
		{
			rightArr[i]= uarr[m+1+i];
		}
		
		int lLen=m-l+1;
		int leftArr[]=new int[lLen];
		//leftarr
		for( int i=0; i < lLen; i++)
		{
			leftArr[i]= uarr[l-i];
		}		
		
		//merge
		int i=0,j=0; int k=l;//initite to low limit
		
		while( (i < lLen) && (j < rLen)) {
			
			if( leftArr[i] <= rightArr[j])
			{
				uarr[k]=leftArr[i];
				k++;
				i++;
			}
			else 
			{
				uarr[k]=rightArr[j];
				k++;
				j++;
			}
		}
		//remaining edges
		while( i < lLen)
		{
			uarr[k]= leftArr[i];
			i++;k++;
		}
		while( j < rLen)
		{
			uarr[k]= rightArr[j];
			j++;k++;
		}		
		
	}
	//mergesort
	void sort(int[] uarr, int l, int h)
	{
		if( l > h)
		{
		int mid=l+h/2;
		sort(  uarr, 0, mid);
		sort(uarr, mid+1,h);
		merge(uarr, l, mid, h);
		}
	}
	
	
	int findMax()
	{
		//sort the array for max value
		if(bSorted == false)
		{
			//sort
			bSorted=true;
			
		}
		return arr[arr.length-1];
	}
	int findMin()
	{
		//sort the array for max value
		if(bSorted == false)
		{
			//sort
			bSorted=true;
			
		}
		return arr[0];
	}	
	

}
