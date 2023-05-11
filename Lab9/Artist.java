package org.example;

import jakarta.persistence.*;

import java.util.Objects;



@Entity
@Table(name = "\"Artists\"")
@NamedQueries({

        @NamedQuery(name = "Artist.findByName",
                query = "SELECT a FROM Artist a WHERE a.Name = :name"),

        @NamedQuery(name = "Artist.findById",
                query = "SELECT a FROM Artist a WHERE a.id = :id")
})
public class Artist {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "\"ID\"")
    private int ID;
    @Basic
    @Column(name = "\"Name\"")
    private String Name;


    public int getId() {
        return ID;
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return ID == artist.ID && Objects.equals(Name, artist.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, Name);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
