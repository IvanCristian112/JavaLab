import java.util.HashMap;
import java.util.HashSet;


public class ReachableAlgorithm extends Algorithm {
    private boolean[] visited;

    public ReachableAlgorithm(Problem problem) {
        super(problem);
        this.adjacencyList = new HashMap<Location, HashSet<Location>>();
    }

    public Solution solve() {
        createAdjacencyList();
        visited = new boolean[problem.getLocations().size()];
        Solution solution = new Solution();
        solution.isReachable = RecursiveDFS(problem.getStartLocation(), problem.getEndLocation());
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
