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
import java.util.ArrayList;
import java.util.Collections;

import Controller.NodeController;

public class Route {

	public int numOfNode;
	public double totalDistance;
	
	public double fitness;
	public ArrayList<Node> routes = new ArrayList();
	
	public Route(int numOfNode) {
		this.numOfNode = numOfNode;
		this.totalDistance = 0;
		this.fitness = 0;
	}
	
	public void generateRoute(NodeController nc) {
		//NodeController nc = new NodeController();
		
		for(int i = 0; i < this.numOfNode; i++) {
                    //salah
			this.routes.add(nc.getNodes(i));
		}
		
		Collections.shuffle(routes);
		
	}
	
	public void setPosition(int index, Node node) {
		this.routes.set(index, node);
		this.totalDistance = 0;
		this.fitness = 0;
	}
	
	public ArrayList<Node> getRoutes() {
		return routes;
	}

	public void setRoutes(ArrayList<Node> routes) {
		this.routes = routes;
	}
	
	public double getTotalDistance() {
		if(this.totalDistance == 0) {
			setTotalDistance(this.totalDistance);
		}
		return totalDistance;
	}

	public void setTotalDistance(double totalDistance) {
		int size = this.routes.size();
		for(int i = 0; i < size; i++) {
			Node currNode = this.routes.get(i);
			Node nextNode;
			if(i+1 < size) {
				nextNode = this.routes.get(i+1);
			}
			else {
				nextNode = this.routes.get(0);
			}
			totalDistance += currNode.getDistance(nextNode);
		}
		this.totalDistance = totalDistance;
		
	}

	public double getFitness() {
		if(this.fitness == 0) {
			setFitness(this.fitness);
		}
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = 1/getTotalDistance();
	}

    

}