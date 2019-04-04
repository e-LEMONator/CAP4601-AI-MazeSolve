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
		Stack<MazeCell> stack = new Stack();  // For keeping track of where we need to go
		ArrayList<MazeCell> visited = new ArrayList();  // For making sure not to visit a previous cell
		Random rand = new Random();
		int adjacentMoveDirection;  // The direction of the next adjacent cell for evaluation
		MazeCell adjacentCell;
		int maxDepth = 0;

		// Add the starting point to the stack
		stack.push(this.start);
		
		// Perform maze Generation logic until our stack is empty
		do
		{
			// While the adjacent cells have not been visited, visit the cells and add to stack
			while(!visited.contains(this.getAdjacent(stack.peek(), Constants.UP)) ||
				  !visited.contains(this.getAdjacent(stack.peek(), Constants.RIGHT)) ||
				  !visited.contains(this.getAdjacent(stack.peek(), Constants.DOWN)) ||
				  !visited.contains(this.getAdjacent(stack.peek(), Constants.LEFT)))
			{

				// If the stack depth is greater than the current maxDepth, update maxDepth
				// and set the finish point to that cell in order to have the longest maze solution
				if(stack.size() > maxDepth)
				{
					maxDepth = stack.size();
					this.finish = stack.peek();
				}

				// TODO: Comment this do while
				do
				{					
					adjacentMoveDirection = rand.nextInt(4) + 1;

					// Set the adjacent cell to the moveDirection from the current cell being evaluated
					adjacentCell = this.getAdjacent(stack.peek(), adjacentMoveDirection);
				} while(adjacentCell == null || visited.contains(adjacentCell));
				
				visited.add(stack.peek());  // add the adjacent cell into the visited list
				stack.push(adjacentCell);  // push the adjacent cell into the stack
			}

			// pop the stack to backtrack if no adjacent cells have not been visited
			stack.pop();

		} while(!stack.isEmpty());
	}

	private MazeCell getAdjacent(MazeCell currentCell, int move)
	{
		int row, column;

		// Check to see if the next move is out of bounds and then
		// return the new position of the currentCell
		if(currentCell.checkMove(move) != Constants.OOB)
		{
			row = currentCell.getRow();
			column = currentCell.getColumn();

			// Check move to determine direction of the new currentCell
			// relative to the existing one
			switch(move)
			{
				case Constants.STAY:
					return this.mazeGrid[row][column];
				case Constants.UP:
					return this.mazeGrid[row - 1][column];
				case Constants.RIGHT:
					return this.mazeGrid[row][column + 1];
				case Constants.DOWN:
					return this.mazeGrid[row + 1][column];
				case Constants.LEFT:
					return this.mazeGrid[row][column - 1];
				default:
					break;
			}
		}
		
		return null;
	}
	
	// TODO: implement printMaze

}
