/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Muharodans
 */
import java.util.ArrayList;

import Model.Node;

public class NodeController {
	private ArrayList<Node> nodes = new ArrayList();

	public Node getNodes(int idx) {
            //salah
		return nodes.get(idx);
	}
	
	public void setNodes(Node node) {
		this.nodes.add(node);
	}
	
}