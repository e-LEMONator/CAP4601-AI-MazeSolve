package com.mazesolver.java.maze;

import com.mazesolver.java.Constants;
import java.util.concurrent.atomic.AtomicInteger;

public class MazeCell
{
	private final int row;
	private final int column;
	private char symbol;
	private AtomicInteger upEdge;
	private AtomicInteger downEdge;
	private AtomicInteger leftEdge;
	private AtomicInteger rightEdge;
	
	public MazeCell(int row, int column, MazeCell upCell, MazeCell leftCell)
	{
		this.row = row;
		this.column = column;
		this.symbol = ' ';
		this.setEdges(upCell, leftCell);
	}
	
	/**
	 * sets all the edges of the cell depending on its coordinates in the maze
	 */
	private void setEdges(MazeCell upCell, MazeCell leftCell)
	{
		if(this.row == 0)
		{
			this.upEdge.set(Constants.OOB);
			this.downEdge.set(Constants.WALL);
		}
		else if(this.row == (Constants.getMazeSize() - 1))
		{
			this.upEdge = upCell.getDownEdge();
			this.downEdge.set(Constants.OOB);
		}
		else
		{
			this.upEdge = upCell.getDownEdge();
			this.downEdge.set(Constants.WALL);
		}
		
		if(this.column == 0)
		{
			this.leftEdge.set(Constants.OOB);
			this.rightEdge.set(Constants.WALL);
		}
		else if(this.column == (Constants.getMazeSize() - 1))
		{
			this.leftEdge = leftCell.getRightEdge();
			this.rightEdge.set(Constants.OOB);
		}
		else
		{
			this.leftEdge = leftCell.getRightEdge();
			this.rightEdge.set(Constants.WALL);
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
	public int checkMove(int move)
	{
		switch(move)
		{
			case Constants.STAY:
				return Constants.OPEN;
			case Constants.UP:
				return this.upEdge.get();
			case Constants.RIGHT:
				return this.rightEdge.get();
			case Constants.DOWN:
				return this.downEdge.get();
			case Constants.LEFT:
				return this.leftEdge.get();
			default:
				return Constants.OOB;
		}
	}

	public int getRow()
	{
		return row;
	}

	public int getColumn()
	{
		return column;
	}

	
	
	public char getSymbol()
	{
		return symbol;
	}

	public void setSymbol(char symbol)
	{
		this.symbol = symbol;
	}

	public AtomicInteger getUpEdge()
	{
		return upEdge;
	}

	public void setUpEdge(int upEdge)
	{
		this.upEdge.set(upEdge);
	}

	public AtomicInteger getDownEdge()
	{
		return downEdge;
	}

	public void setDownEdge(int downEdge)
	{
		this.downEdge.set(downEdge);
	}

	public AtomicInteger getLeftEdge()
	{
		return leftEdge;
	}

	public void setLeftEdge(int leftEdge)
	{
		this.leftEdge.set(leftEdge);
	}

	public AtomicInteger getRightEdge()
	{
		return rightEdge;
	}

	public void setRightEdge(int rightEdge)
	{
		this.rightEdge.set(rightEdge);
	}

	// Check to see if cell is on a boundary
	public boolean isOnBoundary()
	{
		return (this.upEdge.get() == Constants.OOB) ||
				(this.downEdge.get() == Constants.OOB) ||
				(this.leftEdge.get() == Constants.OOB) ||
				(this.rightEdge.get() == Constants.OOB);
	}
}
