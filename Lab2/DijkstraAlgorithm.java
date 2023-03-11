import java.util.*;
import java.util.PriorityQueue;


public class DijkstraAlgorithm extends Algorithm {


    public DijkstraAlgorithm(Problem problem) {
        super(problem);

    }


    public Solution solve() {
        Solution solution = new Solution();
        computePath(problem.getStartLocation());
        solution.setRoute(getShortestPathTo(problem.getEndLocation()));
        solution.setReachable(solution.getRoute().size() != 1);
        return solution;

    }

    private void computePath(Location startLocation) {
        startLocation.setMinDistance(0);
        PriorityQueue<Location> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(startLocation);

        while (!priorityQueue.isEmpty()) {
            Location shortestVertex = priorityQueue.poll();
            for (Road road : shortestVertex.getRoads()) {
                Location neighbor = road.getSecondLocation();
                if (neighbor.equals(shortestVertex)) {
                    neighbor = road.getFirstLocation();
                }
                double weight = road.getLength();
                double minDistance = shortestVertex.getMinDistance() + weight;
                if (minDistance < neighbor.getMinDistance()) {
                    priorityQueue.remove(shortestVertex);
                    neighbor.setPreviousLocation(shortestVertex);
                    neighbor.setMinDistance(minDistance);
                    priorityQueue.add(neighbor);

                }

            }
        }
    }

    private ArrayList<Location> getShortestPathTo(Location endLocation) {
        ArrayList<Location> path = new ArrayList<>();
        for (Location location = endLocation; location != null; location = location.getPreviousLocation()) {
            path.add(location);
        }
        Collections.reverse(path);
        return path;
    }

}



