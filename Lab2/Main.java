

public class Main {
    public static void main(String[] args) {
        Problem pb = new Problem();
        Location[] sites = new Location[4];
        Road[] routes = new Road[4];
        sites[0] = new City("Iasi", 100.5, 45.0, 400_000);
        sites[1] = new GasStation("Rompetrol", 120, -97.8, 6.7);
        sites[2] = new City("Bucuresti", 67.5, 76.5, 2_000_000);
        sites[3] = new GasStation("Lukoil", 67.5, 76.5, 7.8);
        routes[0] = new Road("A1", RoadType.HIGHWAY, sites[0], sites[1], 2500, 130);
        routes[1] = new Road("E58", RoadType.COUNTRY, sites[1], sites[0], 1000, 90);
        routes[2] = new Road("DN3", RoadType.COUNTRY, sites[0], sites[1], 1500, 90);
        routes[3] = new Road("DN1", RoadType.COUNTRY, sites[0], sites[2], 1500, 90);
        pb.addLocation(sites[0]);
        pb.addLocation(sites[1]);
        pb.addLocation(sites[2]);
        pb.addLocation(sites[3]);
        pb.addRoad(routes[0]);
        pb.addRoad(routes[1]);
        pb.addRoad(routes[2]);
        pb.addRoad(routes[3]);
        pb.setStartLocation(sites[0]);
        pb.setEndLocation(sites[3]);
        System.out.println(pb);
        System.out.println(pb.checkValidity());
        Algorithm alg1 = new ReachableAlgorithm(pb);
        Solution solution = alg1.solve();
        System.out.println(solution);
        //System.out.println(pb.ReachableVertex(sites[1], sites[3]));


    }
}