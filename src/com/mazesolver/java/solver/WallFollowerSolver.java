package com.mazesolver.java.solver;

import com.mazesolver.java.maze.Maze;
import com.mazesolver.java.maze.MazeCell;
import com.mazesolver.java.utilities.Constants;
import com.mazesolver.java.utilities.MazePrinter;

import java.util.ArrayList;
import java.util.Scanner;

public class WallFollowerSolver extends Solver
{
	public WallFollowerSolver(Maze maze)
	{
		super(maze);
	}

	@Override
	public void solve()
	{
		MazeCell currentCell = this.maze.getStart();
		int currentDirection;
		Scanner sc = new Scanner(System.in);
		char selection;
		boolean skip = false;

		currentDirection = getLeftTurn(this.maze.getStartingBorder());

		while(!currentCell.equals(this.maze.getFinish()))
		{
			// change the nodes symbol to indicate current node
			if(!currentCell.equals(this.maze.getStart()))
			{
				currentCell.setSymbol('@');
			}

			if(!skip)
			{
				MazePrinter.printMaze(this.maze);

				do
				{
					System.out.print("Continue to next step (c), or skip to the end (s)? ");
					selection = sc.next().charAt(0);

					switch(selection)
					{
						case 'c':
						case 'C':
							break;
						case 's':
						case 'S':
							skip = true;
							break;
						default:
							System.out.println("Invalid entry, please try again:");
							selection = 'e';
							break;
					}
				} while(selection == 'e');

				System.out.println("");
			}

			while(currentCell.checkMove(currentDirection) != Constants.OPEN)
			{
				currentDirection = getLeftTurn(currentDirection);
			}

			// change the nodes symbol to indicate current node
			if(!(currentCell.equals(this.maze.getStart())) && !(currentCell.equals(this.maze.getFinish())))
			{
				currentCell.setSymbol('*');
			}

			currentCell = this.maze.getAdjacent(currentCell, currentDirection);
			currentDirection = getLeftTurn(getInverseEdge(currentDirection));
		}

		// print and clear the maze for the next solver method to have a fresh solution
		MazePrinter.printMaze(this.maze);
		this.maze.clearMaze();
	}

	private int getLeftTurn(int entryEdge)
	{
		if(entryEdge == Constants.LEFT)
		{
			// if coming from left edge left turn leads up
			return Constants.UP;
		}
		else
		{
			// otherwise increment to next direction normally
			return this.maze.getStartingBorder() + 1;
		}
	}

	private int getInverseEdge(int entryEdge)
	{
		switch(entryEdge)
		{
			case Constants.UP:
				return Constants.DOWN;
			case Constants.RIGHT:
				return Constants.LEFT;
			case Constants.DOWN:
				return Constants.UP;
			case Constants.LEFT:
				return Constants.RIGHT;
			default:
				return -1;
		}
	}
}
