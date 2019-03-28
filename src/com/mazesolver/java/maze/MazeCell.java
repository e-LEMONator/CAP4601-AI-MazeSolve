package com.mazesolver.java.maze;

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
			this.upEdge = OOB;
			this.downEdge = WALL;
		}
		else if(this.row == (mazeSize - 1))
		{
			this.upEdge = WALL;
			this.downEdge = OOB;
		}
		else
		{
			this.upEdge = WALL;
			this.downEdge = WALL;
		}
		
		if(this.column == 0)
		{
			this.leftEdge = OOB;
			this.rightEdge = WALL;
		}
		else if(this.column == (mazeSize - 1))
		{
			this.leftEdge = WALL;
			this.rightEdge = OOB;
		}
		else
		{
			this.leftEdge = WALL;
			this.rightEdge = WALL;
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
			case 0:
				return true;
			case 1:
				return (upEdge == OPEN);
			case 2:
				return (rightEdge == OPEN);
			case 3:
				return (downEdge == OPEN);
			case 4:
				return (leftEdge == OPEN);
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
