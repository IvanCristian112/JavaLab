package org.example;

import org.graph4j.Graph;
import org.graph4j.GraphBuilder;
import org.graph4j.alg.clique.BronKerboschCliqueIterator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistAlgorithmGraph4J {
    private RollingStonesAlbumList rollingStonesAlbumList;

    public PlaylistAlgorithmGraph4J(RollingStonesAlbumList rollingStonesAlbumList) {
        this.rollingStonesAlbumList = rollingStonesAlbumList;
    }

    public List<Playlist> GeneratePlaylist() {
        try {
            rollingStonesAlbumList.ParseCSVFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Graph graph = GraphBuilder.numVertices(this.rollingStonesAlbumList.getAlbumList().size()).buildGraph();
        for (int i = 0; i < rollingStonesAlbumList.getAlbumList().size(); i++) {
            for (int j = 0; j < rollingStonesAlbumList.getAlbumList().size(); j++) {
                if (i == j) continue;
                ArrayList<String> intersection = new ArrayList<>(rollingStonesAlbumList.getAlbumList().get(i).getGenreList());
                intersection.retainAll(rollingStonesAlbumList.getAlbumList().get(j).getGenreList());
                if (intersection.isEmpty() && !graph.containsEdge(i, j)) {
                    graph.addEdge(i, j);
                }
            }
        }
        System.out.println(graph);
        /*Graph complementGraph = graph.complement();
        System.out.println(complementGraph);*/
        BronKerboschCliqueIterator iterator = new BronKerboschCliqueIterator(graph);
        List<Playlist> playlistList = new ArrayList<>();
        while (iterator.hasNext()) {
            var clique = iterator.next();
            for (int vertex : clique) {
                List<Album> list = new ArrayList<>();
                list.add(rollingStonesAlbumList.getAlbumList().get(vertex));
                Playlist playlist = new Playlist("playlist", list);
                System.out.println(playlist);
                playlistList.add(playlist);
            }
        }
        return playlistList;

    }

    public static void main(String args[]) {
        RollingStonesAlbumList rollingStonesAlbumList = new RollingStonesAlbumList();
        PlaylistAlgorithmGraph4J playlistAlgorithmGraph4J = new PlaylistAlgorithmGraph4J(rollingStonesAlbumList);
        playlistAlgorithmGraph4J.GeneratePlaylist();
    }
}
