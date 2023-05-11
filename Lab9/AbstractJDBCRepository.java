package org.example;

import org.w3c.dom.ls.LSOutput;

import javax.management.Query;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public abstract class AbstractJDBCRepository<T, ID> implements AbstractFactory<T, ID> {

    private Class<T> entityClass;

    public AbstractJDBCRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(ID ID) {
        T result = null;
        Connection connection = null;
        String tableTitle = entityClass.getSimpleName();
        switch (tableTitle) {
            case ("Artist"):
                tableTitle = "\"Artists\"";
                break;

            case ("Album"):
                tableTitle = "\"Albums\"";
                break;
            case ("Genre"):
                tableTitle = "\"Genres\"";
                break;
        }
        try {
            connection = Database.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "select * from " + tableTitle + " where \"ID\"=" + ID)) {
            if (resultSet.next()) {
                result = entityClass.getDeclaredConstructor().newInstance();
                for (Field field : entityClass.getDeclaredFields()) {
                    field.setAccessible(true);
                    field.set(result, resultSet.getObject(field.getName()));
                }
            }
        } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchMethodException |
                 InvocationTargetException e) {
            e.printStackTrace();


        }
        return result;

    }
}

