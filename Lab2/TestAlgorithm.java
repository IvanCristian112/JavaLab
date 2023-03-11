

public class TestAlgorithm {
    private DijkstraAlgorithm algorithm;


    private void GenerateProblem(int numberOfInstances) {
        Problem problem = new Problem();
        for (int i = 0; i < numberOfInstances; i++) {
            //generate coordinates for location randomly from -100 to 100
            double xCoordinate = Math.random() * 100;
            double yCoordinate = Math.random() * 100;
            Location location = new City(Integer.toString(i), xCoordinate, yCoordinate, 1_000_000);
            problem.addLocation(location);
        }
        //generate randomly start and end locations
        int startLocation = (int) (Math.random() * (numberOfInstances - 1));
        int endLocation = (int) (Math.random() * (numberOfInstances - 1));
        problem.setStartLocation(problem.getLocations().get(0));
        problem.setEndLocation(problem.getLocations().get(endLocation));
        //we generate a number of roads s.t. : 1<=numberOfRoads<=numberOfLocation/2
        int numberOfRoads = (int) (numberOfInstances / 2 * Math.log(numberOfInstances) + 1);
        System.out.println(numberOfRoads);
        /*The euclidean distance between two locations has a maximum of 282.84, because we put coordinates between -100 and 100
        For the problem to be valid, all roads have to have length >= 282.84
         */

        for (int i = 0; i < numberOfRoads; i++) {
            int firstIndex = (int) (Math.random() * (numberOfInstances - 1));
            int secondIndex = (int) (Math.random() * (numberOfInstances - 1));
            if (firstIndex == secondIndex) continue;

            Road road = new Road(Integer.toString(i), RoadType.EXPRESS, problem.getLocations().get(firstIndex),
                    problem.getLocations().get(secondIndex), Math.random() * (500 - 283 + 1) + 283, 90);
            problem.addRoad(road);

        }
        if (!problem.checkValidity()) System.out.println("Problema nu este valida");
        this.algorithm = new DijkstraAlgorithm(problem);
        Solution solution = algorithm.solve();
        System.out.println(solution);


    }

    public long testPerformance(int numberOfInstances) {
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore =
                runtime.totalMemory() - runtime.freeMemory();
        long initialTime = System.currentTimeMillis();
        GenerateProblem(numberOfInstances);
        long runningTime = System.currentTimeMillis() - initialTime;
        long usedMemoryAfter =
                runtime.totalMemory() - runtime.freeMemory();
        long memoryIncrease = usedMemoryAfter - usedMemoryBefore;
        System.out.println("Timp de rulare (milisecunde)  " + runningTime);
        System.out.println("Memorie utilizata " + memoryIncrease);
        return runningTime;
    }
}

