package com.mazesolver.java.maze;

import com.mazesolver.java.Constants;

public class MazeCell
{
	private final int row;
	private final int column;
	private char symbol;
	private int upEdge;
	private int downEdge;
	private int leftEdge;
	private int rightEdge;
	
	public MazeCell(int row, int column)
	{
		this.row = row;
		this.column = column;
		this.symbol = ' ';
		this.setEdges();
	}
	
	/**
	 * sets all the edges of the cell depending on its coordinates in the maze
	 */
	private void setEdges()
	{
		if(this.row == 0)
		{
			this.upEdge = Constants.OOB;
			this.downEdge = Constants.WALL;
		}
		else if(this.row == (Constants.getMazeSize() - 1))
		{
			this.upEdge = Constants.WALL;
			this.downEdge = Constants.OOB;
		}
		else
		{
			this.upEdge = Constants.WALL;
			this.downEdge = Constants.WALL;
		}
		
		if(this.column == 0)
		{
			this.leftEdge = Constants.OOB;
			this.rightEdge = Constants.WALL;
		}
		else if(this.column == (Constants.getMazeSize() - 1))
		{
			this.leftEdge = Constants.WALL;
			this.rightEdge = Constants.OOB;
		}
		else
		{
			this.leftEdge = Constants.WALL;
			this.rightEdge = Constants.WALL;
		}
	}
	
	/**
	 * checks if a proposed move is valid
	 * 
	 * @param move int value in range 0-4 representing move options:
	 * 0 - no move
	 * 1 - move up
	 * 2 - move right
	 * 3 - move down
	 * 4 - move left
	 * @return true if move is valid, false otherwise
	 */
	public boolean checkMove(int move)
	{
		switch(move)
		{
			case Constants.STAY:
				return true;
			case Constants.UP:
				return (upEdge == Constants.OPEN);
			case Constants.RIGHT:
				return (rightEdge == Constants.OPEN);
			case Constants.DOWN:
				return (downEdge == Constants.OPEN);
			case Constants.LEFT:
				return (leftEdge == Constants.OPEN);
			default:
				return false;
		}
	}

	public char getSymbol()
	{
		return symbol;
	}

	public void setSymbol(char symbol)
	{
		this.symbol = symbol;
	}

	public int getUpEdge()
	{
		return upEdge;
	}

	public void setUpEdge(int upEdge)
	{
		this.upEdge = upEdge;
	}

	public int getDownEdge()
	{
		return downEdge;
	}

	public void setDownEdge(int downEdge)
	{
		this.downEdge = downEdge;
	}

	public int getLeftEdge()
	{
		return leftEdge;
	}

	public void setLeftEdge(int leftEdge)
	{
		this.leftEdge = leftEdge;
	}

	public int getRightEdge()
	{
		return rightEdge;
	}

	public void setRightEdge(int rightEdge)
	{
		this.rightEdge = rightEdge;
	}
}
