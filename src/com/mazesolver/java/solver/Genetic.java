package com.mazesolver.java.solver;

import com.mazesolver.java.maze.Maze;

import java.util.PriorityQueue;

public class Genetic extends Solver
{
	public Genetic(Maze maze)
	{
		super(maze);
	}

	@Override
	public void solve()
	{
		PriorityQueue<Individual> population = new PriorityQueue<>();

		// create randomized population
		population.forEach((individual) ->
		{
			individual = new Individual(this.maze);
		});

		// while best solution is greater than 0
		while (population.peek().evaluateGene() > 0)
		{
			// select
			// crossover
			// mutate
		}
	}

}
