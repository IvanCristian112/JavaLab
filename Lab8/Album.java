package org.example;

import java.util.List;

public class Album {
    private int ID;
    private int ReleaseYear;
    private String title;
    private String artist;
    private List<String> genreList;

    public Album(int ID, int releaseYear, String title, String artist, List<String> genreList) {
        this.ID = ID;
        ReleaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
        this.genreList = genreList;
    }

    public void setGenreList(List<String> genreList) {
        this.genreList = genreList;
    }

    public int getID() {
        return ID;
    }

    public List<String> getGenreList() {
        return genreList;
    }

    @Override
    public String toString() {
        return "Album{" +
                "ID=" + ID +
                ", ReleaseYear=" + ReleaseYear +
                ", title='" + title + '\'' +
                ", artist=" + artist +
                ", genreList=" + genreList +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Album)) return false;
        Album album = (Album) obj;
        return (this.ID == album.getID());

    }
}
