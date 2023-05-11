package org.example;

import jakarta.persistence.*;


import java.util.Objects;

@Entity
@Table(name="\"AlbumGenres\"")
public class AlbumGenres {
    @Basic
    @Column(name = "GenreID")
    private int genreId;
    @Basic
    @Column(name = "AlbumID")
    private int albumId;
    @Id
    private Long id;

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumGenres that = (AlbumGenres) o;
        return genreId == that.genreId && albumId == that.albumId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreId, albumId);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
