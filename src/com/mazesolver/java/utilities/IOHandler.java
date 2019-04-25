package com.mazesolver.java.utilities;

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
					mazeSize = Integer.parseInt(args[0]);

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

	}
}
