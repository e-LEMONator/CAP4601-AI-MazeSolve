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

	@Override
	public void solve()
	{
		MazeCell currentCell = this.maze.getStart();
		int currentDirection;
		ArrayList<MazeCell> visited = new ArrayList();  // For making sure not to visit a previous cell

		// switch the starting border to determine the right-hand move priority
		switch(this.maze.getStartingBorder())
		{
			case Constants.UP: // top bound
				currentDirection = Constants.LEFT;
				break;
			case Constants.RIGHT: // right bound
				currentDirection = Constants.UP;
				break;
			case Constants.DOWN: // bottom bound
				currentDirection = Constants.RIGHT;
				break;
			case Constants.LEFT: // left bound
				currentDirection = Constants.DOWN;
				break;
			default:
				break;
		}

		// clear the maze for the next solver method to have a fresh solution
		this.maze.clearMaze();
	}
	
	private void movePriority(MazeCell currentCell, int currentDirection)
	{
		while(currentCell != this.maze.getFinish())
		{

		}
	}
}
