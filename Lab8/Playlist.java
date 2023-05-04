package org.example;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private List<Album> albums = new ArrayList<>();

    public Playlist(String name, List<Album> albums) {
        this.name = name;
        this.albums = albums;
    }
    public void AddAlbum(Album album){
        this.albums.add(album);
    }


    @Override
    public String toString() {
        return "Playlist{" +
                "albums=" + albums +
                '}';
    }
}
