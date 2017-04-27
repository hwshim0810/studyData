package graph.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Graph<T> {
	private List<T> vertices = new ArrayList<>();
	private List<Edge> edges = new ArrayList<>();
	private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
	
	public Optional<T> getVertex(int i) {
		try {
			return Optional.of(vertices.get(i));
		} catch (IndexOutOfBoundsException e) {
			return Optional.empty();
		}
	}
	
	public Optional<Edge> getEdge(int i) {
		try {
			return Optional.of(edges.get(i));
		} catch (IndexOutOfBoundsException e) {
			return Optional.empty();
		}
	}
	
	public void addVertex(T v) {
		vertices.add(v);
	}
	
	public void addVertices(List<T> v) {
		vertices.addAll(v);
	}
	
	public void addEdge(Edge e) {
		edges.add(e);
		adjacencyList
			.computeIfAbsent(e.from, (from) -> new ArrayList<Integer>())
			.add(e.to);
	}
	
	public Map<Integer, List<Integer>> getAdjacencyList() {
		return adjacencyList;
	}
}
