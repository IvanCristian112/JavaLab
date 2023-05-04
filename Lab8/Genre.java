package org.example;

public class Genre {
    private int ID;
    private String name;

    public Genre(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Genre)) return false;
        Genre genre = (Genre) obj;
        return (ID == genre.getID());

    }
}
