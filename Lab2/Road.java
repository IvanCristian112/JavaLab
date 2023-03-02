public class Road {
    private int length;
    private RoadType type;
    private int speedLimit;
    private Location locatie1;
    private Location locatie2;

    public Road() {
    }

    public Road(int length) {
        int x1 = this.locatie1.xCoordinate;
        int x2 = this.locatie2.xCoordinate;
        int y1 = this.locatie1.yCoordinate;
        int y2 = this.locatie2.yCoordinate;
        int euclidianDistance = (x1 - x2) ^ 2 + (y1 - y2) ^ 2;
        if (length >= euclidianDistance) {
            this.length = length;
        }
    }

    public float getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Road{" +
                "length=" + length +
                ", type=" + type +
                '}';
    }
}
