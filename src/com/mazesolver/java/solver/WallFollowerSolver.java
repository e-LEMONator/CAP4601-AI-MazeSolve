package com.mazesolver.java.solver;

import com.mazesolver.java.maze.Maze;

public class WallFollowerSolver extends Solver
{
	public WallFollowerSolver(Maze maze)
	{
		super(maze);
	}

	public void solve()
	{



		// clear the maze for the next solver method to have a fresh solution
		this.maze.clearMaze();
	}
}
