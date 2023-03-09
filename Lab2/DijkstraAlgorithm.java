import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraAlgorithm extends Algorithm {

    private Set<Location> settledNodes;
    private Set<Location> unsettledNodes;
    private int[] distance;


    public DijkstraAlgorithm(Problem problem) {
        super(problem);
        distance = new int[problem.getLocations().size()];
        for (int i = 0; i < problem.getLocations().size(); i++) {
            distance[i] = Integer.MAX_VALUE;
        }
    }

    /* When creating an instance of the problem, we can add more than one road from one location to another.
    In order to find a solution, we only need to keep the road with the minimum cost
     */
    private void eliminateMultipleEdges() {
        for (int i = 1; i < problem.getRoads().size(); i++) {
            Road firstRoad = problem.getRoads().get(i - 1);
            Road secondRoad = problem.getRoads().get(i);
            if (firstRoad.getFirstLocation().equals(secondRoad.getFirstLocation())
                    && firstRoad.getSecondLocation().equals(secondRoad.getSecondLocation())) {
                if (firstRoad.getLength() > secondRoad.getLength()) {
                    problem.getRoads().remove(firstRoad);
                } else problem.getRoads().remove(secondRoad);
            }
        }
    }

    public Solution solve() {
        return new Solution();

    }
}



