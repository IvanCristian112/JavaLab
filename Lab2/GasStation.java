public class GasStation extends Location {
    private double gasPrice;

    public GasStation(String name, double x, double y, double price) {
        super(name, x, y);
        this.gasPrice = price;
    }
}
