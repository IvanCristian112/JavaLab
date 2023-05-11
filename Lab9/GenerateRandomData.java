package org.example;

import com.github.javafaker.Faker;

public class GenerateRandomData {
    private static final String[] Genres = {"Rock", "Rap", "Trap", "Manele", "Electronic", "Classical", "Pop", "Grunge",
            "Country", "Metal", "Alternative Rock", "Alternative Metal", "Jazz", "Soul", "Funk", "Blues", "Religious", "Industrial"};

    public static void GenerateData(int numberOfObjects) {
        Faker faker = new Faker();
        Album[] fakeAlbums = new Album[numberOfObjects];
        Artist[] fakeArtist = new Artist[numberOfObjects];
        for (int i = 0; i < numberOfObjects; i++) {
            String ArtistName = faker.name().fullName();
            String title = faker.name().title();
            int ReleaseYear = (int) (Math.random() * 100 + 1900);
            int x = (int) (Math.random() * 18);
            Album album = new Album();
            album.setTitle(title);
            album.setReleaseYear(ReleaseYear);
            album.setArtist(ArtistName);
            album.setGenres(Genres[x]);
            fakeAlbums[i] = album;
            Artist artist = new Artist();
            artist.setName(ArtistName);
            fakeArtist[i] = artist;
        }
        long startTime = System.currentTimeMillis();
        ArtistRepository artistRepository = new ArtistRepository();
        AlbumRepository albumRepository = new AlbumRepository();
        for(int i=0;i<numberOfObjects;i++){
            artistRepository.create(fakeArtist[i]);
            albumRepository.create(fakeAlbums[i]);
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Execution time: " + executionTime + " ms");
    }
    public static void main(String[] args){
        GenerateRandomData.GenerateData(500);
    }
}
