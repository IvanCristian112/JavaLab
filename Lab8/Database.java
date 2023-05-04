package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class Database {
    private static Database single_instance = null;

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    private Database() {
    }

    static {
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/Music");
        config.setUsername("postgres");
        config.setPassword("immediateResponse420");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    public static Database getInstance() {
        if (single_instance == null) {
            single_instance = new Database();
        }
        return single_instance;
    }


    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
