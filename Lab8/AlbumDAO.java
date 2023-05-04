package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.Array;

public class AlbumDAO {


    public void Create(int ReleaseYear, String Title, String Artist, String genres) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO public.\"Albums\"(\"ReleaseYear\", \"Title\", \"Artist\", \"Genres\") VALUES (?, ?, ?, ?);")) {
            pstmt.setInt(1, ReleaseYear);
            pstmt.setString(2, Title);
            pstmt.setString(3, Artist);
            String[] words = genres.split(",\\s*");

            Array genresArray = connection.createArrayOf("text", words);

            pstmt.setArray(4, genresArray);

            System.out.println(pstmt);
            pstmt.executeUpdate();
        }
    }


    public Album findByName(String title) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select \"ID\", \"ReleaseYear\", \"Artist\", \"Genres\"  from \"Albums\" where \"Title\"='" + title + "'")) {
            if (rs.next()) {
                String[] words = rs.getString(4).split(",\\s*");
                List<String> arrayList = Arrays.stream(words).toList();
                return new Album(rs.getInt(1), rs.getInt(2), title, rs.getString(3), arrayList);
            }
            return null;
        }
    }

    public Album findByID(int ID) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select \"Title\", \"ReleaseYear\", \"Artist\", \"Genres\"  from \"Albums\" where \"ID\"=" + ID)) {
            if (rs.next()) {
                String[] words = rs.getString(4).split(",\\s*");
                List<String> arrayList = Arrays.stream(words).toList();
                return new Album(ID, rs.getInt(2), rs.getString(1), rs.getString(3), arrayList);
            }
            return null;
        }
    }

}
