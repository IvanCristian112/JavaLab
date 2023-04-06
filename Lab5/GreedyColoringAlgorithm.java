package org.example;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.*;

public class GreedyColoringAlgorithm {
    private Catalog catalog;
    private Map<String, Set<Integer>> TagMap = new HashMap<>();
    private Map<Integer, Set<Integer>> AdjacencyMap = new HashMap<>();

    public GreedyColoringAlgorithm(Catalog catalog) {
        this.catalog = catalog;
    }

    private void CreateTagMap() {
        for (Document document : catalog.getDocumentList()) {
            for (String tag : document.getTags()) {
                if (!TagMap.containsKey(tag)) {
                    TagMap.put(tag, new HashSet<>());
                }
                TagMap.get(tag).add(catalog.getIndexMap().get(document));
            }
        }

    }

    private void CreateAdjacencyMap() {
        for (Set<Integer> set : TagMap.values()) {
            for (Integer i : set) {
                if (!AdjacencyMap.containsKey(i)) {
                    AdjacencyMap.put(i, new HashSet<>());
                }
                AdjacencyMap.get(i).addAll(set);
            }
        }
    }

    private Graph<Integer, DefaultEdge> CreateGraph() {
        Graph<Integer, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        for (Integer i : catalog.getIndexMap().values()) {
            graph.addVertex(i);
        }
        for (Set<Integer> set : TagMap.values()) {
            if (set.size() < 2) continue;
            for (Integer i : set) {
                for (Integer j : set) {
                    if (i == j) continue;
                    graph.addEdge(i, j);
                }
            }
        }

        return graph;
    }

    public int solve() {
        CreateTagMap();
        Graph<Integer, DefaultEdge> graph = CreateGraph();
        CreateAdjacencyMap();
        int maxColor = -1;
        Map<Integer, Integer> colors = new HashMap<>();
        Set<Integer> used = new HashSet<>();

        for (Integer i : catalog.getIndexMap().values()) {
            for (Integer j : AdjacencyMap.get(i)) {
                if (colors.containsKey(j)) {
                    used.add(colors.get(j));
                }
            }
            int candidate = 0;
            while (used.contains(candidate)) {
                candidate++;
            }
            used.clear();
            colors.put(i, candidate);
            maxColor = Math.max(maxColor, candidate);
        }
        return maxColor + 1;

    }
}
