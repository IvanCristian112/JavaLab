import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Node> nodes = new ArrayList<>();
        for(int i=0;i<5;i++){
            Node node = new Person();
            node.setName(Integer.toString(i));
            nodes.add(node);
            Node node2 = new Company();
            node2.setName(Integer.toString(i));
            nodes.add(node2);
        }
        System.out.println(nodes);

    }
}