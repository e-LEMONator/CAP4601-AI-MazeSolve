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
		PriorityQueue<PriorityQueueNode> queue = new PriorityQueue<>();
		ArrayList<MazeCell> visited = new ArrayList();  // For making sure not to visit a previous cell
		PriorityQueueNode currentNode = new PriorityQueueNode(this.maze.getStart(), 0, 0);

		queue.add(currentNode);

		// Perform while frontier queue is not empty
		while(!queue.isEmpty())
		{
			// update the current node to the least cost neighbor
			currentNode = queue.poll();

			// change the nodes symbol to indicate current node
			if(!(currentNode.getCell().equals(this.maze.getStart())) && !(currentNode.getCell().equals(this.maze.getFinish())))
			{
				currentNode.getCell().setSymbol('@');
			}

			MazePrinter.printMaze(this.maze);
			
			// if the queue is at the finish of the maze, break
			if(currentNode.getCell().equals(this.maze.getFinish()))
			{
				break;
			}

			//iterate through all 4 directions to see if the children nodes are valid moves
			// and if they should be expanded
			for(int moveDirection = 1; moveDirection <= 4; moveDirection++)
			{
				if((currentNode.getCell().checkMove(moveDirection) == Constants.OPEN) &&
						!visited.contains(this.maze.getAdjacent(currentNode.getCell(), moveDirection)))
				{
					queue.add(createAdjNode(currentNode, moveDirection));
				}
			}

			visited.add(currentNode.getCell());

			// change the nodes symbol to indicate the node has been visited
			if(!(currentNode.getCell().equals(this.maze.getStart())) && !(currentNode.getCell().equals(this.maze.getFinish())))
			{
				currentNode.getCell().setSymbol('*');
			}
		}
		// clear the maze for the next solver method to have a fresh solution
		this.maze.clearMaze();
	}
	
	PriorityQueueNode createAdjNode(PriorityQueueNode currentNode, int moveDirection)
	{
		MazeCell adjacentCell = this.maze.getAdjacent(currentNode.getCell(), moveDirection);
		int adjacentDepth = currentNode.getDepth() + 1;
		return new PriorityQueueNode(adjacentCell, adjacentDepth, adjacentDepth);
	}
}
