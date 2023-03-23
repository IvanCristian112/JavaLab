package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GreedyAlgorithm {
    private Problem problem;


    public GreedyAlgorithm(Problem problem) {
        this.problem = problem;
    }

    public Solution solve() {
        Solution solution = new Solution();
        Set<Project> unavailableProjects = new HashSet<>();
        Map<Student, Project> Matching = new HashMap<>();
        for (Student student : problem.getPreferences().keySet()) {
            for (Project project : problem.getPreferences().get(student)) {
                if (!unavailableProjects.contains(project)) {
                    solution.getMatching().put(student, project);
                    unavailableProjects.add(project);
                }
            }
        }
        return solution;
    }


}
