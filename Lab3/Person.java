import javax.swing.undo.CannotUndoException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Person implements Node {
    protected String name;
    protected LocalDate BirthDate;
    protected Map<Node, String> relationships = new HashMap<>();


    public Person(String name, LocalDate birthDate) {
        this.name = name;
        BirthDate = birthDate;

    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Node node) {
        return this.name.compareTo(node.getName());
    }

    @Override
    public String toString() {
        return "Person" + this.getName();
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

        Person person = (Person) o;

        if (!Objects.equals(name, person.name)) return false;
        if (!Objects.equals(BirthDate, person.BirthDate)) return false;
        return Objects.equals(relationships, person.relationships);
    }


}
