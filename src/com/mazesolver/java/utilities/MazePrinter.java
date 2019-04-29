package com.mazesolver.java.utilities;

import com.mazesolver.java.maze.*;

public class MazePrinter
{
	/**
	 * prints the entirety of the maze
	 *
	 * @param maze maze to be printed
	 */
	public static void printMaze(Maze maze)
	{
		// print the top boundry before iterating through the rest of the maze
		printFirstLine(maze);

		// iterate through rows of cells printing a line for each cell and a
		// line below each cell
		for (int row = 0; row < Constants.getMazeSize(); row++)
		{
			printCellLine(maze, row);

			printWallLine(maze, row);
		}

		System.out.printf("\n\n");
	}

	/**
	 * prints the top border of the maze
	 *
	 * @param maze maze to be printed
	 */
	private static void printFirstLine(Maze maze)
	{
		MazeCell currentCell;

		System.out.printf("#");

		for (int column = 0; column < Constants.getMazeSize(); column++)
		{
			currentCell = maze.getMazeGrid()[0][column];

			System.out.printf("%s%c", ((currentCell.getUpEdge().get() < 1) ? "---" : "   "), '#');
		}

		System.out.printf("\n");
	}

	/**
	 * prints a line with all the cell symbols and right walls
	 *
	 * @param maze maze to be printed
	 * @param row  row of the maze to be printed
	 */
	private static void printCellLine(Maze maze, int row)
	{
		MazeCell currentCell;

		System.out.printf("|");

		for (int column = 0; column < Constants.getMazeSize(); column++)
		{
			currentCell = maze.getMazeGrid()[row][column];

			System.out.printf(" %c %c", currentCell.getSymbol(), ((currentCell.getRightEdge().get() < 1) ? '|' : ' '));
		}

		System.out.printf("\n");
	}

	/**
	 * prints a line below the cell symbols with bottom walls and corners
	 *
	 * @param maze maze to be printed
	 * @param row  row of the maze to be printed
	 */
	private static void printWallLine(Maze maze, int row)
	{
		MazeCell currentCell;

		System.out.printf("#");

		for (int column = 0; column < Constants.getMazeSize(); column++)
		{
			currentCell = maze.getMazeGrid()[row][column];

			System.out.printf("%s%c", ((currentCell.getDownEdge().get() < 1) ? "---" : "   "), '#');
		}

		System.out.printf("\n");
	}
}
