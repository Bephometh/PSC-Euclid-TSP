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
public class Node {
	private int num;
	private int x;
	private int y;
	
	public Node(int num, int x, int y) {
		this.num = num;
		this.x = x;
		this.y = y;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getDistance(Node node) {
		double distX = Math.abs(this.x  - node.getX());
		double distY = Math.abs(this.y - node.getY());
		double distance = Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));
		return distance;
		
	}
	
}