public class Airport extends Location {
    int numberOfTerminals;

    public Airport(String name, double xCoordinate, double yCoordinate, int numberOfTerminals) {
        super(name, xCoordinate, yCoordinate);
        this.numberOfTerminals = numberOfTerminals;
    }
}
