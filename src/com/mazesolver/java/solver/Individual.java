package com.mazesolver.java.solver;

import com.mazesolver.java.maze.*;
import com.mazesolver.java.utilities.Constants;

import java.util.Random;

public class Individual implements Comparable<Individual>
{
	private Maze maze;
	private int[] gene;

	public Individual(Maze maze)
	{
		this.maze = maze;
		this.gene = new int[Constants.getMazeSize() * Constants.getMazeSize()];
		this.generateGene();
	}

	private void generateGene()
	{
		Random rand = new Random();

		for(int chromosome : this.gene)
		{
			chromosome = rand.nextInt(5);
		}
	}

	public int evaluateGene()
	{
		int penalty = 0;
		MazeCell currentCell = this.maze.getStart();

		for (int chromosome : this.gene)
		{
			switch (currentCell.checkMove(chromosome))
			{
				case Constants.WALL:
					penalty++;
				case Constants.OPEN:
					currentCell = maze.getAdjacent(currentCell, chromosome);
					break;
				case Constants.OOB:
					return Integer.MAX_VALUE;
				default:
					break;
			}

			if (currentCell.equals(this.maze.getFinish()))
			{
				break;
			}
		}

		return penalty + this.maze.getDistToFinish(currentCell);
	}

	@Override
	public int compareTo(Individual o)
	{
		if (this.evaluateGene() > o.evaluateGene())
		{
			return 1;
		} else if (this.evaluateGene() < o.evaluateGene())
		{
			return -1;
		} else
		{
			return 0;
		}
	}
}
