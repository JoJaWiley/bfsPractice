package bfs;

import java.util.*;


public class Vertex {

	private LinkedList<Vertex> adjacents;
	
	public Vertex() {
		this.adjacents = new LinkedList<Vertex>();
	}
	
	public void addAdjacent(Vertex adjacentVertex) {
		adjacents.add(adjacentVertex);
	}
	
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
