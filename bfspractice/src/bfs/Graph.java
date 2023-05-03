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
		v2.addAdjacent(v1);;
	}
}
