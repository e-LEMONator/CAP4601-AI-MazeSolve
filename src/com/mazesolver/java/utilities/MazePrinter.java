package com.mazesolver.java.utilities;

import com.mazesolver.java.maze.Maze;

public class MazePrinter
{
	public static void printMaze(Maze maze)
	{
		// length of one demention of maze as it is printed with walls and bounds
		int printedMazeSize = (Constants.getMazeSize() * 2) + 1;
		
		for(int i = 0; i < printedMazeSize; i++)
		{
			System.out.printf("#");
		}
		
		for(int row = 0; row < Constants.getMazeSize(); row++)
		{
			System.out.printf("#");
			
			for(int column = 0; column < Constants.getMazeSize(); column++)
			{
				System.out.printf("");
			}
			
			System.out.printf("#");
		}
	}
}
