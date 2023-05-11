package org.example;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "\"Albums\"")
@NamedQueries({
        @NamedQuery(name = "Album.findById",
                query = "SELECT a FROM Album a WHERE a.id = :id"),
        @NamedQuery(name = "Album.findByName",
                query = "SELECT a FROM Album a WHERE a.title = :title"),


})
public class Album {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "\"ID\"")
    private int id;
    @Basic
    @Column(name = "\"ReleaseYear\"")
    private int releaseYear;
    @Basic
    @Column(name = "\"Title\"")
    private String title;
    @Basic
    @Column(name = "\"Artist\"")
    private String artist;
    @Basic
    @Column(name ="\"Genres\"")
    private String genres;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", releaseYear=" + releaseYear +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genres=" + genres +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return id == album.id && releaseYear == album.releaseYear && Objects.equals(title, album.title) && Objects.equals(artist, album.artist) && Objects.equals(genres, album.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, releaseYear, title, artist, genres);
    }
}
