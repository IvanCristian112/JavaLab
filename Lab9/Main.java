package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArtistRepository artistRepository = new ArtistRepository();
        System.out.println(artistRepository.findByName("Radiohead"));
        AlbumRepository albumRepository = new AlbumRepository();
        System.out.println(albumRepository.findByName("In Utero"));
        System.out.println(albumRepository.findById(17));
        GenreRepository genreRepository = new GenreRepository();
        System.out.println(genreRepository.findByName("Electronica"));
        ArtistDAO artistDAO = new ArtistDAO();
        System.out.println(artistDAO.findById(28));
        AlbumDAO albumDAO = new AlbumDAO();
        System.out.println(albumDAO.findById(600));

    }
}
