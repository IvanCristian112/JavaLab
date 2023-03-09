import java.util.HashSet;
import java.util.Map;

public abstract class Algorithm {
    protected Problem problem;
    protected Map<Location, HashSet<Location>> adjacencyList;


    public Algorithm(Problem problem) {
        this.problem = problem;
    }

    protected void createAdjacencyList() {
        for (int i = 0; i < problem.getLocations().size(); i++) {
            HashSet<Location> auxiliary = new HashSet<Location>();
            adjacencyList.put(problem.getLocations().get(i), auxiliary);
        }
        for (Road road : problem.getRoads()) {
            adjacencyList.get(road.getFirstLocation()).add(road.getSecondLocation());
            adjacencyList.get(road.getSecondLocation()).add(road.getFirstLocation());


        }
    }

    public abstract Solution solve();


}
