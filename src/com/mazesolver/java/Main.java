package com.mazesolver.java;

import com.mazesolver.java.maze.Maze;
import com.mazesolver.java.solver.*;

public class Main
{
    public static void main(String[] args)
	{
		Maze maze = new Maze(10);
		
		//UniformCostSearch ucsSolver = new UniformCostSearch(maze);
		AStar astar = new AStar(maze);
		
		astar.solve();
    }
	
	// TODO: add argument handling for maze size and debug mode
}
