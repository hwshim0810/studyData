package graph.traversal;

import java.util.function.Consumer;

import graph.structure.Graph;

public abstract class GraphTraversal {
	public static <T> void traverse(final Graph<T> graph, int from, final Consumer<T> callBack) {}
}
