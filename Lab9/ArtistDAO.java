package org.example;

public class ArtistDAO extends AbstractJDBCRepository<Artist, Integer> {
    public ArtistDAO() {
        super(Artist.class);
    }

    @Override
    public Artist create(Artist entity) {
        return null;
    }

    @Override
    public Artist update(Artist entity) {
        return null;
    }
}
