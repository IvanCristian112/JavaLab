import java.util.ArrayList;
import java.util.List;

public abstract class Location implements Comparable<Location> {
    protected String name;
    protected double xCoordinate;
    protected double yCoordinate;
    protected double minDistance;
    protected List<Road> Roads;
    protected Location previousLocation;

    public Location(String name, double xCoordinate, double yCoordinate) {
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.minDistance = Double.MAX_VALUE;
        Roads = new ArrayList<>();
    }

    public Location() {
    }



    public List<Road> getRoads() {
        return Roads;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    public void setPreviousLocation(Location previousLocation) {
        this.previousLocation = previousLocation;
    }

    public Location getPreviousLocation() {
        return previousLocation;
    }

    public double getMinDistance() {
        return minDistance;
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

    @Override
    public int compareTo(Location location) {
        return Double.compare(this.minDistance, location.minDistance);
    }
}
