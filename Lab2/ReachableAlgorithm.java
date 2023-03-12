import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class ReachableAlgorithm extends Algorithm {


    private boolean[] visited;
    protected Map<Location, HashSet<Location>> adjacencyList;

    public ReachableAlgorithm(Problem problem) {
        super(problem);
        visited = new boolean[problem.getLocations().size()];
        this.adjacencyList = new HashMap<>();
    }

    private void createAdjacencyList() {
        for (int i = 0; i < problem.getLocations().size(); i++) {
            HashSet<Location> auxiliary = new HashSet<>();
            adjacencyList.put(problem.getLocations().get(i), auxiliary);
        }
        for (Road road : problem.getRoads()) {
            adjacencyList.get(road.getFirstLocation()).add(road.getSecondLocation());
            adjacencyList.get(road.getSecondLocation()).add(road.getFirstLocation());


        }
    }

    public Solution solve() {
        createAdjacencyList();
        Solution solution = new Solution();
        solution.setReachable(RecursiveDFS(problem.getStartLocation(), problem.getEndLocation()));
        return solution;
    }

    private boolean RecursiveDFS(Location startLocation, Location endLocation) {
        boolean canReach;
        if (startLocation.equals(endLocation)) return true;
        if (visited[problem.getLocations().indexOf(startLocation)]) return false;
        visited[problem.getLocations().indexOf(startLocation)] = true;
        for (Location adjacentVertex : adjacencyList.get(startLocation)) {
            canReach = RecursiveDFS(adjacentVertex, endLocation);
            if (canReach) return true;
        }
        return false;
    }

}
