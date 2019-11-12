package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muharodans
 */
import Controller.NodeController;
import java.util.ArrayList;

public class Population {

	public ArrayList<Route> individuals = new ArrayList();
	public int numberOfNodes;
	public final static int populationSize = 4;
        private NodeController nc;
	
        public Population(int numberOfNodes){
            //salah;
            this.numberOfNodes = numberOfNodes;
            
        }
        
	public void generatePopuplation(NodeController nc) {
		for(int i = 0; i < this.populationSize; i++) {
			Route rt = new Route(this.numberOfNodes);
                        //salah
			rt.generateRoute(nc);
			individuals.add(rt);
		}
	}

    public static int getPopulationSize() {
        return populationSize;
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
