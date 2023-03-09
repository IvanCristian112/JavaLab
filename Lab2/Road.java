public class Road  {
    private String name;
    private double length;
    private RoadType type;
    private int speedLimit;
    private Location firstLocation;
    private Location secondLocation;

    public Road() {
    }

    public Road(String name, RoadType type, Location a, Location b, double length, int speedLimit) {
        this.name = name;
        this.type = type;
        this.firstLocation = a;
        this.secondLocation = b;
        this.speedLimit = speedLimit;
        double euclideanDistance = Math.sqrt(Math.pow((this.secondLocation.xCoordinate - this.firstLocation.xCoordinate), 2) + Math.pow((this.secondLocation.yCoordinate - this.firstLocation.yCoordinate), 2));
        if (length > euclideanDistance) {
            this.length = length;
        }

    }

    public Location getFirstLocation() {
        return firstLocation;
    }

    public Location getSecondLocation() {
        return secondLocation;
    }

    public double getLength() {
        return length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }


    @Override
    public String toString() {
        return "Road{" +
                "length=" + length +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof Road)) return false;
        Road road = (Road) object;
        return (name.equals(road.name));
    }
}
