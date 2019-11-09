package model;

import java.util.ArrayList;
import java.util.Collections;

import controller.NodeController;

public class Route {

	private int numOfNode;
	private double totalDistance;
	
	private double fitness;
	private ArrayList<Node> routes;
	
	public Route(int numOfNode) {
		this.numOfNode = numOfNode;
		this.totalDistance = 0;
		this.fitness = 0;
	}
	
	public void generateRoute() {
		NodeController nc = new NodeController();
		
		for(int i = 0; i < this.numOfNode-1; i++) {
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
