package model;

import java.util.ArrayList;

public class Population {

	private ArrayList<Route> individuals;
	private final static int numberOfNodes = 51;
	private final static int populationSize = 4;
	
	public void generatePopuplation() {
		for(int i = 0; i < this.populationSize; i++) {
			Route rt = new Route(this.numberOfNodes);
			rt.generateRoute();
			individuals.add(rt);
		}
	}
	
	
	public int  getFittest() {
		double fittest = Integer.MIN_VALUE;
		int fittestIdx = 0;
		for(int i = 0; i < this.populationSize; i++) {
			double temp = this.individuals.get(i).getFitness();
			if(temp > fittest) {
				fittest = temp;
				fittestIdx = i;
			}
		}
		
		return fittestIdx;
	}
	
	public void setRoute(int idx, Route route) {
		this.individuals.add(idx, route);
	}
	
	public Route getRoute(int idx) {
		return this.individuals.get(idx);
	}
}
