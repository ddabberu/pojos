/**
 * 
 */
package com.dabberu.pojos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author ddabberu
 *
 */
public class WordCount {
	
	String[] words;
	int[] count;
	int totalWords;
	public WordCount(int size) {
		words= new String[size];
		count= new int[size];
		for( int i=0; i< size; i++)
		{
			words[i]=""; count[i]=0;
			
		}
		totalWords=0;
	}
	
	/**
	 * Inserts the word in alpha sorted array
	 * @param word
	 */
	void insertWordAndSort( String word)
	{
		if( totalWords > words.length) {
			myPrint( "The array is full",false);
			return;
		}
		if( totalWords==0)
		{
			words[totalWords]=word;
			count[0]=1;
			totalWords++;
		}
		else
		{
			//sort and insert
			words[totalWords]= word; //add it at the end
			totalWords++;
			int len= totalWords-1;			
			printWordsArr();
			//myPrint("totalWords:"+totalWords+",word:"+word,true);
			myPrint("",true);
			int high= len-1; //last-1 index to compare
			while( high >= 0)
			{
				System.out.println(word+","+words[high]);
				if( word.compareTo(words[high]) < 0 )
				{
					swap( high,high+1);
					high--;
					//System.out.println(word+","+words[high]+", high--"+high);
				}
				else break;
			}
		}
	}

	void swap( int a, int b)
	{
		String tmp= words[a];
		words[a]=words[b];
		words[b]=tmp;
	}
	static void myPrint( String str, boolean newLine)
	{
		if( newLine)
		{
			System.out.println(str);
		}
		else
		{
			System.out.print(str+",");
		}
	}
	
	
/**
 * 
 * @param str
 * @return index if found, or position to be inserted
 */
	int binarySearch( String str)
	{
		int hi=totalWords;
		int low=0;
		
		
		while( low <= hi)
		{
			int mid=(hi+low)/2;
			if(  str.compareToIgnoreCase(words[mid]) == 0)
			{
				return mid;
			}
			else if(  str.compareToIgnoreCase(words[mid]) > 0)
			{
				low=mid+1;
			}
			else if(  str.compareToIgnoreCase(words[mid]) < 0)
			{
				hi=mid-1;
			}
		}
		
		return low; //key to remember
	}
	
	public static void main(String[] args) throws Exception {
		//assumptions
		//the max size of the array is 100
		//sort 100 words at maximum and prints the word count
		
		WordCount wc= new WordCount(100);
		//read a file to input stream
		Scanner scan= new Scanner( new File("/Users/ddabberu/words.txt"));
		
		while( scan.hasNextLine())
		{
			Scanner sc1= new Scanner( scan.nextLine());
			while( sc1.hasNext())
			{
				String word=sc1.next();
				word=word.trim();
				int index= wc.binarySearch(word);
				//wc.myPrint( "word:"+word+",index:"+index,true);
				//wc.myPrint( word, false);
				if( word.compareTo(wc.words[index]) == 0)
				{
					//increment count
					wc.count[index]= wc.count[index]++;
				}
				else 
				{
					//insert at the location
					wc.addToList(word, index );
				}
			}
			sc1.close();
		}
		scan.close();
		wc.printWordsAndCount();
		
		
//		wc.insertWordAndSort("are");
//		wc.insertWordAndSort("do"
//		wc.insertWordAndSort("is");
//		wc.insertWordAndSort("merely");
//		wc.insertWordAndSort("be");
//		wc.insertWordAndSort("and");
//		wc.insertWordAndSort("durga");
//		wc.insertWordAndSort("word");		
//		wc.insertWordAndSort("add");	
//		wc.printWordsArr();
//		myPrint("",true);
		
		//read something from file

	}

	private void addToList(String word, int index) {
		
		//add the word at the index
		//shift everything to right
		if( totalWords==0)
		{
			myPrint("Here",true);
			totalWords++;
			words[0]=word;
			count[0]=1;
			return;
		}
		for( int i=totalWords-1; i >= index; i--)
		{
			//myPrint( "i:"+i,true);
			words[i+1]=words[i];
			count[i+1]=count[i];
		}
		words[index]=word;
		count[index]=1;
		totalWords++;
				
	}
	void printWordsAndCount( )
	{
		myPrint("TotalWords:"+totalWords,true);
		for( int i=0; i< totalWords; i++)
		{
			String str= words[i]+"#\t\t"+count[i];
			myPrint( str,true);
		}
	}
	void printWordsArr( )
	{
		myPrint("TotalWords:"+totalWords,true);
		for( int i=0; i< totalWords; i++)
		{
			myPrint( words[i],false);
		}
	}
}
