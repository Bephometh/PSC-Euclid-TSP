/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.Population;
import Model.Route;
import Model.Node;
import Controller.NodeController;
import java.util.*;
/**
 *
 * @author Muharodans
 */
public class TesterGA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NodeController nc = new NodeController();
        ArrayList<Node> arrNode = new ArrayList<>();
        
        // Create and add our cities
//        Node city = new Node(0,60, 200);
//        nc.setNodes(city);
//        Node city2 = new Node(1,180, 200);
//        nc.setNodes(city2);
//        Node city3 = new Node(2,80, 180);
//        nc.setNodes(city3);
//        Node city4 = new Node(3,140, 180);
//        nc.setNodes(city4);
//        Node city5 = new Node(4,20, 160);
//        nc.setNodes(city5);
//        Node city6 = new Node(5,100, 160);
//        nc.setNodes(city6);
//        Node city7 = new Node(6,200, 160);
//        nc.setNodes(city7);
//        Node city8 = new Node(7,140, 140);
//        nc.setNodes(city8);
//        Node city9 = new Node(8,40, 120);
//        nc.setNodes(city9);
//        Node city10 = new Node(9,100, 120);
//        nc.setNodes(city10);
//        Node city11 = new Node(10,180, 100);
//        nc.setNodes(city11);
//        Node city12 = new Node(11,60, 80);
//        nc.setNodes(city12);
//        Node city13 = new Node(12,120, 80);
//        nc.setNodes(city13);
//        Node city14 = new Node(13,180, 60);
//        nc.setNodes(city14);
//        Node city15 = new Node(14,20, 40);
//        nc.setNodes(city15);
//        Node city16 = new Node(15,100, 40);
//        nc.setNodes(city16);
//        Node city17 = new Node(16,200, 40);
//        nc.setNodes(city17);
//        Node city18 = new Node(17,20, 20);
//        nc.setNodes(city18);
//        Node city19 = new Node(18,60, 20);
//        nc.setNodes(city19);
//        Node city20 = new Node(19,160, 20);
//        nc.setNodes(city20);

        

        // Initialize population
        //salah
        
        
        for(int i=1 ; i<=51 ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            Node n = new Node(i,x,y);
            nc.setNodes(n);
            arrNode.add(n);
        }
        Population pop = new Population(51);
        
        pop.generatePopuplation(nc);

        // Evolve population for 100 generations
//        pop = GeneticAlgorithm.evolvePopulation(pop);
//        for (int i = 0; i < 100; i++) {
//            pop = GeneticAlgorithm.evolvePopulation(pop);
//        }

        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
    }
}
