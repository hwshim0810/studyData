package graph.traversal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.function.Consumer;

import graph.structure.Graph;

public class BFS extends GraphTraversal {
	public static <T> void traverse(final Graph<T> graph, int from, final Consumer<T> callBack) {
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(from);
		while (!queue.isEmpty()) {
			int here = queue.poll();
			visited.add(here);
			
			graph.getVertex(here).ifPresent(callBack::accept);
			
			List<Integer> nextVertices = graph.getAdjacencyList().get(here);
			if (nextVertices != null) {
				nextVertices
					.stream()
					.distinct()
					.filter(there -> !visited.contains(there))
					.forEach(queue::add);
			}
		}
	}
}
