package org.example;

import com.github.javafaker.Faker;


import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
/*        Compulsory
        var arrayOfStudents = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + Integer.toString(3 - i)))
                .toArray(Student[]::new);
        var arrayOfProjects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + Integer.toString(3 - i)))
                .toArray(Project[]::new);

        List<Student> listOfStudents = new ArrayList<>();
        listOfStudents.addAll(Arrays.asList(arrayOfStudents));
        Set<Project> listOfProjects = new TreeSet<>(Project::compareTo);
        listOfProjects.addAll(Arrays.asList(arrayOfProjects));
        Collections.sort(listOfStudents, Comparator.comparing(Student::getName));
        System.out.println(listOfStudents);
        System.out.println(listOfProjects);*/

       Problem problem = new Problem();

        Faker faker = new Faker();
        var ListOfProjects = IntStream.rangeClosed(0, 9).mapToObj(i -> new Project(faker.name().title())).toArray(Project[]::new);
        var ListOfStudents = IntStream.rangeClosed(0, 9).mapToObj(i -> new Student(faker.name().fullName())).toArray(Student[]::new);
        for (int i = 0; i < 10; i++) {
            List<Project> listOfPreferences = new ArrayList<>();
            listOfPreferences.add(ListOfProjects[(int) (Math.random() * 10)]);
            listOfPreferences.add(ListOfProjects[(int) (Math.random() * 10)]);
            listOfPreferences.add(ListOfProjects[(int) (Math.random() * 10)]);
            problem.getPreferences().put(ListOfStudents[i], listOfPreferences);
        }
        problem.addStudents(Arrays.asList(ListOfStudents));
        problem.addProjects(Arrays.asList(ListOfProjects));


        /*problem.getPreferences().entrySet().stream().filter(entry->entry.getValue().size() <
                problem.getPreferences().values().stream().mapToInt(List::size).average().orElse(0.0))
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
        */
        Solution solution = new Solution();
        GreedyAlgorithm algorithm = new GreedyAlgorithm(problem);
        MaxCardinalityAlgorithm algorithm1 = new MaxCardinalityAlgorithm(problem);
        algorithm1.minimumVertexCover();
        algorithm1.maximumStableSet();
        //solution = algorithm1.solve();
        //System.out.println(solution);

        AlgorithmTest test = new AlgorithmTest();

/*        int sum1=0;
        int sum2=0;
        for(int i=0;i<100;i++){
            sum1+=test.testGreedyAlgorithm(3000);
            sum2+=test.testMaxCardinalityAlgorithm(3000);
        }
        System.out.println("Marimea medie a cuplajului greedy este: " + sum1/100);
        System.out.println("Marimea medie a cuplajului Graph4J este: " + sum2/100);*/
    }

}