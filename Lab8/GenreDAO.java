package org.example;

import java.sql.*;

public class GenreDAO {
    public void Create(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(
                "insert into \"Genres\"  (\"Name\") values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Genre findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select \"ID\" from \"Genres\" where \"Name\"='" + name + "'")) {
            if (rs.next()) {
                return new Genre(rs.getInt(1), name);
            }
            return null;
        }
    }

    public Genre findByID(int ID) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select \"Name\" from \"Genres\" where \"ID\"=" + ID)) {
            if (rs.next()) {
                return new Genre(ID, rs.getString(1));
            }
            return null;
        }
    }
}
