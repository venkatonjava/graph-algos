package graph.algos.depth.first.traversal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;
/**
 * @author venkatonjava
 * Graph Traversal (Directed Graph)
 * 		
 <br/>* 		d------>f
 <br/>* 		^
 <br/>* 		|		
 <br/>* 		|		
 <br/>* 		b		e
 <br/>* 		^		^
 <br/>* 		|		|
 <br/>* 		|		|
 <br/>* 		a------->c
<br/> *
 */

public class DepthFirstTraversalRecursiveImpl {

	public void depthFirstTraverse(Character node, Map<Character, List<Character>> inputMap) {
		System.out.println(node);
		List<Character> adjacentNodes = inputMap.get(node);
		for (Character adj : adjacentNodes) {
			depthFirstTraverse(adj, inputMap);
		}
	}

	@Test
	public void depthFirstTraverseTest() {
		Map<Character, List<Character>> inputMap = new HashMap<>();
		inputMap.put('a', Arrays.asList('c', 'b'));
		inputMap.put('b', Arrays.asList('d'));
		inputMap.put('c', Arrays.asList('e'));
		inputMap.put('d', Arrays.asList('f'));
		inputMap.put('e', Arrays.asList());
		inputMap.put('f', Arrays.asList());
		depthFirstTraverse('a', inputMap);
	}

}
