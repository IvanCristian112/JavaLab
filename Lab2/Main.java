

public class Main {
    public static void main(String[] args) {
        /*Problem pb = new Problem();
        Location[] sites = new Location[7];
        Road[] routes = new Road[5];
        sites[0] = new City("Iasi", 100.5, 45.0, 400_000);
        sites[1] = new GasStation("Rompetrol", 120, -97.8, 6.7);
        sites[2] = new City("Bucuresti", 67.5, 76.5, 2_000_000);
        sites[3] = new GasStation("Lukoil", 67.5, 76.5, 7.8);
        sites[4] = new GasStation("Romgaz", 120.0, 76.5, 7.9);
        sites[5] = new GasStation("Alsachi", 100.0, -56.5, 7.8);
        sites[5] = new City("Alsadsachi", 100.0, -56.5, 7_800_000);

        routes[0] = new Road("A1", RoadType.HIGHWAY, sites[0], sites[1], 25000, 130);
        routes[1] = new Road("DN3", RoadType.COUNTRY, sites[0], sites[2], 1500, 90);
        routes[2] = new Road("DN1", RoadType.COUNTRY, sites[2], sites[3], 1500, 90);
        routes[3] = new Road("DN7", RoadType.COUNTRY, sites[3], sites[1], 1500, 90);
        pb.addLocation(sites[0]);
        pb.addLocation(sites[1]);
        pb.addLocation(sites[2]);
        pb.addLocation(sites[3]);
        pb.addRoad(routes[0]);
        pb.addRoad(routes[1]);
        pb.addRoad(routes[2]);

        pb.setStartLocation(sites[0]);
        pb.setEndLocation(sites[5]);
        System.out.println(pb);
        System.out.println(pb.checkValidity());
        Algorithm alg1 = new ReachableAlgorithm(pb);
        Solution solution = alg1.solve();
        //System.out.println(solution);
        //System.out.println(pb.ReachableVertex(sites[1], sites[3]));
        DijkstraAlgorithm alg3 = new DijkstraAlgorithm(pb);
        //alg3.computePath(sites[0]);
        Solution solution1 = alg3.solve();
        System.out.println(solution1);*/
        TestAlgorithm test = new TestAlgorithm();
        //for(int i=0;i<1000;i++){}
        long average=0;
        for(int i=0;i<20;i++){
            long time = test.testPerformance(9000);
            average+=time;
        }
        average/=20;
        System.out.println("timp mediu " + average);

    }
}