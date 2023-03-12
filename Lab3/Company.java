public class Company implements Node{
    private String name;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Node node) {
        return this.name.compareTo(node.getName());
    }

    @Override
    public String toString() {
        return "Company" + this.getName();
    }
}
