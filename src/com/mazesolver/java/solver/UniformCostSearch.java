package com.mazesolver.java.solver;

import com.mazesolver.java.maze.*;
import com.mazesolver.java.utilities.*;

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
		PriorityQueue<MazeCellPair> queue = new PriorityQueue<>();
		ArrayList<MazeCell> visited = new ArrayList();  // For making sure not to visit a previous cell
		MazeCellPair currentPair = new MazeCellPair(this.maze.getStart(), 0);

		queue.add(currentPair);

		// Perform while frontier queue is not empty
		while(!queue.isEmpty())
		{
			MazePrinter.printMaze(this.maze);

			currentPair = queue.poll();

			currentPair.getCell().setSymbol('@');

			// if the queue is at the finish of the maze, break
			if(currentPair.getCell().equals(this.maze.getFinish()))
			{
				break;
			}

			//iterate through all 4 directions to see if the children nodes are valid moves
			// and if they should be expanded
			for(int direction = 1; direction <= 4; direction++)
			{
				if((currentPair.getCell().checkMove(direction) == Constants.OPEN) &&
						!visited.contains(currentPair.getCell()))
				{
					queue.add(new MazeCellPair(this.maze.getAdjacent(currentPair.getCell(), direction), currentPair.getDepth() + 1));
				}
			}

			visited.add(currentPair.getCell());

			currentPair.getCell().setSymbol('*');
		}
	}
}
