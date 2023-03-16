package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class Problem {
    private Map<Student,List<Project>> Preferences;

    public Map<Student, List<Project>> getPreferences() {
        return Preferences;
    }

    public Problem() {
        Preferences = new HashMap<>();
    }

}
