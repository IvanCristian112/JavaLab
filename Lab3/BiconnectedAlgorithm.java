import java.util.*;


public class BiconnectedAlgorithm {
    private Network network;
    private Set<Node> visited;
    private Map<Node, Integer> disc;
    private Map<Node, Integer> low;
    private Map<Node, Node> parent;
    private LinkedList<Pair> stack;
    private Set<Set<Node>> MaxConnectedComponents;
    private int time;

    public void addNetwork(Network network) {
        this.network = network;
    }

    public BiconnectedAlgorithm() {

        disc = new HashMap<>();
        low = new HashMap<>();
        parent = new HashMap<>();
        visited = new HashSet<>();
        stack = new LinkedList<>();
        MaxConnectedComponents = new HashSet<>();
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

                    stack.add(new Pair(node, neighbor));
                    dfs(neighbor);
                    low.put(node, Math.min(low.get(node), low.get(neighbor)));
                    if (parent.get(node) == null && children > 1 || parent.get(node) != null && low.get(neighbor) >= disc.get(node)) {
                        Set<Node> nodes = new HashSet<>();
                        while (stack.getLast().node1 != node || stack.getLast().node2 != neighbor) {
                            nodes.add(stack.getLast().node1);
                            nodes.add(stack.getLast().node2);
                            stack.removeLast();
                        }

                        MaxConnectedComponents.add(nodes);
                        Set<Node> nodes2 = new HashSet<>();
                        nodes2.add(stack.getLast().node1);
                        nodes2.add(stack.getLast().node2);
                        stack.removeLast();
                        MaxConnectedComponents.add(nodes2);


                    }
                } else if (neighbor != parent.get(node) && disc.get(neighbor) < disc.get(node)) {
                    if (low.get(node) > disc.get(neighbor)) low.put(node, disc.get(neighbor));
                    stack.add(new Pair(node, neighbor));
                }
            }
        }

    }

    public Set<Set<Node>> findComponents() {
        for (Node node : network.getNodes()) {
            Set<Node> nodes = new HashSet<>();
            if (!visited.contains(node)) {
                dfs(node);
            }
            while (stack.size() > 0) {
                nodes.add(stack.getLast().node1);
                nodes.add(stack.getLast().node2);
                stack.removeLast();

            }
            MaxConnectedComponents.add(nodes);
        }
        // we have to check if all nodes in a connected component have a degree equal to 2

        for (Iterator<Set<Node>> iterator = MaxConnectedComponents.iterator(); iterator.hasNext(); ) {
            Set<Node> element = iterator.next();
            if (element.isEmpty()) iterator.remove();
        }
        for (Iterator<Set<Node>> iterator = MaxConnectedComponents.iterator(); iterator.hasNext(); ) {
            Set<Node> element = iterator.next();
            if (!minDegree(element)) iterator.remove();
        }
        return MaxConnectedComponents;
    }

    private boolean minDegree(Set<Node> set) {
        if (set.size() < 3) return false;
        for (Node node : set) {
            int degree = 0;
            for (Node neighbor : node.getRelationships().keySet()) {
                if (set.contains(neighbor)) degree++;
            }
            if (degree < 2) return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "biconnectedAlgorithm{" +
                "MaxConnectedComponents=" + MaxConnectedComponents +
                '}';
    }
}
