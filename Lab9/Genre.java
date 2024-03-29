package org.example;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "\"Genres\"")
@NamedQueries({

        @NamedQuery(name = "Genre.findByName",
                query = "SELECT a FROM Genre a WHERE a.name = :name"),

        @NamedQuery(name = "Genre.findById",
                query = "SELECT a FROM Genre a WHERE a.id = :id")
})
public class Genre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "\"ID\"")
    private int id;
    @Basic
    @Column(name = "\"Name\"")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return id == genre.id && Objects.equals(name, genre.name);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
