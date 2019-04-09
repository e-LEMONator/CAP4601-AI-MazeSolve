package com.mazesolver.java;

import com.mazesolver.java.maze.Maze;
import com.mazesolver.java.utilities.MazePrinter;

public class Main
{

    public static void main(String[] args)
	{
		Maze maze = new Maze(10);
		
		MazePrinter.printMaze(maze);
    }
	
}
