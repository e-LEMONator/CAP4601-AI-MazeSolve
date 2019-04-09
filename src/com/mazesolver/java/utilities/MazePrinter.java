package com.mazesolver.java.utilities;

import com.mazesolver.java.maze.*;

public class MazePrinter
{
	public static void printMaze(Maze maze)
	{
		MazeCell currentCell;
		
		System.out.printf("+");
			
		for(int column = 0; column < Constants.getMazeSize(); column++)
		{
			currentCell = maze.getMazeGrid()[0][column];

			System.out.printf("%c%c", ((currentCell.getUpEdge().get() < 1) ? '-' : ' '), '+');
		}

		System.out.printf("\n");
		
		for(int row = 0; row < Constants.getMazeSize(); row++)
		{
			System.out.printf("|");
			
			for(int column = 0; column < Constants.getMazeSize(); column++)
			{
				currentCell = maze.getMazeGrid()[row][column];
				
				System.out.printf("%c%c", currentCell.getSymbol(), ((currentCell.getRightEdge().get() < 1) ? '|' : ' '));
			}
			
			System.out.printf("\n+");
			
			for(int column = 0; column < Constants.getMazeSize(); column++)
			{
				currentCell = maze.getMazeGrid()[row][column];
				
				System.out.printf("%c%c", ((currentCell.getDownEdge().get() < 1) ? '-' : ' '), '+');
			}
			
			System.out.printf("\n");
		}
		
		System.out.printf("\n\n");
	}
}
