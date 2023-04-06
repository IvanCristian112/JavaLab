package org.example;

import org.jgrapht.Graph;
import org.jgrapht.alg.color.BrownBacktrackColoring;
import org.jgrapht.alg.interfaces.VertexColoringAlgorithm;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JGraphTAlgorithm {
    private Catalog catalog;
    private Map<String, Set<Integer>> TagMap = new HashMap<>();

    public JGraphTAlgorithm(Catalog catalog) {
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
        System.out.println("TagMap: " + TagMap);

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
        System.out.println("Graph: " + graph);
        return graph;
    }


    public int solve() {
        CreateTagMap();
        Graph<Integer, DefaultEdge> graph = CreateGraph();
        BrownBacktrackColoring<Integer, DefaultEdge> color = new BrownBacktrackColoring<>(graph);
        return color.getChromaticNumber();
    }

}
