import java.util.ArrayList;


public class Network {
    private ArrayList<Node> nodes = new ArrayList<>();

    public ArrayList<Node> getNodes() {
        return nodes;
    }


    public Network() {

    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public Integer getDegree(Node node) {
        Integer degree = 0;
        for (Node node1 : nodes) {
            if (node1.getRelationships().containsKey(node)) {
                degree++;
            }
        }
        return degree;
    }

    int compareByDegree(Node node1, Node node2) {
        return -getDegree(node1).compareTo(getDegree(node2));
    }

    @Override
    public String toString() {
        nodes.sort(this::compareByDegree);
        return (nodes.toString());
    }
}
