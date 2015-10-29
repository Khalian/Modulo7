package com.modulo7.engine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by asanyal on 10/28/15.
 *
 * Caching results for maximum performance for Modulo7
 */
public class Modulo7Cache {

    private static void cacheQueryResults() {
        try {
            Class.forName("org.sqlite.JDBC");
            final Connection cacheConn = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
