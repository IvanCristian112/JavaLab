package org.example;

import org.jgrapht.Graph;
import org.jgrapht.alg.clique.BronKerboschCliqueFinder;
import org.jgrapht.generate.ComplementGraphGenerator;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PlaylistAlgorithm {
    private RollingStonesAlbumList rollingStonesAlbumList;

    public PlaylistAlgorithm(RollingStonesAlbumList rollingStonesAlbumList) {
        this.rollingStonesAlbumList = rollingStonesAlbumList;
    }

    public List<Playlist> GeneratePlaylist() {
        try {
            rollingStonesAlbumList.ParseCSVFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Graph<Integer, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        for (int i = 0; i < rollingStonesAlbumList.getAlbumList().size(); i++) {
            graph.addVertex(i);
        }
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

        BronKerboschCliqueFinder<Integer, DefaultEdge> finder = new BronKerboschCliqueFinder<>(graph,3000, TimeUnit.MILLISECONDS);
        Iterator<Set<Integer>> iterator = finder.maximumIterator();

        List<Playlist> playlistList = new ArrayList<>();

        while (iterator.hasNext()) {
            var clique = iterator.next();
            System.out.println(clique);
            Playlist playlist = new Playlist("playlist", new ArrayList<>());
            for (int vertex : clique) {
                playlist.AddAlbum(rollingStonesAlbumList.getAlbumList().get(vertex));
            }
            System.out.println(playlist);
            playlistList.add(playlist);
        }
        return playlistList;
    }

    public static void main(String args[]) {
        RollingStonesAlbumList rollingStonesAlbumList = new RollingStonesAlbumList();
        PlaylistAlgorithm playlistAlgorithm = new PlaylistAlgorithm(rollingStonesAlbumList);
        playlistAlgorithm.GeneratePlaylist();
    }

}
