package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {


        Database database = Database.getInstance();
        var ArtistDAO = new ArtistDAO();
        System.out.println(ArtistDAO.findByName("Adi Minune"));
        System.out.println(ArtistDAO.findByID(1));

        var AlbumDAO = new AlbumDAO();
        System.out.println(AlbumDAO.findByName("In Utero"));
        //AlbumDAO.Create(2000,"Kid A","Radiohead","Electronica, Post Rock, Art Rock");
        System.out.println(AlbumDAO.findByName("Kid A"));

        var GenreDAO = new GenreDAO();
        //GenreDAO.Create("Rock");
    }
}