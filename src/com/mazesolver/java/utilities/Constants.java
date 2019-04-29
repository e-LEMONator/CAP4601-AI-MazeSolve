package com.mazesolver.java.utilities;

public class Constants
{
	// ints used to represent all possible move directions
	public static final int STAY = 0;
	public static final int UP = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;
	public static final int LEFT = 4;

	// ints used to represent the edges of a cell
	public static final int OOB = -1;
	public static final int WALL = 0;
	public static final int OPEN = 1;

	// length of one dimension of maze cells (excludes walls and bounds
	private static int mazeSize;

	// controls various print statements
	private static boolean debugMode = false;

	// controls if the maze solver should continue running
	private static boolean programOver = false;

	public static int getMazeSize()
	{
		return mazeSize;
	}

	public static void setMazeSize(int mazeSize)
	{
		Constants.mazeSize = mazeSize;
	}

	public static boolean isDebugMode()
	{
		return debugMode;
	}

	public static void setDebugMode(boolean debugMode)
	{
		Constants.debugMode = debugMode;
	}

	public static boolean isProgramOver()
	{
		return programOver;
	}

	public static void setProgramOver(boolean programOver)
	{
		Constants.programOver = programOver;
	}
}