package com.mazesolver.java.utilities;

import com.mazesolver.java.maze.*;

public class MazePrinter
{
	public static void printMaze(Maze maze)
	{
		printFirstLine(maze);
		
		for(int row = 0; row < Constants.getMazeSize(); row++)
		{
			printCellLine(maze, row);
			
			printWallLine(maze, row);
		}
		
		System.out.printf("\n\n");
	}
	
	private static void printFirstLine(Maze maze)
	{
		MazeCell currentCell;
		
		System.out.printf("#");
			
		for(int column = 0; column < Constants.getMazeSize(); column++)
		{
			currentCell = maze.getMazeGrid()[0][column];

			System.out.printf("%s%c", ((currentCell.getUpEdge().get() < 1) ? "---" : "   "), '#');
		}

		System.out.printf("\n");
	}
	
	private static void printCellLine(Maze maze, int row)
	{
		MazeCell currentCell;
		
		System.out.printf("|");
			
		for(int column = 0; column < Constants.getMazeSize(); column++)
		{
			currentCell = maze.getMazeGrid()[row][column];

			System.out.printf(" %c %c", currentCell.getSymbol(), ((currentCell.getRightEdge().get() < 1) ? '|' : ' '));
		}

		System.out.printf("\n");
	}
	
	private static void printWallLine(Maze maze, int row)
	{
		MazeCell currentCell;
		
		System.out.printf("#");
		
		for(int column = 0; column < Constants.getMazeSize(); column++)
		{
			currentCell = maze.getMazeGrid()[row][column];

			System.out.printf("%s%c", ((currentCell.getDownEdge().get() < 1) ? "---" : "   "), '#');
		}

		System.out.printf("\n");
	}
}
