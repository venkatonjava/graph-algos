package graph.algos.connected.components;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

public class LargentConnectedComponentProblem {

	public int largestConnectedComponentsRecursive(Map<Character, List<Character>> mapInput, Character current, Set<Character> visited,
			int count) {
		if(visited.add(current)) {
			count = count+1;
			List<Character> adjNodes = mapInput.get(current);
			if(Objects.nonNull(adjNodes)) {
				for(Character character: adjNodes) {
					count = largestConnectedComponentsRecursive(mapInput, character, visited, count);
				}
			}
		}
		return count;
	}
	
	public void largestConnectedComponentsRecursive(Map<Character, List<Character>> mapInput) {
		int count = 0;
		int maxCount = 0;
		Set<Character> visitedNodes = new HashSet<>();
		for(Character node: mapInput.keySet()) {
			count = largestConnectedComponentsRecursive(mapInput, node, visitedNodes, count);
			if (count > maxCount) {
				maxCount = count;
				count =0;
			}
		}
		System.out.println("Connected Componenets Recursive method " + maxCount);
	}
	public void largestConnectedComponents(Map<Character, List<Character>> mapInput) {
		Set<Character> visitedNodes = new HashSet<Character>();
		int maxNodes = 0;
		int currentComponentCount = 0;
		for(Character nodeChar: mapInput.keySet()) {
			Stack<Character> characters = new Stack<Character>();
			characters.push(nodeChar);
			while(characters.size()>0) {
				Character node = characters.pop(); //Visit All nodes using depth first traversal
				if(visitedNodes.add(node)) {
					currentComponentCount++;
					List<Character> adjcentNodes = mapInput.get(node);
					if(Objects.nonNull(adjcentNodes)) {
						for (Character adjNode : adjcentNodes) {
							characters.push(adjNode);
						}
					}
				}
			}
			if(currentComponentCount>maxNodes) {
				maxNodes = currentComponentCount;
				currentComponentCount=0;
			}
		}
		System.out.println(maxNodes);
	}
	
	@Test
	public void largestConnectedComponentsTest() {
		largestConnectedComponents(prepareInput());
	}
	
	@Test
	public void largestConnectedComponentsRecursiveTest() {
		largestConnectedComponentsRecursive(prepareInput());
	}
	 
	public Map<Character, List<Character>> prepareInput() {
		Map<Character, List<Character>> mapInput = new HashMap<>();
		mapInput.put('a', Arrays.asList('b', 'c'));
		mapInput.put('b', Arrays.asList('a', 'd'));
		mapInput.put('c', Arrays.asList('a', 'e'));
		mapInput.put('d', Arrays.asList('b', 'e'));
		mapInput.put('e', Arrays.asList('c', 'd'));
		mapInput.put('i', Arrays.asList('j'));
		mapInput.put('k', Arrays.asList('l'));
		return mapInput;
	}
}
