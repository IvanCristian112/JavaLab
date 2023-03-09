public abstract class Location {
    protected String name;
    protected double xCoordinate;
    protected double yCoordinate;

    public Location(String name, double xCoordinate, double yCoordinate) {
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

    }

    public Location() {
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Location)) return false;
        Location location = (Location) obj;
        return name.equals(location.name);

    }
}
