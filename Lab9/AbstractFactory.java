package org.example;

import java.io.Serializable;

public interface AbstractFactory <T, ID > {
    T findById(ID id);
    T create(T entity);
    T update(T entity);
}
