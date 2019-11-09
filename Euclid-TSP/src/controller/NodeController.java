package controller;
import java.util.ArrayList;

import model.Node;

public class NodeController {
	private ArrayList<Node> nodes = new ArrayList();

	public Node getNodes(int idx) {
		return nodes.get(idx);
	}
	
	public void setNodes(Node node) {
		this.nodes.add(node);
	}
	
}
