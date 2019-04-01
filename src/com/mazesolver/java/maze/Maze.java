package com.mazesolver.java.maze;

import com.mazesolver.java.Constants;

import java.util.*;

public class Maze
{
	private MazeCell[][] mazeGrid;
	private MazeCell start;
	private MazeCell finish;
	private MazeCell currentCell;
	private MazeCell adjacentCell;
	
	public Maze(int mazeSize)
	{
		Constants.setMazeSize(mazeSize);
		this.mazeGrid = new MazeCell[mazeSize][mazeSize];
		
		for(int row = 0; row < Constants.getMazeSize(); row++)
		{
			for(int column = 0; column < Constants.getMazeSize(); column++)
			{
				this.mazeGrid[row][column] = new MazeCell(row, column);
			}
		}
		
		selectRandomStart();
	}
	
	private void selectRandomStart()
	{
		Random rand = new Random();
		int bound = rand.nextInt(4) + 1;
		
		switch(bound)
		{
			case Constants.UP: // top bound
				this.start = this.mazeGrid[0][rand.nextInt(Constants.getMazeSize())];
				break;
			case Constants.RIGHT: // right bound
				this.start = this.mazeGrid[rand.nextInt(Constants.getMazeSize())][Constants.getMazeSize() - 1];
				break;
			case Constants.DOWN: // bottom bound
				this.start = this.mazeGrid[0][rand.nextInt(Constants.getMazeSize())];
			case Constants.LEFT: // left bound
				this.start = this.mazeGrid[rand.nextInt(Constants.getMazeSize())][Constants.getMazeSize() - 1];
			default:
				break;
		}
	}
	
	// TODO: implement generateMaze
	private void generateMaze()
	{
		boolean adjacentVisited = false;
		Stack queue = new Stack();  // For keeping track of where we need to go
		ArrayList visited = new ArrayList();  // For making sure not to visit a previous cell

		this.currentCell = this.start;

		do
		{
			queue.push(this.currentCell);
			// TODO: add currentCell to visited list

			Random rand = new Random();
			int adjacentMove = rand.nextInt(4) + 1;

			while (!adjacentVisited)
			{
				switch(adjacentMove)
				{
					// TODO: Fix this assignment
					case Constants.UP: // Move up
						this.adjacentCell = this.currentCell;
						break;
					case Constants.RIGHT: // Move right
						this.adjacentCell = this.currentCell;
						break;
					case Constants.DOWN: // Move down
						this.adjacentCell = this.currentCell;
					case Constants.LEFT: // Move left
						this.adjacentCell = this.currentCell;
					default:
						break;
				}

				// TODO: Implement this check
//				if (this.adjacentCell //not visited, so not in visited list)
//				{
//
//				}
			}

			// TODO: Break the wall between currentCell and adjacentCell

			currentCell = adjacentCell;

		}while(!queue.isEmpty());


	}
	
	// TODO: implement printMaze
}
