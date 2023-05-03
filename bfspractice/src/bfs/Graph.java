package bfs;

import java.util.*;

public class Graph {
	//representing a graph as a hashmap of vertices with their names
	private HashMap<String, Vertex> vertices;
	
	//constructor - initialize hashmap
	public Graph() {
		this.vertices = new HashMap<>();
	}
	
	//like a setter, but just add one vertex by name
	public Vertex addVertex(String name) {
		Vertex vertex = new Vertex();
		vertices.put(name,  vertex);
		return vertex;
	}
	
	public void addEdge(String vertex1, String vertex2) {
		//get vertices by name
		Vertex v1 = vertices.get(vertex1);
		Vertex v2 = vertices.get(vertex2);
		
		//add vertices as adjacents to each other
		v1.addAdjacent(v2);
		v2.addAdjacent(v1);
	}
	
	//traversal method
	public void breadthFirstTraversal(String start, String end) {
		//get the start & end vertices from vertices HashMap by name
		Vertex startVert = vertices.get(start);
		Vertex endVert = vertices.get(end);
		
		//queue of vertices to traverse, implemented by LinkedList
		LinkedList<Vertex> queue = new LinkedList<>();
		//HashSet of vertices already visited
		HashSet<Vertex> visited = new HashSet<>();
		
		//add the first vertex to visited
		visited.add(startVert);
		
		//current vertex to check - start appropriately at start
		Vertex current = startVert;
		//repeat until end is reached
		while (current != endVert)
		{
			//get the current vertex's adjacents
			LinkedList<Vertex> adjacents = current.getAdjacents();
			
			//add all the adjacents that haven't already been visited to visited and queue
			for (Vertex v: adjacents)
			{
				if (!visited.contains(v))
				{
					visited.add(v);
					queue.add(v);
				}
			}
			
			//go to the next vertex in the queue
			current = queue.remove();
		}
	}
	
	//search method to get a path from start vertex to end vertex
	public LinkedList<Vertex> breadthFirstSearch(String start, String end) {
		//get start and end vertices from the HashMap by name
		Vertex startVert = vertices.get(start);
		Vertex endVert = vertices.get(end);
		
		//queue of vertices to search, implemented by linkedlist
		LinkedList<Vertex> queue = new LinkedList<>();
		//Hashmap - each vertex and its previous vertex
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		
		//the first vertex has no previous vertex
		visited.put(startVert,  null);
		
		//the current vertex initializes at start
		Vertex current = startVert;
		
		//loop until the end vertex is reached
		while (current != endVert)
		{
			//get the adjacents of the current vertex
			LinkedList<Vertex> adjacents = current.getAdjacents();
			
			//add all the adjacents that haven't already been visited
			for (Vertex v : adjacents) 
			{
				if (!visited.containsKey(v))
				{	
					//add current's unvisited adjacent, with current as previous
					visited.put(v, current);
					//add v to queue
					queue.add(v);
				}
			}
			
			//go to the next vertex
			current = queue.remove();
		}
		
		//create the path by adding from end to start
		LinkedList<Vertex> path = new LinkedList<>();
		path.addFirst(current);
		
		//end at the start vertex
		while (current != startVert)
		{
			//get the value corresponding to the key of current, which is its previous vertex, and set that to current
			current = visited.get(current);
			//use addFirst to get the right order (start to end) - adding in front of the last current
			path.addFirst(current);
		}
		
		return path;
	}
}
