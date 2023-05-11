package org.example;

import jakarta.persistence.EntityManager;

import java.util.List;

public class GenreRepository extends AbstractJPARepository<Genre, Integer> {
    private EntityManager entityManager = PersistenceManager.getEntityManagerFactory().createEntityManager();

    public GenreRepository() {
        super(Genre.class);
    }

    public List<Genre> findByName(String Name) {
        return entityManager.createNamedQuery("Genre.findByName").setParameter("name", Name).getResultList();
    }


}
