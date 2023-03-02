public class Location {
    private String name;
    private LocationType type;
    private float xCoordinate;
    private float yCoordinate;

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
