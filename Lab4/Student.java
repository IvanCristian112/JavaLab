package org.example;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;

    public Student(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Student)) return false;

        Student student = (Student) obj;
        return Objects.equals(name, student.getName());
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
    @Override
    public int compareTo(Student student) {
        return name.compareTo(student.getName());
    }
}
