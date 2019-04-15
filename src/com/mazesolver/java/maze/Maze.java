package com.mazesolver.java.maze;

import com.mazesolver.java.utilities.Constants;

import java.util.*;

public class Maze
{
	private MazeCell[][] mazeGrid;
	public MazeCell start;
	public MazeCell finish;
	
	// Instantiate every cell in the maze logic
	public Maze(int mazeSize)
	{
		 // references to previous cells to pass to new ones
		MazeCell upCell, leftCell;
		
		Constants.setMazeSize(mazeSize);
		this.mazeGrid = new MazeCell[mazeSize][mazeSize];
		
		// instantiate cells
		for(int row = 0; row < Constants.getMazeSize(); row++)
		{
			for(int column = 0; column < Constants.getMazeSize(); column++)
			{
				if(row == 0)
				{
					// if on the top edge there is no cell above
					upCell = null;
				}
				else
				{
					// otherwise set upCell to cell above
					upCell = this.mazeGrid[row - 1][column];
				}
				
				if(column == 0)
				{
					// if on left column there is no cell to the left
					leftCell = null;
				}
				else
				{
					// otherwise set leftCell to the adjacent cell
					leftCell = this.mazeGrid[row][column - 1];
				}
				
				this.mazeGrid[row][column] = new MazeCell(row, column, upCell, leftCell);
			}
		}
		
		this.selectRandomStart();
		this.generateMaze();
	}

	// Select a random cell on the outside border of the maze to use as
	// the beginning of the maze
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
			while(!(((adjacentCell = this.getAdjacent(stack.peek(), Constants.UP)) == null) || visited.contains(adjacentCell)) ||
				  !(((adjacentCell = this.getAdjacent(stack.peek(), Constants.RIGHT)) == null) || visited.contains(adjacentCell)) ||
				  !(((adjacentCell = this.getAdjacent(stack.peek(), Constants.DOWN)) == null) || visited.contains(adjacentCell)) ||
				  !(((adjacentCell = this.getAdjacent(stack.peek(), Constants.LEFT)) == null) || visited.contains(adjacentCell)))
			{
				// If the stack depth is greater than the current maxDepth and the
				// current cell at the top of the stack is on an edge, update maxDepth
				// and set the finish point to that cell in order to have the longest maze solution
				if((stack.size() > maxDepth) && stack.peek().isOnBoundary())
				{
					maxDepth = stack.size();
					this.finish = stack.peek();
				}

				System.out.printf("current cell: [%d,%d]\n", stack.peek().getRow(), stack.peek().getColumn());
				
				// generates random moves until one leads to an unexplored
				// cell within the bounds of the maze
				do
				{					
					adjacentMoveDirection = rand.nextInt(4) + 1;
					
					System.out.println(adjacentMoveDirection);
					
					// Set the adjacent cell to the moveDirection from the current cell being evaluated
					adjacentCell = this.getAdjacent(stack.peek(), adjacentMoveDirection);
					
				} while(adjacentCell == null || visited.contains(adjacentCell));
				
				System.out.println("Done");
				
				// change the wall to an open space at the correct edge
				switch(adjacentMoveDirection)
				{
					case Constants.UP:
						stack.peek().setUpEdge(Constants.OPEN);
						break;
					case Constants.RIGHT:
						stack.peek().setRightEdge(Constants.OPEN);
						break;
					case Constants.DOWN:
						stack.peek().setDownEdge(Constants.OPEN);
						break;
					case Constants.LEFT:
						stack.peek().setLeftEdge(Constants.OPEN);
						break;
					default:
						break;
				}

				visited.add(stack.peek());  // add the adjacent cell into the visited list
				stack.push(adjacentCell);  // push the adjacent cell into the stack
			}

			System.out.printf("Popping cell: [%d,%d]\n", stack.peek().getRow(), stack.peek().getColumn());
			
			// pop the stack to backtrack if no adjacent cells have not been visited
			visited.add(stack.peek());
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

	public MazeCell[][] getMazeGrid()
	{
		return mazeGrid;
	}

}
