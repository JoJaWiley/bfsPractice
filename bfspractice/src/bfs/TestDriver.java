package bfs;

public class TestDriver {

	public static void main(String[] args) {
		
		Graph graph = new Graph();
		
		//edges (a, e), (e, d), (d, f), (d, c), (f, c), (f, b), (c, b)
		graph.addVertex("a");
		graph.addVertex("b");
		graph.addVertex("c");
		graph.addVertex("d");
		graph.addVertex("e");
		graph.addVertex("f");
		
	
		
		graph.addEdge("a", "e");
		graph.addEdge("e", "d");
		graph.addEdge("d", "f");
		graph.addEdge("d", "c");
		graph.addEdge("f", "c");
		graph.addEdge("f", "b");
		graph.addEdge("c", "b");
		
		graph.breadthFirstSearch("a", "b");
	}

}
