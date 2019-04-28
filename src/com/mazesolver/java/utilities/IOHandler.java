package com.mazesolver.java.utilities;

import com.mazesolver.java.Main;
import com.mazesolver.java.maze.Maze;
import com.mazesolver.java.solver.AStar;
import com.mazesolver.java.solver.Genetic;
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
			switch (args.length)
			{
				case 2:
					if (!args[1].equals("-d"))
					{
						throw new NumberFormatException();
					} else
					{
						Constants.setDebugMode(true);
					}
					mazeSize = Integer.parseInt(args[0]);

					if ((mazeSize < 2) || (mazeSize > 1000))  //throw exception if number format invalid
					{
						throw new NumberFormatException();
					}

					Constants.setMazeSize(mazeSize);
					break;
				case 1:
					mazeSize = Integer.parseInt(args[0]);

					if ((mazeSize < 2) || (mazeSize > 1000))  //throw exception if number format invalid
					{
						throw new NumberFormatException();
					}

					Constants.setMazeSize(mazeSize);
					break;
				default:
					throw new NumberFormatException();

			}
		} catch (NumberFormatException e)
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

		while (!Constants.isProgramOver())
		{
			System.out.println("Press 1 for Uniform Cost Search\n");
			System.out.println("Press 2 for A* Hurestic Search\n");
			System.out.println("Press 3 for Genetic Search\n");
			System.out.println("Press 4 for Wall Follower Method\n");
			System.out.println("Press q to quit the program\n");

			selectSolver(maze);
		}
	}

	private static void selectSolver(Maze maze)
	{
		char selection;

		Scanner sc = new Scanner(System.in);

		try
		{
			selection = sc.next().charAt(0);

			switch (selection)
			{
				case '1':
					UniformCostSearch ucs = new UniformCostSearch(maze);

					ucs.solve();
					break;

				case '2':
					AStar aStar = new AStar(maze);

					aStar.solve();
					break;

				case '3':
					Genetic genetic = new Genetic(maze);

					genetic.solve();
					break;
				case '4':
					WallFollowerSolver wallFollower = new WallFollowerSolver(maze);

					wallFollower.solve();
					break;
				case 'q':
				case 'Q':
					Constants.setProgramOver(true);
					break;
				default:
					throw new InvalidParameterException();

			}
		}
		catch (InvalidParameterException e)
		{
			System.out.println("Invalid entry. Please try again, making sure to enter only one character.");
		}





	}
}
