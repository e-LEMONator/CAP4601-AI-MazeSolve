package com.mazesolver.java;

import com.mazesolver.java.maze.Maze;
import com.mazesolver.java.solver.*;
import com.mazesolver.java.utilities.IOHandler;

public class Main
{
    public static void main(String[] args)
	{
		// Parse command line arguments to determine maze
		// dimensions NxN and set debug boolean.
		IOHandler.parseCMDArgs(args);

		// Instantiate new maze
		Maze maze = new Maze();

		//UniformCostSearch ucsSolver = new UniformCostSearch(maze);
		AStar astar = new AStar(maze);

		astar.solve();
    }

	// TODO: add argument handling for maze size and debug mode
}
