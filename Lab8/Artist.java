package org.example;

public class Artist {
    private String name;
    private int ID;


    public Artist(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Artist)) return false;
        Artist artist = (Artist) obj;
        return (this.ID == artist.getID());

    }

}
