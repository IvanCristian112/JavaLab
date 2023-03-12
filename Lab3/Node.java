public interface Node extends Comparable<Node> {
    String getName();
    void setName(String name);
    @Override
    int compareTo(Node o);
}
