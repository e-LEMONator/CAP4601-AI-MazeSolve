package com.mazesolver.java.solver;

import com.mazesolver.java.maze.Maze;

public abstract class Solver
{
	private Maze maze;

	public Solver(Maze maze)
	{
		this.maze = maze;
	}

	public abstract void solve();
}