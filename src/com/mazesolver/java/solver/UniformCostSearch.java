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
		Queue<MazeCell> queue = new LinkedList<>();  // Frontier queue for keeping track of where we need to go
		ArrayList<MazeCell> visited = new ArrayList();  // For making sure not to visit a previous cell
		Random rand = new Random();
		int adjacentMoveDirection;  // The direction of the next adjacent cell for evaluation
		MazeCell adjacentCell;

		// Add the starting point to the queue
		queue.add(maze.start);

		// Perform while frontier queue is not empty
		while (!queue.isEmpty())
		{
			// if the queue is at the finish of the maze, return the solution
			if (queue.peek() == maze.finish)
			{
				//TODO: return solution
			}

			visited.add(queue.peek()); // add the current cell to the visited list
			queue.remove(); // remove the current cell from the frontier queue

			//iterate through all 4 directions to see if the children nodes are valid moves
			// and if they should be expanded
			for (int direction = 1; direction <= 4; direction++)
			{
				switch (direction)
				{
					case Constants.UP: // top bound

						break;
					case Constants.RIGHT: // right bound

						break;
					case Constants.DOWN: // bottom bound

					case Constants.LEFT: // left bound
						
					default:
						break;
				}

				// TODO: check to see if the direction is a valid move

			}

		}


	}
}


