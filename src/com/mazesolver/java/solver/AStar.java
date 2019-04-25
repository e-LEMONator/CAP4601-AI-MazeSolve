package com.mazesolver.java.solver;

import com.mazesolver.java.maze.*;

public class AStar extends UniformCostSearch
{
	public AStar(Maze maze)
	{
		super(maze);
	}

	@Override
	PriorityQueueNode createAdjNode(PriorityQueueNode currentNode, int moveDirection)
	{
		MazeCell adjacentCell = this.maze.getAdjacent(currentNode.getCell(), moveDirection);
		int adjacentDepth = currentNode.getDepth() + 1;
		int adjacentCost = adjacentDepth + this.maze.getDistToFinish(adjacentCell); 
		return new PriorityQueueNode(adjacentCell, adjacentCost, adjacentDepth);
	}
}
