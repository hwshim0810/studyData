package graph.traversal;

import java.util.Arrays;
import java.util.Scanner;

import graph.structure.Graph;
import graph.structure.GraphBuilder;
import graph.traversal.BFS;
import graph.traversal.DFS;

public class GraphTest {
	public static final String HELLO_1S = "Hello, %s!";
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String name = scanner.nextLine();
			System.out.println(String.format(HELLO_1S, name));
		}
		
		// Sample tree
		//      0
		//    /   \
		//   1     2
		//  / \   / \
		// 3   4 5   6
		GraphBuilder<Integer> graphBuilder = new GraphBuilder<>();
		graphBuilder
			.addVertices(Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5, 6}))
			.addEdge(0, 1)
			.addEdge(0, 2)
			.addEdge(1, 3)
			.addEdge(1, 4)
			.addEdge(2, 5)
			.addEdge(2, 6);
		
		Graph<Integer> graph = graphBuilder.toGraph();
		System.out.println("DFS start.");
		DFS.traverse(graph, 0, System.out::println);
		System.out.println("DFS done.");
		
		System.out.println("BFS start.");
		BFS.traverse(graph, 0, System.out::println);
		System.out.println("BFS done.");
	}
}
