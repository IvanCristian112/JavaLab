package org.example;

import jakarta.persistence.EntityManager;

import java.util.*;

public class AlbumRepository extends AbstractJPARepository<Album,Integer> {
    private EntityManager entityManager = PersistenceManager.getEntityManagerFactory().createEntityManager();

    public AlbumRepository() {
        super(Album.class);
    }

    public List<Album> findByName(String Name) {
        return entityManager.createNamedQuery("Album.findByName").setParameter("title", Name).getResultList();
    }


}

