import java.util.*;

public class ArticulationPointAlgorithm {
    private Network network;
    private Set<Node> visited;
    private Map<Node, Integer> disc;
    private Map<Node, Integer> low;
    private Map<Node, Node> parent;
    private int time;
    private Set<Node> articulationPoints;

    public void addNetwork(Network network) {
        this.network = network;
    }

    public ArticulationPointAlgorithm() {
        disc = new HashMap<>();
        low = new HashMap<>();
        parent = new HashMap<>();
        visited = new HashSet<>();
        articulationPoints = new HashSet<>();
        time = 0;


    }

    private void dfs(Node node) {
        int children = 0;
        visited.add(node);
        time++;
        disc.put(node, time);
        low.put(node, time);
        for (Node neighbor : node.getRelationships().keySet()) {

            if (network.getNodes().contains(neighbor)) {
                if (!visited.contains(neighbor)) {
                    children++;
                    parent.put(neighbor, node);
                    dfs(neighbor);
                    low.put(node, Math.min(low.get(node), low.get(neighbor)));
                    if (parent.get(node) == null && children > 1) {
                        articulationPoints.add(node);
                    }
                    if (parent.get(node) != null && low.get(neighbor) >= disc.get(node)) {
                        articulationPoints.add(node);
                    }
                } else if (!neighbor.equals(parent.get(node))) {
                    low.put(node, Math.min(low.get(node), disc.get(neighbor)));
                }
            }
        }

    }

    public Set<Node> findArticulationPoints() {
        for (Node node : network.getNodes()) {
            if (!visited.contains(node)) {
                dfs(node);
            }
        }
        return articulationPoints;
    }


    @Override
    public String toString() {
        return "TarjanAlgorithm{" +
                "articulationPoints=" + articulationPoints +
                '}';
    }

}
