package bfs;

import java.util.*;


public class Vertex {
	
	private String name;

	//represent a vertex as a list of its adjacents
	private LinkedList<Vertex> adjacents;
	
	//constructor - initialize list of adjacents
	public Vertex() {
		this.adjacents = new LinkedList<Vertex>();
	}
	
	//like a setter, but just add one adjacent vertex
	public void addAdjacent(Vertex adjacentVertex) {
		adjacents.add(adjacentVertex);
	}
	
	//getter for list of adjacents
	public LinkedList<Vertex> getAdjacents() {
		return adjacents;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
