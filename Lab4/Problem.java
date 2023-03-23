package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Problem {

    private List<Project> Projects;
    private List<Student> Students;
    private Map<Student, List<Project>> Preferences;

    public Map<Student, List<Project>> getPreferences() {
        return Preferences;
    }

    public List<Student> getStudents() {
        return Students;
    }

    public List<Project> getProjects() {
        return Projects;
    }

    public void addProjects(List<Project> list) {
        this.Projects = list;
    }

    public void addStudents(List<Student> list) {
        this.Students = list;
    }

    public Problem() {
        Projects = new ArrayList<>();
        Students = new ArrayList<>();
        Preferences = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Problem{" +
                "Preferences=" + Preferences +
                '}';
    }
}
