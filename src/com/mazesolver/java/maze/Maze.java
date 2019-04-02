package com.mazesolver.java.maze;

import com.mazesolver.java.Constants;

import java.util.*;

public class Maze
{
	private MazeCell[][] mazeGrid;
	private MazeCell start;
	private MazeCell finish;
	
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
		MazeCell currentCell;
		MazeCell adjacentCell;
		boolean adjacentVisited = false;

		Random rand = new Random();
		int adjacentMove;

		Stack stack = new Stack();  // For keeping track of where we need to go
		ArrayList visited = new ArrayList();  // For making sure not to visit a previous cell

		currentCell = this.start;

		do
		{
			stack.push(currentCell);
			// TODO: add currentCell to visited list


			adjacentMove = rand.nextInt(4) + 1;

			while (!adjacentVisited)
			{
				adjacentCell = currentCell;

				switch(adjacentMove)
				{
					// TODO: Fix this assignment
					case Constants.UP: // Move up
						adjacentCell[2] ;
						break;
					case Constants.RIGHT: // Move right
						adjacentCell = currentCell;
						break;
					case Constants.DOWN: // Move down
						adjacentCell = currentCell;
					case Constants.LEFT: // Move left
						adjacentCell = currentCell;
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

		}while(!stack.isEmpty());


	}

	private boolean checkAdj(MazeCell currentCell, int move)
	{

	}
	
	// TODO: implement printMaze
}
