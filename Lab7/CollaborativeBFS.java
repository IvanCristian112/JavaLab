package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.graph4j.Graph;
import org.graph4j.traverse.BFSVisitor;
import org.graph4j.traverse.BFSTraverser;
import org.graph4j.generate.RandomGnpGraphGenerator;
import org.graph4j.traverse.SearchNode;

public class CollaborativeBFS {
    private final Graph graph;
    private final int numThreads;
    private final BFSVisitor visitor;

    public CollaborativeBFS(Graph graph, int numThreads, BFSVisitor visitor) {
        this.graph = graph;
        this.numThreads = numThreads;
        this.visitor = visitor;
    }

    public void traverse() {
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);


        int verticesPerThread = graph.numVertices() / numThreads;
        int remainder = graph.numVertices() % numThreads;

        // Start BFS traversal in parallel for each partition
        int startVertex = 0;
        for (int i = 0; i < numThreads; i++) {
            int endVertex = startVertex + verticesPerThread;
            if (remainder > 0) {
                endVertex++;
                remainder--;
            }

            // Create a subgraph and execute BFS traversal for the subgraph
            Graph subgraph = graph.subgraph(startVertex, endVertex);
            BFSTraverser bfsTraverser = new BFSTraverser(subgraph);
            executorService.execute(() -> bfsTraverser.traverse(visitor));

            // Update the starting vertex for the next partition
            startVertex = endVertex;
        }

        // Shutdown the executor service and wait for all tasks to complete
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Graph graph = new RandomGnpGraphGenerator(1000, 0.2).createGraph();
        System.out.println(graph.numEdges());
        int numThreads = 4;

        CollaborativeBFS collaborativeBFS = new CollaborativeBFS(graph, numThreads, new BFSVisitor() {
            @Override
            public void startVertex(SearchNode node) {
                System.out.println("Start vertex: " + node);
            }

            @Override
            public void finishVertex(SearchNode node) {
                System.out.println("Finish vertex: " + node);
            }
        });
        collaborativeBFS.traverse();

    }

}
