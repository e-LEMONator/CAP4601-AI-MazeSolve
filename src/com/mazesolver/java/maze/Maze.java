package com.mazesolver.java.maze;

public class Maze
{
	private MazeCell[][] mazeGrid;
	
	public Maze(int mazeSize)
	{
		this.mazeSize = mazeSize;
		this.mazeGrid = new MazeCell[mazeSize][mazeSize];
		
		for(int row = 0; row < this.mazeSize; row++)
		{
			for(int column = 0; column < this.mazeSize; column++)
			{
				this.mazeGrid[row][column] = new MazeCell(row, column);
			}
		}
	}
	
	// TODO: implement generateMaze

	
	// TODO: implement printMaze
}
