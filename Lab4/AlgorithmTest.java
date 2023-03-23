package org.example;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class AlgorithmTest {
    private GreedyAlgorithm greedyAlgorithm;
    private MaxCardinalityAlgorithm maxCardinalityAlgorithm;

    private void generateProblem(int numberOfInstances) {
        Faker faker = new Faker();
        Problem problem = new Problem();
        var ArrayOfProjects = IntStream.rangeClosed(0, numberOfInstances - 1).mapToObj(i -> new Project(faker.name().title())).toArray(Project[]::new);
        var ArrayOfStudents = IntStream.rangeClosed(0, numberOfInstances - 1).mapToObj(i -> new Student(faker.name().fullName())).toArray(Student[]::new);
        for (int i = 0; i < numberOfInstances; i++) {
            List<Project> listOfPreferences = new ArrayList<>();
            listOfPreferences.add(ArrayOfProjects[(int) (Math.random() * (numberOfInstances - 1))]);
            listOfPreferences.add(ArrayOfProjects[(int) (Math.random() * (numberOfInstances - 1))]);
            listOfPreferences.add(ArrayOfProjects[(int) (Math.random() * (numberOfInstances - 1))]);
            listOfPreferences.add(ArrayOfProjects[(int) (Math.random() * (numberOfInstances - 1))]);
            problem.getPreferences().put(ArrayOfStudents[i], listOfPreferences);
        }
        problem.addStudents(Arrays.asList(ArrayOfStudents));
        problem.addProjects(Arrays.asList(ArrayOfProjects));
        greedyAlgorithm = new GreedyAlgorithm(problem);
        maxCardinalityAlgorithm = new MaxCardinalityAlgorithm(problem);

    }


    public int testGreedyAlgorithm(int numberOfInstances) {
        System.gc();
        long initialTime = System.currentTimeMillis();
        generateProblem(numberOfInstances);
        Solution solution = greedyAlgorithm.solve();
        long runningTime = System.currentTimeMillis() - initialTime;
        System.out.println("Running time (milliseconds):  " + runningTime);
        return solution.getMatching().size();
    }

    public int testMaxCardinalityAlgorithm(int numberOfInstances) {
        System.gc();
        long initialTime = System.currentTimeMillis();
        generateProblem(numberOfInstances);
        Solution solution = maxCardinalityAlgorithm.solve();
        long runningTime = System.currentTimeMillis() - initialTime;
        System.out.println("Running time (milliseconds):  " + runningTime);
        return solution.getMatching().size();

    }


}
