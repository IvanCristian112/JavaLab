package org.example;

import jakarta.persistence.EntityManager;

public abstract class AbstractJPARepository<T, ID > implements AbstractFactory<T,ID> {

    protected EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();

    private Class<T> entityClass;

    public AbstractJPARepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    @Override
    public T findById(ID id) {
        return em.find(entityClass, id);
    }
    @Override
    public T create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }
    @Override
    public T update(T entity) {
        em.getTransaction().begin();
        T mergedEntity = em.merge(entity);
        em.getTransaction().commit();
        return mergedEntity;
    }
}
