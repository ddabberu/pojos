/**
 * 
 */
package com.dabberu.pojos;

/**
 * @author ddabberu
 * @category Various solutions to popular java questions
 */
public class Solutions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( "First set bit for Number 2 is "+ FindSetBit(2));
		System.out.println( "First set bit for Number 12 is "+ FindSetBit(12));
		System.out.println( "First set bit for Number 18 is "+ FindSetBit(18));
		System.out.println( "First set bit for Number 1024 is "+ FindSetBit(1024));
		System.out.println( " Is 1 power of 2? "+ isPowerOf2(1));
		System.out.println( " Is 2 power of 2? "+ isPowerOf2(2));
		System.out.println( " Is 3 power of 2? "+ isPowerOf2(3));
		System.out.println( " Is 128 power of 2? "+ isPowerOf2(128));
	}
	
	
	//find the 1st set bit from right
	static int FindSetBit(int number)
	{
		int index=1;
		while( number != 0)
		{
			if( number%2 == 1) return index;
			else {
				number=number/2;
				index++;
			}
		}
		return 0;
	}

	/**
	 * By using bitwise and operation to determine, other methonds are divide by 2 until 0, log2 etc...
	 * @param number
	 * @return
	 */
	static boolean isPowerOf2( int number)
	{
		if ( number > 0)
		{
			return ( (number &( number-1)) == 0);
		}
		return false;
	}
}
