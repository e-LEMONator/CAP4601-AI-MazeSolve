package com.mazesolver.java;

import com.mazesolver.java.maze.Maze;
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

		IOHandler.menu(maze);
    }
}
