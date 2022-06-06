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

public class ConnectedComponentsProblem {

	public boolean connectedComponentsRecursive(Map<Character, List<Character>> mapInput, Character current, Set<Character> visited) {
		if(!visited.add(current)) {
			return false;
		}
		List<Character> adjNodes = mapInput.get(current);
		if(Objects.nonNull(adjNodes)) {
			for(Character character: adjNodes) {
				connectedComponentsRecursive(mapInput, character, visited);
			}
		}
		return true;
	}
	
	public void countConnectedComponentsRecursive(Map<Character, List<Character>> mapInput) {
		int count = 0;
		Set<Character> visitedNodes = new HashSet<>();
		for(Character node: mapInput.keySet()) {
			if(connectedComponentsRecursive(mapInput, node, visitedNodes)) {
				count++;
			}
		}
		System.out.println("Connected Componenets Recursive method " + count);
	}
	public void countConnectedComponents(Map<Character, List<Character>> mapInput) {
		Set<Character> visitedNodes = new HashSet<Character>();
		int connectedComponets = 0;
		for(Character nodeChar: mapInput.keySet()) {
			Stack<Character> characters = new Stack<Character>();
			boolean island = false;
			characters.push(nodeChar);
			while(characters.size()>0) {
				Character node = characters.pop(); //Visit All nodes using depth first traversal
				if(visitedNodes.add(node)) {
					island = true;
					List<Character> adjcentNodes = mapInput.get(node);
					if(Objects.nonNull(adjcentNodes)) {
						for (Character adjNode : adjcentNodes) {
							characters.push(adjNode);
						}
					}
				}
			}
			if(island) { 
				connectedComponets++;
			}
		}
		System.out.println(connectedComponets);
	}
	
	@Test
	public void countConnectedComponentsTest() {
		countConnectedComponents(prepareInput());
	}
	
	@Test
	public void countConnectedComponentsRecursiveTest() {
		countConnectedComponentsRecursive(prepareInput());
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
