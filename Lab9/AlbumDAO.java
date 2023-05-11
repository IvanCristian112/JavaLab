package org.example;

public class AlbumDAO extends AbstractJDBCRepository<Album, Integer> {
    public AlbumDAO() {
        super(Album.class);
    }

    @Override
    public Album create(Album entity) {
        return null;
    }

    @Override
    public Album update(Album entity) {
        return null;
    }
}
