package com.mazesolver.java;

public class Constants
{
	public static final int STAY = 0;
	public static final int UP = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;
	public static final int LEFT = 4;
	
	public static final int OOB = -1;
	public static final int WALL = 0;
	public static final int OPEN = 1;

	private static int mazeSize;
	
	public static int getMazeSize()
	{
		return mazeSize;
	}

	public static void setMazeSize(int mazeSize)
	{
		Constants.mazeSize = mazeSize;
	}
}