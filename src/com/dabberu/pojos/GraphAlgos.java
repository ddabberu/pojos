package com.dabberu.pojos;
import java.util.*;
/**
 * 
 * @author ddabberu
 *
 */
public class GraphAlgos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g= new Graph( 5);
		g.addEdges(0, 1);
		g.addEdges(0, 2);
		g.addEdges(2, 1);
		g.addEdges(2, 3);
		g.addEdges(2, 2);
		g.addEdges(3, 3);
		g.addEdges(2, 4);
		g.addEdges(4, 2);
		g.breadthFirstTraversalFromVerice(2);
		System.out.println("\nDFS");
		g.depthFirstTraversalFromVertice(2);
	}

}

class Graph
{
	int v; //number of verticles
	LinkedList<Integer> adjArr[];
	
	//constructor
	public Graph( int v)
	{
		this.v=v;
		//init array
		adjArr= new LinkedList[v];
		for( int i=0; i < v; i++)
		{
			adjArr[i]= new LinkedList<Integer>();
		}
	}
	//add an edge between v1 and v2 birectional
	//since it's undirected graph
	void addEdges(int v1, int v2)
	{
		if( adjArr[v1] == null)
		{
			adjArr[v1].add(v2);
		}
		else
		{
			adjArr[v1].addFirst(v2);
		}
		if( adjArr[v2] == null)
		{
			adjArr[v2].add(v1);
		}
		else
		{
			adjArr[v2].addFirst(v1);
		}		
	}
	
	void breadthFirstTraversalFromVerice(int src)
	{
		//mark the visited vertex
		//keep traversing
		boolean visited[] = new boolean[v];
		//create a queue for traversing
		visited[src]=true;
		LinkedList<Integer> queue= new LinkedList();
		queue.add(src);
		
		while( queue.size() != 0)
		{
			int i= queue.poll(); //dequeue the vertex
			System.out.print(" "+i);
			//iterate through the vertex, traverse adjecent nodes
			Iterator<Integer> iter = adjArr[src].iterator();
			
			while( iter.hasNext())
			{
				int next= iter.next();
				
				System.out.println( "edge:"+next);
				if( !visited[next])
				{
					visited[next]=true;
					queue.add(next);
				}
				
			}
		}
	}
	
	void depthFirstTraversalFromVertice( int vertex)
	{
		boolean[] visited= new boolean[v];
		dfsRecursive( vertex, visited );
		
	}
	
	void dfsRecursive( int vertex, boolean[] visited)
	{
		visited[vertex]=true;
		System.out.print(" "+vertex);
		Iterator<Integer> iter= adjArr[vertex].iterator();
		while( iter.hasNext())
		{
			int next= iter.next();
			if(  !visited[next])
			{
				dfsRecursive( next, visited);
			}
		}
		
	}
	
}
