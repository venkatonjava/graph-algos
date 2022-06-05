package graph.algos.haspath;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

//Using Depth first search
public class HasPathProblem {
	
	public boolean hasPathDepthFirst(Character node, Character target, Map<Character, List<Character>> graph) {
		if(node == target) {
			return true;
		}
		List<Character> adjNodes = graph.get(node);
		for (Character adj : adjNodes) {
			if(hasPathDepthFirst(adj, target, graph)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasPathBreadthFirst(Queue<Character> queue, Character target, Map<Character, List<Character>> graph) {
		while (!queue.isEmpty()) {
			Character node = queue.poll();
			if (node == target) {
				return true;
			}
			List<Character> adjNodes = graph.get(node);
			for (Character adj : adjNodes) {
				queue.add(adj);
			}
		}
		return false;
	}
	
	@Test
	public void depthFirstTraverseTest() {
		boolean hasPathDepthFirst = hasPathDepthFirst('a', 'e', prepareInput());
		System.out.println("DFS a --> e has path "+ hasPathDepthFirst);

		boolean hasPathDepthFirst2 = hasPathDepthFirst('a', 'z', prepareInput());
		System.out.println("DFS a --> z has path "+ hasPathDepthFirst2);
	}
	
	@Test
	public void breadthFirstTraverseTest() {
		Queue<Character> queue= new LinkedList<Character>();
		queue.add('a');
		boolean hasPathBreadthFirst = hasPathBreadthFirst(queue, 'e', prepareInput());
		assertTrue(hasPathBreadthFirst);
		System.out.println("BFS a --> e has path "+ hasPathBreadthFirst);
		boolean hasPathBreadthFirst2 = hasPathBreadthFirst(queue, 'z', prepareInput());
		assertFalse(hasPathBreadthFirst2);
		System.out.println("BFS a --> z has path "+ hasPathBreadthFirst);
	}
	
	
	
	

	public Map<Character, List<Character>> prepareInput() {
		Map<Character, List<Character>> graph = new HashMap<>();
		graph.put('a', Arrays.asList('c', 'b'));
		graph.put('b', Arrays.asList('d'));
		graph.put('c', Arrays.asList('e'));
		graph.put('d', Arrays.asList('f'));
		graph.put('e', Arrays.asList());
		graph.put('f', Arrays.asList());
		return graph;
	}
}
