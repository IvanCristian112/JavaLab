public class Location {
    private String name;
    private LocationType type;
    public int xCoordinate;
    public int yCoordinate;

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
