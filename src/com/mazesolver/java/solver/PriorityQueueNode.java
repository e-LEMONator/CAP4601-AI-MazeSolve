package com.mazesolver.java.solver;

import com.mazesolver.java.maze.MazeCell;

public class PriorityQueueNode implements Comparable<PriorityQueueNode>
{
	private final MazeCell cell;
	private final int cost;
	private final int depth;

	public PriorityQueueNode(MazeCell cell, int cost)
	{
		this.cell = cell;
		this.cost = cost;
		this.depth = cost;
	}

	public PriorityQueueNode(MazeCell cell, int cost, int depth)
	{
		this.cell = cell;
		this.cost = cost;
		this.depth = depth;
	}

	@Override
	public int compareTo(PriorityQueueNode o)
	{
		if (this.cost > o.cost)
		{
			return 1;
		} else if (this.cost < o.cost)
		{
			return -1;
		} else
		{
			return 0;
		}
	}

	public MazeCell getCell()
	{
		return cell;
	}

	public int getCost()
	{
		return cost;
	}

	public int getDepth()
	{
		return depth;
	}
}
