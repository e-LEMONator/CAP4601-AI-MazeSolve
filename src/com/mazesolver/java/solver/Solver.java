package com.mazesolver.java.solver;

import com.mazesolver.java.maze.Maze;
import com.mazesolver.java.utilities.MazePrinter;
import java.util.Scanner;

public abstract class Solver
{
	public Maze maze;

	public Solver(Maze maze)
	{
		this.maze = maze;
	}

	public abstract void solve();
	
	boolean checkSkip(boolean skip)
	{
		Scanner sc = new Scanner(System.in);
		char selection;
		
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
		
		return skip;
	}
}
