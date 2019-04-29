package com.mazesolver.java.solver;

import com.mazesolver.java.maze.Maze;
import com.mazesolver.java.maze.MazeCell;
import com.mazesolver.java.utilities.Constants;

import java.util.ArrayList;

public class WallFollowerSolver extends Solver
{
	public WallFollowerSolver(Maze maze)
	{
		super(maze);
	}

	public void solve()
	{
		MazeCell currentCell = this.maze.getStart();
		int currentDirection;
		ArrayList<MazeCell> visited = new ArrayList();  // For making sure not to visit a previous cell

		// switch the starting border to determine the right-hand move priority
		switch (Constants.getStartingBorder())
		{
			case Constants.UP: // top bound

				break;
			case Constants.RIGHT: // right bound

				break;
			case Constants.DOWN: // bottom bound

				break;
			case Constants.LEFT: // left bound

				break;
			default:
				break;
		}

		// clear the maze for the next solver method to have a fresh solution
		this.maze.clearMaze();
	}
	private void movePriority()
	{

	}
}
