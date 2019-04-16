package com.mazesolver.java.utilities;

import com.mazesolver.java.maze.MazeCell;

public class MazeCellPair implements Comparable<MazeCellPair>
{
	private final MazeCell cell;
	private final int depth;

	public MazeCellPair(MazeCell cell, int depth)
	{
		this.cell = cell;
		this.depth = depth;
	}
	
	@Override
	public int compareTo(MazeCellPair o)
	{
		if(this.depth > o.depth)
		{
			return 1;
		}
		else if(this.depth == o.depth)
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}

	public MazeCell getCell()
	{
		return cell;
	}

	public int getDepth()
	{
		return depth;
	}

	
}
