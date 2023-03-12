public class Person implements Node{
    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public int compareTo(Node node) {
        return this.name.compareTo(node.getName());
    }

    @Override
    public String toString() {
        return "Person" +  this.getName();
    }
}
