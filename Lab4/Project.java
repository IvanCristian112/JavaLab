package org.example;

import java.util.Objects;

public class Project implements Comparable<Project> {
    private String name;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Student)) return false;

        Student project = (Student) obj;
        return Objects.equals(name, project.getName());
    }
    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Project project) {
        return name.compareTo(project.getName());
    }
}
