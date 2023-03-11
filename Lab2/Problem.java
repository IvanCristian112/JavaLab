import java.util.ArrayList;

public class Problem {
    private final ArrayList<Location> locations;
    private final ArrayList<Road> roads;
    private Location startLocation;
    private Location endLocation;

    public Problem() {
        this.locations = new ArrayList<>();
        this.roads = new ArrayList<>();
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public ArrayList<Road> getRoads() {
        return roads;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void addLocation(Location a) {

        if (!(locations.contains(a))) {
            this.locations.add(a);
        }
    }

    public void addRoad(Road a) {

        if (!(roads.contains(a))) {
            this.roads.add(a);
        }
    }


    @Override

    public String toString() {
        StringBuilder locations = new StringBuilder();
        for (Location location : this.locations) {
            locations.append(location.toString());
        }
        StringBuilder roads = new StringBuilder();
        for (Road road : this.roads) {
            roads.append(road.toString());
        }

        String finalString = locations.toString();
        finalString += roads.toString();
        return finalString;

    }

    public boolean checkValidity() {
        /*For the moment, I have only two conditions for a valid problem :
        1. All roads have a non-null length;
        2. We have more than one location;
         */
        for (Road a : this.roads) {
            if (a.getLength() == 0 || a.getFirstLocation().equals(a.getSecondLocation())) return false;
        }
        if (locations.size() < 2) return false;
        return true;
    }


}
