package bfs;

import java.util.*;


public class Vertex {

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

	@Override
	public int hashCode() {
		return Objects.hash(adjacents);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		return Objects.equals(adjacents, other.adjacents);
	}
	
}
