package org.example;

import java.util.*;
import java.util.stream.IntStream;

public  class   Main {
    public static void main(String[] args) {
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
        System.out.println(listOfProjects);

        Problem problem = new Problem();
        List<Project> list = new ArrayList<>();
        list = Arrays.asList(arrayOfProjects);
        List<Project> list2 = new ArrayList<>();
        list2.add(arrayOfProjects[0]);
        list2.add(arrayOfProjects[1]);
        List<Project> list3 = new ArrayList<>();
        list3.add(arrayOfProjects[2]);
        problem.getPreferences().put(arrayOfStudents[0], list);
        problem.getPreferences().put(arrayOfStudents[1], list2);
        problem.getPreferences().put(arrayOfStudents[2], list3);
        problem.getPreferences().entrySet().stream().filter(entry->entry.getValue().size() <
                problem.getPreferences().values().stream().mapToInt(List::size).average().orElse(0.0))
                .map(Map.Entry::getKey)
                .forEach(System.out::println);



    }

}