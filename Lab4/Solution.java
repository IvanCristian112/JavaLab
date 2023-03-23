package org.example;

import java.util.HashMap;
import java.util.Map;


public class Solution {
    private Map<Student, Project> Matching;

    public Solution() {
        Matching = new HashMap<>();
    }

    public Map<Student, Project> getMatching() {
        return Matching;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "Matching=" + Matching +
                '}';
    }
}
