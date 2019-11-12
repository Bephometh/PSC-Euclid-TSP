import Model.Population;
import Model.Route;
import Model.Node;

public class GeneticAlgorithm {
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;
    //private static final Population popu = new Population();
    public Population newPoppulation;
    

    // Evolves a population over one generation
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(51);

        // Keep our best individual if elitism is enabled
        int elitismOffset = 0;
        if (elitism) {
//            newPopulation.saveRoute(0, pop.getFittest());
            elitismOffset = 1;
        }

        // Crossover population
        // Loop over the new population's size and create individuals from
        // Current population
        for (int i = elitismOffset; i < newPopulation.numberOfNodes ; i++) {
            // Select parents
            Route parent1 = tournamentSelection(pop);
            Route parent2 = tournamentSelection(pop);
            // Crossover parents
            Route child = crossover(parent1, parent2);
            // Add child to new population
            newPopulation.setRoute(i, child);
        }

        // Mutate the new population a bit to add some new genetic material
        for (int i = elitismOffset; i < newPopulation.numberOfNodes; i++) {
            mutate(newPopulation.getRoute(i));
        }

        return newPopulation;
    }

    // Applies crossover to a set of parents and creates offspring
    public static Route crossover(Route parent1, Route parent2) {
        
        
        // Create new child tour
        Route child;
        child = new Route(Population.getPopulationSize());

        // Get start and end sub tour positions for parent1's tour
        int startPos = (int) (Math.random() * parent1.routes.size());
        int endPos = (int) (Math.random() * parent1.routes.size());

        // Loop and add the sub tour from parent1 to our child
        for (int i = 0; i < child.routes.size(); i++) {
            // If our start position is less than the end position
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setRoutes(parent1.routes);
            } // If our start position is larger
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setRoutes(parent1.routes);
                }
            }
        }

        // Loop through parent2's city tour
        for (int i = 0; i < parent2.numOfNode; i++) {
            // If child doesn't have the city add it
            if (child.getRoutes() == null) {
                // Loop to find a spare position in the child's tour
                for (int ii = 0; ii < child.routes.size(); ii++) {
                    // Spare position found, add city
                    if (child.routes.get(ii) == null) {
                        child.setRoutes(parent2.routes);
                        break;
                    }
                }
            }
        }
        return child;
    }

    // Mutate a tour using swap mutation
    private static void mutate(Route tour) {
        // Loop through tour cities
        for(int tourPos1=0; tourPos1 < tour.numOfNode; tourPos1++){
            // Apply mutation rate
            if(Math.random() < mutationRate){
                // Get a second random position in the tour
                int tourPos2 = (int) (tour.routes.size() * Math.random());

                // Get the cities at target position in tour
                Node city1 = tour.routes.get(tourPos1);
                Node city2 = tour.routes.get(tourPos2);

                // Swap them around
                tour.setPosition(tourPos2, city1);
                tour.setPosition(tourPos1, city2);
            }
        }
    }

    // Selects candidate tour for crossover
    private static Route tournamentSelection(Population pop) {
        // Create a tournament population
        Population tournament = new Population(51);
        // For each place in the tournament get a random candidate tour and
        // add it
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.numberOfNodes);
            tournament.setRoute(i, pop.getRoute(randomId));
        }
        // Get the fittest tour
        Route fittest = tournament.individuals.get(tournament.getFittest());
        return fittest;
    }
}