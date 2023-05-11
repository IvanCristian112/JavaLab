package org.example;

import jakarta.persistence.EntityManager;

import java.util.List;

public class ArtistRepository extends AbstractJPARepository<Artist, Integer> {

    public ArtistRepository() {
        super(Artist.class);
    }

    public List<Artist> findByName(String Name) {
        return em.createNamedQuery("Artist.findByName").setParameter("name", Name).getResultList();

    }



}
