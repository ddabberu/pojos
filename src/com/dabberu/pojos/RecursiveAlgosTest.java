package com.dabberu.pojos;

public class RecursiveAlgosTest {

	public static void main(String[] args) {
		
		System.out.println("Factorial of N=10 is "+factorial(10));
		System.out.println("Factorial of N=5 non Recursive is "+factorialNonRec(10));
		
		System.out.println("Fib of 100");
		System.out.println(System.currentTimeMillis());
		for( int i=0; i < 50; i++)
			System.out.print( fibRec(i)+",");
		System.out.println(System.currentTimeMillis());
		System.out.println("\nFib of 100 Non Recursive");
		System.out.println(System.currentTimeMillis());
		for( int i=0; i < 50; i++)
			System.out.print( fibNonRec(i)+",");
		System.out.println(System.currentTimeMillis());
	}

	static int factorial(int n)
	{
		if(n<=0) return 0;
		if(n==1)  return 1;
		return n*factorial(n-1);
	}
	
	static int factorialNonRec(int n)
	{
		if(n<=0) return 0;
		if(n==1)  return 1;
		int fact=1;
		while( n > 1)
		{
			fact= fact*n;
			n--;
		}
		return fact;
	}
	
	static int fibRec(int n)
	{
		if(n<=0) return 1;
		if(n==1)  return 1;
		return fibRec(n-1)+fibRec(n-2);
	}
	
	static int fibNonRec(int n)
	{

		if( n==1 || n==0) return 1;
		int fib_last=1;
		int fib_2ndlast=1;
		int fib= 1;
		for( int i=2; i <= n; i++)
		{
			fib= fib_last+fib_2ndlast;
			fib_2ndlast=fib_last;
			fib_last=fib;
		}
		return fib;
	}

}
