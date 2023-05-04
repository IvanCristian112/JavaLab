package org.example;

import java.sql.*;

public class ArtistDAO {

    public void Create(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(
                "insert into \"Artists\"  (\"Name\") values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Artist findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select \"ID\" from \"Artists\" where \"Name\"='" + name + "'")) {
            if (rs.next()) {
                return new Artist(name, rs.getInt(1));
            }
            return null;
        }
    }

    public Artist findByID(int ID) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select \"Name\" from \"Artists\" where \"ID\"=" + ID)) {
            if (rs.next()) {
                return new Artist(rs.getString(1), ID);
            }
            return null;
        }
    }


}
