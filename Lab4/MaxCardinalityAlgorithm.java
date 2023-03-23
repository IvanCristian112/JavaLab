package org.example;

import org.graph4j.Graph;
import org.graph4j.GraphBuilder;
import org.graph4j.alg.matching.HopcroftKarpMaximumMatching;
import org.graph4j.util.Matching;
import org.graph4j.util.VertexSet;

import java.util.ArrayList;
import java.util.List;


import java.util.Arrays;

public class MaxCardinalityAlgorithm {
    private Problem problem;

    public MaxCardinalityAlgorithm(Problem problem) {
        this.problem = problem;
    }

    public Solution solve() {
        Graph graph = GraphBuilder.numVertices(problem.getStudents().size() + problem.getProjects().size()).buildGraph();
        for (Student student : problem.getPreferences().keySet()) {
            for (Project project : problem.getPreferences().get(student)) {
                int index1 = problem.getStudents().indexOf(student);
                int index2 = problem.getProjects().indexOf(project) + problem.getStudents().size();
                if (index1 != index2 && !graph.containsEdge(index1, index2))
                    graph.addEdge(index1, index2);
            }
        }

        HopcroftKarpMaximumMatching algorithm = new HopcroftKarpMaximumMatching(graph);
        Matching matching = algorithm.getMatching();
        System.out.println(matching);
        Solution solution = new Solution();

        for (int[] row : matching.edges()) {
            solution.getMatching().put(problem.getStudents().get(row[0]), problem.getProjects().get(row[1] - problem.getStudents().size()));

        }


        return solution;
    }

    public List<Object> minimumVertexCover() {
        Graph graph = GraphBuilder.numVertices(problem.getStudents().size() + problem.getProjects().size()).buildGraph();
        for (Student student : problem.getPreferences().keySet()) {
            for (Project project : problem.getPreferences().get(student)) {
                int index1 = problem.getStudents().indexOf(student);
                int index2 = problem.getProjects().indexOf(project) + problem.getStudents().size();
                if (index1 != index2 && !graph.containsEdge(index1, index2))
                    graph.addEdge(index1, index2);
            }
        }

        HopcroftKarpMaximumMatching algorithm = new HopcroftKarpMaximumMatching(graph);
        VertexSet vertexSet = algorithm.getMinimumVertexCover();
        System.out.println("Minimum vertex: " + vertexSet);
        List<Object> result = new ArrayList<>();
        for (int i : vertexSet) {
            if (i < problem.getStudents().size()) {
                result.add(problem.getStudents().get(i));
            } else {
                result.add(problem.getProjects().get(i - problem.getStudents().size()));

            }
        }
        System.out.println(result);
        return result;
    }

    public List<Object> maximumStableSet() {
        Graph graph = GraphBuilder.numVertices(problem.getStudents().size() + problem.getProjects().size()).buildGraph();
        for (Student student : problem.getPreferences().keySet()) {
            for (Project project : problem.getPreferences().get(student)) {
                int index1 = problem.getStudents().indexOf(student);
                int index2 = problem.getProjects().indexOf(project) + problem.getStudents().size();
                if (index1 != index2 && !graph.containsEdge(index1, index2))
                    graph.addEdge(index1, index2);
            }
        }

        HopcroftKarpMaximumMatching algorithm = new HopcroftKarpMaximumMatching(graph);
        VertexSet vertexSet = algorithm.getMaximumStableSet();
        System.out.println("Maximum Stable: " + vertexSet);
        List<Object> result = new ArrayList<>();
        for (int i : vertexSet) {
            if (i < problem.getStudents().size()) {
                result.add(problem.getStudents().get(i));
            } else {
                result.add(problem.getProjects().get(i - problem.getStudents().size()));
            }
        }
        System.out.println(result);
        return result;
    }


}
