package com.mazesolver.java.solver;

import com.mazesolver.java.maze.Maze;

import java.util.PriorityQueue;

public class Genetic extends Solver
{
	private int populationSize;
	private double populationRetention;
	private double mutationChance;
	PriorityQueue<Individual> population;
	
	public Genetic(Maze maze, int populationSize, double populationRetention, double mutationChance)
	{
		super(maze);
		this.populationSize = populationSize;
		this.populationRetention = populationRetention;
		this.mutationChance = mutationChance;
		population = new PriorityQueue<>();
	}

	@Override
	public void solve()
	{
		// create randomized population
		for(Individual individual : this.population)
		{
			individual = new Individual(this.maze);
		}

		// while best solution is greater than 0
		while(this.population.peek().evaluateGene() > 0)
		{
			select();
			
			// crossover
			// mutate
		}
	}
	
	private void select()
	{
		Individual individualArray[] = (Individual[]) this.population.toArray();
		
		this.population.clear();
		
		for(int i = 0; i < (this.populationSize * this.populationRetention); i++)
		{
			System.out.println(individualArray[i].evaluateGene());
			this.population.add(individualArray[i]);
		}
	}
	
	private void crossover()
	{
		Individual parent1, parent2, newIndividual;
		
		while(this.population.size() < this.populationSize)
		{
			
		}
	}
}
