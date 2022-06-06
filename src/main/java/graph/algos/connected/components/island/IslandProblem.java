package graph.algos.connected.components.island;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.junit.Test;

public class IslandProblem {

	
	public void countIslands(Character[][] grid) {
		Set<Grid> visitedPositions = new HashSet<Grid>();
		int count = 0;
		for (int i=0; i< grid[0].length; i++) {
			Character[] gridLine = grid[i];
			for (int j=0; j< gridLine.length; j++) {
				if(breadthFirstTraversalRecursive(grid, i, j, visitedPositions)) {
					count = count + 1;
				}
			}
		}
		System.out.println("No of islands" + count);
	}
	
	public boolean breadthFirstTraversalRecursive(Character[][] grid, int row, int column, Set<Grid> visitedSet) {
		if(row <0 || row >=grid.length) return false;
		if(column <0 || column >=grid[0].length) return false;
		if(grid[row][column] =='W') return false;
		
		if(visitedSet.add(new Grid(row, column))) {
			breadthFirstTraversalRecursive(grid, row+1, column, visitedSet);
			breadthFirstTraversalRecursive(grid, row-1, column, visitedSet);
			breadthFirstTraversalRecursive(grid, row, column+1, visitedSet);
			breadthFirstTraversalRecursive(grid, row, column-1, visitedSet);
		} else {
			return false;
		}
		
		return true;
	}
	
	@Test
	public void countIslandsTest() {
		countIslands(prepareInput());
	}
	
	public Character[][] prepareInput() {
		Character[][] grid = {
					 {'W', 'L', 'W', 'W', 'W'},
		             {'W', 'L', 'W', 'W', 'W'},
		             {'W', 'W', 'W', 'L', 'W'},
		             {'W', 'W', 'L', 'L', 'W'},
		             {'L', 'W', 'W', 'L', 'L'},
		             {'L', 'L', 'W', 'W', 'W'},
		};
		return grid;
	}
}
class Grid {
	private int position1;
	private int psoition2;
	public Grid(int position1, int psoition2) {
		this.position1 = position1;
		this.psoition2 = psoition2;
	}
	public int getPosition1() {
		return position1;
	}
	public void setPosition1(int position1) {
		this.position1 = position1;
	}
	public int getPsoition2() {
		return psoition2;
	}
	public void setPsoition2(int psoition2) {
		this.psoition2 = psoition2;
	}
	@Override
	public int hashCode() {
		return Objects.hash(position1, psoition2);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Grid other = (Grid) obj;
		return position1 == other.position1 && psoition2 == other.psoition2;
	}
	@Override
	public String toString() {
		return "Grid [position1=" + position1 + ", psoition2=" + psoition2 + "]";
	}
}
