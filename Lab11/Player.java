package com.example.demo;

public class Player {
    private String Name;
    private int ID;

    public Player() {
    }

    public Player(String Name, int ID) {
        this.Name = Name;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Player{" +
                "Name='" + Name + '\'' +
                ", ID=" + ID +
                '}';
    }
}
