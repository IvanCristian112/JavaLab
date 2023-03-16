package org.example;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var arrayOfStudents = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + Integer.toString(3-i)))
                .toArray(Student[]::new);
        var arrayOfProjects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + Integer.toString(3-i)))
                .toArray(Project[]::new);

        List<Student> listOfStudents = new ArrayList<>();
        listOfStudents.addAll(Arrays.asList(arrayOfStudents));
        Set<Project> listOfProjects = new TreeSet<>(Project::compareTo);
        listOfProjects.addAll(Arrays.asList(arrayOfProjects));
        Collections.sort(listOfStudents,Comparator.comparing(Student::getName));
        System.out.println(listOfStudents);
        System.out.println(listOfProjects);

    }

}