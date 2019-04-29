package com.mazesolver.java.utilities;

import com.mazesolver.java.maze.Maze;
import com.mazesolver.java.solver.AStar;
import com.mazesolver.java.solver.Genetic;
import com.mazesolver.java.solver.Solver;
import com.mazesolver.java.solver.UniformCostSearch;
import com.mazesolver.java.solver.WallFollowerSolver;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class IOHandler
{

	public static void parseCMDArgs(String[] args)
	{
		int mazeSize;

		try
		{
			switch(args.length)
			{
				case 2:
					if(!args[1].equals("-d"))
					{
						throw new NumberFormatException();
					}
					else
					{
						Constants.setDebugMode(true);
					}

					mazeSize = Integer.parseInt(args[0]);

					if((mazeSize < 2) || (mazeSize > 1000))  //throw exception if number format invalid
					{
						throw new NumberFormatException();
					}

					Constants.setMazeSize(mazeSize);
					break;
				case 1:
					mazeSize = Integer.parseInt(args[0]);

					if((mazeSize < 2) || (mazeSize > 1000))  //throw exception if number format invalid
					{
						throw new NumberFormatException();
					}

					Constants.setMazeSize(mazeSize);
					break;
				default:
					throw new NumberFormatException();

			}
		}
		catch(NumberFormatException e)
		{
			System.err.println("error: incorrect argument format.");
			System.err.println("expected format: mazeSolver <N>. (add flag \"-d\" for debugger mode)");
			System.err.println("for NxN maze where N must be between 2 and 1000");
			System.exit(-1);
		}
	}

	public static void menu(Maze maze)
	{
		System.out.println("Welcome to the Maze Generator/Solver!\n");

		do
		{
			System.out.println("Press 1 for Uniform Cost Search");
			System.out.println("Press 2 for A* Heuristic Search");
			System.out.println("Press 3 for Genetic Search");
			System.out.println("Press 4 for Wall Follower Method");
			System.out.println("Press q to quit the program\n");
			System.out.printf("Selection: ");
		} while(selectSolver(maze) == 0);
	}

	private static int selectSolver(Maze maze)
	{
		Solver solver = null;
		Scanner sc = new Scanner(System.in);
		char selection;
		long startTime, elapsedTime;

		try
		{
			selection = sc.next().charAt(0);

			switch(selection)
			{
				case '1':
					solver = new UniformCostSearch(maze);
					break;
				case '2':
					solver = new AStar(maze);
					break;
				case '3':
					solver = new Genetic(maze, 300000, 0.5, 0.2);
					break;
				case '4':
					solver = new WallFollowerSolver(maze);
					break;
				case 'q':
				case 'Q':
					return 1;
				default:
					throw new InvalidParameterException();
			}

			startTime = System.currentTimeMillis();
			solver.solve();
			elapsedTime = System.currentTimeMillis() - startTime;

			if(Constants.isDebugMode())
			{
				System.out.println("Maze solved in " + elapsedTime + "ms\n");
			}
		}
		catch(InvalidParameterException e)
		{
			System.out.println("Invalid entry. Please try again, making sure to enter only one character.");
		}
		
		return 0;
	}
}
