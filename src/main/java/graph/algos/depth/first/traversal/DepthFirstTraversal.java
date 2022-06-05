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
 *Use Stack implementation for depth first traversal. From the root node push all the adjacent nodes to the stack 
 *and pop the first node on the stack and push all the adjacent nodes to the stack.
 *When element is Popped, Traversal visits that node and pushes all the adjacent nodes to the stack  
 *From the above example: Source Node a<br/>
 *--> Push sourceNode to stack - Stack [a] <br/> 
 *-->2. Pop 'a'(visited node) and move all the adjacent nodes to stack - Stack [b, c]<br/>
 *-->3. Stack pop will return what is on top 'b' and Push all the adjacent nodes from 'b' to stack - Stack [d, c]<br/>
 *-->4. Stack pop will return what is on top 'd' and Push all the adjacent nodes from 'd' to stack - Stack [f, c]<br/>
 *-->5. Stack pop will return what is on top 'f' and Push all the adjacent nodes from 'f'(None) to stack - Stack [c]<br/>
 *-->6. Stack pop will return what is on top 'c' and Push all the adjacent nodes from 'c' to stack - Stack [e]<br/>
 *-->7. Stack pop will return what is on top 'e' and Push all the adjacent nodes from 'e'(none) to stack - Stack []<br/>
 *-->8. Stack is empty. That means all nodes are visited.
 */

public class DepthFirstTraversal {

	Map<Character, List<Character>> inputMap = null;
	public void depthFirstTraverse(Character startingNode) {
		 Stack<Character> stack = new Stack<>();
		 stack.push(startingNode);
		 while(stack.size()>0) {
			 Character node = stack.pop();
			 stack.addAll(inputMap.get(node));
			 System.out.println(node);
		 }
	}

	@Test
	public void depthFirstTraverseTest() {
		depthFirstTraverse('a');
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
