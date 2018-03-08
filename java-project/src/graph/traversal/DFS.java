package graph.traversal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import graph.structure.Graph;

public class DFS extends GraphTraversal {
	public static <T> void traverse(final Graph<T> graph, int from, final Consumer<T> callBack) {
		Set<Integer> visited = new HashSet<>();
		dfs(visited, graph, from, callBack);
	}
	
	private static <T> void dfs(Set<Integer> visited, final Graph<T> graph, int here, final Consumer<T> callBack) {
		visited.add(here);
		
		graph.getVertex(here).ifPresent(callBack::accept);
		
		List<Integer> nextVertices = graph.getAdjacencyList().get(here);
		if (nextVertices != null) {
			nextVertices
				.stream()
				.distinct()
				.filter(there -> !visited.contains(there))
				.forEach(there -> dfs(visited, graph, there, callBack));
		}
	}
}
