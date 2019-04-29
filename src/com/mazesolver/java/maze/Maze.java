package com.mazesolver.java.maze;

import com.mazesolver.java.utilities.Constants;

import java.util.*;

public class Maze
{
	private MazeCell[][] mazeGrid;
	private MazeCell start;
	private int startingBorder;
	private MazeCell finish;
	
	// Instantiate every cell in the maze logic
	public Maze()
	{
		// references to previous cells to pass to new ones
		MazeCell upCell, leftCell;

		this.mazeGrid = new MazeCell[Constants.getMazeSize()][Constants.getMazeSize()];

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

	/**
	 * finds a random edge cell and sets the start value to it
	 */
	private void selectRandomStart()
	{
		Random rand = new Random();
		int bound = rand.nextInt(4) + 1;

		switch(bound)
		{
			case Constants.UP: // top bound
				this.start = this.mazeGrid[0][rand.nextInt(Constants.getMazeSize())];
				this.startingBorder = Constants.UP;
				break;
			case Constants.RIGHT: // right bound
				this.start = this.mazeGrid[rand.nextInt(Constants.getMazeSize())][Constants.getMazeSize() - 1];
				this.startingBorder = Constants.RIGHT;
				break;
			case Constants.DOWN: // bottom bound
				this.start = this.mazeGrid[Constants.getMazeSize() - 1][rand.nextInt(Constants.getMazeSize())];
				this.startingBorder = Constants.DOWN;
				break;
			case Constants.LEFT: // left bound
				this.start = this.mazeGrid[rand.nextInt(Constants.getMazeSize())][0];
				this.startingBorder = Constants.LEFT;
				break;
			default:
				break;
		}

		this.start.setSymbol('S');
	}

	/**
	 * performs a randomized depth first search on the cell, changing walls to
	 * openings as it goes
	 */
	private void generateMaze()
	{
		Stack<MazeCell> stack = new Stack();  // For keeping track of where we need to go
		ArrayList<MazeCell> visited = new ArrayList();  // For making sure not to visit a previous cell
		Random rand = new Random();
		int moveDirection;  // The direction of the next adjacent cell for evaluation
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
				if(Constants.isDebugMode())
				{
					System.out.printf("current cell: [%d,%d]\n", stack.peek().getRow(), stack.peek().getColumn());
				}

				// generates random moves until one leads to an unexplored
				// cell within the bounds of the maze
				do
				{
					moveDirection = rand.nextInt(4) + 1;

					if(Constants.isDebugMode())
					{
						System.out.printf("Randomly generatend move direction: %d\n", moveDirection);
					}

					// Set the adjacent cell to the moveDirection from the current cell being evaluated
					adjacentCell = this.getAdjacent(stack.peek(), moveDirection);

				} while(adjacentCell == null || visited.contains(adjacentCell));

				if(Constants.isDebugMode())
				{
					System.out.printf("Valid random move found\n");
				}

				// change the wall to an open space at the correct edge
				switch(moveDirection)
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

				// If the stack depth is greater than the current maxDepth and the
				// current cell at the top of the stack is on an edge, update maxDepth
				// and set the finish point to that cell in order to have the longest maze solution
				if((stack.size() > maxDepth) && stack.peek().isOnBoundary())
				{
					maxDepth = stack.size();
					this.finish = stack.peek();
				}
			}

			if(Constants.isDebugMode())
			{
				System.out.printf("Popping cell: [%d,%d]\n", stack.peek().getRow(), stack.peek().getColumn());
			}

			// pop the stack to backtrack if no adjacent cells have not been visited
			visited.add(stack.peek());
			stack.pop();

		} while(!stack.isEmpty());

		this.finish.setSymbol('E');
	}

	/**
	 * finds a cell adjacent to the given cell given a move distance
	 *
	 * @param currentCell the cell we need to find an adjacent cell for
	 * @param move the direction we need to move to get our adjacent cell
	 * @return cell in the move selection or null if there is none valid
	 */
	public MazeCell getAdjacent(MazeCell currentCell, int move)
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
	
	/**
	 * calculates Manhattan distance
	 * 
	 * @param currentCell cell to start measuring the distance from
	 * @return distance from current cell to finish
	 */
	public int getDistToFinish(MazeCell currentCell)
	{
		return Math.abs(this.getFinish().getRow() - currentCell.getRow()) + Math.abs(this.getFinish().getColumn() - currentCell.getColumn());
	}

	public MazeCell[][] getMazeGrid()
	{
		return mazeGrid;
	}

	public MazeCell getStart()
	{
		return start;
	}

	public int getStartingBorder()
	{
		return startingBorder;
	}

	public MazeCell getFinish()
	{
		return finish;
	}

	public void clearMaze()
	{
		for (int i = 0; i < mazeGrid.length; i++)
		{
			for (int j = 0; j <mazeGrid[i].length; j++)
			{
				mazeGrid[i][j].setSymbol(' ');
			}
		}
	}
}
