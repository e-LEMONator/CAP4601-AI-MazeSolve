package com.mazesolver.java.solver;

import com.mazesolver.java.maze.Maze;
import java.util.Arrays;

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
		for(int i = 0; i < this.populationSize; i++)
		{
			this.population.add(new Individual(this.maze));
		}

		// while best solution is greater than 0
		while(this.population.peek().evaluateGene() > 0)
		{
			select();
			break;
			// crossover
			// mutate
		}
	}
	
	private void select()
	{
		Individual individualArray[] = new Individual[this.populationSize];
		individualArray = this.population.toArray(individualArray);
		
		this.population.clear();
		
		for(int i = 0; i < this.populationSize * this.populationRetention; i++)
		{
			this.population.add(individualArray[i]);
		}
		
		for(Individual individual : individualArray)
		{
			System.out.println(individual.evaluateGene());
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
