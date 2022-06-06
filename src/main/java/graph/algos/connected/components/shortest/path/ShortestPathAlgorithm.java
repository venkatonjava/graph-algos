package graph.algos.connected.components.shortest.path;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

public class ShortestPathAlgorithm {

	public void findShortestPath(Map<Character, List<Character>> mapInput, Queue<Node> queue, char target) {
		int length = 0;
		Set<Character> visited = new HashSet<>();
		while (queue.size() > 0) {
			Node node = queue.poll();
			if (visited.add(node.node)) {
				length = node.length;
				if (node.node.equals(target)) {
					break;
				}
				length = length + 1;
				List<Character> adjNodes = mapInput.get(node.node);
				for (Character adjNode : adjNodes) {
					queue.add(new Node(adjNode, length));
				}
			}
		}
		System.out.println(length);
	}

	@Test
	public void shortestPathTest() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node('a', 0));
		findShortestPath(prepareInput(), queue, 'e');
	}

	/**
	 * 
	 * 
	 * 
	 * @return
	 */
	public Map<Character, List<Character>> prepareInput() {
		Map<Character, List<Character>> mapInput = new HashMap<>();
		mapInput.put('a', Arrays.asList('b', 'c'));
		mapInput.put('b', Arrays.asList('a', 'd', 'e'));
		mapInput.put('c', Arrays.asList('a'));
		mapInput.put('d', Arrays.asList('b', 'e'));
		mapInput.put('e', Arrays.asList('d', 'b'));
		mapInput.put('i', Arrays.asList('j'));
		mapInput.put('k', Arrays.asList('l'));
		return mapInput;
	}

	class Node {
		Character node;
		int length = 0;

		public Node(Character node, int length) {
			this.node = node;
			this.length = length;
		}

	}
}
