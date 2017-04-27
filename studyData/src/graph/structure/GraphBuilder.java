package graph.structure;

import java.util.List;

public class GraphBuilder<T> {
	private Graph<T> graph;
	
	public GraphBuilder() {
		graph = new Graph<T>();
	}
	
	public GraphBuilder<T> addVertex(T v) {
		graph.addVertex(v);
		return this;
	}
	
	public GraphBuilder<T> addVertices(List<T> v) {
		graph.addVertices(v);
		return this;
	}
	
	public GraphBuilder<T> addEdge(Edge e) {
		graph.addEdge(e);
		return this;
	}
	
	public GraphBuilder<T> addEdge(int from, int to) {
		graph.addEdge(new Edge(from, to));
		return this;
	}
	
	public Graph<T> toGraph() { return graph; }
}
