import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Company implements Node {
    private String name;
    private int turnover;
    private Map<Node, String> relationships = new HashMap<>();

    public Company(String name, int turnover) {
        this.name = name;
        this.turnover = turnover;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<Node, String> getRelationships() {
        return relationships;
    }


    @Override
    public int compareTo(Node node) {
        return this.name.compareTo(node.getName());
    }

    @Override
    public String toString() {
        return "Company" + this.getName();
    }

    @Override
    public void addRelationship(Node node, String relationship) {
        relationships.put(node, relationship);
        node.getRelationships().put(this, relationship);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (turnover != company.turnover) return false;
        if (!Objects.equals(name, company.name)) return false;
        return Objects.equals(relationships, company.relationships);
    }


}
