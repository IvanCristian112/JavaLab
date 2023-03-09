public class City extends Location {
    private int population;

    public City(String name, double x, double y, int population) {
        super(name, x, y);
        this.population = population;
    }
}
