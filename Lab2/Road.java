public class Road {
    private float length;
    private RoadType type;
    private int speedLimit;

    public Road() {
    }

    public Road(float length) {
        this.length = length;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
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
