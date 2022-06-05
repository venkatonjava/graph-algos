package graph.algos.breadth.first.traversal;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;
/**
 * @author venkatonjava
 * Graph Traversal
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
 *Use Stack implementation for Breadth first traversal. From the root node push all the adjacent nodes to the stack 
 *and pop the first node on the stack and push all the adjacent nodes to the stack.
 *When element is Popped, Traversal visits that node and pushes all the adjacent nodes to the stack  
 *From the above example: Source Node a<br/>
 *--> Push sourceNode to stack - Stack [a] <br/> 
 *-->2. Pop 'a'(visited node) and move all the adjacent nodes to stack - Stack [b, c]<br/>
 *-->3. Queue poll will return what is next in queue 'c' and add all the adjacent nodes  from 'c' to the back of the Queue - Queue [e, b]<br/>
 *-->4. Queue poll will return what is next in queue 'b' and Push all the adjacent nodes from 'b' to the back of the Queue - Queue [d, e]<br/>
 *-->5. Queue poll will return what is next in queue 'e' and Push all the adjacent nodes from 'e'(None) to Queue - Queue [d]<br/>
 *-->6. Queue poll will return what is next in queue 'd' and Push all the adjacent nodes from 'd' to the back of the Queue - Queue [f]<br/>
 *-->7. Queue poll will return what is next in queue 'f' and Push all the adjacent nodes from 'f'(none) to Queue - Queue []<br/>
 *-->8. Queue is empty. That means all nodes are visited.
 */

public class BreadthFirstTraversal {

	private Map<Character, List<Character>> inputMap = null;
	public void breadthFirstTraverse(Character startingNode) {
		 Queue<Character> queue = new ArrayDeque<>();
		 queue.add(startingNode);
		 while(queue.size()>0) {
			 final Character node = queue.poll();
			 queue.addAll(inputMap.get(node));
			 System.out.println(node);
		 }
	}

	@Test
	public void breadthFirstTraverseTest() {
		breadthFirstTraverse('a');
	}

	@Before
	public void prepareInput() {
		inputMap = new HashMap<>();
		inputMap.put('a', Arrays.asList('c', 'b'));
		inputMap.put('b', Arrays.asList('d'));
		inputMap.put('c', Arrays.asList('e'));
		inputMap.put('d', Arrays.asList('f'));
		inputMap.put('e', Arrays.asList());
		inputMap.put('f', Arrays.asList());
	}
}
