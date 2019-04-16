package com.mazesolver.java.solver;

import com.mazesolver.java.maze.Maze;
import com.mazesolver.java.maze.MazeCell;
import com.mazesolver.java.utilities.Constants;

import java.util.*;

public class UniformCostSearch extends Solver
{
	public UniformCostSearch(Maze maze)
	{
		super(maze);
	}

	@Override
	public void solve()
	{
		//expand node with smallest path cost
		//(equal for the maze due to the path cost being uniformly 1 in all directions)
		TreeMap<Integer, MazeCell> queue = new TreeMap<>();  // Frontier queue for keeping track of where we need to go
		ArrayList<MazeCell> visited = new ArrayList();  // For making sure not to visit a previous cell
		int adjacentMoveDirection;  // The direction of the next adjacent cell for evaluation
		MazeCell adjacentCell;
		int queueDepth = 0;

		// Add the starting point to the queue
		queue.put(queueDepth, maze.getStart();

		// Perform while frontier queue is not empty
		while (!queue.isEmpty())
		{
			// if the queue is at the finish of the maze, return the solution
			if (queue.peek() == maze.getFinish())
			{
				//TODO: return solution
			}

			visited.add(queue.peek()); // add the current cell to the visited list

			//iterate through all 4 directions to see if the children nodes are valid moves
			// and if they should be expanded
			for (int direction = 1; direction <= 4; direction++)
			{


			}

		}


	}
}


