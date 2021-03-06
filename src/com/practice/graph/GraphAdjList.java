package com.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.omg.CosNaming.NamingContextPackage.NotFound;
/**
 * Adjacency List based representation of graph.
 * Graph has been considered as a graph of Characters
 * 
 * @author Sohil
 *
 */
public class GraphAdjList {
	private int numOfVertices;
	private int numOfEdges;
	
	private Map<Character, ArrayList<Character>> graphAdjList;
	
	public GraphAdjList() {
		this.numOfVertices=0;
		this.numOfEdges=0;
		this.graphAdjList = new HashMap<Character, ArrayList<Character>>();
	}

	public int getNumOfVertices() {
		return numOfVertices;
	}

	/**
	 * Adding a vertex into graph
	 * 
	 * @param v
	 * @return
	 */
	public Boolean addVertex(Character v) {
		if(this.graphAdjList.containsKey(v)){
			return false;
		}
		
		this.numOfVertices++;
		this.graphAdjList.put(v, new ArrayList<Character>());
		return true;
	}
	
	/**
	 * Adding an edge to the graph
	 * 
	 * @param v - start vertex
	 * @param w - end vertex
	 * @return - true or false for edge added successfully
	 */
	public Boolean addEdge(Character v, Character w) {
		if(!this.graphAdjList.containsKey(v) || !this.graphAdjList.containsKey(w)){
			return false;
		}
		
		this.numOfEdges++;
		ArrayList<Character> list = this.graphAdjList.get(v);
		list.add(w);
		
		return true;
	}

	public int getNumOfEdges() {
		return numOfEdges;
	}

	/**
	 * Get list of edges of a vertex
	 * 
	 * @param v - vertex for which edges needed to get
	 * @return - ArrayList of associated edges
	 * @throws IllegalArgumentException
	 */
	public ArrayList<Character> getEdgeList(Character v) throws IllegalArgumentException{
		if(!this.graphAdjList.containsKey(v)) {
			throw new IllegalArgumentException("Node "+v+" not found");
		}
		
		return this.graphAdjList.get(v);		
	}

	public static void main(String[] args) {
		GraphAdjList g = new GraphAdjList();
		g.addVertex('a');
		g.addVertex('b');
		g.addVertex('c');
		g.addVertex('d');
		
		g.addEdge('a', 'b');
		g.addEdge('a', 'd');
		g.addEdge('b', 'c');
		g.addEdge('c', 'a');
		g.addEdge('c', 'd');
		
		
		System.out.println("number of vertices: "+g.getNumOfVertices());
		System.out.println("number of edges: "+g.getNumOfEdges());
		
		System.out.println("List of edges of vertex c: "+g.getEdgeList('c').toString());
		
	}
}
