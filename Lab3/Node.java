
import java.util.Map;

public interface Node extends Comparable<Node> {
    String getName();

    Map<Node, String> getRelationships();


    void addRelationship(Node node, String relationship);

    @Override
    int compareTo(Node o);

}
