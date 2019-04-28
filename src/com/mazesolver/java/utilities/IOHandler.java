package com.mazesolver.java.utilities;

import com.mazesolver.java.solver.UniformCostSearch;

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
				case 3:
					if (!args[2].equals("-d"))
					{
						throw new NumberFormatException();
					} else
					{
						Constants.setDebugMode(true);
					}
				case 2:
					mazeSize = Integer.parseInt(args[1]);

					if ((mazeSize < 2) || (mazeSize > 1000))  //throw exception if number format invalid
					{
						throw new NumberFormatException();
					}

					Constants.setMazeSize(mazeSize);
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

	public static void menu()
	{
		System.out.println("Welcome to the Maze Generator/Solver!\n");

		while (!Constants.isProgramOver())
		{
			System.out.println("Press 1 for Uniform Cost Search\n");
			System.out.println("Press 2 for A* Hurestic Search\n");
			System.out.println("Press 3 for Genetic Search\n");
			System.out.println("Press 4 for Wall Follower Method\n");
			System.out.println("Press q to quit the program\n");

			selectSolver();
		}
	}

	private static void selectSolver()
	{
		char selection;

		Scanner sc = new Scanner(System.in);

		try
		{
			selection = sc.next().charAt(0);

			switch (selection)
			{
				case '1':
					//solution method
					break;

				case '2':
					//solution method
					break;

				case '3':
					//solution method
					break;
				case '4':
					//solution method
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
